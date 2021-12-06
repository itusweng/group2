package com.trainingplatform.userservice.model.oauth2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Getter
public class OAuth2ResponseModel {

    private String tokenUri;
    private String clientId;
    private String clientSecret;
    private String grantType;
    private List<String> scope;
    private String username;
    private String password;

    public OAuth2ResponseModel(RequestBuilder builder){
        this.tokenUri = builder.tokenUri;
        this.clientId = builder.clientId;
        this.clientSecret = builder.clientSecret;
        this.grantType = builder.grantType;
        this.scope = builder.scope;
        this.username = builder.username;
        this.password = builder.password;
    }

    @Component
    public static class RequestBuilder
    {
        private String tokenUri;
        private String clientId;
        private String clientSecret;
        private String grantType;
        private List<String> scope;
        private String username;
        private String password;

        public RequestBuilder tokenUri(String tokenUri) {
            this.tokenUri = tokenUri;
            return this;
        }

        public RequestBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public RequestBuilder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public RequestBuilder grantType(String grantType) {
            this.grantType = grantType;
            return this;
        }

        public RequestBuilder scope(List<String> scope) {
            this.scope = scope;
            return this;
        }

        public RequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        public RequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public OAuth2ResponseModel build() {
            return new OAuth2ResponseModel(this);
        }
    }
}
