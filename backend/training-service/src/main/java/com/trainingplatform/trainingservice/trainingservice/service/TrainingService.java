package com.trainingplatform.trainingservice.trainingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trainingplatform.trainingservice.trainingservice.communication.UserClient;
import com.trainingplatform.trainingservice.trainingservice.config.RabbitMQMessagingConfig;
import com.trainingplatform.trainingservice.trainingservice.exception.TrainingCrudException;
import com.trainingplatform.trainingservice.trainingservice.model.entity.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.entity.User_CreatedTrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.entity.User_ParticipatedTrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingRequestMapper;
import com.trainingplatform.trainingservice.trainingservice.model.request.TrainingRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.TrainingThumbnailUploadRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;

import com.trainingplatform.trainingservice.trainingservice.repository.TrainingRepository;
import com.trainingplatform.trainingservice.trainingservice.repository.User_CreatedTrainingRepo;
import com.trainingplatform.trainingservice.trainingservice.repository.User_ParticipatedTrainingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.io.IOException;
import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepo;
    private final User_CreatedTrainingRepo trainingCreatedUserRepo;
    private final User_ParticipatedTrainingRepo trainingParticipatedUserRepo;
    private final UserClient userClient;
    private final TrainingModelMapper trainingModelMapper;
    private final TrainingRequestMapper trainingRequestMapper;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public List<TrainingModel> getAllTrainings() {
        List<TrainingModel> trainingModels = trainingRepo.findAll();
        return trainingModels;
    }

    public TrainingModel getTrainingById(Long trainingId) throws TrainingCrudException {
        return trainingRepo.findById(trainingId)
                .orElseThrow(() -> new TrainingCrudException("Training is not found by id: " + trainingId));
    }

    public TrainingResponseDTO createTraining(TrainingRequestDTO trainingRequestDTO) throws IOException {
        // TODO: refactor
        TrainingModel tm = trainingRequestMapper.mapToEntity(trainingRequestDTO);

        // Create training
        TrainingModel savedTraining = trainingRepo.save(tm);

        // Create user-created training linker
        User_CreatedTrainingModel userTrainingModel = User_CreatedTrainingModel
                .builder()
                .trainingId(savedTraining.getId())
                .userId(tm.getUser_created_id())
                .build();
        trainingCreatedUserRepo.save(userTrainingModel);

        // Fetch user data who is created the training
        Map<Long, Long> createdUserRequestMap = Collections.singletonMap(tm.getId(), tm.getUser_created_id());
        Map<Long, UserResponseDTO> createdUserResponseMap = userClient.getTrainingUsersByID(createdUserRequestMap).getBody();

        // Fetch instructor user of training
        Map<Long, Long> userInstructorRequestMap = Collections.singletonMap(tm.getId(), tm.getUser_created_id());
        Map<Long, UserResponseDTO> userInstructorResponseMap = userClient.getTrainingUsersByID(userInstructorRequestMap).getBody();

        TrainingResponseDTO trainingResponseDTO = trainingModelMapper.mapToDto(savedTraining);

        // Set instructor and created users of training response dto
        trainingResponseDTO.setUser_created(createdUserResponseMap.get(tm.getId()));
        trainingResponseDTO.setInstructor(userInstructorResponseMap.get(tm.getId()));

        TrainingThumbnailUploadRequestDTO trainingThumbnailUploadRequestDTO = new TrainingThumbnailUploadRequestDTO(savedTraining.getId(), trainingRequestDTO.getThumbnail().getBytes());
        rabbitTemplate.convertAndSend(RabbitMQMessagingConfig.EXCHANGE, RabbitMQMessagingConfig.ROUTING_KEY_UPLOAD_TRAINING_THUMBNAIL, trainingThumbnailUploadRequestDTO);

        return trainingResponseDTO;
    }

    public void deleteTraining(Long trainingId) throws TrainingCrudException {
        try {
            trainingRepo.deleteById(trainingId);
        } catch (EmptyResultDataAccessException e) {
            throw new TrainingCrudException("Training cannot be deleted! " + e.getMessage());
        }
    }

    public List<TrainingModel> getTrainingsByParticipantId(Long participantUserId) {
        List<User_ParticipatedTrainingModel> participatedTrainings = trainingParticipatedUserRepo.findByUserId(participantUserId);
        List<TrainingModel> trainingModels = participatedTrainings.stream()
                .map(participatedTraining -> trainingRepo.findById(participatedTraining.getTrainingId()).get()).collect(Collectors.toList());
        return trainingModels;
    }

    public Map<Long, UserResponseDTO> getTrainingUsersByID(Map<Long, Long> userList) {
        return userClient.getTrainingUsersByID(userList).getBody();
    }

    public UserResponseDTO getSingleTrainingUserByID(Long userId) {
        Map<String, Object> userResponseMap = userClient.getUserByID(userId).getBody();
        UserResponseDTO userResponseDTO = objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .convertValue(userResponseMap.get("data"), UserResponseDTO.class);
        return userResponseDTO;
    }


    public Boolean isUserParticipated(Long trainingId, Long userId) {
        boolean isParticipated = trainingParticipatedUserRepo.existsUser_ParticipatedTrainingModelByUserIdAndTrainingId(trainingId, userId);
        return isParticipated;
    }

    public void updateTraining(TrainingModel training) {
        TrainingModel existingTraining = trainingRepo
                .findById(training.getId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("No training found by id %d", training.getId())));

        trainingModelMapper.updateFields(existingTraining, training);
        existingTraining.setUpdated_date(new Date());

        trainingRepo.save(existingTraining);
    }
}
