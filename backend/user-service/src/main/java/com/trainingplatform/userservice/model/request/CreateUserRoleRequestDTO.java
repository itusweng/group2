package com.trainingplatform.userservice.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateUserRoleRequestDTO extends BaseRequestDTO {
    private String roleName;
    private Long managerGroupId;
}
