package com.trainingplatform.trainingservice.trainingservice.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class TrainingThumbnailUploadRequestDTO {
    private Long ID;
    private byte[] thumbnail;
}
