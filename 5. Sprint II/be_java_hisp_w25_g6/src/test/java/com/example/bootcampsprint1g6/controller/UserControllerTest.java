package com.example.bootcampsprint1g6.controller;

import com.example.bootcampsprint1g6.dto.*;
import com.example.bootcampsprint1g6.service.implementation.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;


import static com.example.bootcampsprint1g6.util.UserTestGenerator.getFollowersCountDTOWSeller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.List;
import org.springframework.http.HttpStatus;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserControllerTest {

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserController userController;

    @Test
    @DisplayName("T0003 & T0004 - (Controller) - List followed users with ascendant order is ok")
    public void getFollowedListOrdAscTestOK(){
        //Arrange
        Integer userId = 1;
        String order = "name_asc";
        FollowedDTO expected = new FollowedDTO(userId, "Name", List.of(
                new UserDTO(2, "nameA"),
                new UserDTO(3, "nameB"),
                new UserDTO(4, "nameC")
        ));
        ResponseEntity<FollowedDTO> expectedResponse = ResponseEntity.ok().body(expected);
        when(userService.getFollowedList(userId, order)).thenReturn(expected);

        //Act
        ResponseEntity<FollowedDTO> obtainedResponse = userController.getFollowedList(userId, order);

        //Assert
        verify(userService, atLeastOnce()).getFollowedList(userId, order);
        assertEquals(expectedResponse, obtainedResponse);
    }

    @Test
    @DisplayName("T0002 - (Controller) - Unfollow - Test Success")
    public void unfollowTestOk(){
        Integer userId = 1;
        Integer userIdUnfollow = 2;

        GenericResponseDTO expectedResponse = new GenericResponseDTO(HttpStatus.OK.value(),"OK");

        when(userService.unfollow(userId,userIdUnfollow)).thenReturn(expectedResponse);

        ResponseEntity<GenericResponseDTO> actualResponse = userController.unfollow(userId,userIdUnfollow);

        verify(userService, atLeastOnce()).unfollow(userId, userIdUnfollow);
        assertNotNull(actualResponse.getBody());
        assertEquals(HttpStatus.OK,actualResponse.getStatusCode());
        assertEquals(expectedResponse,actualResponse.getBody());
    }

    @Test
    @DisplayName("T0007 - (Controller) - Get followers amount - Success")
    public void getFollowersCountTestOk(){
        //arrange
        Integer id = 1;
        FollowersCountDTO followers = getFollowersCountDTOWSeller(id);
        when(userService.getFollowersCount(id)).thenReturn(followers);
        ResponseEntity<FollowersCountDTO> expected = new ResponseEntity<>(followers, HttpStatus.OK);
        //act
        ResponseEntity<FollowersCountDTO> response = userController.getFollowersCount(id);
        //assert
        verify(userService, atLeast(1)).getFollowersCount(id);
        assertEquals(expected, response);
    }

//    Verificar que el tipo de ordenamiento por fecha exista

    @Test
    @DisplayName("T0003 & T0004 - (Controller) - List followed users with descendent order is ok")
    public void getFollowedListOrdDescTestOK(){
        //Arrange
        Integer userId = 1;
        String order = "name_desc";
        FollowedDTO expected = new FollowedDTO(userId, "Name", List.of(
                new UserDTO(4, "nameC"),
                new UserDTO(3, "nameB"),
                new UserDTO(2, "nameA")
        ));
        ResponseEntity<FollowedDTO> expectedResponse = ResponseEntity.ok().body(expected);
        when(userService.getFollowedList(userId, order)).thenReturn(expected);

        //Act
        ResponseEntity<FollowedDTO> obtainedResponse = userController.getFollowedList(userId, order);

        //Assert
        verify(userService, atLeastOnce()).getFollowedList(userId, order);
        assertEquals(expectedResponse, obtainedResponse);
    }
    @Test
    @DisplayName("T0003 & T0004  - (Controller) - List followers users with ascendant order is ok")
    public void getFollowersListOrdAscTestOK(){
        //Arrange
        Integer userId = 1;
        String order = "name_asc";
        FollowersDTO expected = new FollowersDTO(userId, "Name", List.of(
                new UserDTO(2, "nameA"),
                new UserDTO(3, "nameB"),
                new UserDTO(4, "nameC")
        ));
        ResponseEntity<FollowersDTO> expectedResponse = ResponseEntity.ok().body(expected);
        when(userService.getFollowersList(userId, order)).thenReturn(expected);

        //Act
        ResponseEntity<?> obtainedResponse = userController.getFollowersList(userId, order);

        //Assert
        verify(userService, atLeastOnce()).getFollowersList(userId, order);
        assertEquals(expectedResponse, obtainedResponse);
    }

    @Test
    @DisplayName("T0003 & T0004 - (Controller) - List followed users with descendent order is ok")
    public void getFollowersListOrdDescTestOK(){
        //Arrange
        Integer userId = 1;
        String order = "name_desc";
        FollowersDTO expected = new FollowersDTO(userId, "Name", List.of(
                new UserDTO(4, "nameC"),
                new UserDTO(3, "nameB"),
                new UserDTO(2, "nameA")
        ));

        ResponseEntity<FollowersDTO> expectedResponse = ResponseEntity.ok().body(expected);
        when(userService.getFollowersList(userId, order)).thenReturn(expected);

        //Act
        ResponseEntity<?> obtainedResponse = userController.getFollowersList(userId, order);

        //Assert
        verify(userService, atLeastOnce()).getFollowersList(userId, order);
        assertEquals(expectedResponse, obtainedResponse);
    }

    @Test
    @DisplayName("T0001 - (Controller) - Follow valid user - Success")
    public void followTestOk() {
        //Arrange
        GenericResponseDTO expectedResponse = new GenericResponseDTO(HttpStatus.OK.value(), "Ok");
        when(userService.follow(1, 2)).thenReturn(expectedResponse);

        //Act
        ResponseEntity<GenericResponseDTO> response = userController.follow(1, 2);

        //Assert
        verify(userService, atLeastOnce()).follow(1, 2);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getStatus()).isEqualTo(expectedResponse.getStatus());
        assertThat(response.getBody().getMessage()).isEqualTo(expectedResponse.getMessage());
    }
}
