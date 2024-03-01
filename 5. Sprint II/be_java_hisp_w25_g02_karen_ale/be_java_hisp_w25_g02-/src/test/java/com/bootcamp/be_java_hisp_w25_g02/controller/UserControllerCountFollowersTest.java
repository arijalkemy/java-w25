package com.bootcamp.be_java_hisp_w25_g02.controller;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerCountDTO;
import com.bootcamp.be_java_hisp_w25_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w25_g02.service.IUserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerCountFollowersTest {
    @Mock
    IUserService iUserService;
    @InjectMocks
    UserController userController;
    @Test
    void getUserTotalFollowers() throws Exception {
        //Arrange - llama elementos a usar
        FollowerCountDTO expected = new FollowerCountDTO(1, "Javier", 2L);
        when(iUserService.getUserTotalFollowers(1)).thenReturn(expected);
        //Act - ejecuta el método a testear
        ResponseEntity<FollowerCountDTO> current = userController.getUserTotalFollowers(1);
        //Assert - verifica que el resultado sea lo esperado
        System.out.println(expected.followersCount());
        System.out.println(Objects.requireNonNull(current.getBody()).followersCount());
        assertThat(expected.followersCount()).isEqualTo(Objects.requireNonNull(current.getBody()).followersCount());
    }

    /*
    @Test
    void getUserTotalFollowersCountPath() throws Exception {
        //Arrange - llama elementos a usar
        Long expected = 2L;
        when(iUserService.getUserTotalFollowers(1).followersCount()).thenReturn(expected);
        //Act - ejecuta el método a testear
        ResponseEntity<FollowerCountDTO> current = userController.getUserTotalFollowers(1);
        //Assert - verifica que el resultado sea lo esperado
        System.out.println(expected);
        System.out.println(current);
        assertThat(expected).isEqualTo(current);
    }
    */
}