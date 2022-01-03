package com.trainingplatform.trainingservice.trainingservice.repository;

import com.trainingplatform.trainingservice.trainingservice.model.entity.User_RequestedTrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface User_RequestedTrainingRepo extends JpaRepository<User_RequestedTrainingModel, Long> {

    List<User_RequestedTrainingModel> findByManagerGroupIdAndStatusEquals(Long managerId, String status);

    User_RequestedTrainingModel findByTrainingIdAndUserId(Long trainingId, Long userId);

    boolean existsByTrainingIdAndUserId(Long trainingId, Long userId);
}
