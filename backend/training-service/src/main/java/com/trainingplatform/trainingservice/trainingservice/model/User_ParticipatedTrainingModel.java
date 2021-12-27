package com.trainingplatform.trainingservice.trainingservice.model;

import com.trainingplatform.trainingservice.trainingservice.model.composite_keys.User_TrainingPK;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "User_ParticipatedTraining", schema = "tp-userservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@IdClass(User_TrainingPK.class)
public class User_ParticipatedTrainingModel {

    @Id
    @Column(name="training_id")
    private Long trainingId;

    @Id
    @Column(name="user_id")
    private Long userId;

    @Column(name="participated_date")
    private Date participatedDate;
}
