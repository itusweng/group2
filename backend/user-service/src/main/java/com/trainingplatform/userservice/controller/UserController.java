package com.trainingplatform.userservice.controller;

import com.trainingplatform.userservice.model.response.ManagerGroupResponseDTO;
import com.trainingplatform.userservice.model.response.UserResponseDTO;
import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.entity.UserCredentials;
import com.trainingplatform.userservice.model.mapper.UserMapper;
import com.trainingplatform.userservice.service.UserRoleService;
import com.trainingplatform.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController extends BaseController {

    // Inject services
    private final UserService userService;
    private final UserRoleService userRoleService;
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
                UserResponseDTO userDTO = userMapper.mapToDto((User) user);
                userDTO.setRole_name(userRoleService.getUserRoleNameByRoleId(((User) user).getRole_id()));
                userDtoList.add(userDTO);
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
            userDTO.setRole_name(userService.getUserRoleNameByUserRoleId(userModel.getRole_id()));
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
            UserResponseDTO userDTO = userMapper.mapToDto(user);
            userDTO.setRole_name(userService.getUserRoleNameByUserRoleId(user.getRole_id()));
            return ResponseEntity.ok(createReturnObj("User fetched successfully!", userDTO));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/byId/{userId}")
    ResponseEntity<Map<String, Object>> getUserByID(@PathVariable Long userId) {
        try {
            User user = userService.getUserByID(userId);
            UserResponseDTO userDTO = userMapper.mapToDto(user);
            userDTO.setRole_name(userService.getUserRoleNameByUserRoleId(user.getRole_id()));
            return ResponseEntity.ok(createReturnObj("User fetched successfully!", userDTO));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }


    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            ResponseEntity accessToken = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(accessToken);
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(user);
            UserResponseDTO userDTO = userMapper.mapToDto(updatedUser);
            userDTO.setRole_name(userRoleService.getUserRoleNameByRoleId(updatedUser.getRole_id()));
            return ResponseEntity.ok(createReturnObj(String.format("User id:%d updated successfully!", user.getId()), userDTO));
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
            userResponseDTO.setRole_name(userRoleService.getUserRoleNameByRoleId(user.getRole_id()));
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

    @PostMapping("/byIdList/getUserModels")
    ResponseEntity<Map<String, Object>> getUserModelsByUserIdList(@RequestBody List<Long> userIds) {
        try {
            List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
            userIds.forEach(userId -> {
                try {
                    User userModel = userService.getUserByID(userId);
                    UserResponseDTO userResponseDTO = userMapper.mapToDto(userModel);
                    userResponseDTO.setRole_name(userRoleService.getUserRoleNameByRoleId(userModel.getRole_id()));
                    userResponseDTOS.add(userResponseDTO);
                } catch (Exception e) {
                    // do nothing
                }
            });
            return ResponseEntity.ok(createReturnObj("Users are fetched by id list!",userResponseDTOS));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/getAllInstructors")
    public ResponseEntity<Map<String, Object>> getAllInstructors() {
        try {
            List<User> userList = userService.getAllInstructors();
            List<UserResponseDTO> userResponseDTOS = userMapper.mapToDto(userList);
            return ResponseEntity.ok(createReturnObj("All instructors are fetched!", userResponseDTOS));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }
}


