package com.trainingplatform.notificationservice.model.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SetReadNotificationsRequestDTO extends BaseRequestDTO {

    private List<Long> notificationIds;
}
