package com.trainingplatform.trainingservice.trainingservice.model.request.trainingparticipation;

import com.trainingplatform.trainingservice.trainingservice.model.request.BaseRequestDTO;
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
