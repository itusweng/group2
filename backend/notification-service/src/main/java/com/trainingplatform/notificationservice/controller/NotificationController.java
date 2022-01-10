package com.trainingplatform.notificationservice.controller;

import com.trainingplatform.notificationservice.constants.QueueDefinitions;
import com.trainingplatform.notificationservice.model.entity.UserNotificationModel;
import com.trainingplatform.notificationservice.model.mapper.UserNotificationMapper;
import com.trainingplatform.notificationservice.model.request.GetAllUserNotificationsRequestDTO;
import com.trainingplatform.notificationservice.model.request.SetReadNotificationsRequestDTO;
import com.trainingplatform.notificationservice.model.request.UserParticipatedNotificationRequestDTO;
import com.trainingplatform.notificationservice.model.response.GetAllUserNotificationsResponseDTO;
import com.trainingplatform.notificationservice.service.UserNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notification")
public class NotificationController extends BaseController {

    private final UserNotificationService userNotificationService;
    private final UserNotificationMapper userNotificationMapper;

    @PostMapping("/user/getAllByUserId")
    public ResponseEntity<Map<String, Object>> getAllUserNotificationsByUserId(@RequestBody GetAllUserNotificationsRequestDTO requestDTO) {
        try {
            Long userId = requestDTO.getUserId();
            Integer page = requestDTO.getPage();
            Integer size = requestDTO.getSize();

            List<UserNotificationModel> notifications = userNotificationService.getAllUserNotificationByUserId(userId, page, size);
            Long notificationCount = userNotificationService.countOfAllUserNotificationByUserId(userId);

            GetAllUserNotificationsResponseDTO responseDTO = GetAllUserNotificationsResponseDTO.builder()
                    .notifications(userNotificationMapper.mapToDto(notifications))
                    .total(notificationCount)
                    .build();

            return ResponseEntity.ok(createReturnObj(String.format("All user notifications are fetched by user id: %d", userId), responseDTO));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/user/getAllUnreadByUserId")
    public ResponseEntity<Map<String, Object>> getAllUnreadUserNotificationsByUserId(@RequestBody GetAllUserNotificationsRequestDTO requestDTO) {
        try {
            Long userId = requestDTO.getUserId();
            Integer page = requestDTO.getPage();
            Integer size = requestDTO.getSize();

            List<UserNotificationModel> notifications = userNotificationService.getAllUnreadUserNotificationByUserId(userId, page, size);
            Long notificationCount = userNotificationService.countOfUnreadUserNotificationByUserId(userId);

            GetAllUserNotificationsResponseDTO responseDTO = GetAllUserNotificationsResponseDTO.builder()
                    .notifications(userNotificationMapper.mapToDto(notifications))
                    .total(notificationCount)
                    .build();

            return ResponseEntity.ok(createReturnObj(String.format("Unread user notifications are fetched by user id: %d", userId), responseDTO));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/user/notificationsHaveRead")
    public ResponseEntity<Map<String, Object>> setReadNotificationsByUserId(@RequestBody SetReadNotificationsRequestDTO requestDTO) {
        try {
            List<Long> notificationIds = requestDTO.getNotificationIds();
            userNotificationService.setNotificationsHaveReadById(notificationIds);

            return ResponseEntity.ok(createReturnObj("Notifications updated!", null));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @RabbitListener(queues = QueueDefinitions.SendTrainingParticipationNotification.QUEUE_NAME)
    public void createUserParticipatedToTrainingNotification(UserParticipatedNotificationRequestDTO requestDTO) {
        try {
            String trainingTitle = requestDTO.getTrainingTitle();
            Long userID = requestDTO.getUserId();
            userNotificationService.createUserParticipatedToTrainingNotification(trainingTitle, userID);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
