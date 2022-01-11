package com.trainingplatform.reportingservice.model.training.response;

import com.trainingplatform.reportingservice.model.BaseResponseDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
public class TrainingResponseDTO extends BaseResponseDTO {

    private Long id;

    private Boolean is_online;

    private Object user_created;

    private Object instructor;

    private Integer capacity;

    private String title;

    private String description;

    private String thumbnail;
}
