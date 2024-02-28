package com.bootcamp.be_java_hisp_w25_g02.controller;

import com.bootcamp.be_java_hisp_w25_g02.service.PostServiceImpl;
import com.bootcamp.be_java_hisp_w25_g02.util.TestUtilGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProductControllerTest {
    @Mock
    PostServiceImpl postService;
    @InjectMocks
    ProductController productController;

    @Test
    @DisplayName("T-006 verificar ordenamiento asc")
    void getPostOrdereByDateAscOK(){
        //arrange
        Integer userId = 3;
        String order = "date_asc";
        when(postService.getPostsOrderedByDate(userId, order)).thenReturn(TestUtilGenerator.getFollowingPostOrderAsc());
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(TestUtilGenerator.getFollowingPostOrderAsc(), HttpStatus.OK);
        //act
        ResponseEntity<?> actualResponse = productController.getFollowedPosts(userId, order);
        //assert
        verify(postService, atLeast(1)).getPostsOrderedByDate(userId, order);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("T-006 verificar ordenamiento desc")
    void getPostOrdereByDateDescOk(){
        //arrange
        Integer userId = 3;
        String order = "date_desc";
        when(postService.getPostsOrderedByDate(userId, order)).thenReturn(TestUtilGenerator.getFollowingPostOrderDesc());
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(TestUtilGenerator.getFollowingPostOrderDesc(), HttpStatus.OK);
        //act
        ResponseEntity<?> actualResponse = productController.getFollowedPosts(userId, order);
        //assert
        verify(postService, atLeast(1)).getPostsOrderedByDate(userId, order);
        assertEquals(expectedResponse, actualResponse);
    }

}