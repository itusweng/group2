package com.trainingplatform.trainingservice.trainingservice.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OfflineLessonRequestDTO {

    private String title;

    private String video_link;

    private String files;

    private String description;

    private Long training_id;
}