package com.socialMeli.service;

import com.socialMeli.dto.response.FollowedListDto;
import com.socialMeli.dto.response.UserVendorDto;
import com.socialMeli.dto.response.MessageDto;
import com.socialMeli.dto.response.VendorFollowCountDto;
import com.socialMeli.entity.User;
import com.socialMeli.entity.UserType;
import com.socialMeli.exception.InvalidDataException;
import com.socialMeli.exception.NotFoundException;
import com.socialMeli.exception.UserFollowException;
import com.socialMeli.exception.UserIsNotVendorException;
import com.socialMeli.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static com.socialMeli.entity.UserType.CLIENT;
import static com.socialMeli.entity.UserType.VENDOR;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    IUserRepository userRepository;
    @InjectMocks
    UserService userService;
    User vendorUser;
    User clientUser;
    User clientUser2;
    List<User> usuariosArrange;
    List<UserVendorDto> usuariosArrangeOrderAsc;
    List<UserVendorDto> usuariosArrangeOrderDesc;
    List<UserVendorDto> usuariosArrangeOrderNull;
    private ArrayList<UserVendorDto> usuariosArrangeFollowedOrderNull;

    static Stream<Arguments> validFollowersValues() {
        return Stream.of(Arguments.of("name_asc"), Arguments.of("name_desc"), null);
    }

    @BeforeEach
    void setUp() {
        vendorUser = new User(1, "agustin", List.of(2, 3), List.of(2), VENDOR);
        clientUser = new User(2, "diego", List.of(), List.of(1, 3), CLIENT);
        clientUser2 = new User(4, "diego", List.of(), List.of(), CLIENT);

        usuariosArrange = List.of(clientUser,
                new User(3, "facundo", List.of(), List.of(1), CLIENT),
                new User(4, "fabian", List.of(), List.of(1), CLIENT));

        usuariosArrangeOrderNull = new ArrayList<>(List.of(new UserVendorDto(2, "diego"),
                new UserVendorDto(3, "facundo"),
                new UserVendorDto(4, "fabian")));

        usuariosArrangeFollowedOrderNull = new ArrayList<>(List.of(new UserVendorDto(1, "agustin")));


        usuariosArrangeOrderAsc = new ArrayList<>(List.of(new UserVendorDto(2, "diego"),
                new UserVendorDto(4, "fabian"),
                new UserVendorDto(3, "facundo")));

        usuariosArrangeOrderDesc = new ArrayList<>(List.of(new UserVendorDto(3, "facundo"),
                new UserVendorDto(4, "fabian"),
                new UserVendorDto(2, "diego")));

        when(userRepository.findUserByUserId(anyInt())).thenReturn(Optional.of(vendorUser));
    }

    @Test
    void newFollowTestOK() {
        //ARRANGE
        MessageDto expectedMessage = new MessageDto("Comenzaste a seguir al usuario agustin");
        when(userRepository.findUserByUserId(4)).thenReturn(Optional.of(clientUser2));
        when(userRepository.findUserByUserId(1)).thenReturn(Optional.of(vendorUser));
        //ACT
        MessageDto actualMessageDto = userService.newFollow(4, 1);
        //ASSERT
        verify(userRepository).followUser(any(User.class), any(User.class));
        assertEquals(expectedMessage, actualMessageDto);
    }
    @Test
    void newFollowTestThrowUserFollowException () {
        //ARRANGE
        MessageDto expectedMessage = new MessageDto("Ya sigues a este usuario");
        when(userRepository.findUserByUserId(2)).thenReturn(Optional.of(clientUser));
        when(userRepository.findUserByUserId(1)).thenReturn(Optional.of(vendorUser));
        //ASSERT
        assertThrows(UserFollowException.class, () -> userService.newFollow(2, 1));
    }

    @Test
    void getFollowerCountOkTest() {
        VendorFollowCountDto expectedVendorFollowerCount = new VendorFollowCountDto(vendorUser);
        VendorFollowCountDto vendorFollowCountDto = userService.getFollowerCount(1);
        assertEquals(expectedVendorFollowerCount, vendorFollowCountDto);
    }

    @Test
    void getFollowerCountUserNotFoundTest() {
        when(userRepository.findUserByUserId(anyInt())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> userService.getFollowerCount(0));
    }

    @Test
    void getFollowerCountUserNotVendorTest() {
        when(userRepository.findUserByUserId(anyInt())).thenReturn(Optional.of(clientUser));
        assertThrows(UserIsNotVendorException.class, () -> userService.getFollowerCount(2));
    }

    //T-0003 y T-0004 -> US-0003
    @ParameterizedTest
    @MethodSource("validFollowersValues")
    void getVendorFollowersOrderNullOk(String order) {
        //Arrange
        FollowedListDto expectedFollowedList;
        if (order == null) {
            expectedFollowedList = new FollowedListDto(1, "agustin", usuariosArrangeOrderNull);
        } else if (order.equalsIgnoreCase("name_asc")) {
            expectedFollowedList = new FollowedListDto(1, "agustin", usuariosArrangeOrderAsc);
        } else {
            expectedFollowedList = new FollowedListDto(1, "agustin", usuariosArrangeOrderDesc);
        }
        when(userRepository.getAllFollowers(any())).thenReturn(usuariosArrange);
        FollowedListDto actual = userService.getVendorFollowers(1, order);   //act
        assertEquals(expectedFollowedList, actual);                                 //assertion
    }

    @Test
    void getVendorFollowersNotFoundTest() {
        when(userRepository.findUserByUserId(anyInt())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> userService.getVendorFollowers(0, null));
    }

    @Test
    void getVendorFollowersUserNotVendorTest() {
        when(userRepository.findUserByUserId(anyInt())).thenReturn(Optional.of(clientUser));
        assertThrows(UserIsNotVendorException.class, () -> userService.getVendorFollowers(2, null));
    }

    @Test
    void getVendorFollowersInvalidDataExceptionTest() {
        when(userRepository.getAllFollowers(any())).thenReturn(new ArrayList<>());
        assertThrows(InvalidDataException.class, () -> userService.getVendorFollowers(2, "flsdmfr"));
    }

    @Test
    void unfollowUserOkTest () {
        MessageDto expectedMessageDto = new MessageDto("Dejaste de seguir a diego");
        when(userRepository.findUserByUserId(2)).thenReturn(Optional.of(clientUser));
        MessageDto actualMessageDto = userService.unfollowUser(1, 2);
        verify(userRepository).unfollowUser(any(User.class), any(User.class));
        assertEquals(expectedMessageDto, actualMessageDto);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void unfollowNotFoundUserTest (Integer userId){
        when(userRepository.findUserByUserId(userId)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> userService.unfollowUser(1, 2));
    }
    @Test
    void unfollowUserIsNotInFollowersListTest () {
        vendorUser = new User(1, "agustin", List.of(2, 3), List.of(), VENDOR);
        when(userRepository.findUserByUserId(1)).thenReturn(Optional.of(vendorUser));
        assertThrows(UserFollowException.class, () -> userService.unfollowUser(1, 2));
    }
    @Test
    void getFollowedListNoOrderTest() {
        //Arrange
        Integer userId = 2;
        FollowedListDto expected = new FollowedListDto(2,"diego",usuariosArrangeFollowedOrderNull);


        //Act

        when(userRepository.findUserByUserId(2)).thenReturn(Optional.of(clientUser));
        when(userRepository.findUserByUserId(1)).thenReturn(Optional.of(vendorUser));
        when(userRepository.findUserByUserId(3)).thenReturn(Optional.of(new User(3, "luis", new ArrayList<>(), List.of(), UserType.CLIENT)));

        FollowedListDto followedListDto = userService.getFollowedList(userId, null);

        Assertions.assertEquals(expected,followedListDto);

    }

    @Test
    void getFollowedListAscOrderTest() {
        //Arrange
        Integer userId = 2;
        FollowedListDto expected = new FollowedListDto(2,"diego",usuariosArrangeFollowedOrderNull);


        //Act

        when(userRepository.findUserByUserId(2)).thenReturn(Optional.of(clientUser));
        when(userRepository.findUserByUserId(1)).thenReturn(Optional.of(vendorUser));
        when(userRepository.findUserByUserId(3)).thenReturn(Optional.of(new User(3, "luis", new ArrayList<>(), List.of(), UserType.CLIENT)));

        FollowedListDto followedListDto = userService.getFollowedList(userId, "name_asc");

        Assertions.assertEquals(expected,followedListDto);

    }

    @Test
    void getFollowedListDescOrderTest() {
        //Arrange
        Integer userId = 2;
        FollowedListDto expected = new FollowedListDto(2,"diego",usuariosArrangeFollowedOrderNull);


        //Act

        when(userRepository.findUserByUserId(2)).thenReturn(Optional.of(clientUser));
        when(userRepository.findUserByUserId(1)).thenReturn(Optional.of(vendorUser));
        when(userRepository.findUserByUserId(3)).thenReturn(Optional.of(new User(3, "luis", new ArrayList<>(), List.of(), UserType.CLIENT)));

        FollowedListDto followedListDto = userService.getFollowedList(userId, "name_desc");

        Assertions.assertEquals(expected,followedListDto);

    }

    @Test
    void getFollowedListUserNotFoundTest() {
        //Arrange

        //Act

        when(userRepository.findUserByUserId(2)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class,()->userService.getFollowedList(2, "name_desc"));

    }

    @Test
    void getFollowedListFollowUserNotFoundTest() {
        //Arrange

        //Act

        when(userRepository.findUserByUserId(2)).thenReturn(Optional.of(clientUser));
        when(userRepository.findUserByUserId(1)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class,()->userService.getFollowedList(2, "name_desc"));

    }

    @Test
    void getFollowedListOrderNotValidTest() {
        //Arrange

        //Act

        when(userRepository.findUserByUserId(anyInt())).thenReturn(Optional.of(clientUser));

        Assertions.assertThrows(InvalidDataException.class,()->userService.getFollowedList(2, "name_up"));

    }

}