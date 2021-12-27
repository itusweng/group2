package com.trainingplatform.trainingservice.trainingservice.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class FeignRequestInterceptor {

    @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                Jwt details = (Jwt) authentication.getPrincipal();
                if (authentication == null) return;

                requestTemplate.header("Authorization", "Bearer " + details.getTokenValue());
            }
        };
    }
}