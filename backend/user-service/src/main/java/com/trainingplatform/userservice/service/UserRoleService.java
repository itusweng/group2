package com.trainingplatform.userservice.service;

import com.trainingplatform.userservice.model.entity.ManagerGroup;
import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.entity.UserRole;
import com.trainingplatform.userservice.repository.ManagerGroupRepo;
import com.trainingplatform.userservice.repository.UserRepository;
import com.trainingplatform.userservice.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRepository userRepo;
    private final UserRoleRepository userRoleRepo;
    private final ManagerGroupRepo managerGroupRepo;

    public void createNewUserRole(String roleName, Long managerGroupId ) {
        UserRole userRole = UserRole.builder()
                .roleName(roleName)
                .managerGroupId(managerGroupId)
                .build();
        userRoleRepo.save(userRole);
    }

    public List<UserRole> getAllUserRolesByManagerGroupId(Long managerGroupId) {
        List<UserRole> userRoles = userRoleRepo.findAllByManagerGroupId(managerGroupId);
        return userRoles;
    }

    public String getManagerGroupNameByUserRoleId(Long userRoleId){
        UserRole userRole = userRoleRepo.findByRoleId(userRoleId);
        ManagerGroup managerGroup = managerGroupRepo
                .findByManagerGroupId(userRole.getManagerGroupId()).orElseThrow(() -> new EntityNotFoundException());
        return managerGroup.getGroupName();
    }

    public void assignUserToUserRole(Long userId, Long roleId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException());
        user.setRole_id(roleId);
        userRepo.save(user);
    }
}
