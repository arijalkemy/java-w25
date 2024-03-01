package com.example.be_java_hisp_w25_g10.services;

import com.example.be_java_hisp_w25_g10.dtos.CountDto;
import com.example.be_java_hisp_w25_g10.entities.Follower;
import com.example.be_java_hisp_w25_g10.entities.RolEnum;
import com.example.be_java_hisp_w25_g10.entities.User;
import com.example.be_java_hisp_w25_g10.exceptions.InvalidRequestException;
import com.example.be_java_hisp_w25_g10.exceptions.NotFoundException;
import com.example.be_java_hisp_w25_g10.repositories.Repository;
import com.example.be_java_hisp_w25_g10.services.users.UserService;
import com.example.be_java_hisp_w25_g10.utils.Builder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.DisplayName;
@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private Repository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void VerifyCountTest(){

        int user_id = 2;

        User[] usersArray = Builder.VerifyCountTestBuilder();

        List<User> followersList = new ArrayList<>(Arrays.asList(usersArray));

        when(userRepository.getFollowersList(user_id)).thenReturn(followersList);
        List<User> followers_list = userRepository.getFollowersList(user_id);

        CountDto result = new CountDto(user_id, "user2", 2);
       
        assertNotNull(result);
        assertEquals(user_id, result.user_id());
        assertEquals("user2", result.user_name());
        assertEquals(followers_list.size(), result.followers_count());

    }

    @Test
    public void verifyNormalFollowFlowTest() {
        int userId = 4;
        int userToFollowId = 2;

        User user = new User(2, "user2", "lastName", RolEnum.SELLER);

        when(userRepository.findUser(userToFollowId)).thenReturn(Optional.of(user));
        when(userRepository.follow(userId, userToFollowId)).thenReturn(Optional.of(new Follower(4,2)));

        assertTrue(userService.follow(userId,userToFollowId));
    }

    @Test
    public void verifyUserToFollowDoesNotExist() {
        int userId = 4;
        int userToFollowId = 2;

        when(userRepository.findUser(userToFollowId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> {
            userService.follow(userId,userToFollowId);
        });
    }

    @Test
    public void verifyUserToFollowIsNotSeller() {
        int userId = 4;
        int userToFollowId = 2;

        User user = new User(2, "user2", "lastName", RolEnum.BUYER);

        when(userRepository.findUser(userToFollowId)).thenReturn(Optional.of(user));

        assertThrows(InvalidRequestException.class, () -> {
            userService.follow(userId,userToFollowId);
        });
    }

    @Test
    public void verifyRepositoryEmptyResult() {
        int userId = 4;
        int userToFollowId = 2;

        User user = new User(2, "user2", "lastName", RolEnum.SELLER);

        when(userRepository.findUser(userToFollowId)).thenReturn(Optional.of(user));
        when(userRepository.follow(userId, userToFollowId)).thenReturn(Optional.empty());

        assertThrows(InvalidRequestException.class, () -> {
            userService.follow(userId,userToFollowId);
        });
    }

    @Test public void verifyUnfollowNormalFlow() {
        int userId = 4;
        int userToUnfollowId = 2;

        User user = new User(2, "user2", "lastName", RolEnum.SELLER);

        when(userRepository.findUser(userToUnfollowId)).thenReturn(Optional.of(user));

        assertTrue(userService.unFollow(userId, userToUnfollowId));
    }

    @Test public void verifyUserToUnfollowDoesNotExist() {
        int userId = 4;
        int userToUnfollowId = 2;

        when(userRepository.findUser(userToUnfollowId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> {
            userService.unFollow(userId,userToUnfollowId);
        });
    }
    @DisplayName("test order by followers asc")
    public void getFollowersListAscTest(){
        String order = "asc";
        List<User> followersList = new ArrayList<>(List.of(
                new User(1, "user1", "lastName", RolEnum.SELLER),
                new User(3, "user3", "lastName", RolEnum.BUYER)
        ));


        if (order.equals("asc")) {
            followersList.sort(Comparator.comparing(User::getId));
        }

        when(userRepository.getFollowersList(1)).thenReturn(followersList);
        List<User> followers_list = userRepository.getFollowersList(1);

        assertEquals(followersList, followers_list);
    }

    @Test
    @DisplayName("test order by followers desc")
    public void getFollowersListDescTest(){
        String order = "desc";
        List<User> followersList = new ArrayList<>(List.of(
                new User(1, "user1", "lastName", RolEnum.SELLER),
                new User(3, "user3", "lastName", RolEnum.BUYER)
        ));


        if (order.equals("desc")) {
            followersList.sort(Comparator.comparing(User::getId));
        }

        when(userRepository.getFollowersList(1)).thenReturn(followersList);
        List<User> followers_list = userRepository.getFollowersList(1);

        assertEquals(followersList, followers_list);
    }


}
