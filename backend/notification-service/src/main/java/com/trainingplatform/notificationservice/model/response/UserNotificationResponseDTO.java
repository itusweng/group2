package com.trainingplatform.notificationservice.model.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserNotificationResponseDTO extends BaseResponseDTO {

    private Long id;
    private Long recipientId;
    private Long senderId;
    private String message;
    private boolean isRead;
    private String type;
    private Date createdDate;
    private Date readDate;

}
