package com.socialMeli.repository;

import com.socialMeli.entity.User;
import com.socialMeli.entity.UserType;
import com.socialMeli.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserRepositoryTest {

    UserRepository userRepository;
    User userVendor;
    User userClient;

    static Stream<Arguments> userIds() {
        return Stream.of(
                Arguments.arguments(1, 10),
                Arguments.arguments(1, 9));
    }

    User vendor;
    User client1;
    User client2;
    User client3;
    User client4;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        client1 = new User(1,"Luciano Gonzalez",List.of(),List.of(8,10),UserType.CLIENT);
        client2 = new User(2,"Sofia Fernandez",List.of(),List.of(8),UserType.CLIENT);
        client3 = new User(11,"Diego Diaz",List.of(),List.of(),UserType.CLIENT);
        client4 = new User(12,"Facundo Salvia",List.of(),List.of(),UserType.VENDOR);


        userClient = userRepository.userBd.get(0);
        userVendor = userRepository.userBd.get(9);
    }

    @Test
    void findUserByUserIdFoundTest() {
        Optional<User> user = userRepository.findUserByUserId(1);
        Assertions.assertTrue(user.isPresent());
    }

    @Test
    void findUserByUserIdNotFoundTest() {
        Optional<User> user = userRepository.findUserByUserId(-1);
        Assertions.assertTrue(user.isEmpty());
    }
    @Test
    void followUserWhoDontFollowEachOtherTest() {
        userRepository.userBd.add(client3);
        userRepository.userBd.add(client4);

        userRepository.followUser(client3, client4);

        System.out.println("user bd : -> " + userRepository.userBd);
        System.out.println("user 11: " + userRepository.userBd.get(11));

        assertTrue(userRepository.userBd.get(11)
                .getFollowersId().stream().anyMatch((id -> id.equals(11))));
//        assertTrue(userRepository.userBd.get(userToUnfollowPos)
//                .getFollowersId().stream().noneMatch(id -> id.equals(userId)));
    }

    @ParameterizedTest
    @MethodSource("userIds")
    void unfollowUserWhoDontFollowEachOtherTest(int userId, int userToUnfollowId) {
        int userPos = userId - 1;
        int userToUnfollowPos = userToUnfollowId - 1;
        userRepository.unfollowUser(userRepository.userBd.get(userPos), userRepository.userBd.get(userToUnfollowPos));
        assertTrue(userRepository.userBd.get(userPos)
                .getFollowedId().stream().noneMatch(id -> id.equals(userToUnfollowId)));
        assertTrue(userRepository.userBd.get(userToUnfollowPos)
                .getFollowersId().stream().noneMatch(id -> id.equals(userId)));
    }


    //T-0003 y T-0004 -> US-0003
    @Test
    void getAllFollowersFoundTest() {
        List<User> expectedUsersList = List.of(client1, client2);
        List<User> actualUsers = userRepository.getAllFollowers(List.of(1,2));
        assertEquals(expectedUsersList, actualUsers);
    }
    @Test
    void getAllFollowersNotFoundTest() {
        assertThrows(NotFoundException.class, () -> userRepository.getAllFollowers(List.of(1,-2)));
    }
}