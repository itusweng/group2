package com.trainingplatform.userservice.repository;

import com.trainingplatform.userservice.model.User;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collection;
import java.util.stream.Collectors;


@Configuration
public class UserProvider {

    @SuppressWarnings("unchecked")
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST)
    public User getCurrentUser() {

        User authenticatedUser = new User();
        System.out.println(SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal());

        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        String userId = principal.getKeycloakSecurityContext().getToken().getSubject();
        String username = principal.toString();
        String email = principal.getKeycloakSecurityContext().getToken().getEmail();
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        authenticatedUser.setId(Long.parseLong(userId));
        authenticatedUser.setUsername(username);
        authenticatedUser.setEmail(email);
        authenticatedUser.setRoles(authorities.stream().map(SimpleGrantedAuthority::getAuthority).collect(Collectors.toList()));

        return authenticatedUser;
    }
}

