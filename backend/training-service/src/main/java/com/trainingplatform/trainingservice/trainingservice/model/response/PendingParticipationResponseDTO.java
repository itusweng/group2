package com.trainingplatform.trainingservice.trainingservice.model.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
public class PendingParticipationResponseDTO extends BaseResponseDTO {

    private UserResponseDTO requested_user;

    private TrainingResponseDTO requested_training;

    private String status;

}
