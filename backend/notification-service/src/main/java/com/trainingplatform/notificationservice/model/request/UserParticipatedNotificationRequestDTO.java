package com.trainingplatform.notificationservice.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserParticipatedNotificationRequestDTO extends BaseRequestDTO {

    private String trainingTitle;
    private Long userId;

}
