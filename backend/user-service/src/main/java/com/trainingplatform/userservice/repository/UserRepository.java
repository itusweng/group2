package com.trainingplatform.userservice.repository;

import com.trainingplatform.userservice.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    void deleteById(Long id);

    Page<User> findAll(Pageable pageable);

    Optional<Boolean> existsByUsername(String username);

    Optional<Boolean> existsByEmail(String email);

    @Query("select count(*) from User u")
    long countAllUsers();

    boolean existsById(Long ID);

    @Query("select u from User u where u.role_id = ?1")
    Set<User> findAllByByRole_id(Long roleId);


}
