package com.trainingplatform.trainingservice.trainingservice.model.request;


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
