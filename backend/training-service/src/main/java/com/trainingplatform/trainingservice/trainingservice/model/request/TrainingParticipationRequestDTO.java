package com.trainingplatform.trainingservice.trainingservice.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainingParticipationRequestDTO extends BaseRequestDTO{

    private Long trainingId;
    private Long userId;
}
