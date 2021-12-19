package com.trainingplatform.trainingservice.trainingservice.service;

import com.trainingplatform.trainingservice.trainingservice.communication.TrainingClient;
import com.trainingplatform.trainingservice.trainingservice.model.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.User_CreatedTrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;

import com.trainingplatform.trainingservice.trainingservice.repository.TrainingRepository;
import com.trainingplatform.trainingservice.trainingservice.repository.User_CreatedTrainingRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepo;
    private final User_CreatedTrainingRepo trainingUserRepo;
    private final TrainingClient trainingClient;
    private final TrainingModelMapper trainingModelMapper;

    public List<TrainingResponseDTO> getAllTrainings() {
        List<TrainingModel> trainingModels = trainingRepo.findAll();
        List<TrainingResponseDTO> trainingResponseDTOS = new ArrayList<>();

        Map<Long, Long> userCreatedList = trainingModels.stream()
                .collect(Collectors.toMap(TrainingModel::getId, TrainingModel::getUser_created_id));

        Map<Long, Long> userInstructorList = trainingModels.stream()
                .collect(Collectors.toMap(TrainingModel::getId, TrainingModel::getInstructor_id));

        // Fetch users who are created the trainings
        Map<Long, UserResponseDTO> createdUsersMap = trainingClient.getTrainingUsersByID(userCreatedList).getBody();

        // Fetch instructors of trainings
        Map<Long, UserResponseDTO> instructorsMap = trainingClient.getTrainingUsersByID(userInstructorList).getBody();

        // Add instructors & created users into dto model
        trainingModels.forEach(trainingModel -> {
            TrainingResponseDTO responseDTO = trainingModelMapper.mapToDto(trainingModel);
            responseDTO.setUser_created(createdUsersMap.get(responseDTO.getId()));
            responseDTO.setInstructor(instructorsMap.get(responseDTO.getId()));
            trainingResponseDTOS.add(responseDTO);
        });

        return trainingResponseDTOS;
    }

    public TrainingResponseDTO createTraining(TrainingModel tm) {

        // Create training
        TrainingModel savedTraining = trainingRepo.save(tm);

        // Create user-created training linker
        User_CreatedTrainingModel userTrainingModel = new User_CreatedTrainingModel(savedTraining.getId(),
                tm.getUser_created_id());
        trainingUserRepo.save(userTrainingModel);

        // Fetch user data who is created the training
        Map<Long, Long> createdUserRequestMap = Collections.singletonMap(tm.getId(), tm.getUser_created_id());
        Map<Long, UserResponseDTO> createdUserResponseMap = trainingClient.getTrainingUsersByID(createdUserRequestMap).getBody();

        // Fetch instructor user of training
        Map<Long, Long> userInstructorRequestMap = Collections.singletonMap(tm.getId(), tm.getUser_created_id());
        Map<Long, UserResponseDTO> userInstructorResponseMap = trainingClient.getTrainingUsersByID(userInstructorRequestMap).getBody();

        TrainingResponseDTO trainingResponseDTO = trainingModelMapper.mapToDto(savedTraining);

        // Set instructor and created users of training response dto
        trainingResponseDTO.setUser_created(createdUserResponseMap.get(tm.getId()));
        trainingResponseDTO.setInstructor(userInstructorResponseMap.get(tm.getId()));
        return trainingResponseDTO;
    }
}
