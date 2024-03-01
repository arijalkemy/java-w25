package service;

import com.example.be_java_hisp_w25_g01.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01.dto.response.MessagesDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsListDTO;

import com.example.be_java_hisp_w25_g01.entity.Post;
import com.example.be_java_hisp_w25_g01.entity.Product;
import com.example.be_java_hisp_w25_g01.entity.User;
import com.example.be_java_hisp_w25_g01.exception.BadRequestException;
import com.example.be_java_hisp_w25_g01.exception.NotFoundException;

import com.example.be_java_hisp_w25_g01.entity.User;
import com.example.be_java_hisp_w25_g01.exception.BadRequestException;
import com.example.be_java_hisp_w25_g01.repository.IPostRepository;
import com.example.be_java_hisp_w25_g01.repository.IProductRepository;
import com.example.be_java_hisp_w25_g01.repository.IUserRepository;
import com.example.be_java_hisp_w25_g01.service.impl.PostServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import util.TestUtilGenerator;


import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static util.TestUtilGenerator.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceImpTest {
    @Mock
    IPostRepository postRepository;
    @Mock
    IUserRepository userRepository;
    @Mock
    IProductRepository productRepository;

    @InjectMocks
    PostServiceImpl postService;

    @DisplayName("UT5_getLastPostsFollowedByDateDescOkTest")
    @Test
    void getLastPostsFollowedByDateDescOkTest(){
        //Arrange
        String order = "date_desc";
        PostsListDTO expectedPosts = getPostListDTO();
        User user = getUser();

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));
        when(userRepository.findAllByIdIn(user.getFollowed())).thenReturn(getUserList());
        when(postRepository.findAllPostById(List.of())).thenReturn(getPostList());
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(getProduct()));

        //Act
        PostsListDTO currentPosts = postService.getLastPostsFollowedBy(user.getUserId(), order);

        //Assert
        Assertions.assertEquals(expectedPosts, currentPosts);
    }
    @DisplayName("UT5_getLastPostsFollowedByDateDescOkTest")
    @Test
    void getLastPostsFollowedByDateAscOkTest(){
        //Arrange
        String order = "date_asc";
        PostsListDTO expectedPosts = getPostListDTO();
        List<PostDTO> reversedPosts = new ArrayList<>(expectedPosts.getPostsList());
        Collections.reverse(reversedPosts);
        expectedPosts = new PostsListDTO(expectedPosts.getUser_id(), reversedPosts);
        User user = getUser();

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));
        when(userRepository.findAllByIdIn(user.getFollowed())).thenReturn(getUserList());
        when(postRepository.findAllPostById(List.of())).thenReturn(getPostList());
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(getProduct()));

        //Act
        PostsListDTO currentPosts = postService.getLastPostsFollowedBy(user.getUserId(), order);

        //Assert
        Assertions.assertEquals(expectedPosts, currentPosts);
    }

    @DisplayName("UT5_getLastPostsFollowedByBadRequestTest")
    @Test
    void getLastPostsFollowedByBadRequestTest(){
        //Arrange
        String order = "order_invalid";
        MessagesDTO messageExpected = new MessagesDTO("Bad order request.");
        User user = getUser();

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));
        when(userRepository.findAllByIdIn(user.getFollowed())).thenReturn(getUserList());
        when(postRepository.findAllPostById(List.of())).thenReturn(getPostList());
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(getProduct()));

        //Act
        BadRequestException currentThrown = Assertions.assertThrows(BadRequestException.class,() -> postService.getLastPostsFollowedBy(user.getUserId(), order));

        //Assert
        Assertions.assertEquals(messageExpected.getMessage(), currentThrown.getMessage());
    }

    @DisplayName("UT6_getLastPostsFollowedBy_orderNull_Ok")
    @Test
    void getLastPostsFollowedBy_orderNull_Ok(){
        //Arrange
        User user = getUser();
        user.setPosts(List.of(1, 2, 3));
        List<Post> expected = List.of(new Post(1, 2, LocalDate.now().minusDays(1), 1, 1, 0.0),
                new Post(3, 2, LocalDate.now().minusDays(3), 1, 1, 0.0),
                new Post(2, 2, LocalDate.now().minusDays(2), 1, 1, 0.0));
        List<Integer> expectedIntegers = List.of(1, 3, 2);

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(getUser()));
        when(userRepository.findAllByIdIn(any())).thenReturn(List.of(user));
        when(postRepository.findAllPostById(user.getPosts())).thenReturn(expected);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(
                new Product(1,"Silla Gamer", "Gamer", "Razer", "Red & Black", "Special Edition")
        ));

        //Act
        PostsListDTO postsListDTO = postService.getLastPostsFollowedBy(1,  null);
        List<Integer> actualIntegers = postsListDTO.getPostsList().stream().map(PostDTO::getPost_id).toList();

        //Assert
        assertEquals(expectedIntegers, actualIntegers);
    }

    @DisplayName("UT6_getLastPostsFollowedBy_orderDateAsc_Ok")
    @Test
    void getLastPostsFollowedBy_orderDateAsc_Ok(){
        //Arrange
        User user = getUser();
        user.setPosts(List.of(1, 2, 3));
        List<Post> expected = List.of(new Post(1, 2, LocalDate.now().minusDays(1), 1, 1, 0.0),
                new Post(3, 2, LocalDate.now().minusDays(3), 1, 1, 0.0),
                new Post(2, 2, LocalDate.now().minusDays(2), 1, 1, 0.0));
        List<Integer> expectedIntegers = List.of(3, 2, 1);

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(getUser()));
        when(userRepository.findAllByIdIn(any())).thenReturn(List.of(user));
        when(postRepository.findAllPostById(user.getPosts())).thenReturn(expected);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(
                new Product(1,"Silla Gamer", "Gamer", "Razer", "Red & Black", "Special Edition")
        ));
        //Act
        PostsListDTO postsListDTO = postService.getLastPostsFollowedBy(1,  "date_asc");
        List<Integer> actualIntegers = postsListDTO.getPostsList().stream().map(PostDTO::getPost_id).toList();

        //Assert
        assertEquals(expectedIntegers, actualIntegers);
    }

    @DisplayName("UT6_getLastPostsFollowedBy_orderDateDesc_Ok")
    @Test
    void getLastPostsFollowedBy_orderDateDesc_Ok(){
        //Arrange
        User user = getUser();
        user.setPosts(List.of(1, 2, 3));
        List<Post> expected = List.of(new Post(1, 2, LocalDate.now().minusDays(1), 1, 1, 0.0),
                new Post(3, 2, LocalDate.now().minusDays(3), 1, 1, 0.0),
                new Post(2, 2, LocalDate.now().minusDays(2), 1, 1, 0.0));
        List<Integer> expectedIntegers = List.of(1,2,3);

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(getUser()));
        when(userRepository.findAllByIdIn(any())).thenReturn(List.of(user));
        when(postRepository.findAllPostById(user.getPosts())).thenReturn(expected);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(
                new Product(1,"Silla Gamer", "Gamer", "Razer", "Red & Black", "Special Edition")
        ));
        //Act
        PostsListDTO postsListDTO = postService.getLastPostsFollowedBy(1,  "date_desc");
        List<Integer> actualIntegers = postsListDTO.getPostsList().stream().map(PostDTO::getPost_id).toList();

        //Assert
        assertEquals(expectedIntegers, actualIntegers);
    }


    @DisplayName("UT6_getLastPostsFollowedBy_userNotFound")
    @Test
    void getLastPostsFollowedBy_userNotFound(){
        //Arrange
        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());

        //Act & Assert
        assertThrows(NotFoundException.class, () -> postService.getLastPostsFollowedBy(1, "date_asc"));
    }

    @DisplayName("UT6_getLastPostsFollowedBy_orderDate_BadRequest")
    @Test
    void getLastPostsFollowedBy_orderDate_BadRequest(){
        //Arrange
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(getUser()));


        User user = getUser();
        user.setPosts(List.of(1, 2, 3));
        when(userRepository.findAllByIdIn(any())).thenReturn(List.of(user));

        List<Post> expected = List.of(new Post(1, 2, LocalDate.now().minusDays(1), 1, 1, 0.0),
                new Post(3, 2, LocalDate.now().minusDays(3), 1, 1, 0.0),
                new Post(2, 2, LocalDate.now().minusDays(2), 1, 1, 0.0));
        when(postRepository.findAllPostById(user.getPosts())).thenReturn(expected);

        when(productRepository.findById(anyInt())).thenReturn(Optional.of(
                new Product(1,"Silla Gamer", "Gamer", "Razer", "Red & Black", "Special Edition")
        ));

        //Act & Assert
        assertThrows(BadRequestException.class, () -> postService.getLastPostsFollowedBy(1,  "mal"));

    }

    @DisplayName("UT8_getLastPostFollowedByDateTwoWeeksTest")
    @Test
    void getLastPostFollowedByDateTwoWeeksTest(){
        //Arrange
        PostsListDTO expectedPosts = getPostListDTO();
        User user = getUser();
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));
        when(userRepository.findAllByIdIn(user.getFollowed())).thenReturn(getUserList());
        when(postRepository.findAllPostById(List.of())).thenReturn(getPostList());
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(getProduct()));

        //Act
        PostsListDTO currentPosts = postService.getLastPostsFollowedBy(user.getUserId(),null);
        List<LocalDate> fechas = currentPosts.getPostsList().stream()
                .map(PostDTO::getDate)
                .collect(Collectors.toList());

        //Assert
        Assertions.assertTrue(fechas.stream().allMatch(f -> f.isAfter(LocalDate.now().minusWeeks(2))));
    }
}
