package com.trainingplatform.trainingservice.trainingservice.service;

import com.trainingplatform.trainingservice.trainingservice.communication.UserClient;
import com.trainingplatform.trainingservice.trainingservice.exception.TrainingCrudException;
import com.trainingplatform.trainingservice.trainingservice.model.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.User_ParticipatedTrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.User_RequestedTrainingModel;
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


    public Map<Long,Boolean> addParticipantToTraining(Long trainingId, List<Long> participantIdList) throws TrainingCrudException {
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
                        .user_id(userId)
                        .training_id(trainingId)
                        .participatedDate(new Date())
                        .build();

                trainingParticipatedRepo.save(trainingParticipatedUser);
                isUserAddedToTrainingMap.put(userId, true);
            } catch (FeignException.NotFound e) {
                isUserAddedToTrainingMap.put(userId, false);
            }
            catch (Exception e){
                isUserAddedToTrainingMap.put(userId, false);
            }
        });
        return isUserAddedToTrainingMap;
    }

    public void requestParticipation(Long trainingId, Long userId) throws TrainingCrudException {
        TrainingModel training = trainingService.getTrainingById(trainingId);
        Long instructorId = training.getInstructor_id();
        User_RequestedTrainingModel requestedTrainingUserModel = User_RequestedTrainingModel.builder()
                .user_id(userId)
                .training_id(trainingId)
                .instructor_id(instructorId)
                .created_date(new Date())
                .status("pending").build();

        trainingRequestedRepo.save(requestedTrainingUserModel);
    }

}
