package com.trainingplatform.notificationservice.service;

import com.trainingplatform.notificationservice.constants.NotificationMessages;
import com.trainingplatform.notificationservice.constants.NotificationTypes;
import com.trainingplatform.notificationservice.constants.SystemConstants;
import com.trainingplatform.notificationservice.model.entity.UserNotificationModel;
import com.trainingplatform.notificationservice.repository.UserNotificationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserNotificationService {

    private final UserNotificationRepo userNotificationRepo;

    public List<UserNotificationModel> getAllUserNotificationByUserId(Long userId, Integer page, Integer size) {

        List<UserNotificationModel> notifications = userNotificationRepo
                .findAllByRecipientId(userId, PageRequest.of(page, size)).getContent();

        return notifications;
    }

    public List<UserNotificationModel> getAllUnreadUserNotificationByUserId(Long userId, Integer page, Integer size) {

        List<UserNotificationModel> notifications = userNotificationRepo
                .findAllByIsReadIsFalseAndRecipientId(userId, PageRequest.of(page, size)).getContent();

        return notifications;
    }

    public Long countOfAllUserNotificationByUserId(Long userId) {
        return userNotificationRepo.countAllUnreadUserNotificationByUserId(userId);
    }

    public Long countOfUnreadUserNotificationByUserId(Long userId) {
        return userNotificationRepo.countAllUnreadUserNotificationByUserId(userId);
    }

    public void createUserParticipatedToTrainingNotification(String trainingTitle, Long userID) {
        UserNotificationModel model = UserNotificationModel.builder()
                .senderId(SystemConstants.SYSTEM_ID)
                .recipientId(userID)
                .isRead(false)
                .type(NotificationTypes.ENROLLED_TRAINING_NOTIFICATION)
                .createdDate(new Date())
                .message(String.format(NotificationMessages.User.TRAINING_PARTICIPATION, trainingTitle))
                .build();

        userNotificationRepo.save(model);
    }

    @Transactional
    public void setNotificationsHaveReadById(List<Long> notificationIds) throws Exception {
        try {
            notificationIds.forEach(id -> {
                UserNotificationModel notification = userNotificationRepo.getById(id);
                notification.setRead(true);
                userNotificationRepo.save(notification);
            });
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new Exception("Database Error!");
        }
    }
}
