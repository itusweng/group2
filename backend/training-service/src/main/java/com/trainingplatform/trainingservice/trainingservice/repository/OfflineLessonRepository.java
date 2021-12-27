package com.trainingplatform.trainingservice.trainingservice.repository;

import com.trainingplatform.trainingservice.trainingservice.model.OfflineLessonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OfflineLessonRepository extends JpaRepository<OfflineLessonModel, Long> {

    Optional<OfflineLessonModel> findById(Long ID);

    List<OfflineLessonModel> findAll();

    @Query("SELECT offlineLesson FROM OfflineLessonModel offlineLesson WHERE offlineLesson.training.id = ?1")
    List<OfflineLessonModel> findAllByTrainingID(Long trainingID);

    void deleteById(Long ID);

    @Modifying
    @Transactional
    @Query("UPDATE OfflineLessonModel offlineLesson SET offlineLesson.title = ?2 WHERE offlineLesson.id = ?1")
    Integer updateTitle(Long offlineLessonId, String offlineLessonTitle);

    @Modifying
    @Transactional
    @Query("UPDATE OfflineLessonModel offlineLesson SET offlineLesson.video_link = ?2 WHERE offlineLesson.id = ?1")
    Integer updateVideoLink(Long offlineLessonId, String offlineLessonVideoLink);

    @Modifying
    @Transactional
    @Query("UPDATE OfflineLessonModel offlineLesson SET offlineLesson.files = ?2 WHERE offlineLesson.id = ?1")
    Integer updateFiles(Long offlineLessonId, String offlineLessonFiles);

    @Modifying
    @Transactional
    @Query("UPDATE OfflineLessonModel offlineLesson SET offlineLesson.description = ?2 WHERE offlineLesson.id = ?1")
    Integer updateDescription(Long offlineLessonId, String offlineLessonDescription);
}
