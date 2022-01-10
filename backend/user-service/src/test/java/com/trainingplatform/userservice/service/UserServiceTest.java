package com.trainingplatform.userservice.service;

import com.trainingplatform.userservice.exception.UserNotCreatedException;
import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.entity.UserCredentials;
import com.trainingplatform.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceTest {

    @InjectMocks UserService userService;

    @Mock  private UserRepository userRepo;
    @Mock  private KeycloakService keycloakService;
    @Mock  private PasswordEncoder passwordEncoder;

    @Test
    void it_should_return_user_when_user_found() {
        //arrange
        User user = mock(User.class);
        when(user.getEmail()).thenReturn("sena@hotmail.com");
        when(user.getId()).thenReturn(1L);
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        //act
        User userReturned = userService.getUserByID(1L);
        //assert
        assertThat(userReturned.getEmail()).isEqualTo("sena@hotmail.com");
    }

    @Test
    void it_should_throw_exception_when_user_not_found() {
        //arrange
        when(userRepo.findById(1L)).thenReturn(Optional.empty());
        //act
        Throwable throwable = catchThrowable(() -> userService.getUserByID(1L));
        //assert
        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void it_should_return_true_when_user_found(){
        //arrange
        User user = mock(User.class);
        when(user.getId()).thenReturn(1L);
        when(userRepo.existsById(1L)).thenReturn(true);
        //act
        boolean ifExists = userService.checkUserExistsByUserId(1L);
        //assert
        assertThat(ifExists).isEqualTo(true);
    }

    @Test
    void it_should_return_false_when_user_not_found(){
        //arrange
        when(userRepo.existsById(1L)).thenReturn(false);
        //act
        boolean ifExists = userService.checkUserExistsByUserId(1L);
        //assert
        assertThat(ifExists).isEqualTo(false);
    }

    @Test
    void it_should_return_manager_group_id_when_user_found(){
        //arrange
        User user = mock(User.class);
        when(user.getManager_group_id()).thenReturn(2L);
        when(user.getId()).thenReturn(1L);
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        //act
        User userReturned = userService.getUserByID(1L);
        Long managerGroupId = userReturned.getManager_group_id();
        //assert
        assertThat(managerGroupId).isEqualTo(2L);
    }

    @Test
    void it_should_throw_exception_when_user_not_found_getManagerGroupId(){
        //arrange
        when(userRepo.findById(1L)).thenReturn(Optional.empty());
        //act
        Throwable throwable = catchThrowable(() -> userService.getManagerGroupIdByUserId(1L));
        //assert
        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void it_should_return_user_when_user_found_getUserByUsername(){
        //arrange
        User user = mock(User.class);
        when(user.getUsername()).thenReturn("darth vader");
        when(userRepo.findByUsername("darth vader")).thenReturn(Optional.of(user));
        //act
        User userReturned = userService.getUserByUsername("darth vader");
        //assert
        assertThat(userReturned.getUsername()).isEqualTo("darth vader");
    }

    @Test
    void it_should_throw_exception_when_user_not_found_getUserByUsername() {
        //arrange
        when(userRepo.findByUsername("bb8")).thenReturn(Optional.empty());
        //act
        Throwable throwable = catchThrowable(() -> userService.getUserByUsername("bb8"));
        //assert
        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void it_should_return_token_user_when_credentials_correct(){
        //arrange
        UserCredentials userCredentials = mock(UserCredentials.class);
        when(userCredentials.getUsername()).thenReturn("darth vader");
        OAuth2AccessToken token = mock(OAuth2AccessToken.class);
        when(keycloakService.loginToKeycloak(userCredentials)).thenReturn(token);
        User user = mock(User.class);
        when(user.getUsername()).thenReturn("darth vader");
        when(userRepo.findByUsername("darth vader")).thenReturn(Optional.of(user));
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", user);
        //act
        Map<String, Object> responseReturned = userService.login(userCredentials);
        //assert
        Map<String, Object> assertResponse = new HashMap<>();
        assertResponse.put("token", token);
        assertResponse.put("user", user);
        assertThat(responseReturned).isEqualTo(assertResponse);
    }

    @Test
    void  it_should_throw_exception_when_credentials_wrong(){
        //arrange
        UserCredentials userCredentials = mock(UserCredentials.class);
        when(userCredentials.getUsername()).thenReturn("darth vader");
        OAuth2AccessToken token = mock(OAuth2AccessToken.class);
        when(keycloakService.loginToKeycloak(userCredentials)).thenReturn(token);
        User user = mock(User.class);
        when(user.getUsername()).thenReturn("darth vader");
        when(userRepo.findByUsername("darth vader")).thenReturn(Optional.empty());
        //act
        Throwable throwable = catchThrowable(() -> userService.login(userCredentials));
        //assert
        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void it_should_return_token_when_user_created() throws UserNotCreatedException {
        //arrange
        User user = mock(User.class);
        when(user.getUsername()).thenReturn("anakin");
        when(user.getPassword()).thenReturn("skywalker");
        when(user.getEmail()).thenReturn("sky@boi.com");
        UserCredentials userCredentials = mock(UserCredentials.class);
        when(userCredentials.getUsername()).thenReturn("anakin");
        when(userCredentials.getPassword()).thenReturn("skywalker");
        Response response = mock(Response.class);
        when(keycloakService.createKeycloakUser(user.getUsername(), user.getEmail(), user.getPassword())).thenReturn(response);
        ResponseEntity responseEntity = ResponseEntity.ok(keycloakService.loginToKeycloak(userCredentials));
        //act
        ResponseEntity responseEntity1 = userService.createUser(user);
        //assert
        assertThat(responseEntity).isEqualTo(responseEntity1);
    }

    @Test
    void it_should_throw_when_user_cannot_created_403() {
        //arrange
        User user = mock(User.class);
        when(user.getUsername()).thenReturn("anakin");
        when(user.getPassword()).thenReturn("skywalker");
        when(user.getEmail()).thenReturn("sky@boi.com");
        UserCredentials userCredentials = mock(UserCredentials.class);
        when(userCredentials.getUsername()).thenReturn("anakin");
        when(userCredentials.getPassword()).thenReturn("skywalker");
        Response response = mock(Response.class);
        when(response.getStatus()).thenReturn(403);
        when(keycloakService.createKeycloakUser(user.getUsername(), user.getEmail(), user.getPassword())).thenReturn(response);
        //act
        Throwable throwable = catchThrowable(() -> userService.createUser(user));
        //assert
        assertThat(throwable).isInstanceOf(UserNotCreatedException.class);
    }

    @Test
    void it_should_throw_when_user_cannot_created_409() {
        //arrange
        User user = mock(User.class);
        when(user.getUsername()).thenReturn("anakin");
        when(user.getPassword()).thenReturn("skywalker");
        when(user.getEmail()).thenReturn("sky@boi.com");
        UserCredentials userCredentials = mock(UserCredentials.class);
        when(userCredentials.getUsername()).thenReturn("anakin");
        when(userCredentials.getPassword()).thenReturn("skywalker");
        Response response = mock(Response.class);
        when(response.getStatus()).thenReturn(409);
        when(keycloakService.createKeycloakUser(user.getUsername(), user.getEmail(), user.getPassword())).thenReturn(response);
        //act
        Throwable throwable = catchThrowable(() -> userService.createUser(user));
        //assert
        assertThat(throwable).isInstanceOf(UserNotCreatedException.class);
    }

    @Test
    void it_should_return_map(){
        //arrange
        Page<User> usersPage = mock(Page.class);
        List<User> usersList = mock(List.class);
        User user = mock(User.class);
        Pageable pageable = PageRequest.of(1,2);
        usersList.add(user);
        when(userRepo.findAll(pageable)).thenReturn(usersPage);
        when(userRepo.findAll(pageable).getContent()).thenReturn(usersList);
        when(userRepo.countAllUsers()).thenReturn(1L);
        Map<String, Object> returnMap=new HashMap<>();
        returnMap.put("users", usersList);
        returnMap.put("total", 1L);
        //act
        Map<String, Object> returnMap1 = userService.getAllUsers(1,2);
        //assert
        assertThat(returnMap).isEqualTo(returnMap1);
    }
}