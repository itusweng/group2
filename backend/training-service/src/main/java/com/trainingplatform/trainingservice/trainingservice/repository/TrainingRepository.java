package com.trainingplatform.trainingservice.trainingservice.repository;

import com.trainingplatform.trainingservice.trainingservice.model.TrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TrainingRepository extends JpaRepository<TrainingModel, UUID> {

    Optional<TrainingModel> findById(UUID ID);

    List<TrainingModel> findAll();

    void deleteById(UUID ID);
}
