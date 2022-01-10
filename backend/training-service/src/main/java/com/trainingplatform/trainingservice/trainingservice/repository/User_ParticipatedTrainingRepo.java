package com.trainingplatform.trainingservice.trainingservice.repository;


import com.trainingplatform.trainingservice.trainingservice.model.entity.User_ParticipatedTrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface User_ParticipatedTrainingRepo extends JpaRepository<User_ParticipatedTrainingModel, Long> {

    List<User_ParticipatedTrainingModel> findByUserId(Long userId);

    boolean existsUser_ParticipatedTrainingModelByUserIdAndTrainingId(Long userId, Long trainingId);

    List<User_ParticipatedTrainingModel> findByTrainingId(Long id);
}
