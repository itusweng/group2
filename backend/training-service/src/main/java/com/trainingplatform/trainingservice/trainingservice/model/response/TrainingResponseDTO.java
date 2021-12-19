package com.trainingplatform.trainingservice.trainingservice.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrainingResponseDTO {

    private Long id;

    private Boolean is_online;

    private Object user_created;

    private Object instructor;

    private Integer capacity;

    private String title;

    private String description;

    private String thumbnail;
}
