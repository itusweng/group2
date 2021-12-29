package com.trainingplatform.trainingservice.trainingservice.repository;


import com.trainingplatform.trainingservice.trainingservice.model.entity.User_CreatedTrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_CreatedTrainingRepo extends JpaRepository<User_CreatedTrainingModel, Long> {

}
