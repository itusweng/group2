package com.trainingplatform.notificationservice.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User_TrainingParticipationNotif", schema = "tp-notificationservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User_TrainingParticipationNotifModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="training_id")
    private Long trainingId;

    @Column(name="user_id")
    private Long userId;

    @Column(name="message")
    private String message;

    @Column(name="is_read")
    private boolean isRead;


}
