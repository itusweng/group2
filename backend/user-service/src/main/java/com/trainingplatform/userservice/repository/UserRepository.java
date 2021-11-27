package com.trainingplatform.userservice.repository;

import com.trainingplatform.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findbyId(Long ID);

    Optional<List<User>> findbyFirstName(String first_name);

    Optional<List<User>> findbyLastName(String last_name);

    Optional<User> findbyEmail(String email);

    Optional<List<User>> findbyRoleId(Long role_id);

    Optional<Boolean> deletebyId(Long ID);

    Optional<Boolean> deletebyEmail(String email);

    Optional<Boolean> existsByUsername(String username);

    Optional<Boolean> existsByEmail(String email);

}
