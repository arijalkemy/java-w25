package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.UserDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponseDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowedDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowersDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04.exception.BadRequestException;
import com.breakingbytes.be_java_hisp_w25_g04.exception.NotFoundException;
import com.breakingbytes.be_java_hisp_w25_g04.repository.SellerRepositoryImpl;
import com.breakingbytes.be_java_hisp_w25_g04.repository.UserRepositoryImpl;
import com.breakingbytes.be_java_hisp_w25_g04.utils.FactoryUsers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    UserRepositoryImpl userRepository;
    @Mock
    SellerRepositoryImpl sellerRepository;
    @InjectMocks
    UserServiceImpl userService;

    // ------------- Tests para getUsersFollowersOf

    @Test
    @DisplayName("T-0003/getUsersFollowersOf(): Permite continuar con normalidad con el ordenamiento: name_asc")
    void getUsersFollowersOfOrderAscTestOk(){
        // Arrange
        String orderParam = "name_asc";
        Integer idUserParam = 4;
        Seller userExpected = FactoryUsers.getInstance().getSellerByName("Robert");
        // Act
        when(sellerRepository.findById(idUserParam)).thenReturn(Optional.of(userExpected));
        UserFollowersDTO response = userService.getUsersFollowersOf(idUserParam, orderParam);
        // Assert
        Assertions.assertDoesNotThrow(() -> response);
    }

    @Test
    @DisplayName("T-0003/getUsersFollowersOf(): Permite continuar con normalidad con el ordenamiento: name_desc")
    void getUsersFollowersOfOrderDescTestOk(){
        // Arrange
        String orderParam = "name_desc";
        Integer idUserParam = 4;
        Seller userExpected = FactoryUsers.getInstance().getSellerByName("Robert");
        // Act
        when(sellerRepository.findById(idUserParam)).thenReturn(Optional.of(userExpected));
        UserFollowersDTO response = userService.getUsersFollowersOf(idUserParam, orderParam);
        // Assert
        Assertions.assertDoesNotThrow(() -> response);
    }

    @Test
    @DisplayName("T-0003/getUsersFollowersOf(): Permite continuar con normalidad sin ordenamiento")
    void getUsersFollowersOfDisorderlyTestOk(){
        // Arrange
        String orderParam = "";
        Integer idUserParam = 4;
        Seller userExpected = FactoryUsers.getInstance().getSellerByName("Robert");
        // Act
        when(sellerRepository.findById(idUserParam)).thenReturn(Optional.of(userExpected));
        UserFollowersDTO response = userService.getUsersFollowersOf(idUserParam, orderParam);
        // Assert
        Assertions.assertDoesNotThrow(() -> response);
    }

    @Test
    @DisplayName("T-0003/getUsersFollowersOf(): Notifica la no existencia mediante una excepcion")
    void getUsersFollowersOfOrderTestSad(){
        // Arrange
        String orderParam = "ascendente";
        Integer idUserParam = 4;
        Seller userExpected = FactoryUsers.getInstance().getSellerByName("Robert");
        // Act
        when(sellerRepository.findById(idUserParam)).thenReturn(Optional.of(userExpected));
        // Assert
        assertThrows(BadRequestException.class, () -> userService.getUsersFollowersOf(idUserParam, orderParam));
    }

    // ------------ Test para getUsersFollowed

    @Test
    @DisplayName("T-0003/getUsersFollowed(): Permite continuar con normalidad con el ordenamiento: name_asc")
    void getUsersFollowedOrderAscTestOk(){
        // Arrange
        String orderParam = "name_asc";
        Integer idUserParam = 1;
        User userExpected = FactoryUsers.getInstance().getUserByName("Pepe");
        // Act
        when(userRepository.findById(idUserParam)).thenReturn(Optional.of(userExpected));
        when(sellerRepository.findById(idUserParam)).thenReturn(Optional.empty());
        UserFollowedDTO response = userService.getUsersFollowed(idUserParam, orderParam);
        // Assert
        Assertions.assertDoesNotThrow(() -> response);
    }

    @Test
    @DisplayName("T-0003/getUsersFollowed(): Permite continuar con normalidad con el ordenamiento: name_desc")
    void getUsersFollowedOrderDescTestOk(){
        // Arrange
        String orderParam = "name_desc";
        Integer idUserParam = 1;
        User userExpected = FactoryUsers.getInstance().getUserByName("Pepe");
        // Act
        when(userRepository.findById(idUserParam)).thenReturn(Optional.of(userExpected));
        when(sellerRepository.findById(idUserParam)).thenReturn(Optional.empty());
        UserFollowedDTO response = userService.getUsersFollowed(idUserParam, orderParam);
        // Assert
        Assertions.assertDoesNotThrow(() -> response);
    }

    @Test
    @DisplayName("T-0003/getUsersFollowed(): Permite continuar con normalidad sin ordenamiento")
    void getUsersFollowedDisorderlyTestOk(){
        // Arrange
        String orderParam = "";
        Integer idUserParam = 1;
        User userExpected = FactoryUsers.getInstance().getUserByName("Pepe");
        // Act
        when(userRepository.findById(idUserParam)).thenReturn(Optional.of(userExpected));
        when(sellerRepository.findById(idUserParam)).thenReturn(Optional.empty());
        UserFollowedDTO response = userService.getUsersFollowed(idUserParam, orderParam);
        // Assert
        Assertions.assertDoesNotThrow(() -> response);
    }

    @Test
    @DisplayName("T-0003/getUsersFollowed(): Notifica la no existencia mediante una excepcion")
    void getUsersFollowedOrderTestSad(){
        // Arrange
        String orderParam = "cualquier_cosa";
        Integer idUserParam = 1;
        User userExpected = FactoryUsers.getInstance().getUserByName("Pepe");
        // Act
        when(userRepository.findById(idUserParam)).thenReturn(Optional.of(userExpected));
        when(sellerRepository.findById(idUserParam)).thenReturn(Optional.empty());
        // Assert
        assertThrows(BadRequestException.class, () -> userService.getUsersFollowed(idUserParam, orderParam));
    }


    @Test
    @DisplayName("T-0002 - Dejar de seguir a un vendedor - OK")
    void unfollowUserTest(){
        //Arrange
        Integer userID = 1;
        Integer userToUnfollow = 2;
        User user = FactoryUsers.getInstance().createUser(userID);
        Seller sellerToUnfollow = FactoryUsers.getInstance().createSeller(userToUnfollow);
        user.addFollowing(sellerToUnfollow);
        ResponseDTO expected = new ResponseDTO("El usuario " + user.getName() + " ha dejado de seguir a: " + sellerToUnfollow.getName());

        when(userRepository.findById(userID)).thenReturn(Optional.of(user));

        //Act
        ResponseDTO actual = userService.unfollowUser(userID, userToUnfollow);

        //Assert
        verify(userRepository).findById(userID);
        verify(userRepository).setUserFollowings(userID, user.getFollowing());

        assertFalse(sellerToUnfollow.getFollowing().contains(sellerToUnfollow));
        assertEquals(expected, actual);

    }
  
    @Test
    @DisplayName("T-0002 - Dejar de seguir a un vendedor - User NotFound ")
    void unfollowUserNotUserFoundTests(){
        //Arrange
        Integer userID = 1;
        Integer userToUnfollowID = 2;

        when(userRepository.findById(userID)).thenReturn(Optional.empty());

        //Act & Assert
        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> userService.unfollowUser(userID, userToUnfollowID)
        );

        assertEquals("Usuario no encontrado.", exception.getMessage());

    }
  
    @Test
    @DisplayName("T-0002 - Dejar de seguir a un vendedor - Seller NotFound")
    void unfollowUserNotSellerFoundTests(){
        //Arrange
        Integer userID = 1;
        Integer userToUnfollowID = 2;
        User user = FactoryUsers.getInstance().createUser(userID);

        when(userRepository.findById(userID)).thenReturn(Optional.of(user));

        //Act & Assert
        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> userService.unfollowUser(userID, userToUnfollowID)
        );

        assertEquals("El usuario que se quiere dejar de seguir no fue encontrado en los seguidos.", exception.getMessage());
    }

    @Test
    @DisplayName("T-0001: Permite continuar con normalidad.")
    public void followTestOk() {
        // arrange
        Integer userId = 1;
        User user = FactoryUsers.getInstance().getUserById(userId);
        Optional<User> expectedUser = Optional.of(user);

        Integer userIdToFollow = 4;
        Seller seller = (Seller) FactoryUsers.getInstance().getSellerById(userIdToFollow);
        Optional<Seller> expectedSeller = Optional.of(seller);

        when(userRepository.findById(userId)).thenReturn(expectedUser);
        when(sellerRepository.findById(userIdToFollow)).thenReturn(expectedSeller);


        // act
        userService.follow(userId, userIdToFollow);

        // assert
        verify(userRepository, atLeastOnce()).findById(userId);
        verify(sellerRepository, atLeastOnce()).findById(userIdToFollow);
        verify(userRepository, atLeastOnce()).addFollowing(expectedUser.get(), expectedSeller.get());
        verify(sellerRepository, atLeastOnce()).addFollower(expectedSeller.get(), expectedUser.get());
    }

    @Test
    @DisplayName("T-0001: Notifica la no existencia del usuario mediante una excepción.")
    public void followTestUserNotFound() {
        // arrange
        Integer userId = 1;
        User user = FactoryUsers.getInstance().getUserById(userId);
        Optional<User> expectedUser = Optional.of(user);

        when(userRepository.findById(userId)).thenReturn(expectedUser);

        Integer userIdToFollow = 4;
        // act and assert
        Exception exception = assertThrows(NotFoundException.class, () ->
                userService.follow(userId, userIdToFollow));

        verify(userRepository, atLeastOnce()).findById(userId);
        verify(sellerRepository, atLeastOnce()).findById(userIdToFollow);
        assertEquals("Vendedor no encontrado", exception.getMessage());
    }

    @Test
    @DisplayName("T-0001: Notifica la no existencia del vendedor mediante una excepción.")
    public void followTestSellerNotFound() {
        // arrange
        Integer userId = 1;
        Integer userIdToFollow = 3;

        // act and assert
        Exception exception = assertThrows(NotFoundException.class, () ->
                userService.follow(userId, userIdToFollow));

        verify(userRepository, atLeastOnce()).findById(userId);
        verify(sellerRepository, atLeastOnce()).findById(userIdToFollow);
        assertEquals("Ususario no encontrado", exception.getMessage());
    }

    @Test
    @DisplayName("T-0001: Notifica que ya sigue a ese vendedor mediante una excepción.")
    public void followTestSellerBAdRequest() {
        // arrange
        Integer userId = 1;
        User user = FactoryUsers.getInstance().getUserById(userId);
        Optional<User> expectedUser = Optional.of(user);

        Integer userIdToFollow = 3;
        Seller seller = (Seller) FactoryUsers.getInstance().getSellerById(userIdToFollow);
        Optional<Seller> expectedSeller = Optional.of(seller);

        when(userRepository.findById(userId)).thenReturn(expectedUser);
        when(sellerRepository.findById(userIdToFollow)).thenReturn(expectedSeller);


        // act
        Exception exception = assertThrows(BadRequestException.class, () ->
                userService.follow(userId, userIdToFollow));

        // assert
        verify(userRepository, atLeastOnce()).findById(userId);
        verify(sellerRepository, atLeastOnce()).findById(userIdToFollow);
    }
  
    @Test
    @DisplayName("T-0004 Verifica el correcto ordenamiento ascendente de seguidores por nombre.")
    public void testSortedListFollowersAsc(){
        Integer idUser = 3;
        String order = "name_asc";
        Seller seller = FactoryUsers.getSellerThree();
        List<UserDTO> expectedSortedList= FactoryUsers.getSortedListAsc();

        when(sellerRepository.findById(idUser)).thenReturn(Optional.of(seller));
        List<UserDTO> usersResult = userService.getUsersFollowersOf(idUser, order).getFollowers();

        assertThat(expectedSortedList).isEqualTo(usersResult);
    }

    @Test
    @DisplayName("T-0004 Verifica el correcto ordenamiento descendente de seguidores por nombre.")
    public void testSortedListFollowersDesc(){
        Integer idUser = 3;
        String order = "name_desc";
        Seller seller = FactoryUsers.getSellerThree();
        List<UserDTO> expectedSortedList= FactoryUsers.getSortedListDesc();

        when(sellerRepository.findById(idUser)).thenReturn(Optional.of(seller));
        List<UserDTO> usersResult = userService.getUsersFollowersOf(idUser, order).getFollowers();

        assertThat(expectedSortedList).isEqualTo(usersResult);
    }

    @Test
    @DisplayName("T-0004 Verifica el correcto ordenamiento ascendente por nombre de la lista de seguidos.")
    public void testSortedListFollowedsAsc(){
        Integer idUser = 2;
        String order = "name_asc";
        User user = FactoryUsers.getUserTwo();
        List<UserDTO> expectedSortedList= FactoryUsers.getSortedListAsc();

        when(sellerRepository.findById(idUser)).thenReturn(Optional.empty());
        when(userRepository.findById(idUser)).thenReturn(Optional.of(user));

        List<UserDTO> usersResult = userService.getUsersFollowed(idUser, order).getFollowed();

        assertThat(expectedSortedList).isEqualTo(usersResult);
    }

    @Test
    @DisplayName("T-0004 Verifica el correcto ordenamiento descendente por nombre de la lista de seguidos.")
    public void testSortedListFollowedsDesc(){
        Integer idUser = 2;
        String order = "name_desc";
        User user = FactoryUsers.getUserTwo();
        List<UserDTO> expectedSortedList= FactoryUsers.getSortedListDesc();

        when(sellerRepository.findById(idUser)).thenReturn(Optional.empty());
        when(userRepository.findById(idUser)).thenReturn(Optional.of(user));

        List<UserDTO> usersResult = userService.getUsersFollowed(idUser, order).getFollowed();

        assertThat(expectedSortedList).isEqualTo(usersResult);
    }

}
