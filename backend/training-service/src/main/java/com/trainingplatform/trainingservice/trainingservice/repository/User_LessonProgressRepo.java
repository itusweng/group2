package com.trainingplatform.trainingservice.trainingservice.repository;

import com.trainingplatform.trainingservice.trainingservice.model.entity.User_LessonProgressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_LessonProgressRepo extends JpaRepository<User_LessonProgressModel, Long> {

    User_LessonProgressModel findByLessonIdAndUserId(Long lessonId, Long userId);
}
