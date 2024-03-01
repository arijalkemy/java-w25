package com.bootcamp.be_java_hisp_w25_g02.controller;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserFollowingDTO;
import com.bootcamp.be_java_hisp_w25_g02.service.IUserService;
import com.bootcamp.be_java_hisp_w25_g02.util.TestUtilGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    IUserService userService;
    @InjectMocks
    UserController userController;

    @Test
    @DisplayName("T-0003 & T-0004 - getFollowedSellers")
    void getFollowedSellersOK() {
        // Arrange
        Integer id = 1;
        String order = "name_asc";
        UserFollowingDTO expectedServResp = TestUtilGenerator.getCorrectAscUserFollowingDTO();
        ResponseEntity<UserFollowingDTO> expected = new ResponseEntity<>(expectedServResp, HttpStatus.OK);

        when(userService.getFollowedSellers(id, order)).thenReturn(expectedServResp);
        // Act
        ResponseEntity<UserFollowingDTO> result = userController.getFollowedSellers(id, order);

        // Assert
        verify(userService, atLeastOnce()).getFollowedSellers(id, order);
        assertEquals(expected, result);
    }
}