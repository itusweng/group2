package com.trainingplatform.trainingservice.trainingservice.repository;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OnlineLessonModel;
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

    @Query("SELECT onlineLesson.id FROM OnlineLessonModel onlineLesson WHERE onlineLesson.training.id = ?1")
    List<Long> findAllLessonIdsByTrainingId(Long trainingId);

}
