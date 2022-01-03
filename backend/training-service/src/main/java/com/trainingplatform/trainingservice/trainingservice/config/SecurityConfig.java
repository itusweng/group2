package com.trainingplatform.trainingservice.trainingservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        final JwtAuthenticationConverter jwtAuthenticationConverter = jwtAuthenticationConverterForKeycloak();

        http
                .cors()
                .and()
                .csrf()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/training/getAllTrainings").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/training/{id}").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.POST, "/api/training/{id}/participant").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.POST, "/api/training/").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.POST, "/api/training/participationRequest").authenticated()
                .antMatchers(HttpMethod.GET, "/api/training/byParticipantId/{participantId}/getAll").authenticated()

                .antMatchers(HttpMethod.GET, "/api/training/offlineLesson/getAllLessons/{trainingId}").permitAll()
                .antMatchers(HttpMethod.POST, "/api/training/offlineLesson/update/{offlineLessonId}").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.POST, "/api/training/offlineLesson/").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.DELETE, "/api/training/offlineLesson/{trainingId}/{offlineLessonId}").hasAuthority("ROLE_MANAGER")

                .antMatchers(HttpMethod.GET, "/api/training/onlineLesson/getAllLessons/{trainingId}").permitAll()
                .antMatchers(HttpMethod.POST, "/api/training/onlineLesson/update/{onlineLessonId}").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.POST, "/api/training/onlineLesson/").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.DELETE, "/api/training/onlineLesson/{onlineLessonId}").hasAuthority("ROLE_MANAGER")

                .antMatchers(HttpMethod.POST, "/api/training/participation/request").authenticated()
                .antMatchers(HttpMethod.POST, "/api/training/participation/listAll").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.POST, "/api/training/participation/approve").hasAuthority("ROLE_MANAGER")
                .antMatchers(HttpMethod.POST, "/api/training/participation/reject").hasAuthority("ROLE_MANAGER")
                .anyRequest().denyAll()
                .and()
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter);
    }


    public JwtAuthenticationConverter jwtAuthenticationConverterForKeycloak() {
        Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter = jwt -> {
            Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
            Collection<String> roles = realmAccess.get("roles");
            return roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
        };

        var jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);

        return jwtAuthenticationConverter;
    }
}