package com.trainingplatform.trainingservice.trainingservice.repository;


import com.trainingplatform.trainingservice.trainingservice.model.entity.User_ParticipatedTrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_ParticipatedTrainingRepo extends JpaRepository<User_ParticipatedTrainingModel, Long> {

}
