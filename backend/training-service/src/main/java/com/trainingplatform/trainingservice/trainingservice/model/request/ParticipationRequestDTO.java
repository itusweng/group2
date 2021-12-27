package com.trainingplatform.trainingservice.trainingservice.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipationRequestDTO extends BaseRequestDTO{

    private Long trainingId;
    private Long userId;
}
