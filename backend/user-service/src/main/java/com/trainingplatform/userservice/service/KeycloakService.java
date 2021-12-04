package com.trainingplatform.userservice.service;

import com.trainingplatform.userservice.config.KeycloakClientConfig;
import com.trainingplatform.userservice.model.User;
import com.trainingplatform.userservice.model.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KeycloakService {

    // Inject keycloak instance
    private final Keycloak keycloak;
    private final RestTemplate restTemplate;
    private final KeycloakClientConfig.RestUtil restUtil;

    @Value("${keycloak.realm}")
    private String realm;

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
        HttpEntity<MultiValueMap<String, String>> httpEntity = restUtil.createHttpEntityForTokenRequest();
        httpEntity.getBody().put("username", Collections.singletonList(userCredentials.getUsername()));
        httpEntity.getBody().put("password", Collections.singletonList(userCredentials.getPassword()));
        ResponseEntity<Object> result = restTemplate.exchange(restUtil.getTokenEndpoint(), HttpMethod.POST, httpEntity, Object.class);
        return result;
    }

}
