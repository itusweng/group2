package com.trainingplatform.userservice;

import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaClient
@RequiredArgsConstructor
public class UserServiceApplication {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

//    @PostConstruct
//    public void populateUserDb(){
//        User user = new User();
//        user.setUsername("test1");
//        user.setFirst_name("test name");
//        user.setLast_name("test last name");
//        user.setEmail("test@gmail.com");
//        user.setRole_id(1L);
//        user.setPassword(passwordEncoder.encode("test1"));
//        userRepo.save(user);
//    }
}
