package com.trainingplatform.trainingservice.trainingservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trainingplatform.trainingservice.trainingservice.communication.UserClient;
import com.trainingplatform.trainingservice.trainingservice.constants.Constants;
import com.trainingplatform.trainingservice.trainingservice.exception.TrainingCrudException;
import com.trainingplatform.trainingservice.trainingservice.exception.TrainingUserNotFoundException;
import com.trainingplatform.trainingservice.trainingservice.model.entity.*;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.request.trainingparticipation.ParticipationApproveRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.trainingparticipation.ParticipationPendingRequestsListAllRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.trainingparticipation.ParticipationRejectRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.ManagerGroupResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.trainingparticipation.ParticipationApproveResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.trainingparticipation.ParticipationRejectResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.trainingparticipation.PendingParticipationResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.*;
import com.trainingplatform.trainingservice.trainingservice.service.TrainingParticipationService;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TrainingParticipationServiceTest {

    @InjectMocks
    TrainingParticipationService trainingParticipationService;

    @Mock
    private User_ParticipatedTrainingRepo trainingParticipatedRepo;
    @Mock
    private User_RequestedTrainingRepo trainingRequestedRepo;
    @Mock
    private UserClient userClient;
    @Mock
    private TrainingRepository trainingRepo;
    @Mock
    private TrainingModelMapper trainingMapper;
    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private RabbitTemplate rabbitTemplate;
    @Mock
    private OfflineLessonRepository offlineLessonRepo;
    @Mock
    private OnlineLessonRepository onlineLessonRepo;
    @Mock
    private User_LessonProgressRepo lessonProgressRepo;
    @Captor
    private ArgumentCaptor<User_ParticipatedTrainingModel> argumentCaptor;
    @Captor
    private ArgumentCaptor<User_LessonProgressModel> argumentCaptorUser_LessonProgressModel;

    @Test
    public void it_should_return_map_when_participants_added() throws TrainingCrudException {
        //arrange
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingRepo.findById(1L)).thenReturn(Optional.of(trainingModel));
        List<Long> participantIdList = new ArrayList<>();
        participantIdList.add(1L);
        User_ParticipatedTrainingModel trainingParticipatedUser = mock(User_ParticipatedTrainingModel.class);
        when(trainingParticipatedUser.getUserId()).thenReturn(1L);
        when(trainingParticipatedUser.getTrainingId()).thenReturn(1L);
        Map<Long, Boolean> isUserAddedToTrainingMap = new HashMap<>();
        isUserAddedToTrainingMap.put(1L, true);
        //act
        Map<Long, Boolean> isUserAddedToTrainingMap1 = trainingParticipationService.addParticipantsToTraining(1L, participantIdList);
        //assert
        assertThat(isUserAddedToTrainingMap).isEqualTo(isUserAddedToTrainingMap1);
    }

    @Test
    public void it_should_catch_feignexception_when_user_not_found() throws TrainingCrudException {
        //arrange
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingRepo.findById(1L)).thenReturn(Optional.of(trainingModel));
        FeignException.NotFound exception = mock(FeignException.NotFound.class);
        when(userClient.getUserByID(1L)).thenThrow(exception);
        List<Long> participantIdList = new ArrayList<>();
        participantIdList.add(1L);
        Map<Long, Boolean> isUserAddedToTrainingMap = new HashMap<>();
        isUserAddedToTrainingMap.put(1L, false);
        //act
        Map<Long, Boolean> isUserAddedToTrainingMap1 = trainingParticipationService.addParticipantsToTraining(1L, participantIdList);
        //assert
        assertThat(isUserAddedToTrainingMap).isEqualTo(isUserAddedToTrainingMap1);
    }

    @Test
    public void test_requestParticipation() {
        //arrange
        Map<String, Object> managerGroupResponse = new HashMap<String, Object>();
        Object object = mock(Object.class);
        managerGroupResponse.put("data", object);
        ResponseEntity response = mock(ResponseEntity.class);
        when(userClient.getManagerGroupId(1L)).thenReturn(response);
        when(userClient.getManagerGroupId(1L).getBody()).thenReturn(managerGroupResponse);
        ManagerGroupResponseDTO managerGroupResponseDTO = mock(ManagerGroupResponseDTO.class);
        ObjectMapper objectMapper1 = mock(ObjectMapper.class);
        when(objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)).thenReturn(objectMapper1);
        when(objectMapper1.convertValue(managerGroupResponse.get("data"), ManagerGroupResponseDTO.class)).thenReturn(managerGroupResponseDTO);
        User_RequestedTrainingModel requestedTrainingUserModel = mock(User_RequestedTrainingModel.class);
        //act
        trainingParticipationService.requestParticipation(1L, 1L);
        //assert
        verify(trainingRequestedRepo, times(1)).save(any(User_RequestedTrainingModel.class));
    }


    @Test
    public void it_should_return_pending_participation_list() throws TrainingUserNotFoundException {
        //arrange
        ParticipationPendingRequestsListAllRequestDTO requestDTO = mock(ParticipationPendingRequestsListAllRequestDTO.class);
        User_RequestedTrainingModel user_requestedTrainingModel = mock(User_RequestedTrainingModel.class);
        when(requestDTO.getManagerGroupId()).thenReturn(1L);
        when(trainingRequestedRepo.findByManagerGroupIdAndStatusEquals(requestDTO.getManagerGroupId(), Constants.Training.Participation.RequestType.PENDING)).thenReturn(List.of(user_requestedTrainingModel));
        when(user_requestedTrainingModel.getTrainingId()).thenReturn(1L);
        when(user_requestedTrainingModel.getUserId()).thenReturn(1L);
        ResponseEntity response = mock(ResponseEntity.class);
        when(userClient.getUserByID(1L)).thenReturn(response);
        Map<String, Object> map = mock(Map.class);
        Map<String, String> userModelMap = mock(Map.class);
        when(userClient.getUserByID(1L).getBody()).thenReturn(map);
        when(userClient.getUserByID(1L).getBody().get("data")).thenReturn(userModelMap);
        UserResponseDTO userResponseDTO = mock(UserResponseDTO.class);
        ObjectMapper objectMapper1 = mock(ObjectMapper.class);
        when(objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)).thenReturn(objectMapper1);
        when(objectMapper1.convertValue(userModelMap, UserResponseDTO.class)).thenReturn(userResponseDTO);
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingRepo.findById(1L)).thenReturn(Optional.of(trainingModel));
        TrainingResponseDTO trainingResponseDTO = mock(TrainingResponseDTO.class);
        when(trainingMapper.mapToDto(trainingModel)).thenReturn(trainingResponseDTO);
        //act
        List<PendingParticipationResponseDTO> pendingRequests1 = trainingParticipationService.listAllPendingRequests(requestDTO);
        //assert
        assertThat(pendingRequests1.get(0).getRequested_training()).isEqualTo(trainingResponseDTO);
        assertThat(pendingRequests1.get(0).getRequested_user()).isEqualTo(userResponseDTO);
        assertThat(pendingRequests1.get(0).getStatus()).isEqualTo(Constants.Training.Participation.RequestType.PENDING);
    }

    @Test
    public void it_should_addsingleparticipanttotraining() throws TrainingUserNotFoundException, TrainingCrudException {
        //arrange
        Long trainingId = 1L;
        Long userId = 1L;
        ResponseEntity response = mock(ResponseEntity.class);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("data", true);
        when(userClient.checkUserExistsByUserId(userId)).thenReturn(response);
        when(response.getBody()).thenReturn(responseMap);
        when(trainingRepo.existsById(trainingId)).thenReturn(true);
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingRepo.findById(trainingId)).thenReturn(Optional.of(trainingModel));
        //act
        trainingParticipationService.addSingleParticipantToTraining(1L, 1L);
        //assert
        verify(trainingParticipatedRepo, times(1)).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().getTrainingId()).isEqualTo(trainingId);
        assertThat(argumentCaptor.getValue().getUserId()).isEqualTo(userId);
    }

    @Test
    public void it_should_return_participation_approved_list_when_participation_approved_for_online_training(){
        //arrange
        Long trainingId = 1L;
        Long userId = 1L;
        ParticipationApproveRequestDTO participationApproveRequestDTO = mock(ParticipationApproveRequestDTO.class);
        when(participationApproveRequestDTO.getTrainingId()).thenReturn(trainingId);
        when(participationApproveRequestDTO.getUserId()).thenReturn(userId);
        ResponseEntity response = mock(ResponseEntity.class);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("data", true);
        when(userClient.checkUserExistsByUserId(userId)).thenReturn(response);
        when(response.getBody()).thenReturn(responseMap);
        when(trainingRepo.existsById(trainingId)).thenReturn(true);
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingRepo.findById(trainingId)).thenReturn(Optional.of(trainingModel));
        when(trainingModel.getIs_online()).thenReturn(true);
        OnlineLessonModel onlineLessonModel = mock(OnlineLessonModel.class);
        when(onlineLessonRepo.findAllByTrainingID(trainingId)).thenReturn(List.of(onlineLessonModel));
        when(trainingRequestedRepo.existsByTrainingIdAndUserId(trainingId, userId)).thenReturn(true);
        User_RequestedTrainingModel user_requestedTrainingModel = mock(User_RequestedTrainingModel.class);
        when(trainingRequestedRepo.findByTrainingIdAndUserId(trainingId, userId)).thenReturn(user_requestedTrainingModel);

        //act
        List<ParticipationApproveResponseDTO> approvedParticipation  = trainingParticipationService.approveParticipation(List.of(participationApproveRequestDTO));
        //assert
        assertThat(approvedParticipation.get(0).getTrainingId()).isEqualTo(trainingId);
        assertThat(approvedParticipation.get(0).getUserId()).isEqualTo(userId);
        assertThat(approvedParticipation.get(0).getOpStatus()).isEqualTo(Constants.Training.Participation.OpStatus.SUCCESS);
        verify(lessonProgressRepo, atLeastOnce()).save(argumentCaptorUser_LessonProgressModel.capture());
        assertThat(argumentCaptorUser_LessonProgressModel.getValue().getUserId()).isEqualTo(userId);
    }

    @Test
    public void it_should_return_participation_approved_list_when_participation_approved_for_offline_training(){
        //arrange
        Long trainingId = 1L;
        Long userId = 1L;
        ParticipationApproveRequestDTO participationApproveRequestDTO = mock(ParticipationApproveRequestDTO.class);
        when(participationApproveRequestDTO.getTrainingId()).thenReturn(trainingId);
        when(participationApproveRequestDTO.getUserId()).thenReturn(userId);
        ResponseEntity response = mock(ResponseEntity.class);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("data", true);
        when(userClient.checkUserExistsByUserId(userId)).thenReturn(response);
        when(response.getBody()).thenReturn(responseMap);
        when(trainingRepo.existsById(trainingId)).thenReturn(true);
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingRepo.findById(trainingId)).thenReturn(Optional.of(trainingModel));
        when(trainingModel.getIs_online()).thenReturn(false);
        OfflineLessonModel offlineLessonModel = mock(OfflineLessonModel.class);
        when(offlineLessonRepo.findAllByTrainingID(trainingId)).thenReturn(List.of(offlineLessonModel));
        when(trainingRequestedRepo.existsByTrainingIdAndUserId(trainingId, userId)).thenReturn(true);
        User_RequestedTrainingModel user_requestedTrainingModel = mock(User_RequestedTrainingModel.class);
        when(trainingRequestedRepo.findByTrainingIdAndUserId(trainingId, userId)).thenReturn(user_requestedTrainingModel);

        //act
        List<ParticipationApproveResponseDTO> approvedParticipation  = trainingParticipationService.approveParticipation(List.of(participationApproveRequestDTO));
        //assert
        assertThat(approvedParticipation.get(0).getTrainingId()).isEqualTo(trainingId);
        assertThat(approvedParticipation.get(0).getUserId()).isEqualTo(userId);
        assertThat(approvedParticipation.get(0).getOpStatus()).isEqualTo(Constants.Training.Participation.OpStatus.SUCCESS);
        verify(lessonProgressRepo, atLeastOnce()).save(argumentCaptorUser_LessonProgressModel.capture());
        assertThat(argumentCaptorUser_LessonProgressModel.getValue().getUserId()).isEqualTo(userId);
    }

    @Test
    public void it_should_return_participation_reject_list_when_participation_approved_for_online_training(){
        //arrange
        Long trainingId = 1L;
        Long userId = 1L;
        ParticipationRejectRequestDTO participationRejectRequestDTO = mock(ParticipationRejectRequestDTO.class);
        when(participationRejectRequestDTO.getTrainingId()).thenReturn(trainingId);
        when(participationRejectRequestDTO.getUserId()).thenReturn(userId);
        ResponseEntity response = mock(ResponseEntity.class);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("data", true);
        when(userClient.checkUserExistsByUserId(userId)).thenReturn(response);
        when(response.getBody()).thenReturn(responseMap);
        when(trainingRepo.existsById(trainingId)).thenReturn(true);
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingRepo.findById(trainingId)).thenReturn(Optional.of(trainingModel));
        when(trainingModel.getIs_online()).thenReturn(true);
        OnlineLessonModel onlineLessonModel = mock(OnlineLessonModel.class);
        when(onlineLessonRepo.findAllByTrainingID(trainingId)).thenReturn(List.of(onlineLessonModel));
        when(trainingRequestedRepo.existsByTrainingIdAndUserId(trainingId, userId)).thenReturn(true);
        User_RequestedTrainingModel user_requestedTrainingModel = mock(User_RequestedTrainingModel.class);
        when(trainingRequestedRepo.findByTrainingIdAndUserId(trainingId, userId)).thenReturn(user_requestedTrainingModel);

        //act
       List<ParticipationRejectResponseDTO> rejectedParticipation = trainingParticipationService.rejectParticipation(List.of(participationRejectRequestDTO));
        //assert
        assertThat(rejectedParticipation.get(0).getTrainingId()).isEqualTo(trainingId);
        assertThat(rejectedParticipation.get(0).getUserId()).isEqualTo(userId);
    }

    @Test
    public void it_should_return_all_participants_when_training_found(){
        //arrange
        User_ParticipatedTrainingModel participatedTrainingModel = mock(User_ParticipatedTrainingModel.class);
        when(trainingParticipatedRepo.findByTrainingId(1L)).thenReturn(List.of(participatedTrainingModel));
        when(participatedTrainingModel.getUserId()).thenReturn(1L);
        //act
        List<Long> userIds = trainingParticipationService.getAllParticipantIdsByTrainingId(1L);
        //assert
        assertThat(userIds.get(0)).isEqualTo(1L);
    }
}
