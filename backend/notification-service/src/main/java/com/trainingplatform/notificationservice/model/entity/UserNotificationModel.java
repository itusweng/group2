package com.trainingplatform.notificationservice.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UserNotification", schema = "tp-notificationservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserNotificationModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="recipient_id")
    private Long recipientId;

    @Column(name="sender_id")
    private Long senderId;

    @Column(name="message")
    private String message;

    @Column(name="is_read")
    private boolean isRead;

    @Column(name = "type")
    private String type;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "read_date")
    private Date readDate;

}
