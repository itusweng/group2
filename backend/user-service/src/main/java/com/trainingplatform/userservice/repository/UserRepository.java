package com.trainingplatform.userservice.repository;

import com.trainingplatform.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    /*User findbyId(Long ID);

    List<User> findByFirst_name(String first_name);

    List<User> findbyLastName(String last_name);

    User findbyEmail(String email);

    List<User> findbyRoleId(Long role_id);

    boolean deletebyId(Long ID);

    boolean deletebyEmail(String email);*/

}
