package com.trainingplatform.userservice.service;

import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collections;

@RequiredArgsConstructor
public class KeycloakService {

    // Inject keycloak instance
    private final Keycloak keycloak;

    @Value("${keycloak.realm}")
    private String realm;

    private UsersResource usersResource = keycloak.realm(realm).users();

    private CredentialRepresentation createCredential(String password){
        CredentialRepresentation newCred = new CredentialRepresentation();
        newCred.setType(CredentialRepresentation.PASSWORD);
        newCred.setValue(password);
        return newCred;
    }

    public void createKeycloakUser(String username, String email, String password){
        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setEmail(email);
        user.setCredentials(Collections.singletonList(createCredential(password)));

        usersResource.create(user);
    }

    public void deleteKeycloakUserByUsername(String username){
        UserRepresentation user = (UserRepresentation) usersResource.search(username);
        usersResource.delete(user.getId());
    }

    public void updateKeycloakPassword(String username, String newPassword){
        UserRepresentation user = (UserRepresentation) usersResource.search(username);
        user.setCredentials(Collections.singletonList(createCredential(newPassword)));
        usersResource.get(user.getId()).update(user);
    }
}
