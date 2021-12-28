package com.trainingplatform.trainingservice.trainingservice.model.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
public class ParticipationApproveRequestDTO extends BaseRequestDTO {

    private Long trainingId;
    private Long userId;
}
