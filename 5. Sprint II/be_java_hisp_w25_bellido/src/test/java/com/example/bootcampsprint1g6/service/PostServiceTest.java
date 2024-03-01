package com.example.bootcampsprint1g6.service;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.entity.*;
import com.example.bootcampsprint1g6.exception.NotFoundException;
import com.example.bootcampsprint1g6.repository.IUserRepository;
import com.example.bootcampsprint1g6.service.implementation.PostServiceImpl;
import com.example.bootcampsprint1g6.util.PostTestGenerator;
import com.example.bootcampsprint1g6.util.UserTestGenerator;
import com.example.bootcampsprint1g6.util.mapper.PostMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PostServiceTest {
    @Mock
    private IUserRepository userRepository;
    @InjectMocks
    private PostServiceImpl postService;
    private Seller user1;
    private Post post1;
    private Post post3;
    @BeforeEach
    void setUp(){
        Product product1 = new Product(23, "camisa a rayas", "indumentaria", "sarkany", "rojo", "unico color, puro algodon");
        Product product2 = new Product(24, "camisa a cuadros", "indumentaria", "sarkany", "azul", "unico color, puro algodon y cuadros");
        user1 = UserTestGenerator.getSellerWithId(1);
        Seller user3 = UserTestGenerator.getSellerWithId(3);
        user1.follow(user3);
        post1 = PostTestGenerator.getPostFromUserProductDate(user3,product1,LocalDate.now().minusWeeks(2).plusDays(1));
        Post post2 = PostTestGenerator.getPostFromUserProductDate(user3,product2,LocalDate.now().minusWeeks(2));
        post3 = PostTestGenerator.getPostFromUserProductDate(user3,product2,LocalDate.now().minusWeeks(2).plusDays(2));
        (user3).addPost(post1);
        (user3).addPost(post2);
        (user3).addPost(post3);
    }

    @Test
    @DisplayName("T0008 - (Service) - Verify get last posts by followed - Success")
    void getLastPostsByFollowedOkTest(){
        //Arrange
        PostListDTO expected = new PostListDTO(1, new ArrayList<>(){{
            add(PostMapper.getResponseInstance(post1));
            add(PostMapper.getResponseInstance(post3));
        }});
        when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user1));
        //Act
        PostListDTO result = postService.getLastPostsByFollowed(1, "");
        //Assert
        verify(userRepository, atLeastOnce()).findById(user1.getUserId());
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("T0005 - (Service) - Verify that the sort by date_asc exists - Success")
    void getLastPostsByFollowedExistTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "date_asc";
        PostListDTO expected = new PostListDTO(1, new ArrayList<>(){{
            add(PostMapper.getResponseInstance(post1));
            add(PostMapper.getResponseInstance(post3));
        }});
        when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user1));
        //Act
        PostListDTO result = postService.getLastPostsByFollowed(userId, order);
        //Assert
        verify(userRepository, atLeastOnce()).findById(user1.getUserId());
        assertEquals(expected,result);
    }
    @Test
    @DisplayName("T0005 - (Service) - Verify that the sort by date_desc exists - Success")
    void getLastPostsByFollowedExistDescTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "date_desc";
        PostListDTO expected = new PostListDTO(1, new ArrayList<>(){{
            add(PostMapper.getResponseInstance(post3));
            add(PostMapper.getResponseInstance(post1));
        }});
        when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user1));
        //Act
        PostListDTO result = postService.getLastPostsByFollowed(userId, order);
        //Assert
        verify(userRepository, atLeastOnce()).findById(user1.getUserId());
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("T0006 - (Service) - Verify that the sort by date_asc sort correctly - Success")
    void getLastPostsByFollowedAscOkTest(){
        //Arrange
        PostListDTO expected = new PostListDTO(1, new ArrayList<>(){{
            add(PostMapper.getResponseInstance(post1));
            add(PostMapper.getResponseInstance(post3));
        }});
        when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user1));
        //Act
        PostListDTO result = postService.getLastPostsByFollowed(1, "date_asc");
        //Assert
        verify(userRepository, atLeastOnce()).findById(user1.getUserId());
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0006 - (Service) - Verify that the sort by date_desc sort correctly - Success")
    void getLastPostsByFollowedDescOkTest(){
        //Arrange
        PostListDTO expected = new PostListDTO(1, new ArrayList<>(){{
            add(PostMapper.getResponseInstance(post3));
            add(PostMapper.getResponseInstance(post1));
        }});
        when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user1));
        //Act
        PostListDTO result = postService.getLastPostsByFollowed(1, "date_desc");
        //Assert
        verify(userRepository, atLeastOnce()).findById(user1.getUserId());
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T0008 - (Service) - Verify throw exception when id its not found - Success")
    void getLastPostsByFollowedNotFoundExTest(){
        //Arrange
        Integer userId = 0;
        //Act
        //Assert
        assertThrows(NotFoundException.class, () -> postService.getLastPostsByFollowed(userId, ""));
    }

    @Test
    @DisplayName("T0008 - (Service) - Verify throw exception when 'order' string doesn't match - Success")
    void getLastPostsByFollowedIllegalArgumentExTest(){
        //Arrange
        Seller user = UserTestGenerator.getSellerWithId(1);
        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        //Act
        //Assert
        assertThrows(IllegalArgumentException.class, () -> postService.getLastPostsByFollowed(user.getUserId(), "asd"));
    }
}
