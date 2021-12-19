package com.trainingplatform.trainingservice.trainingservice.model;

import com.trainingplatform.trainingservice.trainingservice.model.composite_keys.User_TrainingPK;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User_CreatedTraining", schema = "tp-userservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@IdClass(User_TrainingPK.class)
public class User_CreatedTrainingModel {

    @Id
    private Long training_id;

    @Id
    private Long user_id;

}