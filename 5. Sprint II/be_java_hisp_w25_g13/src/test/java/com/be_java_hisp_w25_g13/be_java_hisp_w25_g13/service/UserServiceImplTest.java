package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.BadRequestException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.NotFoundException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.UserRepositoryImpl;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.PostRepositoryImpl;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Utilities;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.FollowedDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.FollowersDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.NumberDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

import static com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Utilities.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepositoryImpl userRepository;
    @Mock
    PostRepositoryImpl postRepository;
    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("T-01 followUser Ok")
    void followUserOk() {
        //ARRANGE
        Integer userId = 1;
        Integer userIdToFollow = 2;
        when(userRepository.getUserById(1)).thenReturn(Optional.of(Utilities.generateUser3Following(1,"juan")));
        when(userRepository.getUserById(2)).thenReturn(Optional.of(Utilities.generateSeller(2,"Ana", new ArrayList<>())));
        //ACT
        userService.followUser(userId,userIdToFollow);
        //ASSERT
        verify(userRepository, atLeast(2)).getUserById(anyInt());
    }
    @Test
    @DisplayName("T-01 followUser SellerNotFound")
    void followUserSellerNotFound(){
        Integer userId = 1;
        Integer userIdToFollow = 2;
        when(userRepository.getUserById(anyInt())).thenReturn(Optional.of(Utilities.generateUser(1,"juan")));
        when(userRepository.getUserById(anyInt())).thenReturn(Optional.ofNullable(null));

        assertThrows(NotFoundException.class, () -> userService.followUser(userId,userIdToFollow));
    }
    @Test
    @DisplayName("T-01 followingUser UserNotFound")
    void followingUserUserNotFound(){
        Integer userId = 1;
        Integer userIdToFollow = 2;
        when(userRepository.getUserById(anyInt())).thenReturn(Optional.ofNullable(null));
        assertThrows(NotFoundException.class, () -> userService.followUser(userId,userIdToFollow));
    }
    @Test
    @DisplayName("T-01 followingUser UserEqualsSeller")
    void followingUserUserEqualsSeller(){
        Integer id = 1;
        assertThrows(BadRequestException.class, () -> userService.followUser(id,id));
    }
    @Test
    @DisplayName("T-01 followingUser SellerIsNotSeller")
    void followingUserSellerIsNotSeller(){
        Integer userId = 1;
        Integer userIdToFollow = 2;

        when(userRepository.getUserById(anyInt())).thenReturn(Optional.of(Utilities.generateUser(1,"juan")));
        when(userRepository.getUserById(anyInt())).thenReturn(Optional.of(Utilities.generateUser(2,"Ana")));


        assertThrows(BadRequestException.class, () -> userService.followUser(userId,userIdToFollow));
    }
    @Test
    @DisplayName("T-01 followingUser SellerAlreadyFollow")
    void followingUserSellerAlreadyFollow() {
        Integer userId = 4;
        Integer userIdToFollow = 90;
        when(userRepository.getUserById(userId)).thenReturn(Optional.of(Utilities.generateUser3Following(4, "Daniela")));
        when(userRepository.getUserById(userIdToFollow)).thenReturn(Optional.of(Utilities.generateSeller(90, "Juan Manuel", Utilities.generateListUsers())));

        assertThrows(BadRequestException.class, () -> userService.followUser(userId, userIdToFollow));
    }
    @DisplayName("T-03 FollowersAsc")
    @Test
    void getFollowersOrderAscPresent() {
        //Arrange
        Seller seller = Utilities.generateSeller3Followed(1, "Pepe");
        String orderBy = "name_asc";
        when(userRepository.getUserById(1)).thenReturn(Optional.of(seller));
        //Act & Assert
        assertDoesNotThrow(() -> userService.getFollowers(1, orderBy));
        verify(userRepository, atLeastOnce()).getUserById(1);
    }
    @DisplayName("T-03 FollowersDesc")
    @Test
    void getFollowersOrderDescPresent() {
        //Arrange
        Seller seller = Utilities.generateSeller3Followed(1, "Pepe");
        String orderBy = "name_desc";
        when(userRepository.getUserById(1)).thenReturn(Optional.of(seller));
        //Act & Assert
        assertDoesNotThrow(() -> userService.getFollowers(1, orderBy));
        verify(userRepository, atLeastOnce()).getUserById(1);
    }
    @DisplayName("T-03 FollowersNoneOrder")
    @Test
    void getFollowersOrderAbsent() {
        //Arrange
        Seller seller = Utilities.generateSeller3Followed(1, "Pepe");
        String orderBy = "none";
        when(userRepository.getUserById(1)).thenReturn(Optional.of(seller));
        //Act & Assert
        assertDoesNotThrow(() -> userService.getFollowers(1, orderBy));
        verify(userRepository, atLeastOnce()).getUserById(1);
    }
    @DisplayName("T-03 FollowersInvalidOrder")
    @Test
    void getFollowersOrderInvalid() {
        //Arrange
        Seller seller = Utilities.generateSeller3Followed(1, "Pepe");
        String orderBy = "";
        when(userRepository.getUserById(1)).thenReturn(Optional.of(seller));
        //Act & Assert
        assertThrows(BadRequestException.class,() -> userService.getFollowers(1, orderBy));
    }
    @DisplayName("T-03 SellerNotFound")
    @Test
    void getFollowersSellerIdNotFound() {
        //Arrange
        Seller seller = Utilities.generateSeller3Followed(1, "Pepe");
        String orderBy = "none";
        when(userRepository.getUserById(1)).thenReturn(Optional.empty());

        //Act & Assert
        assertThrows(NotFoundException.class,() -> userService.getFollowers(1, orderBy));
    }
    @DisplayName("T-03 NotSellerId")
    @Test
    void getFollowersNotSellerId() {
        //Arrange
        User user = Utilities.generateUser(1,"Pepe");
        String orderBy = "none";
        when(userRepository.getUserById(1)).thenReturn(Optional.of(user));

        //Act & Assert
        assertThrows(BadRequestException.class,() -> userService.getFollowers(1, orderBy));
    }
    @DisplayName("T-03 SellerNoFollowers")
    @Test
    void getFollowersNoFollowers() {
        //Arrange
        Seller seller = Utilities.generateSeller(1, "Pepe", Collections.emptyList());
        String orderBy = "none";
        when(userRepository.getUserById(1)).thenReturn(Optional.of(seller));

        //Act & Assert
        assertThrows(NotFoundException.class,() -> userService.getFollowers(1, orderBy));
    }
    @DisplayName("T-03 FollowedAsc")
    @Test
    void getFollowedOrderAscPresent() {
        //Arrange
        User user = Utilities.generateUser3Following(1, "Pepe");
        String orderBy = "name_asc";
        when(userRepository.getUserById(1)).thenReturn(Optional.of(user));
        //Act & Assert
        assertDoesNotThrow(() -> userService.getFollowed(1, orderBy));
        verify(userRepository, atLeastOnce()).getUserById(1);
    }
    @DisplayName("T-03 FollowedDesc")
    @Test
    void getFollowedOrderDescPresent() {
        //Arrange
        User user = Utilities.generateUser3Following(1, "Pepe");
        String orderBy = "name_desc";
        when(userRepository.getUserById(1)).thenReturn(Optional.of(user));
        //Act & Assert
        assertDoesNotThrow(() -> userService.getFollowed(1, orderBy));
        verify(userRepository, atLeastOnce()).getUserById(1);
    }
    @DisplayName("T-03 FollowedNoneOrder")
    @Test
    void getFollowedOrderAbsent() {
        //Arrange
        User user = Utilities.generateUser3Following(1, "Pepe");
        String orderBy = "none";
        when(userRepository.getUserById(1)).thenReturn(Optional.of(user));
        //Act & Assert
        assertDoesNotThrow(() -> userService.getFollowed(1, orderBy));
        verify(userRepository, atLeastOnce()).getUserById(1);
    }
    @DisplayName("T-03 InvalidOrder")
    @Test
    void getFollowedOrderInvalid() {
        //Arrange
        User user = Utilities.generateUser3Following(1, "Pepe");
        String orderBy = "";
        when(userRepository.getUserById(1)).thenReturn(Optional.of(user));
        //Act & Assert
        assertThrows(BadRequestException.class,() -> userService.getFollowed(1, orderBy));
    }
    @DisplayName("T-03 UserNotFound")
    @Test
    void getFollowedUserIdNotFound() {
        //Arrange
        User user = Utilities.generateUser3Following(1, "Pepe");
        String orderBy = "none";
        when(userRepository.getUserById(1)).thenReturn(Optional.empty());

        //Act & Assert
        assertThrows(NotFoundException.class,() -> userService.getFollowed(1, orderBy));
    }
    @DisplayName("T-03 UserNotFollowed")
    @Test
    void getFollowedNoFollowed() {
        //Arrange
        User user = Utilities.generateUser(1, "Pepe");
        String orderBy = "none";
        when(userRepository.getUserById(1)).thenReturn(Optional.of(user));

        //Act & Assert
        assertThrows(NotFoundException.class,() -> userService.getFollowed(1, orderBy));
    }
    @DisplayName("T-04 FollowerListAscOk")
    @Test
    void getFollowersAsc(){
        //Arrange
        Seller seller = Utilities.generateSeller3Followed(1, "Pepe");
        String orderBy = "name_asc";
        FollowersDTO expectedFollowers = Utilities.generateFollowersDTOAsc(seller.getUserId(), seller.getUserName());
        when(userRepository.getUserById(seller.getUserId())).thenReturn(Optional.of(seller));
        //Act
        FollowersDTO followersDTO = userService.getFollowers(seller.getUserId(), orderBy);
        //Assert
        assertThat(followersDTO).usingRecursiveComparison().isEqualTo(expectedFollowers);
    }
    @DisplayName("T-04 FollowerListDescOk")
    @Test
    void getFollowersDesc(){
        //Arrange
        Seller seller = Utilities.generateSeller3Followed(1, "Pepe");
        String orderBy = "name_desc";
        FollowersDTO expectedFollowers = Utilities.generateFollowersDTODesc(seller.getUserId(), seller.getUserName());
        when(userRepository.getUserById(seller.getUserId())).thenReturn(Optional.of(seller));
        //Act
        FollowersDTO followersDTO = userService.getFollowers(seller.getUserId(), orderBy);
        //Assert
        assertThat(followersDTO).usingRecursiveComparison().isEqualTo(expectedFollowers);
    }
    @DisplayName("T-04 FollowerListNotOk")
    @Test
    void getFollowersNotOk(){
        //Arrange
        Seller seller = Utilities.generateSeller3Followed(1, "Pepe");
        String orderBy = "name_asc";
        FollowersDTO expectedFollowers = Utilities.generateFollowersDTODesc(seller.getUserId(), seller.getUserName());
        when(userRepository.getUserById(seller.getUserId())).thenReturn(Optional.of(seller));
        //Act
        FollowersDTO followersDTO = userService.getFollowers(seller.getUserId(), orderBy);
        //Assert
        assertThat(followersDTO).usingRecursiveComparison().isNotEqualTo(expectedFollowers);
    }
    @DisplayName("T-04 FollowedListAscOk")
    @Test
    void getFollowedAsc(){
        //Arrange
        User user = Utilities.generateUser3Following(1, "Pepe");
        String orderBy = "name_asc";
        FollowedDTO expectedFollowed = Utilities.generateFollowedDTOAsc(user.getUserId(), user.getUserName());
        when(userRepository.getUserById(user.getUserId())).thenReturn(Optional.of(user));
        //Act
        FollowedDTO followedDTO = userService.getFollowed(user.getUserId(), orderBy);
        //Assert
        assertThat(followedDTO).usingRecursiveComparison().isEqualTo(expectedFollowed);
    }
    @DisplayName("T-04 FollowedListDescOk")
    @Test
    void getFollowedDesc(){
        //Arrange
        User user = Utilities.generateUser3Following(1, "Pepe");
        String orderBy = "name_desc";
        FollowedDTO expectedFollowed = Utilities.generateFollowedDTODesc(user.getUserId(), user.getUserName());
        when(userRepository.getUserById(user.getUserId())).thenReturn(Optional.of(user));
        //Act
        FollowedDTO followedDTO = userService.getFollowed(user.getUserId(), orderBy);
        //Assert
        assertThat(followedDTO).usingRecursiveComparison().isEqualTo(expectedFollowed);
    }
    @DisplayName("T-04 FollowedListNotOk")
    @Test
    void getFollowedNotOk(){
        //Arrange
        User user = Utilities.generateUser3Following(1, "Pepe");
        String orderBy = "name_asc";
        FollowedDTO expectedFollowed = Utilities.generateFollowedDTODesc(user.getUserId(), user.getUserName());
        when(userRepository.getUserById(user.getUserId())).thenReturn(Optional.of(user));
        //Act
        FollowedDTO followedDTO = userService.getFollowed(user.getUserId(), orderBy);
        //Assert
        assertThat(followedDTO).usingRecursiveComparison().isNotEqualTo(expectedFollowed);
    }
    @Test
    @DisplayName("T-02 unfollowUser OK")
    void unFollowUserOK(){
        User userExpected = Utilities.generateUser3Following(4,"Daniela");
        Seller sellerExpected = Utilities.generateSeller(2,"Julian",Utilities.generateListUsers());
        userExpected.getFollowing().add(sellerExpected);
        userExpected.getFollowing().remove(sellerExpected);
        sellerExpected.getFollowers().remove(userExpected);
        Optional<User> mockUser = Optional.of(Utilities.generateUser3Following(4,"Daniela"));
        Optional<User> mockSeller = Optional.of(Utilities.generateSeller(2,"Julian",Utilities.generateListUsers()));
        when(userRepository.getUserById(4)).thenReturn(mockUser);
        when(userRepository.getUserById(2)).thenReturn(mockSeller);

        userService.unFollowUser(4,2);

        assertThat(mockUser.get()).usingRecursiveComparison().isEqualTo(userExpected);
        assertThat(mockSeller.get()).usingRecursiveComparison().isEqualTo(sellerExpected);
    }
    @Test
    @DisplayName("T-02 unfollowUser User not found")
    void unFollowUserNotFoundUser(){
        Optional<User> mockUser = Optional.empty();
        when(userRepository.getUserById(4)).thenReturn(mockUser);

        Assertions.assertThrows(NotFoundException.class, () -> userService.unFollowUser(4,2));
    }
    @Test
    @DisplayName("T-02 unfollowUser Seller not found")
    void unFollowUserNotFoundSeller(){
        Optional<User> mockUser = Optional.of(Utilities.generateUser(4,"Daniela"));
        Optional<User> mockSeller = Optional.empty();
        when(userRepository.getUserById(4)).thenReturn(mockUser);
        when(userRepository.getUserById(2)).thenReturn(mockSeller);

        Assertions.assertThrows(NotFoundException.class, () -> userService.unFollowUser(4,2));
    }
    @Test
    @DisplayName("T-02 unfollowUser User to unfollow is not a Seller")
    void unFollowUserNotSeller(){
        Optional<User> mockUser = Optional.of(Utilities.generateUser(4,"Daniela"));
        Optional<User> mockSellerNotSeller = Optional.of(Utilities.generateUser(2,"Julian"));
        when(userRepository.getUserById(4)).thenReturn(mockUser);
        when(userRepository.getUserById(2)).thenReturn(mockSellerNotSeller);

        Assertions.assertThrows(NotFoundException.class, () -> userService.unFollowUser(4,2));
    }
    @Test
    @DisplayName("T-02 unfollowUser Seller to unfollow is not followed by the user")
    void unFolloweUserNotFollowSeller(){
        Optional<User> mockUser = Optional.of(Utilities.generateUser(1,"Juan Manuel"));
        Optional<User> mockSeller = Optional.of(Utilities.generateSeller(2,"Julian",Utilities.generateListUsers()));
        when(userRepository.getUserById(1)).thenReturn(mockUser);
        when(userRepository.getUserById(2)).thenReturn(mockSeller);

        Assertions.assertThrows(BadRequestException.class, () -> userService.unFollowUser(1,2));
    }
    @Test
    @DisplayName("T-07 Get number of followers OK")
    void getNumberOfFollowersOkTest() {
        NumberDTO expectedNumberDTO = new NumberDTO(3, "Felipe", 3);

        when(userRepository.getUserById(anyInt())).thenReturn(Optional.of(generateSeller3Followed(3, "Felipe")));
        NumberDTO actualNumberDTO = userService.getNumberOfFollowers(3);
        assertThat(actualNumberDTO).usingRecursiveComparison().isEqualTo(expectedNumberDTO);
    }
    @Test
    @DisplayName("T-07 Get number of followers. Id not found")
    void getNumberOfFollowersNotFoundTest() {
        when(userRepository.getUserById(anyInt())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> userService.getNumberOfFollowers(3));
    }
    @Test
    @DisplayName("T-07 Get number of followers. Id is not a seller")
    void getNumberOfFollowersBadRequestTest() {
        when(userRepository.getUserById(anyInt())).thenReturn(Optional.of(generateUser(4, "Daniela")));
        assertThrows(BadRequestException.class, () -> userService.getNumberOfFollowers(4));
    }
    @Test
    @DisplayName("T-07 Get number of followers. Seller doesnt have followers")
    void getNumberOfFollowersNotFollowersTest() {
        when(userRepository.getUserById(anyInt())).thenReturn(Optional.of(generateSeller(3, "Felipe", List.of())));
        assertThrows(NotFoundException.class, () -> userService.getNumberOfFollowers(3));
    }
}