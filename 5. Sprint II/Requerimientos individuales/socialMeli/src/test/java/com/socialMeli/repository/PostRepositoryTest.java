package com.socialMeli.repository;

import com.socialMeli.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PostRepositoryTest {

    IPostRepository postRepository = new PostRepository();

    @BeforeEach
    void setUp() {
        Period twoWeeksPeriod1W = Period.ofWeeks(1);
        Post post1 = new Post(1, LocalDate.now(),1,1,12.000,1);
        Post post2 = new Post(2, LocalDate.now().minus(twoWeeksPeriod1W),1,1,12.000,1);
        postRepository.add(post1);
        postRepository.add(post2);
    }
    @Test
    void add_new_product(){
        // Arrange
        Post post = new Post(3, LocalDate.now(),2,1,12.000,1);
        //Act
        Integer returnedValue = postRepository.add(post);
        //Assert
        assertEquals(3, returnedValue);
    }
    @Test
    void getPostFromTheLastTwoWeeksByUserId_Ok(){
        Optional<List<Post>> obtainedPosts = postRepository.getPostFromTheLastTwoWeeksByUserId(1);
        assertFalse(obtainedPosts.isEmpty());
    }
}
