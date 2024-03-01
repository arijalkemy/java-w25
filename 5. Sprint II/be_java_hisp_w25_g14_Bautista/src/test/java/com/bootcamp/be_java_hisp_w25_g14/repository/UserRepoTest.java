package com.bootcamp.be_java_hisp_w25_g14.repository;

import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserRepoTest {
    UserRepoImp userRepoImp = new UserRepoImp();

    /**
     *
     * T0001
     *
     */
    @Test
    @DisplayName("T0001 - Caso Feliz AddFollower")
    void t0001addFollowerOk(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=3;

        //Act Assert
        userRepoImp.addFollower(userId,userIdToFollow);

    }

    @Test
    @DisplayName("T0001 - UnableToFollowItself AddFollower")
    void t0001unableFollowItselfTest(){
        //Arrange
        Integer userId=3;
        Integer userIdToFollow=3;
        //Act  Assert
        assertThrows(FollowException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }
    @Test
    @DisplayName("T0001 - UserNotFound AddFollower")
    void t0001userNoExistsTest(){
        //Arrange
        Integer userId=10;
        Integer userIdToFollow=3;
        //Act  Assert
        assertThrows(NotFoundException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }
    @Test
    @DisplayName("T0001 - UserToFollowNotFound AddFollower")
    void t0001userFollowNoExistsTest(){
        //Arrange
        Integer userId=1;
        Integer userIdToFollow=30;
        //Act  Assert
        assertThrows(NotFoundException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }
    @Test
    @DisplayName("T0001 - AlreadyFollows AddFollower")
    void t0001alreadyFollowTest(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=1;
        //Act  Assert
        assertThrows(FollowException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }

    @Test
    @DisplayName("T0001 - FollowNormalException AddFollower")
    void t0001followNormalExceptionTest(){
        //Arrange
        Integer userId=2;
        Integer userIdToFollow=4;
        //Act  Assert
        assertThrows(FollowException.class, ()->userRepoImp.addFollower(userId,userIdToFollow));
    }

    /*+
    *
    * T0002
    *
     */

    @Test
    @DisplayName("T0002 - Caso Feliz RemoveFollower")
    void t0002removeFollowerOk(){
        //Arrange
        Integer userId=2;
        Integer userIdToUnfollow=1;

        //Act Assert
        userRepoImp.removeFollow(userId,userIdToUnfollow);

    }

    @Test
    @DisplayName("T0002 - UserNotFound RemoveFollower")
    void t0002userIdNotExistsTest(){
        //Arrange
        Integer userId=12;
        Integer userIdToFollow=3;
        //Act  Assert
        assertThrows(NotFoundException.class, ()->userRepoImp.removeFollow(userId,userIdToFollow));
    }
    @Test
    @DisplayName("T0002 - UserToUnfollowNotFound RemoveFollower")
    void t0002userIdToUnfollowNotExistsTest(){
        //Arrange
        Integer userId=1;
        Integer userIdToFollow=10;
        //Act  Assert
        assertThrows(NotFoundException.class, ()->userRepoImp.removeFollow(userId,userIdToFollow));
    }
    @Test
    @DisplayName("T0002 - NotFollowingUser RemoveFollower")
    void t0002dontFollowTest(){
        //Arrange
        Integer userId=3;
        Integer userIdToFollow=2;
        //Act  Assert
        assertThrows(FollowException.class, ()->userRepoImp.removeFollow(userId,userIdToFollow));
    }

}
