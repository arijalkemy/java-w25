package com.mercadolibre.be_java_hisp_w25_g15.service.impl;

import com.mercadolibre.be_java_hisp_w25_g15.dto.request.FollowDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.UnfollowDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountFollowersDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.MessageResponseDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserListDto;
import com.mercadolibre.be_java_hisp_w25_g15.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w25_g15.exception.OrderNotValidException;
import com.mercadolibre.be_java_hisp_w25_g15.model.Buyer;
import com.mercadolibre.be_java_hisp_w25_g15.model.Seller;
import com.mercadolibre.be_java_hisp_w25_g15.model.User;
import com.mercadolibre.be_java_hisp_w25_g15.repository.impl.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

     Optional<User> seller;
     Optional<User> sellerWithFollower;
     Optional<User> buyer;

    Optional<User> sellerWithManyFollowers;
    Optional<User> sellerWithManyFollowers2;
    Optional<User> buyerWithFollowed1;
    Optional<User> buyerWithFollowed2;

    List<User> userList;

    @BeforeEach
    void setUp(){
        buyer =  Optional.of(Buyer.builder().id(1).username("Buyer1").followed(new ArrayList<>()).build());
        seller = Optional.of(Seller.builder().id(2).username("Seller1").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        sellerWithFollower = Optional.of(Seller.builder().id(3).username("Seller with followers").followed(new ArrayList<>()).followers(new ArrayList<>(
                List.of(buyer.get())
        )).build());
        buyer.get().getFollowed().add(sellerWithFollower.get());

        buyerWithFollowed1 = Optional.of(Buyer.builder().id(4).username("Yanina").followed(new ArrayList<>()).build());
        buyerWithFollowed2 = Optional.of(Buyer.builder().id(5).username("Angel").followed(new ArrayList<>()).build());
        sellerWithManyFollowers = Optional.of(Seller.builder().id(6).username("Seller with many followers").followed(new ArrayList<>()).followers(new ArrayList<>(
                List.of(
                        buyerWithFollowed1.get(),
                        buyerWithFollowed2.get()
                )
        )).build());
        sellerWithManyFollowers2 = Optional.of(Seller.builder().id(7).username("Augusto").followed(new ArrayList<>()).followers(new ArrayList<>(
                List.of(
                        buyerWithFollowed1.get(),
                        buyerWithFollowed2.get()
                )
        )).build());
        buyerWithFollowed1.get().getFollowed().add(sellerWithManyFollowers.get());
        buyerWithFollowed1.get().getFollowed().add(sellerWithManyFollowers2.get());
        buyerWithFollowed2.get().getFollowed().add(sellerWithManyFollowers.get());
        buyerWithFollowed2.get().getFollowed().add(sellerWithManyFollowers2.get());
        userList = List.of(
                buyer.get(),
                seller.get(),
                sellerWithFollower.get(),
                sellerWithManyFollowers.get(),
                sellerWithManyFollowers2.get(),
                buyerWithFollowed1.get(),
                buyerWithFollowed2.get()
        );
    }

    //T-0002 CUMPLE
    @Test
    void unfollowSellerOK() {
        //Arrange
        Integer userId = buyer.get().getId();
        Integer userIdToUnfollow = sellerWithFollower.get().getId();
        UnfollowDto unfollowDtoParam = new UnfollowDto(userId, userIdToUnfollow);
        MessageResponseDto messageResponseDtoExpected = new MessageResponseDto("User unfollowed successfully");
        when(userRepository.getUserById(userId)).thenReturn(buyer);
        when(userRepository.getUserById(userIdToUnfollow)).thenReturn(sellerWithFollower);
        when(userRepository.removeFollower((Seller) sellerWithFollower.get(), buyer.get())).thenReturn(true);
        when(userRepository.removeFollowed(buyer.get(),(Seller) sellerWithFollower.get())).thenReturn(true);

        //Act
        MessageResponseDto messageResponseDto = this.userService.unfollowSeller(unfollowDtoParam);

        //Assert
        assertEquals(messageResponseDtoExpected.message(), messageResponseDto.message());
        verify(userRepository).removeFollower((Seller) sellerWithFollower.get(), buyer.get());
        verify(userRepository).removeFollowed(buyer.get(),(Seller) sellerWithFollower.get());
    }
    //T-0002 NO CUMPLE
    @Test
    void unfollowNotExistingSellerOK() {
        //Arrange
        Integer userId = 1;
        Integer userIdToFollow = 2;
        UnfollowDto unfollowDto = new UnfollowDto(userId, userIdToFollow);
        Optional<User> buyerEmpty = Optional.empty();

        when(userRepository.getUserById(userId)).thenReturn(buyerEmpty);
        //Act & Assert
        Assertions.assertThrows(NotFoundException.class,
                () -> userService.unfollowSeller(unfollowDto));
    }
    //T-0001 CUMPLE
    @Test
    void followSellerOK() {
        //Arrange
        Integer userId = 1;
        Integer userIdToFollow = 2;
        FollowDto followDtoParam = new FollowDto(userId, userIdToFollow);
        MessageResponseDto messageResponseDtoExpected = new MessageResponseDto("Seller followed correctly");
        when(userRepository.getUserById(userId)).thenReturn(buyer);
        when(userRepository.getUserById(userIdToFollow)).thenReturn(seller);

        //Act
        MessageResponseDto messageResponseDto = this.userService.followSeller(followDtoParam);

        //Assert
        assertEquals(messageResponseDtoExpected.message(), messageResponseDto.message());
        verify(userRepository).addFollower((Seller) seller.get(), buyer.get());
        verify(userRepository).addFollowed(buyer.get(), (Seller) seller.get());
    }
    //T-0001 NO CUMPLE
    @Test
    void followNotExistingSeller(){
        //Arrange
        Integer userId = 1;
        Integer userIdToFollow = 3;
        FollowDto followDto = new FollowDto(userId, userIdToFollow);
        Optional<User> buyerEmpty = Optional.empty();

        when(userRepository.getUserById(userId)).thenReturn(buyerEmpty);
        //Assert & Act
        Assertions.assertThrows(NotFoundException.class,
                () -> userService.followSeller(followDto));
    }
    //T-0007
    @Test
    void countFollowersByUserId() {
        //Arrange
        Integer sellerId = 3;
        String sellerName = "Seller with followers";
        Integer countExpected = 1;
        CountFollowersDto countFollowersDtoExpected = new CountFollowersDto(sellerId, sellerName, countExpected);
        when(userRepository.getUserById(3)).thenReturn(sellerWithFollower);

        //Act
        CountFollowersDto countFollowersDtoResponse = this.userService.countFollowersByUserId(sellerId);
        //Assert
        Assertions.assertEquals(countFollowersDtoExpected, countFollowersDtoResponse);
    }
    //T-0003 CUMPLE
    @Test
        void findAllSellerFollowersWithOrderAscOK() {
        //Arrange
        Integer sellerId = 6;
        String order = "name_asc";

        UserDto expected = new UserDto(sellerId, sellerWithManyFollowers.get().getUsername(),
                List.of(
                        new UserListDto(buyerWithFollowed2.get().getId(), buyerWithFollowed2.get().getUsername()),
                        new UserListDto(buyerWithFollowed1.get().getId(), buyerWithFollowed1.get().getUsername())
                ),
                null
                );
        when(userRepository.getUserById(sellerId)).thenReturn(sellerWithManyFollowers);
        //Act
        UserDto result = userService.findAllSellerFollowers(sellerId, order);
        //Assert
        Assertions.assertEquals(expected, result);
    }
    //T-0004 FOLLOWERS DESC
    @Test
    void findAllSellerFollowersWithOrderDescOK() {
        //Arrange
        Integer sellerId = 6;
        String order = "name_desc";

        UserDto expected = new UserDto(sellerId, sellerWithManyFollowers.get().getUsername(),
                List.of(
                        new UserListDto(buyerWithFollowed1.get().getId(), buyerWithFollowed1.get().getUsername()),
                        new UserListDto(buyerWithFollowed2.get().getId(), buyerWithFollowed2.get().getUsername())
                ),
                null
        );
        when(userRepository.getUserById(sellerId)).thenReturn(sellerWithManyFollowers);
        //Act
        UserDto result = userService.findAllSellerFollowers(sellerId, order);
        //Assert
        Assertions.assertEquals(expected, result);
    }

    //T-0003 NO CUMPLE
    @Test
    void findAllSellerFollowersWithOrderingNotFoundTypeOrder() {
        //Arrange
        Integer sellerId = 6;
        String differentOrder = "lastname_asc";
        //Act & Assert
        Assertions.assertThrows(OrderNotValidException.class,
                () -> userService.findAllSellerFollowers(sellerId, differentOrder));
    }
    //T-0003 NO CUMPLE
    @Test
    void findAllFollowedByUserWithOrderingNotFoundTypeOrd() {
        //Arrange
        Integer buyerId = 4;
        String differentOrder = "lastname_asc";

        //Act & Assert
        Assertions.assertThrows(OrderNotValidException.class,
                () -> userService.findAllFollowedByUser(buyerId, differentOrder));
    }
    //T-0004 FOLLOWED DESC
    @Test
    void findAllFollowedByUserWithOrderDescOk() {
        //Arrange
        Integer buyerId = 4;
        String order = "name_desc";
        UserDto expected = new UserDto(buyerId, buyerWithFollowed1.get().getUsername(),
                null,
                List.of(
                        new UserListDto(sellerWithManyFollowers.get().getId(), sellerWithManyFollowers.get().getUsername()),
                        new UserListDto(sellerWithManyFollowers2.get().getId(), sellerWithManyFollowers2.get().getUsername())
                )
        );
        when(userRepository.getUserById(buyerId)).thenReturn(buyerWithFollowed1);
        //Act
        UserDto result = userService.findAllFollowedByUser(buyerId, order);

        //Assert
        Assertions.assertEquals(expected, result);
    }

    //T-0004 FOLLOWED ASC
    @Test
    void findAllFollowedByUserWithOrderAscOk() {
        //Arrange
        Integer buyerId = 4;
        String order = "name_asc";
        UserDto expected = new UserDto(buyerId, buyerWithFollowed1.get().getUsername(),
                null,
                List.of(
                        new UserListDto(sellerWithManyFollowers2.get().getId(), sellerWithManyFollowers2.get().getUsername()),
                        new UserListDto(sellerWithManyFollowers.get().getId(), sellerWithManyFollowers.get().getUsername())

                )
        );
        when(userRepository.getUserById(buyerId)).thenReturn(buyerWithFollowed1);
        //Act
        UserDto result = userService.findAllFollowedByUser(buyerId, order);

        //Assert
        Assertions.assertEquals(expected, result);
    }


    //*T005 Adicional NO CUMPLE :D
    @Test
    void findAllEmpty() {
        // Act & Assert
        Assertions.assertThrows(NotFoundException.class,
                () -> userService.findAll());
    }

    @Test
    void findAll() {
        // arrange
        List<UserListDto> userListDtosExpected = List.of(
                new UserListDto(buyer.get().getId(), buyer.get().getUsername()),
                new UserListDto(seller.get().getId(), seller.get().getUsername()),
                new UserListDto(sellerWithFollower.get().getId(), sellerWithFollower.get().getUsername()),
                new UserListDto(sellerWithManyFollowers.get().getId(), sellerWithManyFollowers.get().getUsername()),
                new UserListDto(sellerWithManyFollowers2.get().getId(), sellerWithManyFollowers2.get().getUsername()),
                new UserListDto(buyerWithFollowed1.get().getId(), buyerWithFollowed1.get().getUsername()),
                new UserListDto(buyerWithFollowed2.get().getId(), buyerWithFollowed2.get().getUsername())
        );

        // act
        when(userRepository.getAllUsers()).thenReturn(userList);
        List<UserListDto> userListDtosResult = this.userService.findAll();

        // assert
        assertEquals(userListDtosExpected, userListDtosResult);

    }
}