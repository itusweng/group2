package com.trainingplatform.trainingservice.trainingservice.model.request.trainingparticipation;


import com.trainingplatform.trainingservice.trainingservice.model.request.BaseRequestDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
public class ParticipationPendingRequestsListAllRequestDTO extends BaseRequestDTO {

    private Long managerGroupId;

    private Integer page;

    private Integer size;
}
