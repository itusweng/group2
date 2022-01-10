package com.trainingplatform.notificationservice.repository;

import com.trainingplatform.notificationservice.model.entity.UserNotificationModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserNotificationRepo extends JpaRepository<UserNotificationModel, Long> {

    Page<UserNotificationModel> findAllByIsReadIsFalseAndRecipientId(Long recipientId, Pageable pageable);

    Page<UserNotificationModel> findAllByRecipientId(Long recipientId, Pageable pageable);

    @Query("select count(*) from UserNotificationModel n where n.recipientId = ?1")
    long countAllUserNotificationByUserId(Long userId);

    @Query("select count(*) from UserNotificationModel n where n.recipientId = ?1 and n.isRead=false")
    long countAllUnreadUserNotificationByUserId(Long userId);

}
