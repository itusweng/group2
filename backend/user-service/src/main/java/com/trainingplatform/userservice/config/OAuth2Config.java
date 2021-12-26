package com.trainingplatform.userservice.config;

import com.trainingplatform.userservice.model.request.OAuth2ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableOAuth2Client
@Configuration
@RequiredArgsConstructor
public class OAuth2Config {

    @Bean
    @Scope(value = "prototype")
    protected OAuth2ProtectedResourceDetails resource(OAuth2ResponseModel responseModel) {
        ResourceOwnerPasswordResourceDetails resource;
        resource = new ResourceOwnerPasswordResourceDetails();
        resource.setAccessTokenUri(responseModel.getTokenUri());
        resource.setClientId(responseModel.getClientId());
        resource.setClientSecret(responseModel.getClientSecret());
        resource.setGrantType(responseModel.getGrantType());
        resource.setScope(responseModel.getScope());
        resource.setUsername(responseModel.getUsername());
        resource.setPassword(responseModel.getPassword());
        return resource;
    }

    @Bean
    @Scope(value = "prototype")
    public OAuth2RestOperations restTemplate(OAuth2ResponseModel responseModel) {
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource(responseModel), new DefaultOAuth2ClientContext(atr));
        restTemplate.setAccessTokenProvider(new ResourceOwnerPasswordAccessTokenProvider());
        return restTemplate;
    }

}
