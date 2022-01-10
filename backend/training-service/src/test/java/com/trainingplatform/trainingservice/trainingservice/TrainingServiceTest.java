package com.trainingplatform.trainingservice.trainingservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trainingplatform.trainingservice.trainingservice.communication.UserClient;
import com.trainingplatform.trainingservice.trainingservice.exception.TrainingCrudException;
import com.trainingplatform.trainingservice.trainingservice.model.entity.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.entity.User_ParticipatedTrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingRequestMapper;
import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.TrainingRepository;
import com.trainingplatform.trainingservice.trainingservice.repository.User_CreatedTrainingRepo;
import com.trainingplatform.trainingservice.trainingservice.repository.User_ParticipatedTrainingRepo;
import com.trainingplatform.trainingservice.trainingservice.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TrainingServiceTest {

    @InjectMocks
    TrainingService trainingService;

    @Mock private TrainingRepository trainingRepo;
    @Mock private User_CreatedTrainingRepo trainingCreatedUserRepo;
    @Mock private User_ParticipatedTrainingRepo trainingParticipatedUserRepo;
    @Mock private UserClient userClient;
    @Mock private TrainingModelMapper trainingModelMapper;
    @Mock private TrainingRequestMapper trainingRequestMapper;
    @Mock private RabbitTemplate rabbitTemplate;
    @Mock private ObjectMapper objectMapper;

    @Test
    void it_should_return_all_trainings_when_trainings_exist(){
        //arrange
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingRepo.findAll()).thenReturn(List.of(trainingModel));
        //act
        List<TrainingModel> allTrainings = trainingService.getAllTrainings();
        //assert
        assertThat(allTrainings).isEqualTo(List.of(trainingModel));
    }

    @Test
    void it_should_return_empty_list_when_no_trainings_exist(){
        //arrange
        when(trainingRepo.findAll()).thenReturn(List.of());
        //act
        List<TrainingModel> allTrainings = trainingService.getAllTrainings();
        //assert
        assertThat(allTrainings).isEqualTo(List.of());
    }

   @Test
    void it_should_return_training_when_training_found() throws TrainingCrudException {
        //arrange
       TrainingModel trainingModel = mock(TrainingModel.class);
       when(trainingRepo.findById(1L)).thenReturn(Optional.of(trainingModel));
       //act
       TrainingModel trainingModel1 = trainingService.getTrainingById(1L);
       //assert
       assertThat(trainingModel1).isEqualTo(trainingModel);
   }

   @Test
    void it_should_throw_exception_when_training_not_found(){
       //arrange
       when(trainingRepo.findById(1L)).thenReturn(Optional.empty());
       //act
       Throwable throwable = catchThrowable(() -> trainingService.getTrainingById(1L));
       //assert
       assertThat(throwable).isInstanceOf(TrainingCrudException.class);
   }
/*
   @Test
    void it_should_return_trainingresponsedto_when_training_created(){

   }*/

   @Test
    void it_should_delete_training_when_training_found() throws TrainingCrudException{
       trainingService.deleteTraining(1L);
       verify(trainingRepo, times(1)).deleteById(1L);
   }

   @Test
    void it_should_return_trainingmodellist_when_user_participated(){
        //arrange
       User_ParticipatedTrainingModel user_participatedTrainingModel = mock(User_ParticipatedTrainingModel.class);
       when(trainingParticipatedUserRepo.findByUserId(1L)).thenReturn(List.of(user_participatedTrainingModel));
       TrainingModel trainingModel = mock(TrainingModel.class);
       when(user_participatedTrainingModel.getTrainingId()).thenReturn(2L);
       when(trainingRepo.findById(user_participatedTrainingModel.getTrainingId())).thenReturn(Optional.of(trainingModel));
       List<TrainingModel> trainingModels = Stream.of(user_participatedTrainingModel)
               .map(participatedTraining -> trainingRepo.findById(participatedTraining.getTrainingId()).get()).collect(Collectors.toList());
       //act
       List<TrainingModel> trainingModels1 = trainingService.getTrainingsByParticipantId(1L);
       //assert
       assertThat(trainingModels1).isEqualTo(trainingModels);
   }

   @Test
    void it_should_return_participants_when_training_given(){
        //arrange
       Map<Long, Long> userList = new HashMap<>();
       userList.put(1L, 1L);
       UserResponseDTO userResponseDTO = mock(UserResponseDTO.class);
       Map<Long, UserResponseDTO> userResponseDTOMap = new HashMap<>();
       userResponseDTOMap.put(1L, userResponseDTO);
       when(userClient.getTrainingUsersByID(userList)).thenReturn(ResponseEntity.of(Optional.of(userResponseDTOMap)));
       //act
       Map<Long, UserResponseDTO> response = trainingService.getTrainingUsersByID(userList);
       //assert
       assertThat(response).isEqualTo(userResponseDTOMap);
   }
/*
   @Test
    void it_should_return_userresponsedto_when_user_given(){
        //arrange
       Map<String, Object> userResponseMap = new HashMap<>();
       Object object = mock(Object.class);
       userResponseMap.put("data",object);
       when(userClient.getUserByID(1L)).thenReturn(ResponseEntity.of(Optional.of(userResponseMap)));
       UserResponseDTO userResponseDTO = objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
               .convertValue(userResponseMap.get("data"), UserResponseDTO.class);
       //act
       UserResponseDTO userResponseDTO1 = trainingService.getSingleTrainingUserByID(1L);
       //assert
       assertThat(userResponseDTO).isEqualTo(userResponseDTO1);
   }

   @Test
   void it_should_return_true_if_user_participated_training(){

   }
*/
}
