package com.mercadolibre.be_java_hisp_w25_g15.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.ProductDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.exception.ConflictException;
import com.mercadolibre.be_java_hisp_w25_g15.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w25_g15.exception.OrderNotValidException;
import com.mercadolibre.be_java_hisp_w25_g15.model.*;
import com.mercadolibre.be_java_hisp_w25_g15.repository.impl.PostRepository;
import com.mercadolibre.be_java_hisp_w25_g15.repository.impl.UserRepository;
import com.mercadolibre.be_java_hisp_w25_g15.utils.ObjectMapperBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Mock
    PostRepository postRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    ObjectMapperBean mapperService;


    @InjectMocks
    PostService postService;

    PostDto postDto1;
    PostDto postDto2;
    PostDto postDto3;
    ProductDto productDto1;
    ProductDto productDto2;
    Post post1;
    Post post2;
    Post post3;
    PostGetListDto postGetListDto;
    List<PostDto> postDtoList;
    List<Post> postList;
    static ObjectMapper mapper = new ObjectMapper();
    @BeforeAll
    static void init(){
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        mapper.registerModule(javaTimeModule);
    }
    @BeforeEach
    void setUp() {
        productDto1 = new ProductDto(1, "Leche","Lacteo", "Milkaut", "Blanco", "");
        productDto2 = new ProductDto(2, "Azucar","Dulce", "Arcor", "Azul", "");
        postDto1 = new PostDto(1,1,"15-02-2024", productDto1, 1,15.0);
        postDto2 = new PostDto(1,2,"17-02-2024", productDto2, 2,100.0);
        postDto3 = new PostDto(1,3,"01-01-2024", productDto1, 1,250.0);
        postDtoList = new ArrayList<>(List.of(postDto1,postDto2,postDto3));
        postGetListDto = new PostGetListDto(1, postDtoList);

        postList = postDtoList.stream().map(postDto -> mapper.convertValue(postDto, Post.class)).toList();
        post1 = mapper.convertValue(postDto1, Post.class);
        post2 = mapper.convertValue(postDto2, Post.class);
        post3 = mapper.convertValue(postDto3, Post.class);
    }

    @Test
    void createPost(){
        // Arrange
        User user = new Seller();
        user.setId(1);
        when(mapperService.getMapper()).thenReturn(mapper);
        when(userRepository.getUserById(1)).thenReturn(Optional.of(user));
        when(postRepository.addPost(post1)).thenReturn(post1);
        // Act
        PostDto post = postService.createPost(postDto1);
        // Assertions
        Assertions.assertEquals(post, postDto1);
    }
    @Test
    void createPostNotSeller() {
        // Arrange
        User user = new Buyer();
        user.setId(1);
        when(mapperService.getMapper()).thenReturn(mapper);
        when(userRepository.getUserById(1)).thenReturn(Optional.of(user));
        when(userRepository.getUserById(postDto1.user_id())).thenReturn(Optional.of(new Buyer()));
        // Act & Assert
        Assertions.assertThrows(ConflictException.class, () -> postService.createPost(postDto1));
    }

    @Test
    void createPostNotUserFound(){
        // Arrange
        User user = new Seller();
        user.setId(1);
        when(mapperService.getMapper()).thenReturn(mapper);
        when(userRepository.getUserById(1)).thenReturn(Optional.of(user));
        when(userRepository.getUserById(postDto1.user_id())).thenReturn(Optional.empty());
        // Act & Assert
        Assertions.assertThrows(NotFoundException.class, () -> postService.createPost(postDto1));
    }

    @Test
    void getPostsByUserFollowedInLastTwoWeeksDescOK() {
        DateOrderEnumDto order = DateOrderEnumDto.DATE_DESC;
        Seller seller = Seller.builder().id(1).username("Seller with followers").followed(new ArrayList<>()).followers(new ArrayList<>()).build();
        User user = Buyer.builder().id(4).username("Yanina").followed(new ArrayList<>(List.of(seller))).build();
        seller.getFollowers().add(user);
        PostGetListDto expected = new PostGetListDto(user.getId(), List.of(
                new PostDto(seller.getId(),2,"17-02-2024", productDto2, 2,100.0),
                new PostDto(seller.getId(),1,"15-02-2024", productDto1, 1,15.0),
                new PostDto(seller.getId(),3,"01-01-2024", productDto1, 1,250.0)
        ));

        Mockito.when(userRepository.getUserById(user.getId())).thenReturn(Optional.of(user));
        Mockito.when(mapperService.getMapper()).thenReturn(mapper);
        Mockito.when(postRepository.findAllPostsBySellerIdBetweenDateRange(anyInt(),any(),any())).thenReturn(postList);
        PostGetListDto actual = postService.getPostsByUserFollowedInLastTwoWeeks(user.getId(), order);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void getPostsByUserFollowedInLastTwoWeeksAscOK() {
        DateOrderEnumDto order = DateOrderEnumDto.DATE_ASC;
        Seller seller = Seller.builder().id(1).username("Seller with followers").followed(new ArrayList<>()).followers(new ArrayList<>()).build();
        User user = Buyer.builder().id(4).username("Yanina").followed(new ArrayList<>(List.of(seller))).build();
        seller.getFollowers().add(user);
        PostGetListDto expected = new PostGetListDto(user.getId(), List.of(
                new PostDto(seller.getId(),3,"01-01-2024", productDto1, 1,250.0),
        new PostDto(seller.getId(),1,"15-02-2024", productDto1, 1,15.0),
        new PostDto(seller.getId(),2,"17-02-2024", productDto2, 2,100.0)
        ));

        Mockito.when(userRepository.getUserById(user.getId())).thenReturn(Optional.of(user));
        Mockito.when(mapperService.getMapper()).thenReturn(mapper);
        Mockito.when(postRepository.findAllPostsBySellerIdBetweenDateRange(anyInt(),any(),any())).thenReturn(postList);
        PostGetListDto actual = postService.getPostsByUserFollowedInLastTwoWeeks(user.getId(), order);
        Assertions.assertEquals(expected, actual);
    }
    //T-0005 Verificar que el tipo de ordenamiento por fecha exista (US-0009)
    @Test
    void findPostsBySellerIdLastTwoWeeksWithOrderingNotFoundTypeOrder() {
        //Arrange
        Integer sellerId = 6;
        //Act & Assert
        Assertions.assertThrows(OrderNotValidException.class,
                () -> postService.getPostsByUserFollowedInLastTwoWeeks(sellerId,null));
    }
}