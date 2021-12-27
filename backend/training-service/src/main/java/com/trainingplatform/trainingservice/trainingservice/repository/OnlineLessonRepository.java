package com.trainingplatform.trainingservice.trainingservice.repository;

import com.trainingplatform.trainingservice.trainingservice.model.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.OnlineLessonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OnlineLessonRepository extends JpaRepository<OnlineLessonModel, Long> {

    Optional<OnlineLessonModel> findById(Long ID);

    List<OnlineLessonModel> findAll();

    @Query("SELECT onlineLesson FROM OnlineLessonModel onlineLesson WHERE onlineLesson.training.id = ?1")
    List<OnlineLessonModel> findAllByTrainingID(Long trainingID);

    void deleteById(Long ID);

}
