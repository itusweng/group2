package com.trainingplatform.streamingservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class StreamingConfig {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String accessSecret;
    @Value("${cloud.aws.region.static}")
    private String regionStr;


    private AwsBasicCredentials awsBasicCredentials() {
        return AwsBasicCredentials.create(accessKey, accessSecret);
    }

    @Bean
    public StaticCredentialsProvider staticCredentialsProvider() {
        return StaticCredentialsProvider.create(awsBasicCredentials());
    }

    @Bean
    public ProfileCredentialsProvider profileCredentialsProvider() {
        return ProfileCredentialsProvider.create("s3_cred");
    }

    @Bean
    public EnvironmentVariableCredentialsProvider environmentVariableCredentialsProvider() {
        // will create using default aws access key id and secret
        return EnvironmentVariableCredentialsProvider.create();
    }
    @Bean
    public S3Client getClient() {

        // Create the S3Client object.
        Region region = Region.of(regionStr);
        S3Client s3 = S3Client.builder()
                .credentialsProvider(staticCredentialsProvider())
                .region(region)
                .build();
        return s3;
    }
}
