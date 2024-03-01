package com.example.bootcampsprint1g6.repository;

import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.entity.User;
import com.example.bootcampsprint1g6.repository.implementation.UserRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Test
    @DisplayName("T0000 - (Repository) - Find By ID Test Success")
    public void findByIdTestOk() {
        //Arrange
        Integer userId = 1;

        //Act
        Optional<User> user = userRepository.findById(userId);

        //Assert
        assertThat(user).isPresent();
        assertThat(user.get().getUserId()).isEqualTo(userId);
    }

    @Test
    @DisplayName("T0000 - (Repository) - Get followed list")
    void getFollowedListTestOk (){
        // arrange
        Integer userId = 4;

        // act
        List<Seller> followedList = userRepository.getFollowedList(userId);
        List<User> voidList = new ArrayList<>();

        // assert
        assertNotEquals(followedList, voidList);
    }

    @Test
    @DisplayName("T0000 - (Repository) - List followers users OK")
    void getFollowerListTestOk (){
        // arrange
        Integer userId = 1;

        // act
        List<User> followersList = userRepository.getFollowersList(userId);
        List<User> voidList = new ArrayList<>();

        // assert
        assertNotEquals(followersList, voidList);
    }

}
