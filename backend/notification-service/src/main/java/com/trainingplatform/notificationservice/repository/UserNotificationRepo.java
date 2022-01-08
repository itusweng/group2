package com.trainingplatform.notificationservice.repository;

import com.trainingplatform.notificationservice.model.entity.UserNotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserNotificationRepo extends JpaRepository<UserNotificationModel, Long> {

}
