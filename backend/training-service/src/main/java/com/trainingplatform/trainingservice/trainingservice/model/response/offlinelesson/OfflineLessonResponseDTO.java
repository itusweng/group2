package com.trainingplatform.trainingservice.trainingservice.model.response.offlinelesson;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OfflineLessonResponseDTO {

    private Long id;

    private String title;

    private String files;

    private String description;

    private Long training_id;
}
