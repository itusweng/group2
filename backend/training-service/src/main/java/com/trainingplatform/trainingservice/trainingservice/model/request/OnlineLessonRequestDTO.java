package com.trainingplatform.trainingservice.trainingservice.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OnlineLessonRequestDTO {
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate meeting_date;

    private String zoom_link;

    private Long training_id;

    private String title;

    private String description;
}
