package com.trainingplatform.userservice.repository;

import com.trainingplatform.userservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    void deleteById(Long id);

    List<User> findAll();

    Optional<Boolean> existsByUsername(String username);

    Optional<Boolean> existsByEmail(String email);

}
