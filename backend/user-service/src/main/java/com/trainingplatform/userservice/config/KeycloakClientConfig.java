package com.trainingplatform.userservice.config;


import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


import java.util.Collections;

import static org.keycloak.OAuth2Constants.CLIENT_CREDENTIALS;

@Configuration
public class KeycloakClientConfig {
    @Value("${keycloak.credentials.secret}")
    private String secretKey;
    @Value("${keycloak.resource}")
    private String clientId;
    @Value("${keycloak.auth-server-url}")
    private String authUrl;
    @Value("${keycloak.realm}")
    private String realm;

    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .grantType(CLIENT_CREDENTIALS)
                .serverUrl(authUrl)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(secretKey)
                .build();
    }

    @Configuration
    public class RestUtil {

        private String tokenEndpoint = "http://localhost:8180/auth/realms/training-platform-realm/protocol/openid-connect/token";
        private String grantType = "password";
        private String scope = "openid";

        public HttpEntity<MultiValueMap<String, String>> createHttpEntityForTokenRequest() {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");

            MultiValueMap<String, String> httpBody = new LinkedMultiValueMap<>();
            httpBody.put("client_id", Collections.singletonList(clientId));
            httpBody.put("client_secret", Collections.singletonList(secretKey));
            httpBody.put("grant_type", Collections.singletonList(grantType));
            httpBody.put("scope", Collections.singletonList(scope));

            return new HttpEntity<>(httpBody, httpHeaders);
        }

        public String getTokenEndpoint() {
            return tokenEndpoint;
        }
    }
}
