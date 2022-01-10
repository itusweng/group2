package com.trainingplatform.userservice.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRolesResponseDTO extends BaseResponseDTO {

    private Long id;
    private String roleName;
    private String managerGroupName;
}
