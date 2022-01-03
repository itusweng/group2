package com.trainingplatform.streamingservice.service;

import com.trainingplatform.streamingservice.model.request.OfflineLessonStreamRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;


@Service
@RequiredArgsConstructor
public class StreamingService {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String VIDEO_CONTENT = "video/";

    @Autowired
    private S3Client s3;

    @Value("${application.bucket.name}")
    private String bucketName;

    public void uploadVideo(OfflineLessonStreamRequestDTO offlineLessonStreamRequestDTO){
        byte[] file = offlineLessonStreamRequestDTO.getVideoFile();
        Long trainingID = offlineLessonStreamRequestDTO.getTrainingId();
        Long offlineLessonID = offlineLessonStreamRequestDTO.getOfflineLessonId();

        String fileName = trainingID + "_" + offlineLessonID;
        //TODO make uploading multithread
        putVideo(file, fileName);
    }

    // Places a new video into an Amazon S3 bucket.
    public void putVideo(byte[] bytes,  String fileName) {

        try {
            PutObjectRequest putOb = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .build();

            s3.putObject(putOb, RequestBody.fromBytes(bytes));

        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
        }
    }

    // Reads a video from a bucket and returns a ResponseEntity.
    public ResponseEntity<byte[]> getObjectBytes (Long trainingID, Long offlineLessonID) {
        String fileName = trainingID + "_" + offlineLessonID;
        try {
            // Create a GetObjectRequest instance.
            GetObjectRequest objectRequest = GetObjectRequest
                    .builder()
                    .key(fileName)
                    .bucket(bucketName)
                    .build();

            // Get the byte[] from this AWS S3 object and returns a ResponseEntity.
            ResponseBytes<GetObjectResponse> objectBytes = s3.getObjectAsBytes(objectRequest);
            return ResponseEntity.status(HttpStatus.OK)
                    .header(CONTENT_TYPE, VIDEO_CONTENT + "mp4")
                    .header(CONTENT_LENGTH, String.valueOf(objectBytes.asByteArray().length))
                    .body(objectBytes.asByteArray());

        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
        }
        return null;
    }

    public void deleteVideo(Long trainingID, Long offlineLessonID){
        String fileName = trainingID + "_" + offlineLessonID;
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest
                .builder()
                .key(fileName)
                .bucket(bucketName)
                .build();
        s3.deleteObject(deleteObjectRequest);
    }

}


