package com.bootcamp.be_java_hisp_w25_g9.service;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDtoMixIn;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDtoMixin;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g9.model.Client;
import com.bootcamp.be_java_hisp_w25_g9.model.Post;
import com.bootcamp.be_java_hisp_w25_g9.model.Product;
import com.bootcamp.be_java_hisp_w25_g9.model.Seller;
import com.bootcamp.be_java_hisp_w25_g9.repository.PostRepository;
import com.bootcamp.be_java_hisp_w25_g9.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    UserRepository userRepository;
    @Mock
    PostRepository postRepository;

    @InjectMocks
    PostService postService;
    static ObjectMapper mapper = new ObjectMapper();

    @Test
    void getPostVerifyOrderingOkDesc() {
        //Arrange
        Integer userId = 12;
        Boolean userExists = true;
        String order = "date_desc";
        Client clientById = new Client(12, "Daryl Miguel");
        Seller sellerFollowed1 = new Seller(29, "Josiah Sanchez");
        Seller sellerFollowed2 = new Seller(30, "Patrick Blanco");
        clientById.setFollowed(List.of(sellerFollowed1, sellerFollowed2));
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Camisa", "Ropa", "Marca A", "Azul", "Algodón"));
        productList.add(new Product(2, "Pantalón", "Ropa", "Marca B", "Negro", "Poliéster"));
        productList.add(new Product(3, "Zapatos", "Calzado", "Marca C", "Blanco", "Cuero"));
        List<Post> postList = new ArrayList<>();
        postList.add(new Post(1, 29, 25, LocalDate.of(2024,1,10), productList.get(0), 81.0));
        postList.add(new Post(2, 29, 40, LocalDate.of(2024,2,19), productList.get(1), 82.0));
        postList.add(new Post(3, 29, 43, LocalDate.of(2024,2,27), productList.get(0), 65.0));
        postList.add(new Post(4, 30, 12, LocalDate.of(2024,2,24), productList.get(2), 9.0));
        postList.add(new Post(5, 30, 32, LocalDate.of(2024,2,25), productList.get(1), 65.0));
        ProductDto productDto1 = new ProductDto(1, "Camisa", "Ropa", "Marca A", "Azul", "Algodón");
        ProductDto productDto2 = new ProductDto(2, "Pantalón", "Ropa", "Marca B", "Negro", "Poliéster");
        ProductDto productDto3 = new ProductDto(3, "Zapatos", "Calzado", "Marca C", "Blanco", "Cuero");
        List<PostResponseDto> expectedPostList = new ArrayList<>();
        expectedPostList.add(new PostResponseDto(3, 29,  LocalDate.of(2024,2,27), productDto1, 43, 65.0));
        expectedPostList.add(new PostResponseDto(5, 30, LocalDate.of(2024,2,25), productDto2, 32, 65.0));
        expectedPostList.add(new PostResponseDto(4, 30, LocalDate.of(2024,2,24), productDto3, 12,9.0));
        expectedPostList.add(new PostResponseDto(2, 29, LocalDate.of(2024,2,19), productDto2, 40, 82.0));
        FollowedPostsDto expected = new FollowedPostsDto(userId, expectedPostList);

        when(userRepository.userExists(userId)).thenReturn(userExists);
        when(userRepository.getUserById(userId)).thenReturn(clientById);
        when(postRepository.findAll()).thenReturn(postList);
        //Act
        FollowedPostsDto result = postService.getPost(userId, order);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    void getPostVerifyOrderingOkAsc() {
        //Arrange
        Integer userId = 12;
        Boolean userExists = true;
        String order = "date_asc";
        Client clientById = new Client(12, "Daryl Miguel");
        Seller sellerFollowed1 = new Seller(29, "Josiah Sanchez");
        Seller sellerFollowed2 = new Seller(30, "Patrick Blanco");
        clientById.setFollowed(List.of(sellerFollowed1, sellerFollowed2));
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Camisa", "Ropa", "Marca A", "Azul", "Algodón"));
        productList.add(new Product(2, "Pantalón", "Ropa", "Marca B", "Negro", "Poliéster"));
        productList.add(new Product(3, "Zapatos", "Calzado", "Marca C", "Blanco", "Cuero"));
        List<Post> postList = new ArrayList<>();
        postList.add(new Post(1, 29, 25, LocalDate.of(2024,1,10), productList.get(0), 81.0));
        postList.add(new Post(2, 29, 40, LocalDate.of(2024,2,19), productList.get(1), 82.0));
        postList.add(new Post(3, 29, 43, LocalDate.of(2024,2,27), productList.get(0), 65.0));
        postList.add(new Post(4, 30, 12, LocalDate.of(2024,2,24), productList.get(2), 9.0));
        postList.add(new Post(5, 30, 32, LocalDate.of(2024,2,25), productList.get(1), 65.0));
        ProductDto productDto1 = new ProductDto(1, "Camisa", "Ropa", "Marca A", "Azul", "Algodón");
        ProductDto productDto2 = new ProductDto(2, "Pantalón", "Ropa", "Marca B", "Negro", "Poliéster");
        ProductDto productDto3 = new ProductDto(3, "Zapatos", "Calzado", "Marca C", "Blanco", "Cuero");
        List<PostResponseDto> expectedPostList = new ArrayList<>();
        expectedPostList.add(new PostResponseDto(2, 29, LocalDate.of(2024,2,19), productDto2, 40, 82.0));
        expectedPostList.add(new PostResponseDto(4, 30, LocalDate.of(2024,2,24), productDto3, 12,9.0));
        expectedPostList.add(new PostResponseDto(5, 30, LocalDate.of(2024,2,25), productDto2, 32, 65.0));
        expectedPostList.add(new PostResponseDto(3, 29,  LocalDate.of(2024,2,27), productDto1, 43, 65.0));
        FollowedPostsDto expected = new FollowedPostsDto(userId, expectedPostList);

        when(userRepository.userExists(userId)).thenReturn(userExists);
        when(userRepository.getUserById(userId)).thenReturn(clientById);
        when(postRepository.findAll()).thenReturn(postList);
        //Act
        FollowedPostsDto result = postService.getPost(userId, order);
        //Assert
        assertEquals(expected, result);
    }

    @BeforeAll
    public static void before() {
        mapper.registerModule(new JavaTimeModule());
        mapper.addMixIn(Product.class, ProductDtoMixIn.class);
        mapper.addMixIn(Post.class, PostRequestDtoMixin.class);
    }

    @Test
    void getPostOk() {
        //ARRANGE
        int userId = 1;
        List<Product> productList = List.of(
                new Product(1, "Camisa", "Ropa", "Marca A", "Azul", "Algodón"),
                new Product(2, "Pantalón", "Ropa", "Marca B", "Negro", "Poliéster"),
                new Product(3, "Zapatos", "Calzado", "Marca C", "Blanco", "Cuero")
        );

        List<Seller> clients = List.of(
                new Seller(35, "Deacon Marquez"),
                new Seller(36, "Molly Martina"),
                new Seller(37, "Chase Tapia"),
                new Seller(38, "Leigh Gabriela")
        );

        Client client = new Client(1, "Quynn Nunez");
        client.setFollowed(clients);

        List<Post> postList = new ArrayList<>();
        postList.add(new Post(1, 35, 25, LocalDate.now().minusDays(3), productList.get(1), 78.0));
        postList.add(new Post(2, 36, 25, LocalDate.now(), productList.get(1), 78.0));
        postList.add(new Post(3, 35, 25, LocalDate.now().minusDays(20), productList.get(1), 78.0));
        postList.add(new Post(4, 35, 25, LocalDate.now().minusDays(10), productList.get(1), 78.0));

        List<PostResponseDto> postResponseDtosExpected = new ArrayList<>();
        postResponseDtosExpected.add(mapper.convertValue(postList.get(1), PostResponseDto.class));
        postResponseDtosExpected.add(mapper.convertValue(postList.get(0), PostResponseDto.class));
        postResponseDtosExpected.add(mapper.convertValue(postList.get(3), PostResponseDto.class));

        FollowedPostsDto expected = new FollowedPostsDto(1, postResponseDtosExpected);
        //ACT
        when(userRepository.userExists(userId)).thenReturn(true);
        when(userRepository.getUserById(userId)).thenReturn(client);
        when(postRepository.findAll()).thenReturn(postList);
        //ASSERT
        assertEquals(postService.getPost(userId), expected);
    }

    @Test
    void getPostByIdNotOkBadRequest() {
        //ARRANGE
        int userId = 1;
        String order = "date_asce";
        //ACT
        //ASSERT
        assertThrows(BadRequestException.class,()-> postService.getPost(userId, order));
    }

    @Test
    void getPostByIdNotOkNotFound(){
        //ARRANGE
        int userId = 1;
        String order = "date_asc";
        //ACT
        when(userRepository.userExists(userId)).thenReturn(false);
        //ASSERT
        NotFoundException exception = assertThrows(NotFoundException.class,()-> postService.getPost(userId, order));
        assertEquals(exception.getMessage(),"El usuario con id 1 no existe");
    }

    @Test

    void getPostByIdNotOkNotFoundSeller(){
        //ARRANGE
        int userId = 1;
        String order = "date_asc";
        Client client = new Client(1, "Quynn Nunez");
        //ACT
        when(userRepository.userExists(userId)).thenReturn(true);
        when(userRepository.getUserById(userId)).thenReturn(client);
        //ASSERT
        NotFoundException exception =  assertThrows(NotFoundException.class,()-> postService.getPost(userId, order));
        assertEquals(exception.getMessage(),"El usuario 1 no tiene vendedores seguidos");
    }

    @Test
    void getPostByIdNotOkNotFOundPosts(){
        //ARRANGE
        int userId = 1;
        String order = "date_asc";
        List<Product> productList = List.of(
                new Product(1, "Camisa", "Ropa", "Marca A", "Azul", "Algodón")
        );

        List<Seller> clients = List.of(
                new Seller(35, "Deacon Marquez")
        );

        Client client = new Client(1, "Quynn Nunez");
        client.setFollowed(clients);

        List<Post> postList = new ArrayList<>();
        postList.add(new Post(1, 29, 25, LocalDate.now().minusDays(3), productList.get(0), 78.0));

        //ACT
        when(userRepository.userExists(userId)).thenReturn(true);
        when(userRepository.getUserById(userId)).thenReturn(client);
        when(postRepository.findAll()).thenReturn(postList);
        //ACT
        NotFoundException exception =  assertThrows(NotFoundException.class,()-> postService.getPost(userId, order));
        assertEquals(exception.getMessage(),"No se encontraron post de los vendedores seguidos del usuario 1");
    }


}