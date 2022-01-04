package com.trainingplatform.trainingservice.trainingservice.model.entity;

import com.trainingplatform.trainingservice.trainingservice.model.entity.composite_keys.User_TrainingPK;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User_CreatedTraining", schema = "tp-userservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@IdClass(User_TrainingPK.class)
public class User_CreatedTrainingModel {

    @Id
    @Column(name="training_id")
    private Long trainingId;

    @Id
    @Column(name="user_id")
    private Long userId;

}
