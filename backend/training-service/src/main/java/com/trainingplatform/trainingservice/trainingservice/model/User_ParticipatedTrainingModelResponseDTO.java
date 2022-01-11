package com.trainingplatform.trainingservice.trainingservice.model;

import com.trainingplatform.trainingservice.trainingservice.model.response.BaseResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
@ToString
public class User_ParticipatedTrainingModelResponseDTO extends BaseResponseDTO {

    private Long trainingId;

    private Long userId;

    private Date participatedDate;
}