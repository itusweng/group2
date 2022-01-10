package com.trainingplatform.trainingservice.trainingservice.model.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
public class ParticipationApproveResponseDTO extends BaseResponseDTO {

    private Long trainingId;
    private Long userId;
    private String opStatus;

}