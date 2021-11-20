package com.trainingplatform.streamingservice.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
// localhost:8080/api/user/endpoint1
@RestController
@RequestMapping("/api/streaming")
public class StreamingController {

    @GetMapping("/getVideoStream")
    @ResponseStatus(HttpStatus.OK)
    public String getVideoStream(){
        return "Deneme1";
    };

    @GetMapping("/getVideoStreamSecure")
    @ResponseStatus(HttpStatus.OK)
    public String getVideoStreamSecure(){
        return "Deneme1 Secure";
    };

    @GetMapping("/getSomething")
    @ResponseStatus(HttpStatus.OK)
    public String getSomething(){
        return "Deneme2";
    };
}

