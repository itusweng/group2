package com.trainingplatform.reportingservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trainingplatform.reportingservice.communication.TrainingServiceClient;
import com.trainingplatform.reportingservice.communication.UserServiceClient;
import com.trainingplatform.reportingservice.model.training.response.TrainingResponseDTO;
import com.trainingplatform.reportingservice.model.training.response.UserResponseDTO;
import com.trainingplatform.reportingservice.service.TrainingParticipantService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TrainingParticipantServiceTest {

    @InjectMocks
    TrainingParticipantService trainingParticipantService;
    @Mock
    private TrainingServiceClient trainingClient;
    @Mock
    private UserServiceClient userClient;
    @Mock
    private ObjectMapper objectMapper;

    @Test
    public void it_should_return_participant_list_when_training_found(){
        //arrange
        Long trainingId = 1L;
        Long participantId = 2L;
        ResponseEntity response = mock(ResponseEntity.class);
        ResponseEntity response1 = mock(ResponseEntity.class);
        UserResponseDTO userResponseDTO = mock(UserResponseDTO.class);
        UserResponseDTO userResponseDTO1 = mock(UserResponseDTO.class);
        List list = new ArrayList<UserResponseDTO>();
        list.add(userResponseDTO1);
        Map<String, Object> map = new HashMap<>();
        map.put("data", list);
        when(trainingClient.getAllParticipantIdsByTrainingId(trainingId)).thenReturn(response);
        when(response.getBody()).thenReturn(List.of(participantId));
        when(userClient.getUserModelsByUserIdList(List.of(participantId))).thenReturn(response1);
        when(response1.getBody()).thenReturn(map);
        ObjectMapper objectMapper1 = mock(ObjectMapper.class);
        when(objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)).thenReturn(objectMapper1);
        when(objectMapper1.convertValue(userResponseDTO1, UserResponseDTO.class)).thenReturn(userResponseDTO);
        List<UserResponseDTO> participantList = new ArrayList<>();
        participantList.add(userResponseDTO);
        //act
        List<UserResponseDTO> participantList1 = trainingParticipantService.getTrainingParticipants(trainingId);
        //assert
        assertThat(participantList1).isEqualTo(participantList);
    }

    @Test
    public void it_should_return_training_when_id_given(){
        //arrange
        Long trainingId = 1L;
        HashMap<String, Object> map = mock(HashMap.class);
        ResponseEntity<HashMap<String, Object>> response = mock(ResponseEntity.class);
        when(trainingClient.getTrainingModelById(trainingId)).thenReturn(response);
        when(response.getBody()).thenReturn(map);
        TrainingResponseDTO trainingResponseDTO = mock(TrainingResponseDTO.class);
        TrainingResponseDTO trainingResponseDTO1 = mock(TrainingResponseDTO.class);
        map.put("data", trainingResponseDTO1);
        ObjectMapper objectMapper1 = mock(ObjectMapper.class);
        when(objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)).thenReturn(objectMapper1);
        when(objectMapper1.convertValue(response.getBody().get("data"), TrainingResponseDTO.class)).thenReturn(trainingResponseDTO);
        //act
        TrainingResponseDTO returnTrainingModel = trainingParticipantService.getTrainingModel(trainingId);
        //assert
        assertThat(returnTrainingModel).isEqualTo(trainingResponseDTO);
    }

}
