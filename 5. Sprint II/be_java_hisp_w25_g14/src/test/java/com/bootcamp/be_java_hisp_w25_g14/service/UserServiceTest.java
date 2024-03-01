package com.bootcamp.be_java_hisp_w25_g14.service;

import com.bootcamp.be_java_hisp_w25_g14.dto.FollowedListResponseDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserDataDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.InvalidRequestException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.repository.IUserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepo userRepo;
    @InjectMocks
    private UserServiceImp userServiceImp;

    /**
     *
     * T0001
     *
     */
    @Test
    @DisplayName("T0001 - Caso Feliz FollowUser")
    void t0001followOkTest(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=3;

        //Act
        userServiceImp.addFollowe(userId,userIdToFollow);
        verify(userRepo, atLeast(1)).addFollower(userId,userIdToFollow);
    }

    /**
     *
     * T0002
     *
     */

    @Test
    @DisplayName("T0002 - Caso Feliz UnfollowUser")
    void t0002unfollowOkTest(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=1;

        //Act
        userServiceImp.removeFollow(userId,userIdToFollow);
        verify(userRepo, atLeast(1)).removeFollow(userId,userIdToFollow);
    }

    /**
     *
     * T0003
     *
     */
    @Test
    @DisplayName("T0003 - Ascending Validate order")
    void validateAscOrderTest(){
        //Arrange
        int id = 1;
        String order = "name_as";
        //Act & Assert
        assertThrows(InvalidRequestException.class, ()->{
            this.userServiceImp.listSellersFollowers(id,order);
        });

    }

    @Test
    @DisplayName("T0003 - Descending Validate order")
    void validateDescOrderTest(){
        //Arrange
        int id = 1;
        String order = "name_des";
        //Act & Assert
        assertThrows(InvalidRequestException.class, ()->{
            this.userServiceImp.listSellersFollowers(id,order);
        });

    }

    /*

        T0004

     */
    @Test
    @DisplayName("T0004 - List Sellers Followers")
    void listSellersFollowersTest(){
        //Arrange
        int id=1;
        String order="name_desc";
        Optional<User> user = Optional.of(new User(1, "edgar", true, List.of(2, 3), List.of(2, 4)));
        List<User> listUsersDesc = List.of(
                new User(4,"rosa",false,List.of(1,3),List.of()),
                new User(2,"jacob",true,List.of(1),List.of(1,5)));

        FollowedListResponseDto listExpected = new FollowedListResponseDto(
                user.get().getUserId(),
                user.get().getUserName(),
                List.of(new UserDataDto(4,"rosa"), new UserDataDto(2,"jacob"))
        );

        when(userRepo.findUserById(1)).thenReturn(user);
        when(userRepo.listSellersFollowers(1)).thenReturn(listUsersDesc);
        //Act
        FollowedListResponseDto listActual = userServiceImp.listSellersFollowers(id,order);

        assertEquals(listActual,listExpected);
    }

    @Test
    @DisplayName("T0004 - Not Found List Sellers Followers")
    void listSellersFollowersNotFoundTest(){
        //Arrange
        int id=1;
        String order="name_desc";
        Optional<User> user = Optional.of(new User(1, "edgar", true, List.of(2, 3), List.of(2, 4)));
        List<User> listUsersDesc = List.of(
                new User(4,"rosa",false,List.of(1,3),List.of()),
                new User(2,"jacob",true,List.of(1),List.of(1,5)));

        FollowedListResponseDto listExpected = new FollowedListResponseDto(
                user.get().getUserId(),
                user.get().getUserName(),
                List.of(new UserDataDto(4,"rosa"), new UserDataDto(2,"jacob"))
        );

        when(userRepo.findUserById(1)).thenReturn(user);
        when(userRepo.listSellersFollowers(1)).thenReturn(listUsersDesc);
        //Act
        FollowedListResponseDto listActual = userServiceImp.listSellersFollowers(id,order);

        assertEquals(listActual,listExpected);
    }

    @Test
    @DisplayName("T0004 - No User List Sellers Followers")
    void listSellersFollowersNoUserTest(){
        int id=111;
        String order="name_desc";
        Assertions.assertThrows(NotFoundException.class,
                () -> {userServiceImp.listSellersFollowers(id,order);});
    }

    @Test
    @DisplayName("T0004 - No Followers List Sellers Followers")
    void listSellersFollowersNoFollowersTest(){
        int id=4;
        String order="name_desc";
        Assertions.assertThrows(NotFoundException.class,
                () -> {userServiceImp.listSellersFollowers(id,order);});
    }

    @Test
    @DisplayName("T0004 - Descending Get Followed By User")
    void getFollowedByUserDescTest(){
        //Arrange
        int id=1;
        String order="name_desc";
        Optional<User> user = Optional.of(new User(1, "edgar", true, List.of(2, 3), List.of(2, 4)));
        List<UserDataDto> listUsersDesc = List.of(
                new UserDataDto(2,"jacob"),
                new UserDataDto(3,"hector"));

        FollowedListResponseDto listExpected = new FollowedListResponseDto(
                user.get().getUserId(),
                user.get().getUserName(),
                listUsersDesc
        );

        when(userRepo.findUserById(1)).thenReturn(user);
        when(userRepo.getFollowed(1)).thenReturn(listUsersDesc);
        //Act
        FollowedListResponseDto listActual = userServiceImp.getFollowedByUser(id,order);

        assertEquals(listActual,listExpected);
    }
    @Test
    @DisplayName("T0004 - Ascending Get Followed By User")
    void getFollowedByUserAscTest(){
        //Arrange
        int id=1;
        String order="name_asc";
        Optional<User> user = Optional.of(new User(1, "edgar", true, List.of(2, 3), List.of(2, 4)));
        List<UserDataDto> listUsersDesc = List.of(
                new UserDataDto(3,"hector"),
                new UserDataDto(2,"jacob"));

        FollowedListResponseDto listExpected = new FollowedListResponseDto(
                user.get().getUserId(),
                user.get().getUserName(),
                listUsersDesc
        );

        when(userRepo.findUserById(1)).thenReturn(user);
        when(userRepo.getFollowed(1)).thenReturn(listUsersDesc);
        //Act
        FollowedListResponseDto listActual = userServiceImp.getFollowedByUser(id,order);

        assertEquals(listActual,listExpected);
    }

    @Test
    @DisplayName("T0004 - User Not Found Get Followed By User")
    void getFollowedByUserNotFoundTest(){
        int id=111;
        String order="name_desc";
        Assertions.assertThrows(NotFoundException.class,
                () -> {userServiceImp.getFollowedByUser(id,order);});
    }

    /*

        T0007

     */

    /**
     * Test case to verify the behavior of getUserFollowersCount when the user exists and is a seller with followers.
     *
     * <p>
     * This test ensures that when the user exists and is a seller with followers, the getUserFollowersCount method
     * returns a UserFollowersCountDto object with the correct user ID, user name, and followers count.
     * </p>
     */
    @Test
    @DisplayName("T0007 - Caso Feliz Get UserFollowersCount")
    public void testGetUserFollowersCount_UserExistsAndIsSeller() {
        // Create a simulated user who exists, is a seller, and has followers
        User user = new User();
        user.setUserId(1);
        user.setUserName("testUser");
        user.setIsSeller(true);
        List<Integer> followers = new ArrayList<>();
        followers.add(2);
        followers.add(3);
        user.setFollowers(followers);

        // Configure the behavior of the user repository mock
        when(userRepo.findUserById(1)).thenReturn(Optional.of(user));

        // Call the method of the service
        UserFollowersCountDto result = userServiceImp.getUserFollowersCount(1);

        // Verify that the expected result is obtained
        assertEquals(1, result.getUser_id());
        assertEquals("testUser", result.getUser_name());
        assertEquals(2, result.getFollowers_count());
    }


    /**
     * Test case to verify the behavior of getUserFollowersCount when the user is not found.
     *
     * <p>
     * This test ensures that when the user is not found in the repository, the getUserFollowersCount method
     * throws a NotFoundException.
     * </p>
     */
    @Test
    @DisplayName("T0007 - UserNotFound Get UserFollowersCount")
    public void testGetUserFollowersCount_UserNotFound() {
        // Configure the behavior of the user repository mock to return an empty Optional
        when(userRepo.findUserById(1)).thenReturn(Optional.empty());

        // Verify that a NotFoundException is thrown when the user is not found
        assertThrows(NotFoundException.class, () -> userServiceImp.getUserFollowersCount(1));
    }


    /**
     * Test case to verify the behavior of getUserFollowersCount when the user is not a seller.
     *
     * <p>
     * This test ensures that when the user is not a seller, the getUserFollowersCount method
     * throws a FollowException.
     * </p>
     */
    @Test
    @DisplayName("T0007 - UserNotSeller Get UserFollowersCount")
    void testGetUserFollowersCount_UserNotSeller() {
        // Create a simulated user who is not a seller
        User user = new User();
        user.setUserId(1);
        user.setUserName("testUser");
        user.setIsSeller(false);

        // Configure the behavior of the user repository mock
        when(userRepo.findUserById(1)).thenReturn(Optional.of(user));

        // Verify that a FollowException is thrown when the user is not a seller
        assertThrows(FollowException.class, () -> userServiceImp.getUserFollowersCount(1));
    }


    /**
     * Test case to verify the behavior of getUserFollowersCount when the user is a seller but does not have any followers.
     *
     * <p>
     * This test ensures that when the user is a seller but has no followers, the getUserFollowersCount method returns a UserFollowersCountDto
     * object with a followers count of 0.
     * </p>
     */
    @Test
    @DisplayName("T0007 - NoFollowers Get UserFollowersCount")
    void testGetUserFollowersCount_DoesNotHaveFollowers() {
        // Create a simulated user who is a seller but has no followers
        User user = new User();
        user.setUserId(1);
        user.setUserName("testUser");
        user.setIsSeller(true);
        user.setFollowers(new ArrayList<>());

        // Configure the behavior of the user repository mock
        when(userRepo.findUserById(1)).thenReturn(Optional.of(user));

        // Call the method under test
        UserFollowersCountDto userFollowersCount = userServiceImp.getUserFollowersCount(1);

        // Verify that the returned UserFollowersCountDto has a followers count of 0
        assertEquals(0, userFollowersCount.getFollowers_count());

    }
    
}
