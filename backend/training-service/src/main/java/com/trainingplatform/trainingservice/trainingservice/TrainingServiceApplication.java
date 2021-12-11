package com.trainingplatform.trainingservice.trainingservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RequiredArgsConstructor
public class TrainingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingServiceApplication.class, args);
	}

//	@PostConstruct
//	public void populateTrainingDb(){
//		TrainingModel training = new TrainingModel();
//		training.setTitle("Training 1 Title");
//		training.setDescription("Training 1 Description");
//		training.setIs_online(true);
//		training.setTrainer_id(1L);
//		training.setCapacity(500);
//		training.setUser_created_id(1L);
//		trainingRepo.save(training);
//	}
}
