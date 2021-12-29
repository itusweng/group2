package com.trainingplatform.trainingservice.trainingservice.repository;

import com.trainingplatform.trainingservice.trainingservice.model.entity.TrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingRepository extends JpaRepository<TrainingModel, Long> {

    Optional<TrainingModel> findById(Long ID);

    List<TrainingModel> findAll();

    void deleteById(Long ID);

    boolean existsById(Long ID);
}
