package com.trainingplatform.userservice.controller;

import com.trainingplatform.userservice.model.entity.UserRole;
import com.trainingplatform.userservice.model.request.AssignUserToUserRoleRequestDTO;
import com.trainingplatform.userservice.model.request.CreateUserRoleRequestDTO;
import com.trainingplatform.userservice.model.response.ManagerGroupResponseDTO;
import com.trainingplatform.userservice.model.response.UserResponseDTO;
import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.entity.UserCredentials;
import com.trainingplatform.userservice.model.mapper.UserMapper;
import com.trainingplatform.userservice.model.response.UserRolesResponseDTO;
import com.trainingplatform.userservice.service.UserRoleService;
import com.trainingplatform.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController extends BaseController {

    // Inject services
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/getAllUsers")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllUsers(@RequestParam Integer page, @RequestParam Integer size) {
        try {
            Map<String, Object> userMap = userService.getAllUsers(page, size);
            Map<String, Object> userDtoMap = new HashMap<>();
            List<UserResponseDTO> userDtoList = new ArrayList<>();
            userDtoMap.put("total", userMap.get("total"));
            ((List) userMap.get("users")).forEach(user -> {
                userDtoList.add(userMapper.mapToDto((User) user));
            });
            userDtoMap.put("users", userDtoList);
            return ResponseEntity.ok(createReturnObj("Users fetched successfully!", userDtoMap));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/getAllUsers/byUserRoleId/{userRoleId}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllUsersByUserRoleId(@PathVariable Long userRoleId) {
        try {
            Set<User> users = userService.getAllUsersByUserRoleId(userRoleId);
            Set<UserResponseDTO> userDtoList = userMapper.mapToDto(users);
            return ResponseEntity.ok(
                    createReturnObj(String.format("Users fetched successfully by role id %d!", userRoleId), userDtoList));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/getUserProfile/byId/{userId}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUserProfileById(@PathVariable Long userId) {
        try {
            User userModel = userService.getUserByID(userId);
            UserResponseDTO userDTO = userMapper.mapToDto(userModel);
            return ResponseEntity.ok(
                    createReturnObj(String.format("User profile fetched successfully by id %d!", userId), userDTO));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/byUsername/{username}")
    public ResponseEntity<Map<String, Object>> getUserByUsername(@PathVariable String username) {
        try {
            User user = userService.getUserByUsername(username);
            return ResponseEntity.ok(createReturnObj("User fetched successfully!", user));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/byId/{userId}")
    ResponseEntity<Map<String, Object>> getUserByID(@PathVariable Long userId) {
        try {
            User user = userService.getUserByID(userId);
            return ResponseEntity.ok(createReturnObj("User fetched successfully!", user));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }


    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            ResponseEntity accessToken = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(accessToken);
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginWithPassword(@RequestBody UserCredentials userCredentials) {
        try {
            ResponseEntity<Map<String, Object>> responseEntity = ResponseEntity.ok(userService.login(userCredentials));
            return responseEntity;
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/getTrainingUsersByID")
    public ResponseEntity<Map<Long, Object>> getTrainingUsersByID(@RequestBody Map<Long, Long> trainingIdUserIdMap) {
        // Key -> Training Id, Value -> User created the training
        Map<Long, Object> userResponseDTOMap = new HashMap<>();

        trainingIdUserIdMap.forEach((trainingId, userId) -> {
            User user = userService.getUserByID(userId);
            UserResponseDTO userResponseDTO = userMapper.mapToDto(user);
            userResponseDTOMap.put(trainingId, userResponseDTO);
        });
        return ResponseEntity.ok(userResponseDTOMap);
    }

    @GetMapping("/isExists/byId/{userId}")
    public ResponseEntity<Map<String, Object>> checkUserExistsByUserId(@PathVariable Long userId) {
        try {
            boolean response = userService.checkUserExistsByUserId(userId);
            return ResponseEntity.ok(createReturnObj("User exist query performed successfully!", response));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/getManagerGroupId/byId/{userId}")
    public ResponseEntity<Map<String, Object>> getManagerGroupId(@PathVariable Long userId) {
        try {
            Long managerGroupId = userService.getManagerGroupIdByUserId(userId);
            ManagerGroupResponseDTO responseDTO = ManagerGroupResponseDTO.builder().managerGroupId(managerGroupId).build();
            return ResponseEntity.ok(createReturnObj(String.format("User manager group id is fetched by user id:%d", userId), responseDTO));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }
}


