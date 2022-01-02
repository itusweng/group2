package com.trainingplatform.streamingservice.controller;

import com.trainingplatform.streamingservice.config.RabbitMQMessagingConfig;
import com.trainingplatform.streamingservice.model.request.OfflineLessonStreamRequestDTO;
import com.trainingplatform.streamingservice.service.StreamingService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/streaming")
@AllArgsConstructor
@RequiredArgsConstructor
public class StreamingController extends BaseController {

    @Autowired
    private StreamingService streamingService;

    @RabbitListener(queues = RabbitMQMessagingConfig.QUEUE_UPLOAD)
    public void uploadLessonVideo(OfflineLessonStreamRequestDTO offlineLessonStreamRequestDTO) {
        streamingService.uploadVideo(offlineLessonStreamRequestDTO);
    }

    @GetMapping(value = "/stream/{trainingID}/{offlineLessonID}")
    public Mono<ResponseEntity<byte[]>> streamVideo(@PathVariable Long trainingID, @PathVariable Long offlineLessonID) {
        //if lesson is deleted, throws 500, may need a fix
        return Mono.just(streamingService.getObjectBytes(trainingID, offlineLessonID));
    }

    @RabbitListener(queues = RabbitMQMessagingConfig.QUEUE_DELETE)
    public void deleteLessonVideo(Map<String, Long> trainingLessonPair) {
        Long trainingID = trainingLessonPair.get("trainingID");
        Long offlineLessonID = trainingLessonPair.get("offlineLessonID");
        streamingService.deleteVideo(trainingID, offlineLessonID);
    }
}

