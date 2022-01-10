package com.trainingplatform.userservice.service;

import com.trainingplatform.userservice.model.entity.ManagerGroup;
import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.entity.UserRole;
import com.trainingplatform.userservice.repository.ManagerGroupRepo;
import com.trainingplatform.userservice.repository.UserRepository;
import com.trainingplatform.userservice.repository.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserRoleServiceTest {

    @InjectMocks UserRoleService userRoleService;

    @Mock private UserRepository userRepo;
    @Mock private UserRoleRepository userRoleRepo;
    @Mock private ManagerGroupRepo managerGroupRepo;

   /* @Test
    public void void_create_new_user_role(){
        String roleName = "roleName";
        Long managerGroupId = 1L;
        UserRole userRole = mock(UserRole.class);
        when(userRole.getRoleName()).thenReturn("roleName");
        when(userRole.getManagerGroupId()).thenReturn(1L);
        userRoleService.createNewUserRole(roleName, managerGroupId);
        verify(userRoleRepo, times(1)).save(userRole);
    }*/

    @Test
    public void it_should_return_all_user_roles_when_manager_group_given(){
        //arrange
        UserRole userRole = mock(UserRole.class);
        when(userRoleRepo.findAllByManagerGroupId(1L)).thenReturn(List.of(userRole));
        //act
        List<UserRole> userRoleList = userRoleService.getAllUserRolesByManagerGroupId(1L);
        //assert
        assertThat(userRoleList).isEqualTo(List.of(userRole));
    }

    @Test
    public void it_should_return_manager_group_name_when_user_role_given(){
        //arrange
        UserRole userRole = mock(UserRole.class);
        when(userRoleRepo.findByRoleId(1L)).thenReturn(userRole);
        when(userRole.getManagerGroupId()).thenReturn(2L);
        ManagerGroup managerGroup = mock(ManagerGroup.class);
        when(managerGroup.getGroupName()).thenReturn("muse");
        when(managerGroupRepo.findByManagerGroupId(userRole.getManagerGroupId())).thenReturn(Optional.of(managerGroup));
        //act
        String groupName = userRoleService.getManagerGroupNameByUserRoleId(1L);
        //assert
        assertThat(groupName).isEqualTo("muse");
    }

    @Test
    public void test_assignUserToUserRole(){
        //arrange
        User user = mock(User.class);
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        user.setRole_id(2L);
        //act
        userRoleService.assignUserToUserRole(1L, 2L);
        //assert
        verify(userRepo, times(1)).save(user);
    }

    @Test
    public void it_should_return_user_role_name_when(){
        //arrange
        UserRole userRole = mock(UserRole.class);
        when(userRoleRepo.findByRoleId(1L)).thenReturn(userRole);
        when(userRoleRepo.findByRoleId(1L).getRoleName()).thenReturn("darth vader");
        //act
        String userRoleName = userRoleService.getUserRoleNameByRoleId(1L);
        //assert
        assertThat(userRoleName).isEqualTo("darth vader");
    }
}
