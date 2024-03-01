package com.bootcamp.be_java_hisp_w25_g9.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.bootcamp.be_java_hisp_w25_g9.dto.UserDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowersDto;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.NoUsersFoundException;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g9.model.Client;
import com.bootcamp.be_java_hisp_w25_g9.model.Seller;
import com.bootcamp.be_java_hisp_w25_g9.model.User;
import com.bootcamp.be_java_hisp_w25_g9.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  UserRepository userRepository;

  @InjectMocks
  UserService userService;

  Client client1;
  Client client2;
  Client client3;
  Client client4;
  Client client5;
  Client client6;

  Seller seller1;
  Seller seller2;
  Seller seller3;

  private static Client client;
  private static List<User> userList;
  private static Seller seller;

  @BeforeEach
  void setUp() {
    client = new Client(2, "p");
    client1 = new Client(1, "Quynn Nunez");
    client2 = new Client(2, "Zena Pastor");
    client3 = new Client(3, "Sylvia Catalina");
    client4 = new Client(4, "Macon Vera");
    client5 = new Client(5, "Lucia Arvizu");
    client6 = new Client(6, "Alexander Lozano");


    seller = new Seller(1, "a");
    seller1 = new Seller(26, "Chase Sanchez");
    seller2 = new Seller(27, "Darren Mendoza");
    seller3 = new Seller(28, "Kamal Alvarado");

    client1.setFollowed(List.of(seller1, seller2));
    client2.setFollowed(List.of(seller1, seller2));
    client3.setFollowed(List.of(seller1, seller2));
    client4.setFollowed(List.of(seller1, seller2));
    client.setFollowed(List.of(seller,
        new Seller(3, "b"),
        new Seller(4, "c"),
        new Seller(5, "d"),
        new Seller(6, "e")
    ));
    userList = List.of(client, client2, client3, client4);

  }

  @Test
  void followOk() {

    //Arrange
    int id = 1;
    int idToFollow = 26;
    Client testUser = new Client(id, "TestUser");
    Seller testSeller = new Seller(id, "TestSeller");
    when(userRepository.userExists(anyInt())).thenReturn(true, true);
    when(userRepository.getUserById(any())).thenReturn(testSeller, testUser, testSeller);
    doNothing().when(userRepository).save(any());
    MessageDto expected = new MessageDto("Vendedor seguido con éxito");
    //Act
    MessageDto result = userService.follow(id, idToFollow);
    //Assert
    assertEquals(expected, result);

  }

  @Test
  void followAlreadyFollowed() {

    //Arrange
    int id = 1;
    int idToFollow = 26;
    Client testUser = new Client(id, "TestUser");
    Seller testSeller = new Seller(idToFollow, "TestSeller");
    testUser.getFollowed().add(testSeller);
    when(userRepository.userExists(anyInt())).thenReturn(true, true);
    when(userRepository.getUserById(any())).thenReturn(testSeller, testUser, testSeller);
    //Act Assert
    assertThrows(BadRequestException.class, () -> userService.follow(id, idToFollow));

  }

  @Test
  void followSellerNotClient() {

    //Arrange
    int id = 1;
    int idToFollow = 26;
    Client testUser = new Client(id, "TestUser");
    when(userRepository.userExists(anyInt())).thenReturn(true, true);
    when(userRepository.getUserById(any())).thenReturn(testUser);
    //Act Assert
    assertThrows(BadRequestException.class, () -> userService.follow(id, idToFollow));

  }

  @Test
  void followSameIdBothParams() {

    //Arrange
    int id = 1;
    int idToFollow = 1;
    //Act Assert
    assertThrows(BadRequestException.class,() -> userService.follow(id, idToFollow));

  }

  @Test
  void followFollowerNotFound() {

    //Arrange
    int id = 1;
    int idToFollow = 26;
    when(userRepository.userExists(anyInt())).thenReturn(false);
    //Act Assert
    assertThrows(BadRequestException.class,() -> userService.follow(id, idToFollow));

  }

  @Test
  void followFollowedNotFound() {

    //Arrange
    int id = 1;
    int idToFollow = 26;
    when(userRepository.userExists(anyInt())).thenReturn(true, false);
    //Act Assert
    assertThrows(BadRequestException.class,() -> userService.follow(id, idToFollow));
  }

  @Test
  void unfollowOK() {
    //ARRANGE
    int idClient = 1;
    int idSeller = 2;
    Client client = new Client(idClient,"TestClient");
    Seller seller = new Seller(idSeller,"TestSeller");
    List<Seller> followedList = client.getFollowed();
    followedList.add(seller);

    MessageDto messageDtoExpected = new MessageDto("El vendedor ha sido quitado de la lista de seguidos del cliente");
    MessageDto messageDtoResult;

    when(userRepository.userExists(anyInt())).thenReturn(true);
    when(userRepository.getUserById(anyInt())).thenReturn(client,seller);

    //ACT
    messageDtoResult = userService.unfollow(idClient,idSeller);

    //ASSERT
    assertEquals(messageDtoExpected,messageDtoResult);
  }
  @Test
  void unfollowMyself() {
    //ARRANGE
    int idClient = 1;
    int idSeller = 1;

    //ACT & ASSERT
    assertThrows(BadRequestException.class,()->userService.unfollow(idClient,idSeller));
  }
  @Test
  void unfollowClientNoExists() {
    //ARRANGE
    int idClient = 1;
    when(userRepository.userExists(idClient)).thenReturn(false);

    //ACT & ASSERT
    assertThrows(BadRequestException.class,()->userService.unfollow(idClient,anyInt()));
  }
  @Test
  void unfollowSellerNoExists() {
    //ARRANGE
    int idSeller = 2;
    when(userRepository.userExists(anyInt())).thenReturn(true,false);

    //ACT & ASSERT
    assertThrows(BadRequestException.class,()->userService.unfollow(anyInt(),idSeller));
  }
  @Test
  void unfollowSellerUnfollowed() {
    //ARRANGE
    int idClient = 1;
    int idSeller = 2;
    Client client = new Client(idClient,"TestClient");
    Seller seller = new Seller(idSeller,"TestSeller");

    when(userRepository.userExists(anyInt())).thenReturn(true);
    when(userRepository.getUserById(anyInt())).thenReturn(client,seller);

    //ACT & ASSERT
    assertThrows(BadRequestException.class,()->userService.unfollow(anyInt(),idSeller));
  }

  @Test
  void getFollowersCount(){
    //ARRANGE
    int idSeller = 4;

    Seller seller = new Seller(idSeller, "TestSeller");
    Client client = new Client(1, "TestClient");
    Client client2 = new Client(2, "TestClient2");
    Client client3 = new Client(3, "TestClient3");

    client.getFollowed().add(seller);
    client2.getFollowed().add(seller);
    client3.getFollowed().add(seller);

    List<User> userList = new ArrayList<>(List.of(seller, client, client2, client3));

    FollowersCountDto followersCountDtoExpected = new FollowersCountDto(idSeller, "TestSeller", 3);
    FollowersCountDto followersCountDtoResult;

    when(userRepository.findAll()).thenReturn(userList);

    //ACT
    followersCountDtoResult = userService.getFollowersCount(idSeller);

    //ASSERT
    assertEquals(followersCountDtoExpected,followersCountDtoResult);
  }
  @Test
  void getFollowersCountListIsEmpty(){
    //ARRANGE
    int idSeller = 4;

    Seller seller = new Seller(idSeller,"TestSeller");
    Client client = new Client(1,"TestClient");
    Client client2 = new Client(2,"TestClient2");
    Client client3 = new Client(3,"TestClient3");


    List<User> userList = new ArrayList<>(List.of(seller,client,client2,client3));

    when(userRepository.findAll()).thenReturn(userList);

    //ACT & ASSERT
    assertThrows(NotFoundException.class,()->userService.getFollowersCount(idSeller));
  }

  @Test
  void getFollowedAsc() {

    //Arrange
    int clientId = 1;
    String order = "name_asc";

    //Act Assert
    when(userRepository.getUserById(anyInt())).thenReturn(client);
    Assertions.assertNotNull(userService.getFollowed(clientId, order));
    Assertions.assertNotEquals(0, userService.getFollowed(clientId, order).followed().size());
  }

  @Test
  void getFollowedDesc() {

    //Arrange
    int clientId = 1;
    String order = "name_desc";

    //Act Assert
    when(userRepository.getUserById(anyInt())).thenReturn(client);
    Assertions.assertNotNull(userService.getFollowed(clientId, order));
    Assertions.assertNotEquals(0, userService.getFollowed(clientId, order).followed().size());
  }

  @Test
  void getFollowersAscName() {

    //Arrange
    int sellerId = 1;
    String order = "name_asc";
    when(userRepository.getUserById(sellerId)).thenReturn(seller);
    when(userRepository.findAll()).thenReturn(userList);

    //Act Assert
    Assertions.assertNotNull(userService.getFollowers(sellerId, order));
    Assertions.assertNotEquals(0, userService.getFollowers(sellerId, order).followed().size());
  }

  @Test
  void getFollowersDescName() {

    //Arrange
    int sellerId = 1;
    String order = "name_desc";
    when(userRepository.getUserById(sellerId)).thenReturn(seller);
    when(userRepository.findAll()).thenReturn(userList);

    //Act Assert
    Assertions.assertNotNull(userService.getFollowers(sellerId, order));
    Assertions.assertNotEquals(0, userService.getFollowers(sellerId, order).followed().size());
  }

  @Test
  void getErrorOrderName(){

    //Arrange
    int clientId = 1;
    String order = "name";

    //Act Assert
    Assertions.assertThrows(BadRequestException.class, ()->userService.getFollowed(clientId, order));
  }

  @Test
  void getFollowersInAscendingOrderOk() {
    // ARRANGE
    int sellerId = seller1.getUserId();
    FollowersDto expectedAscFollowersDto = new FollowersDto(
        seller1.getUserId(),
        seller1.getUserName(),
        new ArrayList<UserDto>(List.of(
            new UserDto(client4.getUserId(), client4.getUserName()), // M Q S Z -> 4 1 3 2
            new UserDto(client1.getUserId(), client1.getUserName()),
            new UserDto(client3.getUserId(), client3.getUserName()),
            new UserDto(client2.getUserId(), client2.getUserName())
        ))
    );

    when(userRepository.getUserById(sellerId)).thenReturn(seller1);
    when(userRepository.findAll()).thenReturn(List.of(client1, client2, client3, client4, client5, client6, seller1, seller2, seller3));

    // ACT
    FollowersDto resultAscFollowersDto = userService.getFollowers(sellerId, "name_asc");

    // ASSERT
    assertEquals(expectedAscFollowersDto, resultAscFollowersDto);
  }

  @Test
  void getFollowersInDescendingOrderOk() {
    // ARRANGE
    FollowersDto expectedDescFollowersDto = new FollowersDto(
        seller2.getUserId(),
        seller2.getUserName(),
        new ArrayList<UserDto>(List.of(
            new UserDto(client2.getUserId(), client2.getUserName()), // Z S Q M -> 2 3 1 4
            new UserDto(client3.getUserId(), client3.getUserName()),
            new UserDto(client1.getUserId(), client1.getUserName()),
            new UserDto(client4.getUserId(), client4.getUserName())
        ))
    );

    when(userRepository.getUserById((int) seller2.getUserId())).thenReturn(seller2);
    when(userRepository.findAll()).thenReturn(List.of(client1, client2, client3, client4, client5, client6, seller1, seller2, seller3));

    // ACT
    FollowersDto resultDescFollowersDto = userService.getFollowers((int) seller2.getUserId(), "name_desc");

    // ASSERT
    assertEquals(expectedDescFollowersDto, resultDescFollowersDto);
  }

  @Test
  void ThrowSellerNotFoundWhenFindFollowers() {
    // ARRANGE
    int userId = 26;
    when(userRepository.getUserById(userId)).thenReturn(null);
    // ACT
    // ASSERT
    assertThrows(NoUsersFoundException.class, () -> userService.getFollowers(userId, "name_asc"));
  }

  @Test
  void ThrowUserIsNotSellerWhenFindFollowers() {
    // ARRANGE
    int clientId = client1.getUserId();
    when(userRepository.getUserById(clientId)).thenReturn(client1);
    // ACT
    // ASSERT
    assertThrows(BadRequestException.class, () -> userService.getFollowers(clientId, "name_asc"));
  }

  @Test
  void ThrowSellerDontHaveFollowersWhenFindFollowers() {
    int userId = seller1.getUserId();

    // ARRANGE
    when(userRepository.getUserById(userId)).thenReturn(seller1);
    when(userRepository.findAll()).thenReturn(List.of());
    // ACT
    // ASSERT
    assertThrows(NoUsersFoundException.class, () -> userService.getFollowers(userId, "name_asc"));
  }

  // Followed
  @Test
  void getFollowedInAscendingOrderOk() {
    // ARRANGE
    int clientId = client1.getUserId();
    FollowedDto expectedAscFollowedDto = new FollowedDto(
        client1.getUserId(),
        client1.getUserName(),
        new ArrayList<UserDto>(List.of(
            new UserDto(seller1.getUserId(), seller1.getUserName()),
            new UserDto(seller2.getUserId(), seller2.getUserName())
        ))
    );

    when(userRepository.getUserById(clientId)).thenReturn(client1);

    // ACT
    FollowedDto resultAscFollowedDto = userService.getFollowed(clientId, "name_asc");

    // ASSERT
    assertEquals(expectedAscFollowedDto, resultAscFollowedDto);
  }

  @Test
  void getFollowedInDescendingOrderOk() {
    // ARRANGE
    int clientId = client1.getUserId();
    FollowedDto expectedDescFollowedDto = new FollowedDto(
        client1.getUserId(),
        client1.getUserName(),
        new ArrayList<UserDto>(List.of(
            new UserDto(seller2.getUserId(), seller2.getUserName()),
            new UserDto(seller1.getUserId(), seller1.getUserName())
        ))
    );

    when(userRepository.getUserById(clientId)).thenReturn(client1);

    // ACT
    FollowedDto resultDescFollowedDto = userService.getFollowed(clientId, "name_desc");

    // ASSERT
    assertEquals(expectedDescFollowedDto, resultDescFollowedDto);
  }

  @Test
  void ThrowUserNotFoundWhenFindFollowed() {
    // ARRANGE
    when(userRepository.getUserById(anyInt())).thenReturn(null);
    // ACT
    // ASSERT
    assertThrows(NotFoundException.class, () -> userService.getFollowed(anyInt(), "name_asc"));
  }

  @Test
  void ThrowUserDontHaveFollowed() {
    int clientId = client5.getUserId();
    // ARRANGE
    when(userRepository.getUserById(anyInt())).thenReturn(client5);
    // ACT
    // ASSERT
    assertThrows(NoUsersFoundException.class, () -> userService.getFollowed(clientId, "name_asc"));
  }
}