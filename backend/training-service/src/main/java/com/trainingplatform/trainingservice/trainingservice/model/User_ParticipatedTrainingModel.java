package com.trainingplatform.trainingservice.trainingservice.model;

import com.trainingplatform.trainingservice.trainingservice.model.composite_keys.User_TrainingPK;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
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
    private Long training_id;

    @Id
    private Long user_id;

    private Date participatedDate;
}
