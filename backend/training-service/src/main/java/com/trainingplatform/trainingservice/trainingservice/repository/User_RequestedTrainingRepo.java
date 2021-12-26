package com.trainingplatform.trainingservice.trainingservice.repository;

import com.trainingplatform.trainingservice.trainingservice.model.User_RequestedTrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface User_RequestedTrainingRepo extends JpaRepository<User_RequestedTrainingModel, Long> {


}
