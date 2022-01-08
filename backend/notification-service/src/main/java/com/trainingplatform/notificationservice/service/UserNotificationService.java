package com.trainingplatform.notificationservice.service;

import com.trainingplatform.notificationservice.constants.NotificationMessages;
import com.trainingplatform.notificationservice.model.entity.User_TrainingParticipationNotifModel;
import com.trainingplatform.notificationservice.repository.User_TrainingParticipationNotifRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserNotificationService {

    private final User_TrainingParticipationNotifRepo trainingParticipationRepo;

    public void createUserParticipatedToTrainingNotification(Long trainingID, String trainingTitle, Long userID) {
        User_TrainingParticipationNotifModel model = User_TrainingParticipationNotifModel.builder()
                .trainingId(trainingID)
                .userId(userID)
                .trainingTitle(trainingTitle)
                .isRead(false)
                .message(String.format(NotificationMessages.User.TRAINING_PARTICIPATION, trainingTitle))
                .build();

        trainingParticipationRepo.save(model);
    }
}
