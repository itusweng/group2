package com.trainingplatform.trainingservice.trainingservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trainingplatform.trainingservice.trainingservice.communication.UserClient;
import com.trainingplatform.trainingservice.trainingservice.config.RabbitMQMessagingConfig;
import com.trainingplatform.trainingservice.trainingservice.exception.TrainingCrudException;
import com.trainingplatform.trainingservice.trainingservice.model.entity.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.entity.User_CreatedTrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.entity.User_LessonProgressModel;
import com.trainingplatform.trainingservice.trainingservice.model.entity.User_ParticipatedTrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingRequestMapper;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.UserLessonProgressModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.request.TrainingRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.TrainingThumbnailUploadRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.*;
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
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.*;
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
    @Mock private OnlineLessonRepository onlineLessonRepo;
    @Mock private OfflineLessonRepository offlineLessonRepo;
    @Mock private User_LessonProgressRepo userLessonProgressRepo;
    @Mock private UserLessonProgressModelMapper userLessonProgressModelMapper;

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

   @Test
    void it_should_return_trainingresponsedto_when_training_created() throws IOException {
        TrainingModel trainingModel = mock(TrainingModel.class);
       when(trainingModel.getUser_created_id()).thenReturn(2L);
       when(trainingModel.getId()).thenReturn(1L);
        TrainingRequestDTO trainingRequestDTO = mock(TrainingRequestDTO.class);

       when(trainingRequestMapper.mapToEntity(trainingRequestDTO)).thenReturn(trainingModel);
        TrainingModel savedTrainingModel = mock(TrainingModel.class);
        when(trainingRepo.save(trainingModel)).thenReturn(savedTrainingModel);
        when(savedTrainingModel.getId()).thenReturn(1L);
       User_CreatedTrainingModel user_createdTrainingModel = mock(User_CreatedTrainingModel.class);
       when(user_createdTrainingModel.getTrainingId()).thenReturn(1L);
       when(user_createdTrainingModel.getUserId()).thenReturn(2L);
       MultipartFile thumbnail = mock(MultipartFile.class);
       when(trainingRequestDTO.getThumbnail()).thenReturn(thumbnail);
       byte[] bytes = new byte[5];
       when(trainingRequestDTO.getThumbnail().getBytes()).thenReturn(bytes);

       Map<Long, Long> createdUserRequestMap = Collections.singletonMap(trainingModel.getId(), trainingModel.getUser_created_id());
       Map<Long, UserResponseDTO> createdUserResponseMap = mock(Map.class);
       ResponseEntity<Map<Long, UserResponseDTO>> responseEntity = mock(ResponseEntity.class);
       when(userClient.getTrainingUsersByID(createdUserRequestMap)).thenReturn(responseEntity);
       when(userClient.getTrainingUsersByID(createdUserRequestMap).getBody()).thenReturn(createdUserResponseMap);

       Map<Long, Long> userInstructorRequestMap = Collections.singletonMap(trainingModel.getId(), trainingModel.getUser_created_id());
       Map<Long, UserResponseDTO> userInstructorResponseMap = mock(Map.class);
       ResponseEntity<Map<Long, UserResponseDTO>> responseEntity1 = mock(ResponseEntity.class);
       when(userClient.getTrainingUsersByID(userInstructorRequestMap)).thenReturn(responseEntity1);
       when(userClient.getTrainingUsersByID(userInstructorRequestMap).getBody()).thenReturn(userInstructorResponseMap);

       TrainingResponseDTO trainingResponseDTO = mock(TrainingResponseDTO.class);
       when(trainingModelMapper.mapToDto(savedTrainingModel)).thenReturn(trainingResponseDTO);
       TrainingThumbnailUploadRequestDTO trainingThumbnailUploadRequestDTO = mock(TrainingThumbnailUploadRequestDTO.class);
       //act
       TrainingResponseDTO responseDTO = trainingService.createTraining(trainingRequestDTO);
       //assert
       assertThat(responseDTO).isEqualTo(trainingResponseDTO);
       verify(trainingCreatedUserRepo, times(1)).save(any(User_CreatedTrainingModel.class));
       verify(rabbitTemplate, times(1)).convertAndSend(any(String.class), any(String.class), any(TrainingThumbnailUploadRequestDTO.class));
   }

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

   @Test
    void it_should_return_userresponsedto_when_user_given(){
        //arrange
       Map<String, Object> userResponseMap = new HashMap<>();
       Object object = mock(Object.class);
       userResponseMap.put("data",object);

       when(userClient.getUserByID(1L)).thenReturn(ResponseEntity.of(Optional.of(userResponseMap)));
       UserResponseDTO userResponseDTO = mock(UserResponseDTO.class);
       ObjectMapper objectMapper1 = mock(ObjectMapper.class);
       when(objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)).thenReturn(objectMapper1);
       when(objectMapper1.convertValue(userResponseMap.get("data"), UserResponseDTO.class)).thenReturn(userResponseDTO);
       //act
       UserResponseDTO userResponseDTO1 = trainingService.getSingleTrainingUserByID(1L);
       //assert
       assertThat(userResponseDTO).isEqualTo(userResponseDTO1);
   }

   @Test
   void it_should_return_true_if_user_participated_training(){
        when(trainingParticipatedUserRepo.existsUser_ParticipatedTrainingModelByUserIdAndTrainingId(1L, 1L)).thenReturn(true);
        boolean isParticipated = trainingService.isUserParticipated(1L,1L);
        assertThat(isParticipated).isEqualTo(true);
   }

   @Test
    void test_update_successful(){
       TrainingModel training = mock(TrainingModel.class);
       when(training.getId()).thenReturn(1L);
       TrainingModel existingTrainingModel = mock(TrainingModel.class);
       when(trainingRepo.findById(training.getId())).thenReturn(Optional.of(existingTrainingModel));

       trainingService.updateTraining(training);

       verify(trainingModelMapper, times(1)).updateFields(any(TrainingModel.class), any(TrainingModel.class));
       verify(existingTrainingModel,times(1)).setUpdated_date(any(Date.class));
       verify(trainingRepo, times(1)).save(any(TrainingModel.class));
   }

   @Test
    void it_should_return_user_progress_when_onlinetraining_user_found(){
        //arrange
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingModel.getIs_online()).thenReturn(true);
        when(trainingRepo.findById(1L)).thenReturn(Optional.of(trainingModel));
       when(onlineLessonRepo.findAllLessonIdsByTrainingId(1L)).thenReturn(List.of(2L));
       User_LessonProgressModel userLessonProgressModel = mock(User_LessonProgressModel.class);
       when(userLessonProgressRepo.findByLessonIdAndUserId(2L,1L)).thenReturn(userLessonProgressModel);
       //act
       List<User_LessonProgressModel> progressModelList = trainingService.getLessonProgressByTrainingAndUserId(1L,1L);
       //assert
       assertThat(progressModelList).isEqualTo(List.of(userLessonProgressModel));
   }

    @Test
    void it_should_return_user_progress_when_offlinetraining_user_found(){
        //arrange
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingModel.getIs_online()).thenReturn(false);
        when(trainingRepo.findById(1L)).thenReturn(Optional.of(trainingModel));
        when(offlineLessonRepo.findAllLessonIdsByTrainingId(1L)).thenReturn(List.of(2L));
        User_LessonProgressModel userLessonProgressModel = mock(User_LessonProgressModel.class);
        when(userLessonProgressRepo.findByLessonIdAndUserId(2L,1L)).thenReturn(userLessonProgressModel);
        //act
        List<User_LessonProgressModel> progressModelList = trainingService.getLessonProgressByTrainingAndUserId(1L,1L);
        //assert
        assertThat(progressModelList).isEqualTo(List.of(userLessonProgressModel));
    }

    @Test
    void test_updatelessonprogress_successful(){
        //arrange
        User_LessonProgressModel existingProgress = mock(User_LessonProgressModel.class);
        User_LessonProgressModel updatedProgress = mock(User_LessonProgressModel.class);
        when(existingProgress.getUserId()).thenReturn(1L);
        when(existingProgress.getLessonId()).thenReturn(1L);
        when(updatedProgress.getUserId()).thenReturn(1L);
        when(updatedProgress.getLessonId()).thenReturn(1L);
        when(userLessonProgressRepo.findByLessonIdAndUserId(1L,1L)).thenReturn(existingProgress);
        //act
        trainingService.updateLessonProgress(updatedProgress);
        //assert
        verify(userLessonProgressModelMapper, times(1)).updateFields(any(User_LessonProgressModel.class), any(User_LessonProgressModel.class));
        verify(userLessonProgressRepo, times(1)).save(any(User_LessonProgressModel.class));
    }
}
