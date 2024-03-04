package com.bootcamp.be_java_hisp_w25_g02.repository;
import com.bootcamp.be_java_hisp_w25_g02.entity.Post;
import com.bootcamp.be_java_hisp_w25_g02.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostRepositoryImplTest {
    @Autowired
    IPostRepository postRepository;
    @BeforeEach @AfterEach
    public void setUp(){
        postRepository = new PostRepositoryImpl();
    }
    @Test
    @DisplayName("T-008 - the posts are from the last two weeks only - TestOK")
    void findByUserIdLastTwoWeeks(){
        //assert
        List<Post> postsOfTwoWeeksAndBeyond = TestUtilGenerator.getPostsOfLimitTwoWeeks();
        Integer userId =1;
        Post postOffourteenDaysAgo = postsOfTwoWeeksAndBeyond.get(0);
        Post postOfThirteendaysAgo = postsOfTwoWeeksAndBeyond.get(1);
        Post postOfFifteenDaysAgo = postsOfTwoWeeksAndBeyond.get(2);
        postOffourteenDaysAgo.setPostId(postRepository.savePost(postOffourteenDaysAgo));
        postRepository.savePost(postOfThirteendaysAgo);
        postRepository.savePost(postOfFifteenDaysAgo);
        //act
        List<Post> posts = postRepository.findByUserId(userId);
        //assert
        assertTrue(CollectionUtils.containsInstance( posts, postOffourteenDaysAgo));
        assertTrue(CollectionUtils.containsInstance( posts, postOfThirteendaysAgo));
        assertFalse(CollectionUtils.containsInstance( posts, postOfFifteenDaysAgo));
    }

}