package com.trainingplatform.notificationservice.service;

import com.trainingplatform.notificationservice.constants.NotificationMessages;
import com.trainingplatform.notificationservice.constants.NotificationTypes;
import com.trainingplatform.notificationservice.constants.SystemConstants;
import com.trainingplatform.notificationservice.model.entity.UserNotificationModel;
import com.trainingplatform.notificationservice.repository.UserNotificationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserNotificationService {

    private final UserNotificationRepo trainingParticipationRepo;

    public void createUserParticipatedToTrainingNotification(String trainingTitle, Long userID) {
        UserNotificationModel model = UserNotificationModel.builder()
                .senderID(SystemConstants.SYSTEM_ID)
                .recipientId(userID)
                .isRead(false)
                .type(NotificationTypes.ENROLLED_TRAINING_NOTIFICATION)
                .createdDate(new Date())
                .message(String.format(NotificationMessages.User.TRAINING_PARTICIPATION, trainingTitle))
                .build();

        trainingParticipationRepo.save(model);
    }


}
