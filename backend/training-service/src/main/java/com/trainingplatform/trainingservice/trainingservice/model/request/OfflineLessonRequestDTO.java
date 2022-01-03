package com.trainingplatform.trainingservice.trainingservice.model.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OfflineLessonRequestDTO {

    private String title;

    private MultipartFile videoFile;

    private String files;

    private String description;

    private Long training_id;
}