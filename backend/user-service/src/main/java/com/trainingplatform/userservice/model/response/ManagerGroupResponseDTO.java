package com.trainingplatform.userservice.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ManagerGroupResponseDTO extends BaseResponseDTO{

    private Long managerGroupId;
}
