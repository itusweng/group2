package com.trainingplatform.trainingservice.trainingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trainingplatform.trainingservice.trainingservice.communication.UserClient;
import com.trainingplatform.trainingservice.trainingservice.constants.Constants;
import com.trainingplatform.trainingservice.trainingservice.exception.TrainingCrudException;
import com.trainingplatform.trainingservice.trainingservice.model.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.User_ParticipatedTrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.User_RequestedTrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.request.ParticipationPendingRequestsListAllRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.PendingParticipationResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.TrainingRepository;
import com.trainingplatform.trainingservice.trainingservice.repository.User_ParticipatedTrainingRepo;
import com.trainingplatform.trainingservice.trainingservice.repository.User_RequestedTrainingRepo;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TrainingParticipationService {

    private final User_ParticipatedTrainingRepo trainingParticipatedRepo;
    private final User_RequestedTrainingRepo trainingRequestedRepo;
    private final UserClient userClient;
    private final TrainingRepository trainingRepo;
    private final TrainingService trainingService;
    private final TrainingModelMapper trainingMapper;
    private final ObjectMapper objectMapper;

    public Map<Long, Boolean> addParticipantToTraining(Long trainingId, List<Long> participantIdList) throws TrainingCrudException {
        // TODO: CHECK TRAINING QUOTA BEFORE ADDING!

        // Check training exists
        Optional<TrainingModel> training = trainingRepo.findById(trainingId);
        training.orElseThrow(() -> new TrainingCrudException("Participant cannot be added to training! " +
                "Training is not found by id:" + trainingId));

        Map<Long, Boolean> isUserAddedToTrainingMap = new HashMap<>();
        participantIdList.forEach((Long userId) -> {
            try {
                // Check user exists
                userClient.getUserByID(userId);

                // Create user-training model to save it into database
                User_ParticipatedTrainingModel trainingParticipatedUser = User_ParticipatedTrainingModel
                        .builder()
                        .userId(userId)
                        .trainingId(trainingId)
                        .participatedDate(new Date())
                        .build();

                trainingParticipatedRepo.save(trainingParticipatedUser);
                isUserAddedToTrainingMap.put(userId, true);
            } catch (FeignException.NotFound e) {
                isUserAddedToTrainingMap.put(userId, false);
            } catch (Exception e) {
                isUserAddedToTrainingMap.put(userId, false);
            }
        });
        return isUserAddedToTrainingMap;
    }

    public void requestParticipation(Long trainingId, Long userId) throws TrainingCrudException {
        TrainingModel training = trainingService.getTrainingById(trainingId);
        Long instructorId = training.getInstructor_id();
        User_RequestedTrainingModel requestedTrainingUserModel = User_RequestedTrainingModel.builder()
                .userId(userId)
                .trainingId(trainingId)
                .managerId(instructorId)
                .createdDate(new Date())
                .status(Constants.Training.Participation.RequestType.PENDING).build();

        trainingRequestedRepo.save(requestedTrainingUserModel);
    }

    public List<PendingParticipationResponseDTO> listAllPendingRequests(ParticipationPendingRequestsListAllRequestDTO requestDTO) {
        List<User_RequestedTrainingModel> requestedList = trainingRequestedRepo.findByManagerIdAndStatusEquals(requestDTO.getManagerId(),
                Constants.Training.Participation.RequestType.PENDING);

        List<PendingParticipationResponseDTO> pendingRequests = new ArrayList<>();
        requestedList.forEach(participationRequest -> {

            Long trainingId = participationRequest.getTrainingId();
            Long userId = participationRequest.getUserId();

            Map<String, String> userModelMap = (Map<String, String>) userClient.getUserByID(userId).getBody().get("data");
            UserResponseDTO userModelDTO = objectMapper
                    .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                    .convertValue(userModelMap, UserResponseDTO.class);

            TrainingModel trainingModel = trainingRepo.findById(trainingId).get();
            TrainingResponseDTO trainingModelDTO = trainingMapper.mapToDto(trainingModel);

            PendingParticipationResponseDTO pendingParticipationResponseDTO = PendingParticipationResponseDTO
                    .builder()
                    .requested_training(trainingModelDTO)
                    .requested_user(userModelDTO)
                    .status(Constants.Training.Participation.RequestType.PENDING)
                    .build();

            pendingRequests.add(pendingParticipationResponseDTO);
        });

        return pendingRequests;
    }
}
