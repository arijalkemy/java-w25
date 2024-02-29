package com.grupo08.socialmeli.controller;

import com.grupo08.socialmeli.dto.response.FollowDto;
import com.grupo08.socialmeli.dto.response.FollowedDTO;
import com.grupo08.socialmeli.dto.response.FollowersCountDto;
import com.grupo08.socialmeli.dto.response.FollowersDto;
import com.grupo08.socialmeli.entity.User;
import com.grupo08.socialmeli.service.UserServiceImpl;
import com.grupo08.socialmeli.utils.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserServiceImpl userService;

    @InjectMocks
    UserController userController;

    @Test
    void followSeller() {

        int buyerId = 1;
        int sellerId = 1;

        FollowDto expected = new FollowDto(sellerId, "Andrés");

        when(userService.follow(buyerId, sellerId)).thenReturn(expected);

        ResponseEntity<?> actual = userController.followSeller(buyerId, sellerId);

        assertEquals(expected, actual.getBody());
        assertEquals(HttpStatus.OK, actual.getStatusCode());

    }

    @Test
    void getFollowers() {
        //ARRANGE
        int userId= 1;
        String order="name_desc";
        FollowersDto followersDto = new FollowersDto(1, "Fabian", new ArrayList<FollowDto>());
        when(userService.getFollowers(userId,order)).thenReturn(followersDto);
        //ACT
        ResponseEntity<?> response = userController.getFollowers(userId, order);

        //ASSERT
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void unFollowSeller() {

        int buyerId = 1;
        int sellerId = 1;

        doNothing().when(userService).unfollow(buyerId, sellerId);

        ResponseEntity<?> actual = userController.unFollowSeller(buyerId, sellerId);

        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    void getFollowedSellers() {
        //ARRANGE
        int userId = 1000;
        String order = null;

        FollowedDTO followedDTO = TestData.getFollowedDTOResponse(userId);
        when(userService.getFollowedSellers(userId, order)).thenReturn(followedDTO);

        //ACT
        ResponseEntity<?> response =
                userController.getFollowedSellers(followedDTO.getUserId(), order);

        //ASSERT
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void followersCount() {
        //ARRANGE
        FollowersCountDto expectedResponse = new FollowersCountDto(1, "sellerName", 2L);
        when(userService.countSellerFollowers(anyInt())).thenReturn(expectedResponse);
        //ACT
        ResponseEntity<?> obtainedResponse = userController.followersCount(1);
        //ASSERT
        assertEquals(expectedResponse, obtainedResponse.getBody());
        assertEquals(HttpStatus.OK, obtainedResponse.getStatusCode());
    }
}