package com.trainingplatform.uploadingservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@RequiredArgsConstructor
@SpringBootApplication
public class UploadingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadingServiceApplication.class, args);
	}

}
