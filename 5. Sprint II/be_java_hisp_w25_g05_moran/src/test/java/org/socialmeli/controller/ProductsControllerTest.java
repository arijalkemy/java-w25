package org.socialmeli.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.PostIdDto;
import org.socialmeli.service.IPostsService;
import org.socialmeli.util.ObjectFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductsControllerTest {

    @Mock
    private IPostsService postsService;
    @InjectMocks
    private ProductsController productsController;

    ObjectFactory objectFactory = new ObjectFactory();

    // T-0008
    @Test
    @DisplayName("[T-0005, T-0006, T-0008] Happy path")
    public void followedList() {
        // Arrange
        Integer userId = objectFactory.getValidUserId();
        String order = "date_asc";
        FollowedListReqDto followedListReqDto = new FollowedListReqDto(userId, order);
        // Act
        ResponseEntity<FollowedListDto> result = productsController.followedList(userId, order);
        // Assert
        verify(postsService, atLeastOnce()).getFollowedList(followedListReqDto);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    @DisplayName("[COV-0001] Create post method ok")
    public void createPostOk() {
        // ARRANGE
        PostReqDto inputDto = objectFactory.getValidPostReqDto();
        PostIdDto mockPostIdDto = new PostIdDto(1);
        ResponseEntity<PostIdDto> expected = new ResponseEntity<>(mockPostIdDto, HttpStatus.OK);
        when(postsService.savePost(inputDto)).thenReturn(mockPostIdDto);

        // ACT
        ResponseEntity<PostIdDto> response = productsController.createPost(inputDto);

        // ASSERT
        assertEquals(expected, response);
    }
}
