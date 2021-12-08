package com.trainingplatform.userservice.repository;

import com.trainingplatform.userservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findById(UUID ID);

    Optional<User> findByUsername(String username);

    void deleteById(UUID ID);

    List<User> findAll();

    Optional<Boolean> existsByUsername(String username);

    Optional<Boolean> existsByEmail(String email);

}
