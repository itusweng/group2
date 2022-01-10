package com.trainingplatform.apigatewayservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableHystrix
@RequiredArgsConstructor
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("streaming-service", r -> r.path("/api/streaming/**")
                        .uri("lb://streaming-service"))

                .route("user-service", r -> r.path("/api/user/**")
                        .uri("lb://user-service"))

                .route("training-service", r -> r.path("/api/training/**")
                        .uri("lb://training-service"))

                .route("notification-service", r -> r.path("/api/notification/**")
                        .uri("lb://notification-service"))

                .route("reporting-service", r -> r.path("/api/reporting/**")
                        .uri("lb://reporting-service"))

                .route("uploading-service", r -> r.path("/api/uploading/**")
                        .uri("lb://uploading-service"))
                .build();
    }

}
