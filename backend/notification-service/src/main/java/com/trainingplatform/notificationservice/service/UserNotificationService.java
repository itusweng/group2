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

    public void createUserParticipatedToTrainingNotification(Long trainingID, Long userID) {
        User_TrainingParticipationNotifModel model = User_TrainingParticipationNotifModel.builder()
                .trainingId(trainingID)
                .userId(userID)
                .isRead(false)
                .message(NotificationMessages.User.TRAINING_PARTICIPATION)
                .build();

        trainingParticipationRepo.save(model);
    }
}
