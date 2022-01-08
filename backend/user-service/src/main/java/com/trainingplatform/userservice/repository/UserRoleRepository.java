package com.trainingplatform.userservice.repository;

import com.trainingplatform.userservice.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRoleId(Long userRoleId);

    List<UserRole> findAllByManagerGroupId(Long managerGroupId);
}
