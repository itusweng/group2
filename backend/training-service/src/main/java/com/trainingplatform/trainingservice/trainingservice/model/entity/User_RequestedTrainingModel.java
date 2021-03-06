package com.trainingplatform.trainingservice.trainingservice.model.entity;

import com.trainingplatform.trainingservice.trainingservice.model.entity.composite_keys.User_TrainingPK;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "User_RequestedTraining", schema = "tp-userservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@IdClass(User_TrainingPK.class)
public class User_RequestedTrainingModel {

    @Id
    @Column(name = "training_id")
    private Long trainingId;

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "manager_group_id")
    private Long managerGroupId;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "responded_date")
    private Date respondedDate;

    @Column(name = "status")
    private String status;

}
