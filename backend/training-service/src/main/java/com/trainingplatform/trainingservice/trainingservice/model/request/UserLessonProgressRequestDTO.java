package com.trainingplatform.trainingservice.trainingservice.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
public class UserLessonProgressRequestDTO extends BaseRequestDTO {
    private Long userId;
    private Long lessonId;
    private Boolean isStarted;
    private Boolean isCompleted;
}
