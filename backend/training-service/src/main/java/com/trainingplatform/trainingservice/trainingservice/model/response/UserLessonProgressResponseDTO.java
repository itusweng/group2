package com.trainingplatform.trainingservice.trainingservice.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
public class UserLessonProgressResponseDTO extends BaseResponseDTO {
    private Long userId;
    private Long lessonId;
    private Boolean isStarted;
    private Boolean isCompleted;
}
