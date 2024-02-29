package com.mercadolibre.be_java_hisp_w25_g15.repository.impl;

import com.mercadolibre.be_java_hisp_w25_g15.model.Buyer;
import com.mercadolibre.be_java_hisp_w25_g15.model.Seller;
import com.mercadolibre.be_java_hisp_w25_g15.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRepository = new UserRepository();

    @BeforeEach
    void setUp() {
    }


    @Test
    void getUserById() {
        // Arrange
        Optional<User> expected = Optional.of(Seller.builder().id(1).username("Tony Stark").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        // Act
        Optional<User> actual = userRepository.getUserById(1);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("JUnit Test for get all users")
    void getAllUsers() {
        // arrange
        List<User> expectedUsers = List.of(
                Seller.builder().id(1).username("Tony Stark").followed(new ArrayList<>()).followers(new ArrayList<>()).build(),
                Seller.builder().id(2).username("Luca").followed(new ArrayList<>()).followers(new ArrayList<>()).build(),
                Seller.builder().id(3).username("Martin").followed(new ArrayList<>()).followers(new ArrayList<>()).build(),
                Buyer.builder().id(4).username("Santiago").followed(new ArrayList<>(
                )).build(),
                Buyer.builder().id(5).username("Orlando").followed(new ArrayList<>()).build(),
                Buyer.builder().id(6).username("Miguel").followed(new ArrayList<>()).build(),
                Buyer.builder().id(7).username("Samuel").followed(new ArrayList<>()).build(),
                Buyer.builder().id(8).username("Tony Stark").followed(new ArrayList<>()).build()
        );

        // act
        List<User> result = userRepository.getAllUsers();

        // assert
        assertEquals(expectedUsers, result);
    }

    @Test
    void removeFollower() {
        //Arrange
        Seller seller = Seller.builder().id(1).username("Tony Stark").followed(new ArrayList<>()).followers(new ArrayList<>()).build();
        User user = Buyer.builder().id(4).username("Santiago").followed(new ArrayList<>(
        )).build();
        //Act
        boolean result = userRepository.removeFollower(seller, user);
        //Assert
        assertTrue(result);
        assertFalse(seller.getFollowers().contains(user));
    }

    @Test
    void removeFollowed() {
        //Arrange
        User user = Buyer.builder().id(4).username("Santiago").followed(new ArrayList<>(
        )).build();
        Seller seller = Seller.builder().id(1).username("Tony Stark").followed(new ArrayList<>()).followers(new ArrayList<>()).build();
        //Act
        boolean result = userRepository.removeFollowed(user, seller);
        //Assert
        assertTrue(result);
        assertFalse(user.getFollowed().contains(seller));
    }

    @Test
    void addFollower() {
        //Arrange
        Seller seller = Seller.builder().id(1).username("Tony Stark").followed(new ArrayList<>()).followers(new ArrayList<>()).build();
        User user = Buyer.builder().id(4).username("Santiago").followed(new ArrayList<>(
        )).build();
        //Act
        boolean result = userRepository.addFollower(seller, user);
        //Assert
        assertTrue(result);
        assertTrue(seller.getFollowers().contains(user));
    }

    @Test
    void addFollowed() {
//Arrange
        User user = Buyer.builder().id(4).username("Santiago").followed(new ArrayList<>(
        )).build();
        Seller seller = Seller.builder().id(1).username("Tony Stark").followed(new ArrayList<>()).followers(new ArrayList<>()).build();
        //Act
        boolean result = userRepository.addFollowed(user, seller);
        //Assert
        assertTrue(result);
        assertTrue(user.getFollowed().contains(seller));
    }
}