package com.grupo08.socialmeli.service;

import com.grupo08.socialmeli.dto.ExceptionDto;
import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.entity.Post;
import com.grupo08.socialmeli.entity.Product;
import com.grupo08.socialmeli.entity.Seller;
import com.grupo08.socialmeli.repository.PostRepositoryImp;
import com.grupo08.socialmeli.repository.SellerRepositoryImpl;
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
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PostServiceImpTest {

    @Mock
    PostRepositoryImp postRepository;

    @Mock
    SellerRepositoryImpl sellerRepository;

    @InjectMocks
    PostServiceImp postService;

    @Test
    void getAll() {
    }

    @Test
    void insertPost() {

        // Arrange
        Seller sellerMock = new Seller(1, "Brayan", new ArrayList<>(), new ArrayList<>());

        PostDto postDtoToInsert = new PostDto(
                1,
                LocalDate.of(2024, 2, 17),
                new Product(
                        5,
                        "Silla gamer #2",
                        "Gamer",
                        "Racer",
                        "Blue & Green",
                        "Cheap Edition"
                ),
                1,
                200000.0
        );

        Post postToInsert = new Post(
                1,
                LocalDate.of(2024, 2, 17),
                new Product(
                        5,
                        "Silla gamer #2",
                        "Gamer",
                        "Racer",
                        "Blue & Green",
                        "Cheap Edition"
                ),
                1,
                200000.0
        );

        when(sellerRepository.findById(1)).thenReturn(Optional.of(sellerMock));

        postService.insertPost(postDtoToInsert);
        verify(postRepository, atLeast(1)).insertPost(postToInsert);

        ExceptionDto expectedExceptionDto = new ExceptionDto("Todo Ok");
        ExceptionDto actualExceptionDto = postService.insertPost(postDtoToInsert);

        assertEquals(expectedExceptionDto, actualExceptionDto);
    }
}