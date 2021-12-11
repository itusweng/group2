package com.trainingplatform.trainingservice.trainingservice.service;

import com.trainingplatform.trainingservice.trainingservice.communication.TrainingClient;
import com.trainingplatform.trainingservice.trainingservice.model.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.TrainingRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepo;
    private final TrainingClient trainingClient;
    private final TrainingModelMapper trainingModelMapper;

    public List<TrainingResponseDTO> getAllTrainings() {
        List<TrainingModel> trainingModels = trainingRepo.findAll();
        List<TrainingResponseDTO> trainingResponseDTOS = new ArrayList<>();
        Map<Long, Long> userCreatedList = trainingModels.stream()
                .collect(Collectors.toMap(TrainingModel::getId, TrainingModel::getUser_created_id));

        Map<Long, UserResponseDTO> usersMap = trainingClient.getTrainingCreatedUsersByID(userCreatedList).getBody();
        trainingModels.forEach(trainingModel -> {
            TrainingResponseDTO responseDTO = trainingModelMapper.mapToDto(trainingModel);
            responseDTO.setUser_created(usersMap.get(responseDTO.getId()));
            trainingResponseDTOS.add(responseDTO);
        });

        return trainingResponseDTOS;
    }
}
