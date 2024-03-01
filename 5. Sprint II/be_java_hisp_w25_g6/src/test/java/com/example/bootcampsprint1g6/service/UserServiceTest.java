package com.example.bootcampsprint1g6.service;

import com.example.bootcampsprint1g6.dto.*;
import com.example.bootcampsprint1g6.dto.GenericResponseDTO;

import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.entity.User;
import com.example.bootcampsprint1g6.exception.NotFoundException;
import com.example.bootcampsprint1g6.repository.implementation.UserRepositoryImpl;
import com.example.bootcampsprint1g6.service.implementation.UserServiceImpl;
import com.example.bootcampsprint1g6.exception.BadRequestException;
import com.example.bootcampsprint1g6.util.UserTestGenerator;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static com.example.bootcampsprint1g6.util.UserTestGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepositoryImpl userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void getFollowedListOrdAscTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "name_asc";
        FollowedDTO expectedFollowedList = new FollowedDTO(userId, "name", new ArrayList<>(List.of()));
        when(userRepository.findById(userId)).thenReturn(Optional.of(new Seller(userId, "name", "mail")));
        when(userRepository.getFollowedList(userId)).thenReturn(new ArrayList<>(List.of()));
        //Act
        FollowedDTO obtainedFollowedList = userService.getFollowedList(userId, order);

        //Assert
        assertEquals(expectedFollowedList, obtainedFollowedList);
    }

    @Test
    public void getFollowedListOrdAscIsSortedTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "name_asc";
        FollowedDTO expectedFollowedList = new FollowedDTO(userId, "name", new ArrayList<>(List.of(
                new UserDTO(2, "Alberto"),
                new UserDTO(3, "Benito"),
                new UserDTO(4, "Charly")
        )));

        when(userRepository.findById(userId)).thenReturn(Optional.of(new Seller(userId, "name", "mail")));
        when(userRepository.getFollowedList(userId)).thenReturn(new ArrayList<>(List.of(
                new Seller(4, "Charly", "mail@charly"),
                new Seller(2, "Alberto", "mail@alberto"),
                new Seller(3, "Benito", "mail@benito")
        )));
        //Act
        FollowedDTO obtainedFollowedList = userService.getFollowedList(userId, order);

        //Assert
        assertEquals(expectedFollowedList, obtainedFollowedList);
    }

    @Test
    public void getFollowedListDescAscTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "name_desc";
        FollowedDTO expectedFollowedList = new FollowedDTO(userId, "name", new ArrayList<>(List.of()));
        when(userRepository.findById(userId)).thenReturn(Optional.of(new Seller(userId, "name", "mail")));
        when(userRepository.getFollowedList(userId)).thenReturn(new ArrayList<>(List.of()));
        //Act
        FollowedDTO obtainedFollowedList = userService.getFollowedList(userId, order);

        //Assert
        assertEquals(expectedFollowedList, obtainedFollowedList);
    }

    @Test
    public void getFollowedListOrdDescIsSortedTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "name_desc";
        FollowedDTO expectedFollowedList = new FollowedDTO(userId, "name", new ArrayList<>(List.of(
                new UserDTO(4, "Charly"),
                new UserDTO(3, "Benito"),
                new UserDTO(2, "Alberto")
        )));

        when(userRepository.findById(userId)).thenReturn(Optional.of(new Seller(userId, "name", "mail")));
        when(userRepository.getFollowedList(userId)).thenReturn(new ArrayList<>(List.of(
                new Seller(4, "Charly", "mail@charly"),
                new Seller(2, "Alberto", "mail@alberto"),
                new Seller(3, "Benito", "mail@benito")
        )));
        //Act
        FollowedDTO obtainedFollowedList = userService.getFollowedList(userId, order);

        //Assert
        assertEquals(expectedFollowedList, obtainedFollowedList);
    }


    @Test
    public void getFollowersListOrdAscTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "name_asc";
        FollowersDTO expectedFollowersList = new FollowersDTO(userId, "name", new ArrayList<>(List.of()));
        when(userRepository.findById(userId)).thenReturn(Optional.of(new Seller(userId, "name", "mail")));
        when(userRepository.getFollowersList(userId)).thenReturn(new ArrayList<>(List.of()));
        //Act
        FollowersDTO obtainedFollowersList = userService.getFollowersList(userId, order);

        //Assert
        assertEquals(expectedFollowersList, obtainedFollowersList);
    }

    @Test
    public void getFollowersListOrdAscIsSortedTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "name_asc";
        FollowersDTO expectedFollowersList = new FollowersDTO(userId, "name", new ArrayList<>(List.of(
                new UserDTO(2, "Alberto"),
                new UserDTO(3, "Benito"),
                new UserDTO(4, "Charly")
        )));
        when(userRepository.findById(userId)).thenReturn(Optional.of(new Seller(userId, "name", "mail")));
        when(userRepository.getFollowersList(userId)).thenReturn(new ArrayList<>(List.of(
                new Seller(4, "Charly", "mail@charly"),
                new Seller(2, "Alberto", "mail@alberto"),
                new Seller(3, "Benito", "mail@benito")
        )));
        //Act
        FollowersDTO obtainedFollowersList = userService.getFollowersList(userId, order);

        //Assert
        assertEquals(expectedFollowersList, obtainedFollowersList);
    }

    @Test
    public void getFollowersListOrdDescTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "name_desc";
        FollowersDTO expectedFollowersList = new FollowersDTO(userId, "name", new ArrayList<>(List.of()));
        when(userRepository.findById(userId)).thenReturn(Optional.of(new Seller(userId, "name", "mail")));
        when(userRepository.getFollowersList(userId)).thenReturn(new ArrayList<>(List.of()));
        //Act
        FollowersDTO obtainedFollowersList = userService.getFollowersList(userId, order);

        //Assert
        assertEquals(expectedFollowersList, obtainedFollowersList);
    }

    @Test
    public void getFollowersListOrdDescIsSortedTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "name_desc";
        FollowersDTO expectedFollowersList = new FollowersDTO(userId, "name", new ArrayList<>(List.of(
                new UserDTO(4, "Charly"),
                new UserDTO(3, "Benito"),
                new UserDTO(2, "Alberto")
        )));
        when(userRepository.findById(userId)).thenReturn(Optional.of(new Seller(userId, "name", "mail")));
        when(userRepository.getFollowersList(userId)).thenReturn(new ArrayList<>(List.of(
                new Seller(4, "Charly", "mail@charly"),
                new Seller(2, "Alberto", "mail@alberto"),
                new Seller(3, "Benito", "mail@benito")
        )));
        //Act
        FollowersDTO obtainedFollowersList = userService.getFollowersList(userId, order);

        //Assert
        assertEquals(expectedFollowersList, obtainedFollowersList);
    }
    @Test
    public void getFollowedListOrdNotValidTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "name_inverted";
        when(userRepository.findById(userId)).thenReturn(Optional.of(new Seller(userId, "name", "mail")));
        when(userRepository.getFollowedList(userId)).thenReturn(new ArrayList<>(List.of()));
        //Act
        //Assert
        assertThrows(IllegalArgumentException.class , () -> { userService.getFollowedList(userId, order); }, "La variable 'order' enviada es inválida (name_inverted)" );
    }

    @Test
    public void getFollowersListOrdNotValidTestOk(){
        //Arrange
        Integer userId = 1;
        String order = "name_inverted";
        when(userRepository.findById(userId)).thenReturn(Optional.of(new Seller(userId, "name", "mail")));
        when(userRepository.getFollowedList(userId)).thenReturn(new ArrayList<>(List.of()));
        //Act
        //Assert
        assertThrows(IllegalArgumentException.class , () -> { userService.getFollowersList(userId, order); }, "La variable 'order' enviada es inválida (name_inverted)" );
    }

    @Test
    void getFollowersListTestThrowsExceptionBadRequest(){
        // arrange
        Integer userId = 1;
        String order = "name_asc";
        List<User> followersUsers = UserTestGenerator.getFollowersUser();
        User buyer = getBuyerWithId(1);

        when(userRepository.getFollowersList(userId)).thenReturn(followersUsers);
        when(userRepository.findById(userId)).thenReturn(Optional.of(buyer));

        //Act & Assert
        assertThrows(BadRequestException.class, () -> userService.getFollowersList(userId, order));
    }
    @Test
    public void followTestOk() {
        //Arrange
        int idUserWhoFollows = 1;
        int idUserToBeFollowed = 2;
        User userWhoFollows = getBuyerWithId(idUserWhoFollows);
        when(userRepository.findById(idUserWhoFollows)).thenReturn(Optional.of(userWhoFollows));
        User userToBeFollowed = getSellerWithId(idUserToBeFollowed);

        when(userRepository.findById(idUserToBeFollowed)).thenReturn(Optional.of(userToBeFollowed));
        GenericResponseDTO expectedResponse = new GenericResponseDTO(HttpStatus.OK.value(), "Ok");

        //Act
        GenericResponseDTO response = userService.follow(idUserWhoFollows, idUserToBeFollowed);

        //Assert
        assertThat(response.getStatus()).isEqualTo(expectedResponse.getStatus());
        assertThat(response.getMessage()).isEqualTo(expectedResponse.getMessage());
    }

    @Test
    public void followTestFollowingYourself() {
        //Arrange
        int idUserWhoFollows = 1;
        int idUserToBeFollowed = 1;
        User userWhoFollows = getBuyerWithId(idUserWhoFollows);
        when(userRepository.findById(idUserWhoFollows)).thenReturn(Optional.of(userWhoFollows));
        User userToBeFollowed = getBuyerWithId(idUserToBeFollowed);
        when(userRepository.findById(idUserToBeFollowed)).thenReturn(Optional.of(userToBeFollowed));

        //Act & Assert
        assertThrows(BadRequestException.class, () -> userService.follow(idUserWhoFollows, idUserToBeFollowed));
    }

    @Test
    public void followTestFollowingBuyerThrowsException() {
        //Arrange
        int idUserWhoFollows = 1;
        int idUserToBeFollowed = 2;
        User userWhoFollows = getBuyerWithId(idUserWhoFollows);
        when(userRepository.findById(idUserWhoFollows)).thenReturn(Optional.of(userWhoFollows));
        User userToBeFollowed = getBuyerWithId(idUserToBeFollowed);
        when(userRepository.findById(idUserToBeFollowed)).thenReturn(Optional.of(userToBeFollowed));

        //Act & Assert
        assertThrows(BadRequestException.class, () -> userService.follow(idUserWhoFollows, idUserToBeFollowed));
    }

    @Test
    public void followTestFollowingNotExistingUserThrowsException() {
        //Arrange
        int idUserWhoFollows = 1;
        int idUserToBeFollowed = 999;
        User userWhoFollows = getBuyerWithId(idUserWhoFollows);
        when(userRepository.findById(idUserWhoFollows)).thenReturn(Optional.of(userWhoFollows));
        when(userRepository.findById(idUserToBeFollowed)).thenReturn(Optional.empty());

        //Act & Assert
        assertThrows(NotFoundException.class, () -> userService.follow(idUserWhoFollows, idUserToBeFollowed));
    }

    @Test
    public void followTestFollowingAlreadyFollowedUserThrowsException() {
        //Arrange
        int idUserWhoFollows = 1;
        int idUserToBeFollowed = 2;
        User userWhoFollows = getBuyerWithId(idUserWhoFollows);
        when(userRepository.findById(idUserWhoFollows)).thenReturn(Optional.of(userWhoFollows));
        User userToBeFollowed = getSellerWithId(idUserToBeFollowed);
        when(userRepository.findById(idUserToBeFollowed)).thenReturn(Optional.of(userToBeFollowed));

        //Act
        userService.follow(idUserWhoFollows, idUserToBeFollowed);
        assertThrows(BadRequestException.class, () -> userService.follow(idUserWhoFollows, idUserToBeFollowed));
    }

    @Test
    @DisplayName("T-0002 Unfollow Test BAD Same User")
    public void unfollowTestWhenSameUser() {
        // Arrange
        Integer idUser = 1;

        // Act & Assert
        Exception exception = assertThrows(BadRequestException.class, () -> {
            userService.unfollow(idUser, idUser);
        });

        String expectedMessage = "El usuario no se puede dejar de seguir así mismo ID: " + idUser;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("T-0002 Unfollow Test BAD User Not Following")
    public void unfollowTestWhenUserNotFollowing() {
        // Arrange
        Integer idUserWhoUnfollows = 1;
        Integer idUserToBeUnfollowed = 2;

        User userWhoUnfollows = getBuyerWithId(idUserWhoUnfollows);
        User userToBeUnfollowed = getSellerWithId(idUserToBeUnfollowed);

        when(userRepository.findById(idUserWhoUnfollows)).thenReturn(Optional.of(userWhoUnfollows));
        when(userRepository.findById(idUserToBeUnfollowed)).thenReturn(Optional.of(userToBeUnfollowed));

        // Act & Assert

        Exception exception = assertThrows(BadRequestException.class, () -> {
            userService.unfollow(idUserWhoUnfollows, idUserToBeUnfollowed);
        });

        String expectedMessage = "El usuario no está siguiendo al usuario con ID: " + idUserToBeUnfollowed;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("T-0002 Unfollow Test OK")
    public void unfollowTestOk() {
        // Arrange
        int userId = 1;
        int userIdUnfollow = 2;
        User userWhoUnfollows = getBuyerFollowingSeller(userId, userIdUnfollow);
        User userToBeUnfollowed = getSellerFollowedByBuyer(userId, userIdUnfollow);

        when(userRepository.findById(userId)).thenReturn(Optional.of(userWhoUnfollows));
        when(userRepository.findById(userIdUnfollow)).thenReturn(Optional.of(userToBeUnfollowed));

        GenericResponseDTO expectedResponse = new GenericResponseDTO(HttpStatus.OK.value(), "Ok");

        // Act
        GenericResponseDTO actualResponse = userService.unfollow(userId, userIdUnfollow);

        // Assert
        assertThat(actualResponse.getStatus()).isEqualTo(expectedResponse.getStatus());
        assertThat(actualResponse.getMessage()).isEqualTo(expectedResponse.getMessage());
    }

    @Test
    @DisplayName("Get followers amount (Service) - Success")
    void getFollowersCountTestOk(){
        //arrange
        Integer id = 1;
        Seller seller = getSellerWithFollowers(id);
        when(userRepository.findById(id)).thenReturn(Optional.of(seller));
        FollowersCountDTO followers = new FollowersCountDTO(seller.getUserId(), seller.getUserName(), seller.getFollowers().size());

        //act
        FollowersCountDTO readFollowers = userService.getFollowersCount(id);

        //assert
        verify(userRepository, atLeast(1)).findById(id);
        assertEquals(followers, readFollowers);
    }
    @Test
    @DisplayName("Get followers amount (Service) - No followers")
    void getFollowersCountTestEmpty(){
        //arrange
        Integer id = 1;
        Seller seller = getSellerWithId(id);
        when(userRepository.findById(id)).thenReturn(Optional.of(seller));
        FollowersCountDTO followers = new FollowersCountDTO(seller.getUserId(), seller.getUserName(), seller.getFollowers().size());

        //act
        FollowersCountDTO readFollowers = userService.getFollowersCount(id);

        //assert
        verify(userRepository, atLeast(1)).findById(id);
        assertEquals(followers, readFollowers);
    }

    @Test
    @DisplayName("Get followers amount (Service) - Success")
    void getFollowersCountTestUserIsNotSellerThrowsException(){
        //Arrange
        Integer id = 1;
        User buyer = getBuyerWithId(id);
        when(userRepository.findById(id)).thenReturn(Optional.of(buyer));

        //Act && Assert
        assertThrows(BadRequestException.class, () -> userService.getFollowersCount(id));
    }

    @Test
    @DisplayName("Get followers amount (Service) - Success")
    void getFollowersCountTestNotExistingUserThrowsException(){
        //Arrange
        Integer id = 999;
        when(userRepository.findById(id)).thenReturn(Optional.empty());

        //Act && Assert
        assertThrows(NotFoundException.class, () -> userService.getFollowersCount(id));
    }

}
