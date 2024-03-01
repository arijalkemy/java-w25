package service;

import com.example.be_java_hisp_w25_g01.dto.response.*;

import com.example.be_java_hisp_w25_g01.entity.Post;
import com.example.be_java_hisp_w25_g01.entity.User;
import com.example.be_java_hisp_w25_g01.exception.BadRequestException;
import com.example.be_java_hisp_w25_g01.repository.IPostRepository;
import com.example.be_java_hisp_w25_g01.repository.IUserRepository;
import com.example.be_java_hisp_w25_g01.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import util.TestUtilGenerator;

import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static util.TestUtilGenerator.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImpTest {

    @Mock
    IUserRepository userRepository;

    @Mock
    IPostRepository postRepository;

    @InjectMocks
    UserServiceImpl userService;

    @DisplayName("UT1_followUserOkTest")
    @Test
    void followUserOkTest() {
        //Arrange
        User user = getUser();
        User userToFollow = getUser3();
        MessagesDTO expectedMessage = new MessagesDTO("User with id: " + user.getUserId()
                                                + " is now following user with id: " + userToFollow.getUserId());

        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findById(userToFollow.getUserId())).thenReturn(Optional.of(userToFollow));
        when(postRepository.findByUser(userToFollow.getUserId())).thenReturn(new ArrayList<>(List.of(new Post())));

        //Act
        MessagesDTO result = userService.followUser(user.getUserId(), userToFollow.getUserId());

        //Assert
        Assertions.assertEquals(expectedMessage.getMessage(), result.getMessage());
    }

    @DisplayName("UT1_followUserBadRequestTest")
    @Test
    void followUserBadRequestTest() {
        //Arrange
        Integer userIdToFollow = 2;
        User user = getUser();

        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.findById(userIdToFollow)).thenReturn(Optional.empty());

        //Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.followUser(user.getUserId(), userIdToFollow));
    }

    @DisplayName("UT2_unfollowUserOkTest")
    @Test
    void unfollowUserOkTest() {
        //Arrange
        User user1 = getUser();
        User user2 = getUser2();//new User(5,"leanSaracco", new ArrayList<>(List.of()), new ArrayList<>(List.of(1,2,3,4)),new ArrayList<>(List.of(4,5)));
        MessagesDTO messageSpected = new MessagesDTO("User with id: " + user1.getUserId() + " is now unfollowing user with id: " + user2.getUserId());

        when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user1));
        when(userRepository.findById(user2.getUserId())).thenReturn(Optional.of(user2));

        //Act
         MessagesDTO result = userService.unfollowUser(user1.getUserId(),user2.getUserId());

        //Assert
        Assertions.assertEquals(result, messageSpected);
    }
    @DisplayName("UT2_unfollowUserBadRequestTest")
    @Test
    void unfollowUserBadRequestTest(){
        //Arrange
        Integer userId = 1;
        Integer userIdToFollow = 2;
        User user = new User(userId, "user_1", List.of(), List.of(), List.of());

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userRepository.findById(userIdToFollow)).thenReturn(Optional.empty());

        //Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.unfollowUser(userId, userIdToFollow));
    }

    @DisplayName("UT3_getFollowersList_NotOkTest")
    @Test
    void getFollowersList_NotOk(){
        //Arrange
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(getUser()));
        when(userRepository.findAllByIdIn(List.of())).thenReturn(List.of(getUser()));

        //Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> {
            //Code under test
            userService.getFollowersList(1,"mal");
        });
    }
    @DisplayName("UT3_getFollowedList_NotOkTest")
    @Test
    void getFollowedList_NotOk(){
        //Arrange
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(getUser()));
        when(userRepository.findAllByIdIn(List.of())).thenReturn(List.of(getUser()));

        //Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> {
            //Code under test
            userService.getFollowersList(1,"mal");
        });
    }
    @DisplayName("UT3_getFollowersList_Test")
    @Test
    void getFollowersList_Ok(){
        //Arrange
        UserDTO user = getUserDTO();
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(getUser()));
        when(userRepository.findAllByIdIn(List.of())).thenReturn(List.of(getUser()));

        //Act
        FollowersDTO result = userService.getFollowersList(1,"name_asc");

        //Assert
        Assertions.assertEquals(user.getUser_id(), result.getUser_id());
        Assertions.assertEquals(user.getUser_name(), result.getUser_name());
    }
    @DisplayName("UT3_getFollowedList_Test")
    @Test
    void getFollowedList_Ok(){
        //Arrange
        UserDTO user = getUserDTO();
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(getUser()));
        when(userRepository.findAllByIdIn(List.of(5))).thenReturn(List.of(getUser()));

        //Act
        FollowedDTO result = userService.getFollowedList(1,"name_asc");

        //Assert
        Assertions.assertEquals(user.getUser_id(), result.getUser_id());
        Assertions.assertEquals(user.getUser_name(), result.getUser_name());
    }

    @DisplayName("UT4_getFollowedListAscOKTest")
    @Test
    void getFollowedListAscOKTest(){
        //Arrange
        User user = new User(2, "ariJaime", List.of(4,5), List.of(), List.of());
        List<User> followeds = getUserList2();

        when(userRepository.findById(2)).thenReturn(Optional.of(user));
        when(userRepository.findAllByIdIn(List.of(4,5))).thenReturn(followeds);

        //Act
        FollowedDTO result = userService.getFollowedList(2, "name_asc");

        //Assert
        Assertions.assertEquals(2,result.getUser_id());
        Assertions.assertEquals("ariJaime",result.getUser_name());
        Assertions.assertEquals(2,result.getFollowed().size());
        Assertions.assertEquals("leanSaracco",result.getFollowed().get(0).getUser_name());
        Assertions.assertEquals("sofiaMaria",result.getFollowed().get(1).getUser_name());
    }

    @DisplayName("UT4_getFollowedListDescOKTest")
    @Test
    void getFollowedListDescOKTest(){
        //Arrange
        User user = new User(2, "ariJaime", List.of(4,5), List.of(), List.of());
        List<User> followeds = getUserList2();
        Collections.reverse(followeds);

        when(userRepository.findById(2)).thenReturn(Optional.of(user));
        when(userRepository.findAllByIdIn(List.of(4,5))).thenReturn(followeds);

        //Act
        FollowedDTO result = userService.getFollowedList(2, "name_desc");

        //Assert
        Assertions.assertEquals(2,result.getUser_id());
        Assertions.assertEquals("ariJaime",result.getUser_name());
        Assertions.assertEquals(2,result.getFollowed().size());
        Assertions.assertEquals("sofiaMaria",result.getFollowed().get(0).getUser_name());
        Assertions.assertEquals("leanSaracco",result.getFollowed().get(1).getUser_name());
    }

    @DisplayName("UT4_getFollowersListAscOkTest")
    @Test
    void getFollowersListAscOkTest() {
        //Arrange
        User user = new User(4, "sofiaMaria", List.of(), List.of(2, 3), List.of());
        List<User> followers = List.of(
                new User(3, "ezeEscobar", List.of(4), List.of(), List.of()),
                new User(2, "ariJaime", List.of(4), List.of(), List.of())
        );
        when(userRepository.findById(4)).thenReturn(Optional.of(user));
        when(userRepository.findAllByIdIn(List.of(2, 3))).thenReturn(followers);

        FollowersDTO expectedResult = getFollowersDTOasc();

        //Act
        FollowersDTO result = userService.getFollowersList(4, "name_asc");

        // Assert
        Assertions.assertEquals(expectedResult, result);

    }

    @DisplayName("UT4_getFollowersListDescOkTest")
    @Test
    void getFollowersListDescOkTest() {
        //Arrange
        User user = new User(4, "sofiaMaria", List.of(), List.of(2, 3), List.of());
        List<User> followers = List.of(new User(2, "ariJaime", List.of(4), List.of(), List.of()),
                new User(3, "ezeEscobar", List.of(4), List.of(), List.of()));
        when(userRepository.findById(4)).thenReturn(Optional.of(user));
        when(userRepository.findAllByIdIn(List.of(2, 3))).thenReturn(followers);

        FollowersDTO expectedResult = getFollowersDTOdesc();


        //Act
        FollowersDTO result = userService.getFollowersList(4, "name_desc");

        //Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("UT4_getFollowersListOrderNullTest")
    @Test
    void getFollowersListOrderNullTest() {
        //Arrange
        User user = new User(4, "sofiaMaria", List.of(), List.of(2, 3), List.of());
        List<User> followers = List.of(new User(3, "ezeEscobar", List.of(4), List.of(), List.of()),
                new User(2, "ariJaime", List.of(4), List.of(), List.of()));

        when(userRepository.findById(4)).thenReturn(Optional.of(user));
        when(userRepository.findAllByIdIn(List.of(2, 3))).thenReturn(followers);

        FollowersDTO expectedResult = getFollowersDTOdesc();

        //Act
        FollowersDTO result = userService.getFollowersList(4, null);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("UT4_getFollowedListOrderNullTest")
    @Test
    void getFollowedListOrderNullTest(){
        //Arrange
        User user = new User(2, "ariJaime", List.of(4,5), List.of(), List.of());
        List<User> followeds = List.of(new User(4,"sofiaMaria",List.of(),List.of(2),List.of()),
                new User(5,"leanSaracco",List.of(),List.of(2),List.of()));

        when(userRepository.findById(2)).thenReturn(Optional.of(user));
        when(userRepository.findAllByIdIn(List.of(4,5))).thenReturn(followeds);

        //Act
        FollowedDTO result = userService.getFollowedList(2, null);

        //Assert
        Assertions.assertEquals(2,result.getUser_id());
        Assertions.assertEquals("ariJaime",result.getUser_name());
        Assertions.assertEquals(2,result.getFollowed().size());
        Assertions.assertEquals("sofiaMaria",result.getFollowed().get(0).getUser_name());
        Assertions.assertEquals("leanSaracco",result.getFollowed().get(1).getUser_name());
    }

    @DisplayName("UT7_getFollowersCountOKTest")
    @Test
    void getFollowersCountOKTest(){
        //Arrange
        User user = new User(1, "user_1", List.of(), List.of(2), List.of());
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(user));

        //Act
        FollowersCountDTO result = userService.getFollowersCount(anyInt());

        //Assert
        Assertions.assertEquals(1, result.getFollowers_count());
    }
}