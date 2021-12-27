package com.trainingplatform.trainingservice.trainingservice.model.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipationPendingRequestsListAllRequestDTO extends BaseRequestDTO {

    private Long managerId;

    private Integer page;

    private Integer size;
}
