package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowingPostDTO;
import com.bootcamp.be_java_hisp_w25_g02.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w25_g02.util.TestUtilGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PostServiceImplTest {
    @Mock
    IPostRepository iPostRepository;
    @Mock
    IUserService userService;
    @InjectMocks
    PostServiceImpl postService;

    @Test
    @DisplayName("T-005 - cumple - verificar tipo de ordenamiento (date_asc)")
    void getPostOrderedByDateOrderTypeOKTest(){
        //arrange
        String order =  "date_asc";
        Integer userId = 3;
        when(userService.getFollowedUsersId(userId)).thenReturn(List.of(1));
        when(iPostRepository.findByUserId(1)).thenReturn(
                TestUtilGenerator.getPostsDisordered()
        );
        FollowingPostDTO expectedResponse = TestUtilGenerator.getFollowingPostOrderAsc();
        //act
        FollowingPostDTO actualResponse = postService.getPostsOrderedByDate(userId, order);
        //assert
        verify(iPostRepository, atLeast(1)).findByUserId(1);
        verify(userService, atLeast(1)).getFollowedUsersId(userId);
        assertEquals(expectedResponse, actualResponse);
    }
    @Test
    @DisplayName("T-005 - cumple - verificar tipo de ordenamiento (null)")
    void getPostOrderedByDateOrderTypeNullOKTest(){
        //arrange
        String order =  null;
        Integer userId = 3;
        when(userService.getFollowedUsersId(userId)).thenReturn(List.of(1));
        when(iPostRepository.findByUserId(1)).thenReturn(
                TestUtilGenerator.getPostsDisordered()
        );
        FollowingPostDTO expectedResponse = TestUtilGenerator.getFollowingPostDisordered();
        //act
        FollowingPostDTO actualResponse = postService.getPostsOrderedByDate(userId, order);
        //assert
        verify(iPostRepository, atLeast(1)).findByUserId(1);
        verify(userService, atLeast(1)).getFollowedUsersId(userId);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("T005- No cumple - notifica la no existencia mediante una excepcion")
    void getPostOrderedByDateBadRequest(){
        //arrange
        String order = "ordenamiento_asc";
        Integer userId = 3;
        // act and assert
        assertThrows(BadRequestException.class, () -> postService.getPostsOrderedByDate(userId, order));
    }

    @Test
    @DisplayName("T006 -Verificar ordenamiento ascendente por fecha ")
    void getPostOrderedByDateAscOkTest(){
        //arrange
        String order = "date_asc";
        Integer userId = 3;
        when(userService.getFollowedUsersId(userId)).thenReturn(List.of(1));
        when(iPostRepository.findByUserId(1)).thenReturn(
                TestUtilGenerator.getPostsDisordered()
        );
        FollowingPostDTO expectedResponse = TestUtilGenerator.getFollowingPostOrderAsc();
        //act
        FollowingPostDTO actualResponse = postService.getPostsOrderedByDate(userId, order);
        //assert
        verify(iPostRepository, atLeast(1)).findByUserId(1);
        verify(userService, atLeast(1)).getFollowedUsersId(userId);
        assertEquals(expectedResponse, actualResponse);
    }
    @Test
    @DisplayName("T006 -Verificar ordenamiento descendente por fecha ")
    void getPostOrderedByDateDescOkTest(){
        //arrange
        String order = "date_desc";
        Integer userId = 3;
        when(userService.getFollowedUsersId(userId)).thenReturn(List.of(1));
        when(iPostRepository.findByUserId(1)).thenReturn(
                TestUtilGenerator.getPostsDisordered()
        );
        FollowingPostDTO expectedResponse = TestUtilGenerator.getFollowingPostOrderDesc();
        //act
        FollowingPostDTO actualResponse = postService.getPostsOrderedByDate(userId, order);
        //assert
        verify(iPostRepository, atLeast(1)).findByUserId(1);
        verify(userService, atLeast(1)).getFollowedUsersId(userId);
        assertEquals(expectedResponse, actualResponse);
    }

}