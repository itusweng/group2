package com.trainingplatform.reportingservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@RequiredArgsConstructor
@EnableFeignClients
public class ReportingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportingServiceApplication.class, args);
	}

}
