package com.example.bootcampsprint1g6.repository;

import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.User;
import com.example.bootcampsprint1g6.repository.implementation.PostRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepositoryImpl postRepository;

    @Test
    void getFollowedListTestOk (){
        // arrange
        Integer userId = 1;

        // act
        Post post = postRepository.findById(userId);

        // assert
        assertNull(post);
    }
}
