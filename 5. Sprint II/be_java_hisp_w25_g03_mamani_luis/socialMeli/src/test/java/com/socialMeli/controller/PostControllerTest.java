package com.socialMeli.socialMeli.controller;

import com.socialMeli.controller.PostController;
import com.socialMeli.dto.response.PostDto;
import com.socialMeli.dto.response.ProductDto;
import com.socialMeli.dto.response.PublicationDto;
import com.socialMeli.service.IPostService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@ExtendWith(MockitoExtension.class)
public class PostControllerTest {
    @Mock
    IPostService postService;

    @InjectMocks
    PostController postController;

    @Test
    void obtainLastPublicationsByTheFollowedVendorsTest() {
        // Arrange
        PostDto obtainedPost = new PostDto(1, 1, LocalDate.now(),
                new ProductDto(
                        1, "Silla Gamer", "Gamer", "Racer", "Negra", "Completa"
                ), 1, 120000.0
        );
        PublicationDto obtainedPublicationDto = new PublicationDto(1,List.of(obtainedPost));

        when(postService.obtainLastPublicationsByTheFollowedVendors(1, "")).thenReturn(obtainedPublicationDto);

        // Act
        ResponseEntity<PublicationDto> response = postController.obtainLastPublicationsByTheFollowedVendors(1,"");

        // Assert
        verify(postService, atLeastOnce()).obtainLastPublicationsByTheFollowedVendors(1,"");
        assertEquals(obtainedPost, Objects.requireNonNull(response.getBody()).getPostDTOList().get(0));
    }




}
