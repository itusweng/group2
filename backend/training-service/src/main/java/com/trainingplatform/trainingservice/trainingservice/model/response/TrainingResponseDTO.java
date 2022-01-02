package com.trainingplatform.trainingservice.trainingservice.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
@JsonSerialize
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
