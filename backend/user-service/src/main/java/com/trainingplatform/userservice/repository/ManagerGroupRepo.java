package com.trainingplatform.userservice.repository;


import com.trainingplatform.userservice.model.entity.ManagerGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerGroupRepo extends JpaRepository<ManagerGroup, Long> {

    Optional<ManagerGroup> findByManagerGroupId(Long managerGroupId);
}
