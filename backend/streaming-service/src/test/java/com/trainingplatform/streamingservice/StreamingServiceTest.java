package com.trainingplatform.streamingservice;

import com.trainingplatform.streamingservice.model.request.OfflineLessonStreamRequestDTO;
import com.trainingplatform.streamingservice.service.StreamingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;


import static com.trainingplatform.streamingservice.service.StreamingService.CONTENT_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class StreamingServiceTest {

    @InjectMocks
    StreamingService streamingService;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    S3Client s3Client;

    @Captor
    private ArgumentCaptor<RequestBody> argumentCaptorFile;

    @Test
    public void it_should_upload_video_when_lesson_given(){
        OfflineLessonStreamRequestDTO offlineLessonStreamRequestDTO = mock(OfflineLessonStreamRequestDTO.class);
        byte[] file = "video file".getBytes();
        Long trainingId = 1L;
        Long offlineLessonId = 1L;
        when(offlineLessonStreamRequestDTO.getOfflineLessonId()).thenReturn(offlineLessonId);
        when(offlineLessonStreamRequestDTO.getTrainingId()).thenReturn(trainingId);
        when(offlineLessonStreamRequestDTO.getVideoFile()).thenReturn(file);
        RequestBody requestBody = RequestBody.fromBytes(file);
        //act
        streamingService.uploadVideo(offlineLessonStreamRequestDTO);
        //assert
        verify(s3Client, times(1)).putObject(any(PutObjectRequest.class), argumentCaptorFile.capture());
        assertThat(argumentCaptorFile.getValue().contentLength()).isEqualTo(requestBody.contentLength());
    }

    @Test
    public void it_should_delete_file_when_file_found(){
        //arrange
        Long trainingId = 1L;
        Long offlineLessonId = 1L;
        //act
        streamingService.deleteVideo(trainingId, offlineLessonId);
        //assert
        verify(s3Client, times(1)).deleteObject(any(DeleteObjectRequest.class));
    }
}
