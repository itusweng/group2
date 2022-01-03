package com.trainingplatform.trainingservice.trainingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trainingplatform.trainingservice.trainingservice.communication.UserClient;
import com.trainingplatform.trainingservice.trainingservice.constants.Constants;
import com.trainingplatform.trainingservice.trainingservice.exception.TrainingCrudException;
import com.trainingplatform.trainingservice.trainingservice.exception.TrainingParticipationException;
import com.trainingplatform.trainingservice.trainingservice.exception.TrainingUserNotFoundException;
import com.trainingplatform.trainingservice.trainingservice.model.entity.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.entity.User_ParticipatedTrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.entity.User_RequestedTrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.request.ParticipationApproveRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.ParticipationPendingRequestsListAllRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.ParticipationRejectRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.*;
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
    private final TrainingModelMapper trainingMapper;
    private final ObjectMapper objectMapper;

    public Map<Long, Boolean> addParticipantsToTraining(Long trainingId, List<Long> participantIdList) throws TrainingCrudException {
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

    public void requestParticipation(Long trainingId, Long userId) {
        // TODO: CHECK QUOTA IS FULL OR NOT

        Map<String, Object> managerGroupResponse = userClient.getManagerGroupId(userId).getBody();
        ManagerGroupResponseDTO managerGroupResponseDTO = objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS).convertValue(managerGroupResponse.get("data"), ManagerGroupResponseDTO.class);
        User_RequestedTrainingModel requestedTrainingUserModel = User_RequestedTrainingModel.builder()
                .userId(userId)
                .trainingId(trainingId)
                .managerGroupId(managerGroupResponseDTO.getManagerGroupId())
                .createdDate(new Date())
                .status(Constants.Training.Participation.RequestType.PENDING).build();

        trainingRequestedRepo.save(requestedTrainingUserModel);
    }

    public List<PendingParticipationResponseDTO> listAllPendingRequests(ParticipationPendingRequestsListAllRequestDTO requestDTO) {
        List<User_RequestedTrainingModel> requestedList = trainingRequestedRepo.findByManagerGroupIdAndStatusEquals(requestDTO.getManagerId(),
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

    public void addSingleParticipantToTraining(Long trainingId, Long userId) throws TrainingUserNotFoundException, TrainingCrudException {

        validateTrainingUser(userId);
        validateTraining(trainingId);

        User_ParticipatedTrainingModel participatedTrainingModel = User_ParticipatedTrainingModel
                .builder()
                .userId(userId)
                .trainingId(trainingId)
                .participatedDate(new Date())
                .build();

        trainingParticipatedRepo.save(participatedTrainingModel);
    }

    public boolean checkTrainingExistsByTrainingId(Long trainingId) {
        return trainingRepo.existsById(trainingId);
    }

    public List<ParticipationApproveResponseDTO> approveParticipation(List<ParticipationApproveRequestDTO> requestDTOs) {

        // TODO: CHECK QUOTA IS ENOUGH OR NOT
        List<ParticipationApproveResponseDTO> approveResponseDTOList = new ArrayList<>();

        requestDTOs.forEach(requestToBeApproved -> {
            Long trainingId = requestToBeApproved.getTrainingId();
            Long userId = requestToBeApproved.getUserId();


            // Create response dto
            ParticipationApproveResponseDTO responseDTO = ParticipationApproveResponseDTO.builder()
                    .trainingId(trainingId)
                    .userId(userId)
                    .build();
            try {
                validateTraining(trainingId);
                validateTrainingUser(userId);
                validateTrainingParticipationRequest(trainingId, userId);

                User_RequestedTrainingModel participationRequest = trainingRequestedRepo.findByTrainingIdAndUserId(trainingId, userId);

                // Update participation request
                participationRequest.setRespondedDate(new Date());
                participationRequest.setStatus(Constants.Training.Participation.RequestType.APPROVED);
                trainingRequestedRepo.save(participationRequest);

                // Add participant to db
                addSingleParticipantToTraining(trainingId, userId);

                // Set response dto opStatus as success
                responseDTO.setOpStatus(Constants.Training.Participation.OpStatus.SUCCESS);

            } catch (Exception e) {
                // Set response dto opStatus as failed
                responseDTO.setOpStatus(Constants.Training.Participation.OpStatus.FAILED);
            }

            approveResponseDTOList.add(responseDTO);
        });

        return approveResponseDTOList;
    }

    public List<ParticipationRejectResponseDTO> rejectParticipation(List<ParticipationRejectRequestDTO> requestDTOs) {
        List<ParticipationRejectResponseDTO> rejectResponseDTOList = new ArrayList<>();

        requestDTOs.forEach(requestToBeRejected -> {
            Long trainingId = requestToBeRejected.getTrainingId();
            Long userId = requestToBeRejected.getUserId();
            User_RequestedTrainingModel participationRequest = trainingRequestedRepo.findByTrainingIdAndUserId(trainingId, userId);

            // Create response dto
            ParticipationRejectResponseDTO responseDTO = ParticipationRejectResponseDTO.builder()
                    .trainingId(trainingId)
                    .userId(userId)
                    .build();
            try {
                validateTraining(trainingId);
                validateTrainingUser(userId);
                validateTrainingParticipationRequest(trainingId, userId);

                // Update participation request
                participationRequest.setRespondedDate(new Date());
                participationRequest.setStatus(Constants.Training.Participation.RequestType.REJECTED);
                trainingRequestedRepo.save(participationRequest);

                // Set response dto opStatus as success
                responseDTO.setOpStatus(Constants.Training.Participation.OpStatus.SUCCESS);

            } catch (Exception e) {
                // Set response dto opStatus as failed
                responseDTO.setOpStatus(Constants.Training.Participation.OpStatus.FAILED);
            }

            rejectResponseDTOList.add(responseDTO);
        });

        return rejectResponseDTOList;
    }

    public void validateTrainingUser(Long userId) throws TrainingUserNotFoundException {
        // Check user exists
        if (!((boolean) userClient.checkUserExistsByUserId(userId).getBody().get("data")))
            throw new TrainingUserNotFoundException("There is no user by id: \n" + userId);
    }

    public void validateTraining(Long trainingId) throws TrainingCrudException {
        // Check training exists
        if (!this.checkTrainingExistsByTrainingId(trainingId))
            throw new TrainingCrudException("Training not found by id: \n" + trainingId);

    }

    public void validateTrainingParticipationRequest(Long trainingId, Long userId) throws TrainingParticipationException {
        // Check participation request exists
        if (!trainingRequestedRepo.existsByTrainingIdAndUserId(trainingId, userId))
            throw new TrainingParticipationException("Training participation request is not found " +
                    "by training id: " + trainingId +
                    "and user id: \n" + userId);
    }
}
