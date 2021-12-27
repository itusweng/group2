package com.trainingplatform.trainingservice.trainingservice.model;

import com.trainingplatform.trainingservice.trainingservice.model.composite_keys.User_TrainingPK;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
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
    private Long training_id;

    @Id
    private Long user_id;

    private Long instructor_id;

    private Date created_date;

    private Date responded_date;

    private String status;

}
