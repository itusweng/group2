package com.trainingplatform.reportingservice.model.training.response;

import com.trainingplatform.reportingservice.model.BaseResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
public class UserResponseDTO extends BaseResponseDTO {

    private Long id;

    private String first_name;

    private String last_name;

    private Long role_id;

    private String role_name;

    private String profile_photo;

    private Long manager_group_id;
}