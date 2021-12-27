package com.trainingplatform.apigatewayservice.config;


import lombok.SneakyThrows;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.server.DefaultServerOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class AuthorizationRequestResolver implements ServerOAuth2AuthorizationRequestResolver {
    private final ServerOAuth2AuthorizationRequestResolver defaultAuthorizationRequestResolver;

    public AuthorizationRequestResolver(ReactiveClientRegistrationRepository clientRegistrationRepository) {

        this.defaultAuthorizationRequestResolver =
                new DefaultServerOAuth2AuthorizationRequestResolver(clientRegistrationRepository);
    }

    private Mono<OAuth2AuthorizationRequest> customAuthorizationRequest(
            Mono<OAuth2AuthorizationRequest> authorizationRequest) throws ExecutionException, InterruptedException {

        Map<String, Object> additionalParameters =
                new LinkedHashMap<>(authorizationRequest.toFuture().get().getAdditionalParameters());
        additionalParameters.put("prompt", "consent");

        return Mono.just(OAuth2AuthorizationRequest.from(authorizationRequest.toFuture().get())
                .additionalParameters(additionalParameters)
                .build());
    }

    @SneakyThrows
    @Override
    public Mono<OAuth2AuthorizationRequest> resolve(ServerWebExchange exchange) {
        Mono<OAuth2AuthorizationRequest> authorizationRequest =
                this.defaultAuthorizationRequestResolver.resolve(exchange);

        if (authorizationRequest.toFuture().get() == null)
            return authorizationRequest;
        else
            return customAuthorizationRequest(authorizationRequest);
    }

    @SneakyThrows
    @Override
    public Mono<OAuth2AuthorizationRequest> resolve(ServerWebExchange exchange, String clientRegistrationId) {

        Mono<OAuth2AuthorizationRequest> authorizationRequest =
                this.defaultAuthorizationRequestResolver.resolve(
                        exchange, clientRegistrationId);

        if (authorizationRequest.toFuture().get() == null)
            return authorizationRequest;
        else
            return customAuthorizationRequest(authorizationRequest);
    }
}