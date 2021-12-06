package com.trainingplatform.userservice.service;

import com.trainingplatform.userservice.model.oauth2.OAuth2ResponseModel;
import com.trainingplatform.userservice.model.user.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KeycloakService {

    // Inject dependencies
    private final Keycloak keycloak;
    private final OAuth2ResponseModel.RequestBuilder oAuth2RequestBuilder;
    private final BeanFactory beanFactory;

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

    public Response createKeycloakUser(String username, String email, String password) {
        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setEmail(email);
        user.setCredentials(Collections.singletonList(createCredential(password)));

        return usersResource.create(user);
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

    public ResponseEntity loginToKeycloak(UserCredentials userCredentials) {
        OAuth2ResponseModel oAuth2ResponseModel = oAuth2RequestBuilder.tokenUri(oauth2TokenEndpoint)
                .clientId(oauth2ClientId)
                .clientSecret(oauth2ClientSecret)
                .scope(List.of(oauth2Scope))
                .grantType(oauth2GrantType)
                .username(userCredentials.getUsername())
                .password(userCredentials.getPassword())
                .build();


        OAuth2RestOperations restTemplate = beanFactory.getBean(OAuth2RestOperations.class, oAuth2ResponseModel);
        return ResponseEntity.ok(restTemplate.getAccessToken());
    }

}
