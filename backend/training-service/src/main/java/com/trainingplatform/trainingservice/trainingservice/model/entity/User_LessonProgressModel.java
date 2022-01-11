package com.trainingplatform.trainingservice.trainingservice.model.entity;

import com.trainingplatform.trainingservice.trainingservice.model.entity.composite_keys.User_LessonPK;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "User_LessonProgress", schema = "tp-userservice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@IdClass(User_LessonPK.class)
public class User_LessonProgressModel {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "last_watched_minute")
    private Timestamp lastWatchedMinute;

    @Column(name = "is_started")
    private Boolean isStarted;

    @Column(name = "is_completed")
    private Boolean isCompleted;
}
