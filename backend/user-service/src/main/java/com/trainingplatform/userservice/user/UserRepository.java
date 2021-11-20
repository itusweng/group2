package com.trainingplatform.userservice.user;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findbyId(Long ID);

    List<User> findbyFirstName(String first_name);

    List<User> findbyLastName(String last_name);

    User findbyEmail(String email);

    List<User> findbyRoleId(Long role_id);

    boolean deletebyId(Long ID);

    boolean deletebyEmail(String email);

}
