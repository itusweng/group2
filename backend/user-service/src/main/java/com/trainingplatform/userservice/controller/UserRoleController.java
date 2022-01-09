package com.trainingplatform.userservice.controller;

import com.trainingplatform.userservice.model.entity.UserRole;
import com.trainingplatform.userservice.model.request.AssignUserToUserRoleRequestDTO;
import com.trainingplatform.userservice.model.request.CreateUserRoleRequestDTO;
import com.trainingplatform.userservice.model.response.UserRolesResponseDTO;
import com.trainingplatform.userservice.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserRoleController extends BaseController{

    // Inject services
    private final UserRoleService userRoleService;

    @PostMapping("/createUserRole")
    public ResponseEntity<Map<String, Object>> createUserRole(@RequestBody CreateUserRoleRequestDTO requestDTO) {
        try {
            userRoleService.createNewUserRole(requestDTO.getRoleName(), requestDTO.getManagerGroupId());
            return ResponseEntity.ok(createReturnObj(String.format("User role is created: %s", requestDTO.getRoleName()), null));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/assignUserToUserRole")
    public ResponseEntity<Map<String, Object>> createUserRole(@RequestBody AssignUserToUserRoleRequestDTO requestDTO) {
        try {
            userRoleService.assignUserToUserRole(requestDTO.getUserId(), requestDTO.getRoleId());
            return ResponseEntity.ok(createReturnObj(String.format("User %d role is assigned to: %s", requestDTO.getUserId()), null));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/getAllUserRoles/byManagerGroupId/{managerGroupId}")
    public ResponseEntity<Map<String, Object>> getAllUserRolesByManagerGroupId(@PathVariable Long managerGroupId) {
        try {
            List<UserRole> userRoles = userRoleService.getAllUserRolesByManagerGroupId(managerGroupId);
            List<UserRolesResponseDTO> userRolesResponseDTOS = userRoles
                    .stream()
                    .map(userRole -> {
                        UserRolesResponseDTO userRolesResponseDTO = new UserRolesResponseDTO();
                        userRolesResponseDTO.setManagerGroupName(userRoleService.getManagerGroupNameByUserRoleId(userRole.getRoleId()));
                        userRolesResponseDTO.setId(userRole.getRoleId());
                        userRolesResponseDTO.setRoleName(userRole.getRoleName());
                        return userRolesResponseDTO;
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(createReturnObj(String.format("User roles are fetched by manager group id %d", managerGroupId), userRolesResponseDTOS));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }
}
