package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerCountDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserFollowingDTO;
import com.bootcamp.be_java_hisp_w25_g02.entity.User;
import com.bootcamp.be_java_hisp_w25_g02.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w25_g02.util.TestUtilGenerator;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerListDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImplTest {

    @Mock
    IUserRepository iUserRepository;
    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Test
    @DisplayName("T-0001 - Follow user - Test ok")
    void followUserTestOk() {
        //Arange
        Integer userId = 1;
        Integer userIdToFollow = 10;
        Optional<User> user = Optional.of(TestUtilGenerator.getUserWithFollowingSellers());
        Optional<User> userToFollow = Optional.of(TestUtilGenerator.getUserSeller());

        when(iUserRepository.findById(userId)).thenReturn(user);
        when(iUserRepository.findById(userIdToFollow)).thenReturn(userToFollow);

        //Act
        userServiceImpl.followUser(userId, userIdToFollow);

        //Assert
        verify(iUserRepository, atLeastOnce()).findById(userId);
        verify(iUserRepository, atLeastOnce()).findById(userIdToFollow);
        assertTrue(CollectionUtils.contains(user.get().getFollowing().iterator(), userToFollow.get().getUserId()));
    }

    @Test
    @DisplayName("T-0001 - Follow user - Bad Request")
    void followUserTestBadRequest() {
        //Arrange
        Integer userId = 1;
        Integer userToFollowId = 3;
        Optional<User> user = Optional.of(TestUtilGenerator.getUserWithFollowingSellers());
        Optional<User> userToFollow = Optional.of(TestUtilGenerator.getUserNotSeller());

        when(iUserRepository.findById(userId)).thenReturn(user);
        when(iUserRepository.findById(userToFollowId)).thenReturn(userToFollow);

        // Act + Assert
        assertThrows(BadRequestException.class, () -> {
            userServiceImpl.followUser(userId, userToFollowId);
        });

        verify(iUserRepository, atLeastOnce()).findById(userId);
        verify(iUserRepository, atLeastOnce()).findById(userToFollowId);


    }

    @Test
    @DisplayName("T-0002 - Unfollow user - Test ok")
    void unfollowUserTestOk() {
        //Arange
        Integer userId = 1;
        Integer userIdToUnfollow = 10;
        Optional<User> user = Optional.of(TestUtilGenerator.getUserWithFollowingSellers());
        Optional<User> userToUnfollow = Optional.of(TestUtilGenerator.getUserSeller());

        when(iUserRepository.findById(userId)).thenReturn(user);
        when(iUserRepository.findById(userIdToUnfollow)).thenReturn(userToUnfollow);

        //Act
        userServiceImpl.unfollowUser(userId, userIdToUnfollow);

        //Assert
        verify(iUserRepository,atLeastOnce()).findById(userId);
        verify(iUserRepository,atLeastOnce()).findById(userIdToUnfollow);


    }

    @Test
    @DisplayName("T-0002 - Unfollow user - Bad request")
    void unfollowUserTestBadRequest() {
        //Arange
        Integer userId = 1;
        Integer userIdToUnfollow = 15;
        Optional<User> user = Optional.of(TestUtilGenerator.getUserWithFollowingSellers());
        Optional<User> userToUnfollow = Optional.empty();

        when(iUserRepository.findById(userId)).thenReturn(user);
        when(iUserRepository.findById(userIdToUnfollow)).thenReturn(userToUnfollow);

        // Act + Assert
        assertThrows(BadRequestException.class, () -> {
            userServiceImpl.unfollowUser(userId, userIdToUnfollow);
        });

        verify(iUserRepository, atLeastOnce()).findById(userId);
        verify(iUserRepository, atLeastOnce()).findById(userIdToUnfollow);


    }


    @Test
    @DisplayName("T-0003 - Alphabetical Followed Order Doesn't Exist")
    void followedOrderExistsOK() {
        // Arrange
        Integer id_1 = 1;
        Integer id_7 = 7;
        Integer id_9 = 9;

        String order = null;

        Optional<User> userWithId_1 = Optional.of(TestUtilGenerator.getUserWithFollowingSellers());
        Optional<User> userWithId_7 = Optional.of(TestUtilGenerator.followingUserId7());
        Optional<User> userWithId_9 = Optional.of(TestUtilGenerator.followingUserId9());

        UserFollowingDTO expected = TestUtilGenerator.getCorrectDescUserFollowingDTO();

        when(iUserRepository.findById(id_1)).thenReturn(userWithId_1);
        when(iUserRepository.findById(id_7)).thenReturn(userWithId_7);
        when(iUserRepository.findById(id_9)).thenReturn(userWithId_9);

        // Act
        UserFollowingDTO result = userServiceImpl.getFollowedSellers(id_1, order);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T-0003 - Alphabetical Followed Order Bad Request")
    void followedOrderExistsBadRequest() {
        // Arrange
        Integer id_1 = 1;
        Integer id_7 = 7;
        Integer id_9 = 9;

        String order = "invalid";

        Optional<User> userWithId_1 = Optional.of(TestUtilGenerator.getUserWithFollowingSellers());
        Optional<User> userWithId_7 = Optional.of(TestUtilGenerator.followingUserId7());
        Optional<User> userWithId_9 = Optional.of(TestUtilGenerator.followingUserId9());

        when(iUserRepository.findById(id_1)).thenReturn(userWithId_1);
        when(iUserRepository.findById(id_7)).thenReturn(userWithId_7);
        when(iUserRepository.findById(id_9)).thenReturn(userWithId_9);

        // Act + Assert
        assertThrows(BadRequestException.class, () -> {
            userServiceImpl.getFollowedSellers(1, order);
        });
    }

    @Test
    @DisplayName("T-0004 - Correct Asc. Alphabetical Followed Order")
    void followedAscOrderOK() {
        // Arrange
        Integer id_1 = 1;
        Integer id_7 = 7;
        Integer id_9 = 9;

        String order = "name_asc";

        Optional<User> userWithId_1 = Optional.of(TestUtilGenerator.getUserWithFollowingSellers());
        Optional<User> userWithId_7 = Optional.of(TestUtilGenerator.followingUserId7());
        Optional<User> userWithId_9 = Optional.of(TestUtilGenerator.followingUserId9());

        UserFollowingDTO expected = TestUtilGenerator.getCorrectAscUserFollowingDTO();

        when(iUserRepository.findById(id_1)).thenReturn(userWithId_1);
        when(iUserRepository.findById(id_7)).thenReturn(userWithId_7);
        when(iUserRepository.findById(id_9)).thenReturn(userWithId_9);

        // Act
        UserFollowingDTO result = userServiceImpl.getFollowedSellers(id_1, order);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T-0004 - Correct Desc. Alphabetical Followed Order")
    void followedDescOrderOK() {
        // Arrange
        Integer id_1 = 1;
        Integer id_7 = 7;
        Integer id_9 = 9;

        String order = "name_desc";

        Optional<User> userWithId_1 = Optional.of(TestUtilGenerator.getUserWithFollowingSellers());
        Optional<User> userWithId_7 = Optional.of(TestUtilGenerator.followingUserId7());
        Optional<User> userWithId_9 = Optional.of(TestUtilGenerator.followingUserId9());

        UserFollowingDTO expected = TestUtilGenerator.getCorrectDescUserFollowingDTO();

        when(iUserRepository.findById(id_1)).thenReturn(userWithId_1);
        when(iUserRepository.findById(id_7)).thenReturn(userWithId_7);
        when(iUserRepository.findById(id_9)).thenReturn(userWithId_9);

        // Act
        UserFollowingDTO result = userServiceImpl.getFollowedSellers(id_1, order);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T-0004 - When calling getFollowersList(), without an 'order' param, the list is returned without any order.")
    public void getFollowersListTestNoOrderParam(){
        // Arr
        String order = null;

        User user1 = TestUtilGenerator.createUser1(); // Matias
        User user2 = TestUtilGenerator.createUser2(); // Romina
        User user3 = TestUtilGenerator.createUser3(); // Abel
        User user4 = TestUtilGenerator.createUser4(); // jorge

        List<UserDTO> listOfUserDTOs = TestUtilGenerator.createFollowerDTOList(null);

        FollowerListDTO myAnsDTO = new FollowerListDTO(user4.getUserId(), user4.getUserName(), listOfUserDTOs);
        // Act

        when(iUserRepository.findById(anyInt())).thenReturn(
                Optional.of(user4),
                Optional.of(user1),
                Optional.of(user2),
                Optional.of(user3)
        );
        // Assert
        Assertions.assertEquals(myAnsDTO, userServiceImpl.getFollowersList(12, null));

    }

    @Test
    @DisplayName("T-0004 - When calling getFollowersList(), with 'order' param being 'name_asc' , the list is returned in order ascending by name.")
    public void getFollowersListTestOrderAsc(){
        // Arr
        String order = "name_asc";

        User user1 = TestUtilGenerator.createUser1(); // Matias
        User user2 = TestUtilGenerator.createUser2(); // Romina
        User user3 = TestUtilGenerator.createUser3(); // Abel
        User user4 = TestUtilGenerator.createUser4(); // jorge

        List<UserDTO> listOfUserDTOs = TestUtilGenerator.createFollowerDTOList("name_asc");

        FollowerListDTO myAnsDTO = new FollowerListDTO(user4.getUserId(), user4.getUserName(), listOfUserDTOs);
        // Act

        when(iUserRepository.findById(anyInt())).thenReturn(
                Optional.of(user4),
                Optional.of(user3), // Abel
                Optional.of(user1), // Matias
                Optional.of(user2) // Romina
        );
        // Assert
        Assertions.assertEquals(myAnsDTO, userServiceImpl.getFollowersList(12, order));
    }

    @Test
    @DisplayName("T-0004 - When calling getFollowersList(), with 'order' param being 'name_desc' , the list is returned in order descending by name.")
    public void getFollowersListTestOrderDesc(){

        // Arr
        String order = "name_desc";

        User user1 = TestUtilGenerator.createUser1(); // Matias
        User user2 = TestUtilGenerator.createUser2(); // Romina
        User user3 = TestUtilGenerator.createUser3(); // Abel
        User user4 = TestUtilGenerator.createUser4(); // jorge

        List<UserDTO> listOfUserDTOs = TestUtilGenerator.createFollowerDTOList("name_desc");

        FollowerListDTO myAnsDTO = new FollowerListDTO(user4.getUserId(), user4.getUserName(), listOfUserDTOs);
        // Act

        when(iUserRepository.findById(anyInt())).thenReturn(
                Optional.of(user4), // Jorge no se agrega a la lista de sus propios seguidores, no necesitamos aqui para simular buscarlo por ID
                Optional.of(user2), // Agregamos los usuarios en la lista de jorge en orden correspondeiente.
                Optional.of(user1),
                Optional.of(user3)
        );
        // Assert
        Assertions.assertEquals(myAnsDTO, userServiceImpl.getFollowersList(12, order));
    }

    @Test
    @DisplayName("T-0003 - When calling getFollowersList(), an exception is thrown if 'order' has an incorrect value")
    public void getFollowersListTestIncorrectOrderParam(){
        // Arr
        String incorrectOrderString = "algoIncorrecto";

        // Act and Assert
        Assertions.assertThrows(BadRequestException.class,
                ()-> userServiceImpl.getFollowersList(1, incorrectOrderString));
    }

    @Test
    @DisplayName("T-0007 - Total followers given user ID")
    void getUserTotalFollowers() {
        //ARRANGE
        User user = TestUtilGenerator.createUser1();
        Integer userId = 1;
        when(iUserRepository.findById(userId)).thenReturn(Optional.of(user));

        //ACT
        FollowerCountDTO result = userServiceImpl.getUserTotalFollowers(userId);
        //ASSERT
        verify(iUserRepository, atLeastOnce()).findById(userId);
        assertNotNull(result);
        assertThat(result.followersCount()).isEqualTo(user.getFollowedBy().size());
    }
}