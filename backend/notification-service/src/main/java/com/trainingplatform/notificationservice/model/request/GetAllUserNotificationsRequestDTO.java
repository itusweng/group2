package com.trainingplatform.notificationservice.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetAllUserNotificationsRequestDTO extends BaseRequestDTO{

    private Long userId;
    private Integer page;
    private Integer size;

}
