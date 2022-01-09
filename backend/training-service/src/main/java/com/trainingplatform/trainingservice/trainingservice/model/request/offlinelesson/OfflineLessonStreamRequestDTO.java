package com.trainingplatform.trainingservice.trainingservice.model.request.offlinelesson;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class OfflineLessonStreamRequestDTO implements Serializable {

    private Long offlineLessonId;

    private Long trainingId;

    private byte[] videoFile;
}
