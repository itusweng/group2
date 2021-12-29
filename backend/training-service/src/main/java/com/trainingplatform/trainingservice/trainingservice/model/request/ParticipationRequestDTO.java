package com.trainingplatform.trainingservice.trainingservice.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
public class ParticipationRequestDTO extends BaseRequestDTO{

    private Long trainingId;
    private Long userId;
}
