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
public class TrainingParticipantResponseDTO extends BaseResponseDTO {

    private Long id;

    private String first_name;

    private String last_name;

    private String role;

    private String profile_photo;

    private String job_title;
}