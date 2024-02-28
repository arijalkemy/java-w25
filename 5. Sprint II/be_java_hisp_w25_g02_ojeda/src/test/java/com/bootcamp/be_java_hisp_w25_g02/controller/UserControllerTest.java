package com.bootcamp.be_java_hisp_w25_g02.controller;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerCountDTO;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Test
    @DisplayName("T-0001 - followSeller - Test OK")
    void followSellerTestOk() {
        //Asset
        Integer userId = 1;
        Integer userIdToFollow = 7;
        // Act
        ResponseEntity<?> response = userController.followSeller(userId, userIdToFollow);

        // Assert
        verify(userService,  atLeastOnce()).followUser(userId, userIdToFollow);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    @DisplayName("T-0002 - unfollowSeller - Test OK")
    void unfollowSellerTestOk() {
        //Assert
        Integer userId = 1;
        Integer userIdToUnfollow = 7;
        // Act
        ResponseEntity<?> response = userController.unfollowSeller(userId, userIdToUnfollow);

        // Assert
        verify(userService, atLeastOnce()).unfollowUser(userId, userIdToUnfollow);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("T-0007- getUserTotalFollowers")
    void getUserTotalFollowers() throws Exception {
        //Arrange - llama elementos a usar
        FollowerCountDTO expected = new FollowerCountDTO(1, "Javier", 2L);
        when(userService.getUserTotalFollowers(1)).thenReturn(expected);
        //Act - ejecuta el método a testear
        ResponseEntity<FollowerCountDTO> current = userController.getUserTotalFollowers(1);
        //Assert - verifica que el resultado sea lo esperado
        assertThat(current.getStatusCode()).isEqualTo(HttpStatus.OK);
        FollowerCountDTO actual = current.getBody();
        assertThat(actual).isEqualTo(expected);
    }
}