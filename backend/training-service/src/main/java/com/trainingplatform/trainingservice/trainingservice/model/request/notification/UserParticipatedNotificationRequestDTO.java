package com.trainingplatform.trainingservice.trainingservice.model.request.notification;

import com.trainingplatform.trainingservice.trainingservice.model.request.BaseRequestDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserParticipatedNotificationRequestDTO extends BaseRequestDTO {

    private Long trainingId;
    private Long userId;
}
