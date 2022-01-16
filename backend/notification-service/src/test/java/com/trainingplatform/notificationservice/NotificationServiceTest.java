package com.trainingplatform.notificationservice;

import com.trainingplatform.notificationservice.model.entity.UserNotificationModel;
import com.trainingplatform.notificationservice.repository.UserNotificationRepo;
import com.trainingplatform.notificationservice.service.UserNotificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class NotificationServiceTest {

    @InjectMocks
    UserNotificationService userNotificationService;

    @Mock
    private UserNotificationRepo userNotificationRepo;

    @Test
    public void it_should_return_all_notifications_when_user_given(){
        //arrange
        UserNotificationModel userNotificationModel = mock(UserNotificationModel.class);
        Page<UserNotificationModel> pageModel = mock(Page.class);
        Long userId = 1L;
        Integer page = 1;
        Integer size = 1;
        when(userNotificationRepo.findAllByRecipientId(userId, PageRequest.of(page, size))).thenReturn(pageModel);
        when(pageModel.getContent()).thenReturn(List.of(userNotificationModel));
        //act
        List<UserNotificationModel> notifs = userNotificationService.getAllUserNotificationByUserId(userId, page, size);
        //assert
        assertThat(notifs).isEqualTo(List.of(userNotificationModel));
    }

    @Test
    public void it_should_return_unread_notifications_when_user_given(){
        //arrange
        UserNotificationModel userNotificationModel = mock(UserNotificationModel.class);
        Page<UserNotificationModel> pageModel = mock(Page.class);
        Long userId = 1L;
        Integer page = 1;
        Integer size = 1;
        when(userNotificationRepo.findAllByIsReadIsFalseAndRecipientId(userId, PageRequest.of(page, size))).thenReturn(pageModel);
        when(pageModel.getContent()).thenReturn(List.of(userNotificationModel));
        //act
        List<UserNotificationModel> notifs = userNotificationService.getAllUnreadUserNotificationByUserId(userId, page, size);
        //assert
        assertThat(notifs).isEqualTo(List.of(userNotificationModel));
    }

    @Test
    public void it_should_return_notification_count_when_user_given(){
        //arrange
        Long userId = 1L;
        when(userNotificationRepo.countAllUserNotificationByUserId(userId)).thenReturn(2L);
        //act
        Long count = userNotificationService.countOfAllUserNotificationByUserId(userId);
        //assert
        assertThat(count).isEqualTo(2L);
    }

    @Test
    public void it_should_return_unread_notification_count_when_user_given(){
        //arrange
        Long userId = 1L;
        when(userNotificationRepo.countAllUnreadUserNotificationByUserId(userId)).thenReturn(2L);
        //act
        Long count = userNotificationService.countOfUnreadUserNotificationByUserId(userId);
        //assert
        assertThat(count).isEqualTo(2L);
    }

    @Test
    public void it_should_create_notif(){
        //arrange
        //act
        userNotificationService.createUserParticipatedToTrainingNotification("training", 1L);
        //assert
        verify(userNotificationRepo, times(1)).save(any(UserNotificationModel.class));
    }

    @Test
    public void it_should_make_notifs_read() throws Exception {
        //arrange
        List<Long> notificationIds = new ArrayList<>();
        notificationIds.add(1L);
        UserNotificationModel notification = mock(UserNotificationModel.class);
        when(userNotificationRepo.getById(1L)).thenReturn(notification);
        //act
        userNotificationService.setNotificationsHaveReadById(List.of(1L));
        //assert
        verify(userNotificationRepo, times(1)).save(any(UserNotificationModel.class));

    }
}
