package com.trainingplatform.trainingservice.trainingservice.model.response.trainingparticipation;

import com.trainingplatform.trainingservice.trainingservice.model.response.BaseResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;
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
