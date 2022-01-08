package com.trainingplatform.notificationservice.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
public class GetAllUserNotificationsResponseDTO extends BaseResponseDTO {

    private List<UserNotificationResponseDTO> notifications;
    private Long total;

}
