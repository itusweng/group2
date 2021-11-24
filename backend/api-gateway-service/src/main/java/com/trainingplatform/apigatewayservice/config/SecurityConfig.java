package com.trainingplatform.apigatewayservice.config;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig  {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                // User can access register and login pages without access token
                .pathMatchers("/api/auth/*").permitAll()

                // Specify api endpoints that requires authentication
                .pathMatchers("/api/user/*").authenticated()
                .pathMatchers("/api/streaming/*").authenticated()


                // Authentication is required for remaining endpoints
                .anyExchange().authenticated()
                .and()
                .csrf().disable()
                .oauth2Login();
        return http.build();
    }
}
