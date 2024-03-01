package com.example.bootcampsprint1g6.controller;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.Product;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.service.IPostService;
import com.example.bootcampsprint1g6.util.PostTestGenerator;
import com.example.bootcampsprint1g6.util.UserTestGenerator;
import com.example.bootcampsprint1g6.util.mapper.PostMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PostControllerTest {
    @Mock
    private IPostService postService;
    @InjectMocks
    private PostController postController;
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
    void getLastPostsByFollowedOkTest(){
        //Arrange
        PostListDTO expected = new PostListDTO(1, new ArrayList<>(){{
            add(PostMapper.getResponseInstance(post1));
            add(PostMapper.getResponseInstance(post3));
        }});
        when(postService.getLastPostsByFollowed(1, "")).thenReturn(expected);
        //Act
        ResponseEntity<PostListDTO> result = postController.getLastPostsByFollowed(1, "");
        //Assert
        verify(postService, atLeast(1)).getLastPostsByFollowed(1, "");
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isEqualTo(expected);
    }

    @Test
    void getLastPostsByFollowedAscOkTest(){
        //Arrange
        PostListDTO expected = new PostListDTO(1, new ArrayList<>(){{
            add(PostMapper.getResponseInstance(post3));
            add(PostMapper.getResponseInstance(post1));
        }});
        when(postService.getLastPostsByFollowed(1, "date_asc")).thenReturn(expected);
        //Act
        ResponseEntity<PostListDTO> result = postController.getLastPostsByFollowed(1, "date_asc");
        //Assert
        verify(postService, atLeast(1)).getLastPostsByFollowed(1, "date_asc");
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isEqualTo(expected);
    }

    @Test
    void getLastPostsByFollowedDescOkTest(){
        //Arrange
        PostListDTO expected = new PostListDTO(1, new ArrayList<>(){{
            add(PostMapper.getResponseInstance(post1));
            add(PostMapper.getResponseInstance(post3));
        }});
        when(postService.getLastPostsByFollowed(1, "date_desc")).thenReturn(expected);
        //Act
        ResponseEntity<PostListDTO> result = postController.getLastPostsByFollowed(1, "date_desc");
        //Assert
        verify(postService, atLeast(1)).getLastPostsByFollowed(1, "date_desc");
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isEqualTo(expected);
    }
}
