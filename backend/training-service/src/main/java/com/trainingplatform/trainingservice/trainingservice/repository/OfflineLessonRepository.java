package com.trainingplatform.trainingservice.trainingservice.repository;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OfflineLessonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OfflineLessonRepository extends JpaRepository<OfflineLessonModel, Long> {

    Optional<OfflineLessonModel> findById(Long ID);

    List<OfflineLessonModel> findAll();

    @Query("SELECT offlineLesson FROM OfflineLessonModel offlineLesson WHERE offlineLesson.training.id = ?1")
    List<OfflineLessonModel> findAllByTrainingID(Long trainingID);

    void deleteById(Long ID);

    @Query("SELECT offlinelesson.id FROM OfflineLessonModel offlinelesson WHERE offlinelesson.training.id = ?1")
    List<Long> findAllLessonIdsByTrainingId(Long trainingId);

}
