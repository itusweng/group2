package com.trainingplatform.trainingservice.trainingservice.model.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class TrainingRequestDTO implements Serializable {
    private Long id;
    private Boolean is_online;
    private Long user_created_id;
    private Long instructor_id;
    private Integer capacity;
    private String title;
    private String description;
    private Date created_date;
    private Date updated_date;
    private MultipartFile thumbnail;
}
