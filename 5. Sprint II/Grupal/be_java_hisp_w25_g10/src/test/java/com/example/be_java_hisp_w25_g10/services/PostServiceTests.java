package com.example.be_java_hisp_w25_g10.services;

import com.example.be_java_hisp_w25_g10.dtos.PostDto;
import com.example.be_java_hisp_w25_g10.dtos.PostsDto;
import com.example.be_java_hisp_w25_g10.dtos.ProductDto;
import com.example.be_java_hisp_w25_g10.entities.Post;
import com.example.be_java_hisp_w25_g10.entities.Product;
import com.example.be_java_hisp_w25_g10.entities.RolEnum;
import com.example.be_java_hisp_w25_g10.entities.User;
import com.example.be_java_hisp_w25_g10.exceptions.BadRequestException;
import com.example.be_java_hisp_w25_g10.exceptions.NotFoundException;
import com.example.be_java_hisp_w25_g10.repositories.IRepository;
import com.example.be_java_hisp_w25_g10.services.posts.PostService;
import com.example.be_java_hisp_w25_g10.utils.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostServiceTests {

    @Mock
    IRepository repository;

    @InjectMocks
    PostService service;

    @Test
    public void getPostsFollowedTest() {
        //Arrange
        LocalDate dateTest = LocalDate.now().minusDays(20);
        when(repository.getFollowedPosts(2)).thenReturn(Builder.postsExpected);

        //Act
        PostsDto postsDto = service.getPostsFollowed(2,"date_desc");

        //Assert
        Assertions.assertTrue(postsDto.posts().get(0).date().isAfter(dateTest));
    }

    @Test
    public void getCountPostsFollowed(){
        //Arrange
        when(repository.getFollowedPosts(2)).thenReturn(Builder.postsExpected);

        //Act
        PostsDto postsDto = service.getPostsFollowed(2,"date_desc");

        //Assert
        Assertions.assertEquals(2, postsDto.posts().size());
    }

    @Test
    public void getPostFollowedUnsuccessful(){
        //Arrange
        List<Post> posts = new ArrayList<>();
        when(repository.getFollowedPosts(2)).thenReturn(posts);

        //Act & Assert
        Assertions.assertThrows(NotFoundException.class, () -> service.getPostsFollowed(1,"date_desc"));
    }
    @Test
    public void VerifyListPostDesc(){

        //Arrage
        PostsDto expected = Builder.orderedListPostDesc();
        List<Post> posts = Builder.postNotInOrder();

        int userId = 3;
        String sortOrder = "date_desc";

        //act
        when(repository.getFollowedPosts(userId)).thenReturn(posts);
        PostsDto actual = service.getPostsFollowed(userId, sortOrder);

        //assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void VerifyListPostAsc(){

        //Arrage
        PostsDto expected = Builder.orderedListPostAsc();
        List<Post> posts = Builder.postNotInOrder();

        int userId = 3;
        String sortOrder = "date_asc";

        //act
        when(repository.getFollowedPosts(userId)).thenReturn(posts);
        PostsDto actual = service.getPostsFollowed(userId, sortOrder);

        //assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAscSortExist() {

        String sortOrder = "date_asc";
        List<Post> samplePosts = Builder.testSortExistBuilder();

        when(repository.getFollowedPosts(1)).thenReturn(samplePosts);

        PostsDto result = service.getPostsFollowed(1, sortOrder);

        assertNotNull(result);

    }

    @Test
    public void testDescSortExist() {

        String sortOrder = "date_desc";
        List<Post> samplePosts = Builder.testSortExistBuilder();

        when(repository.getFollowedPosts(1)).thenReturn(samplePosts);

        PostsDto result = service.getPostsFollowed(1, sortOrder);

        assertNotNull(result);

    }

    @Test
    public void testInvalidSortOrder(){
        String sortOrder = "imvalid";
        List<Post> samplePosts = Builder.testSortExistBuilder();

        when(repository.getFollowedPosts(1)).thenReturn(samplePosts);

        assertThrows(BadRequestException.class , () -> service.getPostsFollowed(1, sortOrder));
    }
}
