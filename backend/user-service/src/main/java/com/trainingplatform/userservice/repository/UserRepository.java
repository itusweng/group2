package com.trainingplatform.userservice.repository;

import com.trainingplatform.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long ID);

    void deleteById(Long ID);

    Optional<Boolean> existsByUsername(String username);

    Optional<Boolean> existsByEmail(String email);

}
