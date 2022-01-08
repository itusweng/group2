package com.trainingplatform.notificationservice.controller;

import com.trainingplatform.notificationservice.constants.QueueDefinitions;
import com.trainingplatform.notificationservice.model.request.UserParticipatedNotificationRequestDTO;
import com.trainingplatform.notificationservice.service.UserNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notification")
public class NotificationController {

    private final UserNotificationService userNotificationService;

    @GetMapping("/test")
    public ResponseEntity test() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok("Success");
    }

    @RabbitListener(queues = QueueDefinitions.SendTrainingParticipationNotification.QUEUE_NAME)
    public void createUserParticipatedToTrainingNotification(UserParticipatedNotificationRequestDTO requestDTO) {
        try {
            Long trainingID = requestDTO.getTrainingId();
            String trainingTitle = requestDTO.getTrainingTitle();
            Long userID = requestDTO.getUserId();
            userNotificationService.createUserParticipatedToTrainingNotification(trainingID, trainingTitle, userID);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
