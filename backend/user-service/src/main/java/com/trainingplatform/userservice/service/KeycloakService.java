package com.trainingplatform.userservice.service;

import com.trainingplatform.userservice.model.request.OAuth2ResponseModel;
import com.trainingplatform.userservice.model.entity.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.hibernate.internal.util.StringHelper;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KeycloakService {

    // Inject dependencies
    private final Keycloak keycloak;
    private final OAuth2ResponseModel.RequestBuilder oAuth2RequestBuilder;
    private final BeanFactory beanFactory;


    private final RestTemplate restTemplate;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.resource}")
    private String oauth2ClientId;

    @Value("${keycloak.credentials.secret}")
    private String oauth2ClientSecret;

    @Value("${security.oauth2.client.scope}")
    private String oauth2Scope;

    @Value("${security.oauth2.client.grant-type}")
    private String oauth2GrantType;

    @Value("${security.oauth2.client.access-token-uri}")
    private String oauth2TokenEndpoint;


    private UsersResource usersResource;

    @PostConstruct
    public void initUserResource() {
        this.usersResource = this.keycloak.realm(realm).users();
    }

    private CredentialRepresentation createCredential(String password) {
        CredentialRepresentation newCred = new CredentialRepresentation();
        newCred.setType(CredentialRepresentation.PASSWORD);
        newCred.setValue(password);
        return newCred;
    }

    private HttpHeaders createHttpHeaders(String adminToken) {
        String encodedAuth = "Bearer " + adminToken;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", encodedAuth);
        return headers;
    }

    private Map<String, Object> createBody(String username, String email, String password) {
        Map<String, Object> credentialsMap = new HashMap<>();
        credentialsMap.put("username", username);
        CredentialRepresentation credential = createCredential(password);
        credentialsMap.put("credentials", List.of(credential));
        credentialsMap.put("email", email);
        credentialsMap.put("enabled", true);

        return credentialsMap;
    }

    public Response createKeycloakUser(String username, String email, String password) {
        String theUrl = "http://localhost:8180/auth/admin/realms/training-platform-realm/users";
        RestTemplate restTemplate = new RestTemplate();

        String adminToken = ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getTokenValue();
        HttpHeaders headers = createHttpHeaders(adminToken);
        Map<String, Object> credentialsMap = createBody(username, email, password);

        HttpEntity<Map> entity = new HttpEntity<>(credentialsMap, headers);
        ResponseEntity<String> response = restTemplate.exchange(theUrl, HttpMethod.POST, entity, String.class);
        return Response.status(response.getStatusCodeValue()).build();
    }

    public void deleteKeycloakUserByUsername(String username) {
        UserRepresentation user = (UserRepresentation) usersResource.search(username);
        usersResource.delete(user.getId());
    }

    public void updateKeycloakPassword(String username, String newPassword) {
        UserRepresentation user = (UserRepresentation) usersResource.search(username);
        user.setCredentials(Collections.singletonList(createCredential(newPassword)));
        usersResource.get(user.getId()).update(user);
    }

    public OAuth2AccessToken loginToKeycloak(UserCredentials userCredentials) {
        OAuth2ResponseModel oAuth2ResponseModel = oAuth2RequestBuilder.tokenUri(oauth2TokenEndpoint)
                .clientId(oauth2ClientId)
                .clientSecret(oauth2ClientSecret)
                .scope(List.of(oauth2Scope))
                .grantType(oauth2GrantType)
                .username(userCredentials.getUsername())
                .password(userCredentials.getPassword())
                .build();


        OAuth2RestOperations restTemplate = beanFactory.getBean(OAuth2RestOperations.class, oAuth2ResponseModel);
        return restTemplate.getAccessToken();
    }

}
