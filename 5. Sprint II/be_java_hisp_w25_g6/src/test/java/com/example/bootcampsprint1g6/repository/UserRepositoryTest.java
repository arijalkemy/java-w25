package com.example.bootcampsprint1g6.repository;

import com.example.bootcampsprint1g6.dto.FollowedDTO;
import com.example.bootcampsprint1g6.dto.UserDTO;
import com.example.bootcampsprint1g6.entity.Buyer;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.entity.User;
import com.example.bootcampsprint1g6.repository.implementation.UserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Test
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
