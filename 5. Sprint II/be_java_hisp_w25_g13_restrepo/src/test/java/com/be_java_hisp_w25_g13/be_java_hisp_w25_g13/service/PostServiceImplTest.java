package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.SellerPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.AlreadyExistException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.BadRequestException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.NotFoundException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IPostRepository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IUserRepository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Mapper;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Utilities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {
    @Mock
    IUserRepository userRepository;
    @Mock
    IPostRepository postRepository;
    @Mock
    ProductServiceImpl productService;
    @InjectMocks
    PostServiceImpl postService;

    @Test
    @DisplayName("T-08 getUserPostPerSeller OK")
    void getUserPostPerSellerTestOK(){
        Seller seller1 = new Seller(2,"Julian",Utilities.generateListUsers());
        LocalDate hourNow = LocalDate.now();
        List<Post> listPostSeller = Arrays.asList(new Post(2, hourNow.minusDays(1), Utilities.generateProduct(1, "Sushi"), 6, 15000.0),
                new Post(2, hourNow.minusWeeks(1), Utilities.generateProduct(2, "Torta"), 7, 25000.0),
                new Post(2, hourNow.minusWeeks(2), Utilities.generateProduct(1, "Arepa"), 2, 9000.0),
                new Post(2, hourNow.minusWeeks(3), Utilities.generateProduct(2, "Pan"), 3, 8000.0));
        for (Post post : listPostSeller) {
            postRepository.addPost(post);
        }
        User user1 = new User(5,"Sebastian",List.of(seller1));
        //Expected
        List<Post> listPostSellerExpected = Arrays.asList(new Post(2, hourNow.minusDays(1), Utilities.generateProduct(1, "Sushi"), 6, 15000.0),
                new Post(2, hourNow.minusWeeks(1), Utilities.generateProduct(2, "Torta"), 7, 25000.0),
                new Post(2, hourNow.minusWeeks(2), Utilities.generateProduct(1, "Arepa"), 2, 9000.0));
        SellerPostDTO sellerPostDTOExpected = new SellerPostDTO(user1.getUserId(),
                postService.orderPostList(listPostSellerExpected, "date_asc").stream().map(Mapper::mapPostToPost2DTO).toList());

        lenient().when(userRepository.getUserById(5)).thenReturn(Optional.of(user1));
        lenient().when(postRepository.filterByUserIdAndBetweenDate(2, hourNow.minusDays(14),hourNow)).thenReturn(listPostSellerExpected);

        List<Post> listPostSellerActual= postRepository.filterByUserIdAndBetweenDate(2, hourNow.minusDays(14),hourNow);
        SellerPostDTO sellerPostDTOActual = postService.getPostPerSeller(user1.getUserId(), "date_asc");


        assertThat(listPostSellerExpected).isEqualTo(listPostSellerActual);
        assertThat(sellerPostDTOExpected).isEqualTo(sellerPostDTOActual);
    }
    @Test
    @DisplayName("T-08 getUserPostPerSeller NoTFoundException")
    void getUserPostPerSellerTestNoTFoundException(){
        Seller seller1 = new Seller(2,"Julian",Utilities.generateListUsers());
        LocalDate hourNow = LocalDate.now();
        User user1 = new User(5,"Sebastian",List.of(seller1));

        lenient().when(userRepository.getUserById(5)).thenReturn(Optional.of(user1));
        lenient().when(postRepository.filterByUserIdAndBetweenDate(2, hourNow.minusDays(14),hourNow)).thenReturn(List.of());

        assertThrows(NotFoundException.class,()->postService.getPostPerSeller(user1.getUserId(), "date_asc"));
    }
    @Test
    @DisplayName("T-06 verify postListDescOrder")
    void postListOrderDateDesc() {
        LocalDate hourNow = LocalDate.now();
        User mockUser = Utilities.generateUser(1, "Juan Manuel");
        mockUser.setFollowing(List.of(new Seller(2,"Julian",Collections.emptyList())));
        List<Post> postListExpected = Arrays.asList(
                new Post(2, hourNow.minusDays(1), Utilities.generateProduct(1, "Sushi"), 6, 15000.0),
                new Post(2, hourNow.minusWeeks(2), Utilities.generateProduct(2, "Torta"), 7, 25000.0),
                new Post(2, hourNow.minusWeeks(3), Utilities.generateProduct(1, "Arepa"), 2, 9000.0),
                new Post(2, hourNow.minusWeeks(4), Utilities.generateProduct(2, "Pan"), 3, 8000.0));
        SellerPostDTO sellerPostDTOExpected = new SellerPostDTO(1,postListExpected.stream().map(Mapper::mapPostToPost2DTO).toList());
        List<Post> mockPostList = Arrays.asList(
                new Post(2, hourNow.minusWeeks(4), Utilities.generateProduct(2, "Pan"), 3, 8000.0),
                new Post(2, hourNow.minusWeeks(3), Utilities.generateProduct(1, "Arepa"), 2, 9000.0),
                new Post(2, hourNow.minusWeeks(2), Utilities.generateProduct(2, "Torta"), 7, 25000.0),
                new Post(2, hourNow.minusDays(1), Utilities.generateProduct(1, "Sushi"), 6, 15000.0));
        lenient().when(userRepository.getUserById(1)).thenReturn(Optional.of(Utilities.generateUser3Following(1,"Juan Manuel")));
        lenient().when(postRepository.filterByUserIdAndBetweenDate(2,hourNow.minusDays(14),hourNow)).thenReturn(mockPostList);

        SellerPostDTO sellerPostDTOObtained = postService.getPostPerSeller(1,"date_desc");

        assertThat(sellerPostDTOObtained).usingRecursiveComparison().isEqualTo(sellerPostDTOExpected);
    }
    @Test
    @DisplayName("T-06 verify postListAscOrder")
    void postListOrderDateAsc() {
        LocalDate hourNow = LocalDate.now();
        User mockUser = Utilities.generateUser(1, "Juan Manuel");
        mockUser.setFollowing(List.of(new Seller(2, "Julian", Collections.emptyList())));
        List<Post> postListExpected = Arrays.asList(
                new Post(2, hourNow.minusWeeks(4), Utilities.generateProduct(2, "Pan"), 3, 8000.0),
                new Post(2, hourNow.minusWeeks(3), Utilities.generateProduct(1, "Arepa"), 2, 9000.0),
                new Post(2, hourNow.minusWeeks(2), Utilities.generateProduct(2, "Torta"), 7, 25000.0),
                new Post(2, hourNow.minusDays(1), Utilities.generateProduct(1, "Sushi"), 6, 15000.0));
        SellerPostDTO sellerPostDTOExpected = new SellerPostDTO(1, postListExpected.stream().map(Mapper::mapPostToPost2DTO).toList());
        List<Post> mockPostList = Arrays.asList(
                new Post(2, hourNow.minusWeeks(4), Utilities.generateProduct(2, "Pan"), 3, 8000.0),
                new Post(2, hourNow.minusWeeks(3), Utilities.generateProduct(1, "Arepa"), 2, 9000.0),
                new Post(2, hourNow.minusWeeks(2), Utilities.generateProduct(2, "Torta"), 7, 25000.0),
                new Post(2, hourNow.minusDays(1), Utilities.generateProduct(1, "Sushi"), 6, 15000.0));
        lenient().when(userRepository.getUserById(1)).thenReturn(Optional.of(Utilities.generateUser3Following(1, "Juan Manuel")));
        lenient().when(postRepository.filterByUserIdAndBetweenDate(2, hourNow.minusDays(14), hourNow)).thenReturn(mockPostList);

        SellerPostDTO sellerPostDTOObtained = postService.getPostPerSeller(1, "date_asc");

        assertThat(sellerPostDTOObtained).usingRecursiveComparison().isEqualTo(sellerPostDTOExpected);
    }
    @DisplayName("T-05 NotPostProducts")
    @Test
    void getProductsSellerDontHavePosts(){
        // Arrange
        User user=Utilities.generateUser3Following(1, "Manuel");
        LocalDate hourNow = LocalDate.now();
        String orderBy="date_asc";

        when(userRepository.getUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(postRepository.filterByUserIdAndBetweenDate(user.getUserId(), hourNow.minusDays(14), hourNow)).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(NotFoundException.class, ()->postService.getPostPerSeller(user.getUserId(), orderBy));
        verify(userRepository, atLeastOnce()).getUserById(user.getUserId());
        verify(postRepository, atLeastOnce()).filterByUserIdAndBetweenDate(user.getUserId(), hourNow.minusDays(14), hourNow);
    }
    @DisplayName("T-05 PostProductsOrderByDateAsc")
    @Test
    void getProductsSellerDateAscOK(){
        // Arrange
        User user=Utilities.generateUser3Following(1, "Manuel");
        LocalDate hourNow=LocalDate.now();
        List<Post> postsSeller=Utilities.generateListPost();
        String orderBy="date_asc";

        when(userRepository.getUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(postRepository.filterByUserIdAndBetweenDate(user.getUserId(), hourNow.minusDays(14), hourNow)).thenReturn(postsSeller);

        // Act & Assert
        assertDoesNotThrow(()->postService.getPostPerSeller(user.getUserId(), orderBy));
        verify(userRepository, atLeastOnce()).getUserById(user.getUserId());
        verify(postRepository, atLeastOnce()).filterByUserIdAndBetweenDate(user.getUserId(), hourNow.minusDays(14), hourNow);
    }
    @Test
    @DisplayName("getPost Ok")
    void getPostsOk(){
        //Arrange
        Integer id = 1;
        //Act
        Object object = postService.getPosts(1);

        //Assert
        assertNull(object);
    }
    @Test
    @DisplayName("addPost Ok")
    void addPostOk(){
        //Arrange
        Seller seller = Utilities.generateSeller(1, "pepe", Collections.emptyList());
        Post post = Utilities.generatePost(1, 1, LocalDate.parse("2024-02-20"), 1, "Arepa");
        PostDTO expectedPostDto = Utilities.generatePostDto(1, 1, LocalDate.parse("2024-02-20"), 1, "Arepa");

        when(userRepository.getUserById(seller.getUserId())).thenReturn(Optional.of(seller));
        when(postRepository.addPost(post)).thenReturn(post);
        when(productService.getProductById(post.getProduct().getProductId())).thenReturn(Optional.empty());

        //Act
        PostDTO postDto = postService.addPost(expectedPostDto);

        //Assert
        assertThat(expectedPostDto).usingRecursiveComparison().isEqualTo(postDto);
    }
    @Test
    @DisplayName("addPost NotSeller")
    void addPostNotSeller(){
        //Arrange
        User user = Utilities.generateUser(1, "pepe");
        Post post = Utilities.generatePost(1, 1, LocalDate.parse("2024-02-20"), 1, "Arepa");
        PostDTO expectedPostDto = Utilities.generatePostDto(1, 1, LocalDate.parse("2024-02-20"), 1, "Arepa");

        when(userRepository.getUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(productService.getProductById(post.getProduct().getProductId())).thenReturn(Optional.empty());

        //Act & Assert
        assertThrows(BadRequestException.class, ()->postService.addPost(expectedPostDto));
    }
    @Test
    @DisplayName("addPost UserNotFound")
    void addPostNotFoundUser(){
        //Arrange
        User user = Utilities.generateUser(1, "pepe");
        Post post = Utilities.generatePost(1, 1, LocalDate.parse("2024-02-20"), 1, "Arepa");
        PostDTO expectedPostDto = Utilities.generatePostDto(1, 1, LocalDate.parse("2024-02-20"), 1, "Arepa");

        when(userRepository.getUserById(user.getUserId())).thenReturn(Optional.empty());
        when(productService.getProductById(post.getProduct().getProductId())).thenReturn(Optional.empty());

        //Act & Assert
        assertThrows(NotFoundException.class, ()->postService.addPost(expectedPostDto));
    }
    @Test
    @DisplayName("addPost ProductAlreadyPresent")
    void addPostProductAlreadyPresent(){
        //Arrange
        Seller seller = Utilities.generateSeller(1, "pepe", Collections.emptyList());
        Post post = Utilities.generatePost(1, 1, LocalDate.parse("2024-02-20"), 1, "Arepa");
        Product alreadyPrensentProduct = Utilities.generateProduct(1, "Arepa");
        PostDTO expectedPostDto = Utilities.generatePostDto(1, 1, LocalDate.parse("2024-02-20"), 1, "Arepa");

        when(userRepository.getUserById(seller.getUserId())).thenReturn(Optional.of(seller));
        when(productService.getProductById(post.getProduct().getProductId())).thenReturn(Optional.of(alreadyPrensentProduct));

        //Act & Assert
        assertThrows(AlreadyExistException.class, ()->postService.addPost(expectedPostDto));
    }
    @DisplayName("T-05 PostProductsOrderByDateDesc")
    @Test
    void getProductsSellerDateDescOK(){
        // Arrange
        User user=Utilities.generateUser3Following(1, "Manuel");
        List<Post> postsSeller=Utilities.generateListPost();
        LocalDate hourNow=LocalDate.now();
        String orderBy="date_desc";

        when(userRepository.getUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(postRepository.filterByUserIdAndBetweenDate(user.getUserId(), hourNow.minusDays(14), hourNow)).thenReturn(postsSeller);

        // Act & Assert
        assertDoesNotThrow(()->postService.getPostPerSeller(user.getUserId(), orderBy));
        verify(userRepository, atLeastOnce()).getUserById(user.getUserId());
        verify(postRepository, atLeastOnce()).filterByUserIdAndBetweenDate(user.getUserId(), hourNow.minusDays(14), hourNow);
    }
    @DisplayName("T-05 PostProductsOrderByDefault")
    @Test
    void getProductsSellerDateNoneOK(){
        // Arrange
        User user=Utilities.generateUser3Following(1, "Manuel");
        List<Post> postsSeller=Utilities.generateListPost();
        LocalDate hourNow=LocalDate.now();
        String orderBy="none";

        when(userRepository.getUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(postRepository.filterByUserIdAndBetweenDate(user.getUserId(), hourNow.minusDays(14), hourNow)).thenReturn(postsSeller);

        // Act & Assert
        assertDoesNotThrow(()->postService.getPostPerSeller(user.getUserId(), orderBy));
        verify(userRepository, atLeastOnce()).getUserById(user.getUserId());
        verify(postRepository, atLeastOnce()).filterByUserIdAndBetweenDate(user.getUserId(), hourNow.minusDays(14), hourNow);
    }
    @DisplayName("T-05 PostProductsOrderByInvalidValue")
    @Test
    void getProductsSellerDateDontOK(){
        // Arrange
        User user=Utilities.generateUser3Following(1, "Manuel");
        List<Post> postsSeller=Utilities.generateListPost();
        LocalDate hourNow=LocalDate.now();
        String orderBy="";

        when(userRepository.getUserById(user.getUserId())).thenReturn(Optional.of(user));
        when(postRepository.filterByUserIdAndBetweenDate(user.getUserId(), hourNow.minusDays(14), hourNow)).thenReturn(postsSeller);

        // Act & Assert
        assertThrows(BadRequestException.class, ()->postService.getPostPerSeller(user.getUserId(), orderBy));
        verify(userRepository, atLeastOnce()).getUserById(user.getUserId());
        verify(postRepository, atLeastOnce()).filterByUserIdAndBetweenDate(user.getUserId(), hourNow.minusDays(14), hourNow);
    }
    @DisplayName("T-05 UserDontExist")
    @Test
    void getProductsSellerByUserIdNotFound(){
        // Arrange
        User user=Utilities.generateUser(1, "Manuel");
        String orderBy="";

        when(userRepository.getUserById(user.getUserId())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, ()-> postService.getPostPerSeller(user.getUserId(), orderBy));
        verify(userRepository, atLeastOnce()).getUserById(user.getUserId());
    }
}