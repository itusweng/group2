package com.trainingplatform.trainingservice.trainingservice.model.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@JsonSerialize
public class ManagerGroupResponseDTO extends BaseResponseDTO{

    private Long managerGroupId;
}
