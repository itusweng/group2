package com.trainingplatform.reportingservice.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trainingplatform.reportingservice.communication.TrainingServiceClient;
import com.trainingplatform.reportingservice.communication.UserServiceClient;
import com.trainingplatform.reportingservice.model.training.response.UserResponseDTO;
import com.trainingplatform.reportingservice.model.training.response.TrainingResponseDTO;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TrainingParticipantService {

    private final TrainingServiceClient trainingClient;
    private final UserServiceClient userClient;
    private final ObjectMapper objectMapper;


    public List<UserResponseDTO> getTrainingParticipants(Long trainingId) {

        // get participant id list
        List<Long> participantIds = trainingClient.getAllParticipantIdsByTrainingId(trainingId).getBody();

        // get participants models with user id list
        List<UserResponseDTO> participantList = new ArrayList<>();
        List participantsResponse = (List) userClient.getUserModelsByUserIdList(participantIds).getBody().get("data");

        participantsResponse.forEach(
                participant -> participantList.add(objectMapper
                        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                        .convertValue(participant, UserResponseDTO.class)
                ));

        return participantList;
    }

    public TrainingResponseDTO getTrainingModel(Long trainingId) {
        // get training model
        ResponseEntity<HashMap<String, Object>> response = trainingClient.getTrainingModelById(trainingId);
        TrainingResponseDTO trainingModel = objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .convertValue(response.getBody().get("data"), TrainingResponseDTO.class);

        return trainingModel;
    }

}
