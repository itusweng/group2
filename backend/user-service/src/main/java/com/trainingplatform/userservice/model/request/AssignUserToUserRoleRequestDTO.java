package com.trainingplatform.userservice.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssignUserToUserRoleRequestDTO extends BaseRequestDTO {
    private Long userId;
    private Long roleId;

}
