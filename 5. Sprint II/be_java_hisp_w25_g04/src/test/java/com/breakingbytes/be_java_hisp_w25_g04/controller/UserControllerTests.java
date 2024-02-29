package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.UserDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowedDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowersDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04.service.ISellerService;
import com.breakingbytes.be_java_hisp_w25_g04.service.UserServiceImpl;
import com.breakingbytes.be_java_hisp_w25_g04.utils.FactoryUsers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

    @Mock
    UserServiceImpl userService;
    @Mock
    ISellerService sellerService;
    @InjectMocks
    UserController userController;

    @Test
    @DisplayName("T-0003 - Correcto funcionamiento de getUsersFollowersOf()")
    void getUsersFollowersOfTestOk() {
        // Arrange
        Integer idParam = 4;
        String orderParam = "";
        User user = FactoryUsers.getInstance().getSellerByName("Robert");
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        List<UserDTO> followed = user.getFollowing().stream().map(u -> mapper.map(u, UserDTO.class)).toList();
        UserFollowersDTO u = new UserFollowersDTO(user.getId(), user.getName(),followed);

        ResponseEntity expected = ResponseEntity.ok().body(u);
        // Act
        when(userService.getUsersFollowersOf(idParam, orderParam)).thenReturn(u);
        // Assert
        Assertions.assertEquals(expected, userController.getUsersFollowersOf(idParam, orderParam));
    }

    @Test
    @DisplayName("T-0003 - Correcto funcionamiento de getUsersFollowed()")
    void getUsersFollowedTestOk(){
        // Arrange
        Integer idParam = 1;
        String orderParam = "";
        User user = FactoryUsers.getInstance().getUserByName("Pepe");
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        List<UserDTO> followed = user.getFollowing().stream().map(u -> mapper.map(u, UserDTO.class)).toList();
        UserFollowedDTO u = new UserFollowedDTO(user.getId(), user.getName(),followed);
        ResponseEntity expected = ResponseEntity.ok().body(u);
        // Act
        when(userService.getUsersFollowed(idParam, orderParam)).thenReturn(u);
        // Assert
        Assertions.assertEquals(expected, userController.getUsersFollowed(idParam, orderParam));
    }

    @Test
    @DisplayName("T-0002 - Validar que se llamen las funciones del controller - OK")
    void unfollowUserTest(){
        //Arrange
        Integer userToUnfollowID = 1;
        Integer userID = 2;

        //Act
        userController.unfollowUser(userID, userToUnfollowID);

        //Assert
        verify(sellerService, atLeastOnce()).quitFollower(userToUnfollowID, userID);
        verify(userService, atLeastOnce()).unfollowUser(userID, userToUnfollowID);
        // TODO: Corregir y agregar response entity assert.equals
    }
  
    @Test
    @DisplayName("T-0001 - followUserTestOk")
    public void followUserTestOk() {
        // arrange
        Integer userId = 1;
        Integer userIdToFollow = 2;
        // act
        ResponseEntity<?> response = userController.followUser(userId, userIdToFollow);
        // assert
        verify(userService, atLeastOnce()).follow(userId, userIdToFollow);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        // TODO: Es necesario devolver el response entity si solo se devuelve un status code??
    }
}
