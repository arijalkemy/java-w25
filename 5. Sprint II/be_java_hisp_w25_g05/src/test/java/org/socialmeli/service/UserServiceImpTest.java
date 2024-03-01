package org.socialmeli.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.socialmeli.dto.request.*;
import org.socialmeli.dto.response.*;
import org.socialmeli.entity.Client;
import org.socialmeli.entity.Vendor;
import org.socialmeli.exception.BadRequestException;
import org.socialmeli.exception.NotFoundException;
import org.socialmeli.repository.implementation.ClientRepositoryImp;
import org.socialmeli.repository.implementation.VendorRepositoryImp;
import org.socialmeli.service.implementation.UsersServiceImp;
import org.socialmeli.util.ObjectFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceImpTest {

    @Mock
    ClientRepositoryImp clientRepositoryImp;

    @Mock
    VendorRepositoryImp vendorRepositoryImp;

    @InjectMocks
    UsersServiceImp userServiceImp;

    ObjectFactory objectFactory = new ObjectFactory();

    // T_0001 & US_0001
    @Test
    @DisplayName("[T-0001] -> [US_0001] Happy path: Client follows existing vendor")
    void followUserOkTest() {
        // Arrange
        Client client = objectFactory.getValidClient();
        Vendor vendor = objectFactory.getValidVendor();
        Integer userId = client.getUserId();
        Integer userIdToFollow = vendor.getUserId();
        UserFollowVendorDto userFollowVendorDto = new UserFollowVendorDto(userId, userIdToFollow);

        when(clientRepositoryImp.findOne(userId)).thenReturn(client);
        when(vendorRepositoryImp.findOne(userIdToFollow)).thenReturn(vendor);

        // Act
        userServiceImp.userFollowVendor(userFollowVendorDto);

        // Assert
        verify(clientRepositoryImp, atLeastOnce()).findOne(userId);
        verify(vendorRepositoryImp, atLeastOnce()).findOne(userIdToFollow);
    }

    // T_0001 & US_0001
    @Test
    @DisplayName("[T-0001] -> [US_0001] Happy path: Vendor follows existing vendor")
    void vendorFollowUserOkTest() {
        // Arrange
        Vendor vendor1 = objectFactory.getValidVendor();
        Vendor vendor2 = objectFactory.getValidVendor2();
        Integer userId = vendor1.getUserId();
        Integer userIdToFollow = vendor2.getUserId();
        UserFollowVendorDto userFollowVendorDto = new UserFollowVendorDto(userId, userIdToFollow);

        when(clientRepositoryImp.findOne(userId)).thenReturn(null);

        when(vendorRepositoryImp.findOne(userId)).thenReturn(vendor1);
        when(vendorRepositoryImp.findOne(userIdToFollow)).thenReturn(vendor2);

        // Act
        userServiceImp.userFollowVendor(userFollowVendorDto);

        // Assert
        verify(vendorRepositoryImp, atLeastOnce()).findOne(userId);
        verify(vendorRepositoryImp, atLeastOnce()).findOne(userIdToFollow);
    }

    // T_0001 & US_0001
    @Test
    @DisplayName("[T-0001] -> [US_0001] Sad path: User follows non-existing vendor")
    void vendorFollowsNonExistingUserTest() {
        // Arrange
        Client client = objectFactory.getValidClient();
        Integer userId = client.getUserId();
        Integer userIdToFollow = objectFactory.getInvalidUserId();
        UserFollowVendorDto userFollowVendorDto = new UserFollowVendorDto(userId, userIdToFollow);

        when(clientRepositoryImp.findOne(userId)).thenReturn(client);

        // Act & Assert
        assertThrows(
                NotFoundException.class,
                () -> userServiceImp.userFollowVendor(userFollowVendorDto),
                "El vendedor no existe"
        );
    }

    // T_0001 & US_0001
    @Test
    @DisplayName("[T-0001] -> [US_0001] Sad path: User follows himself")
    void userFollowsHimselfTest() {
        // Arrange
        Client client = objectFactory.getValidClient();
        Integer userId = client.getUserId();
        UserFollowVendorDto userFollowVendorDto = new UserFollowVendorDto(userId, userId);

        // Act & Assertc
        assertThrows(
                BadRequestException.class,
                () -> userServiceImp.userFollowVendor(userFollowVendorDto),
                "Un usuario no se puede seguir a si mismo"
        );
    }

    // T_0001 & US_0001
    @Test
    @DisplayName("[T-0001] -> [US_0001] Sad path: Vendor already followed")
    void vendorAlreadyFollowedTest() {
        // Arrange
        Client client = objectFactory.getValidClientFollowingVendor();
        Vendor vendor = client.getFollowing().get(0);
        Integer userId = client.getUserId();
        Integer userIdToFollow = vendor.getUserId();
        UserFollowVendorDto userFollowVendorDto = new UserFollowVendorDto(userId, userIdToFollow);

        when(clientRepositoryImp.findOne(userId)).thenReturn(client);
        when(vendorRepositoryImp.findOne(userIdToFollow)).thenReturn(vendor);

        // Act & Assert
        assertThrows(
                BadRequestException.class,
                () -> userServiceImp.userFollowVendor(userFollowVendorDto),
                "Ya se esta siguiendo al vendedor."
        );
    }

    // T_0002 & US_0007
    @Test
    @DisplayName("[T-0002] -> [US_0007] Happy path: Client unfollows vendor")
    void clientUnfollowVendorOkTest() {
        // Arrange
        Client mockClient = objectFactory.getValidClientFollowingVendor();
        Vendor mockVendor = mockClient.getFollowing().get(0);
        Integer userId = mockClient.getUserId();
        Integer userIdToUnfollow = mockVendor.getUserId();

        UserUnfollowVendorDto inputDto = new UserUnfollowVendorDto(userId, userIdToUnfollow);
        MessageDto expected = new MessageDto("El usuario con id " + userId + " ha dejado de seguir al vendedor con id " + userIdToUnfollow);

        when(clientRepositoryImp.findOne(userId)).thenReturn(mockClient);
        when(vendorRepositoryImp.findOne(userIdToUnfollow)).thenReturn(mockVendor);

        // Act
        MessageDto response = userServiceImp.unfollowVendor(inputDto);

        // Assert
        assertEquals(expected, response);
    }

    // T_0002 & US_0007
    @Test
    @DisplayName("[T-0002] -> [US_0007] Happy path: Vendor unfollows vendor")
    void vendorUnfollowVendorOkTest() {
        // Arrange
        Vendor mockFollower = objectFactory.getValidVendorFollowingVendor();
        Vendor mockVendorToUnfollow = mockFollower.getFollowing().get(0);
        Integer userId = mockFollower.getUserId();
        Integer userIdToUnfollow = mockVendorToUnfollow.getUserId();

        UserUnfollowVendorDto inputDto = new UserUnfollowVendorDto(userId, userIdToUnfollow);
        MessageDto expected = new MessageDto("El usuario con id " + userId + " ha dejado de seguir al vendedor con id " + userIdToUnfollow);

        when(clientRepositoryImp.findOne(userId)).thenReturn(null);
        when(vendorRepositoryImp.findOne(userId)).thenReturn(mockFollower);
        when(vendorRepositoryImp.findOne(userIdToUnfollow)).thenReturn(mockVendorToUnfollow);

        // Act
        MessageDto response = userServiceImp.unfollowVendor(inputDto);

        // Assert
        assertEquals(expected, response);
    }

    // T_0002 & US_0007
    @Test
    @DisplayName("[T-0002] -> [US_0007] Sad path: Client unfollows a non existing vendor")
    void clientUnfollowNonExistingVendorTest() {
        // Arrange
        Client mockClient = objectFactory.getValidClientFollowingVendor();
        Integer userId = mockClient.getUserId();
        Integer userIdToUnfollow = objectFactory.getInvalidUserId();

        UserUnfollowVendorDto inputDto = new UserUnfollowVendorDto(userId, userIdToUnfollow);

        when(clientRepositoryImp.findOne(userId)).thenReturn(mockClient);
        when(vendorRepositoryImp.findOne(userIdToUnfollow)).thenReturn(null);

        // Act & Assert
        assertThrows(NotFoundException.class,
                () -> userServiceImp.unfollowVendor(inputDto),
                "El vendedor no existe");
    }

    // T_0002 & US_0007
    @Test
    @DisplayName("[T-0002] -> [US_0007] Sad path: Client unfollows himself")
    void clientCantUnfollowHimselfTest() {
        // Arrange
        Integer userId = objectFactory.getValidUserId();
        UserUnfollowVendorDto inputDto = new UserUnfollowVendorDto(userId, userId);

        // Act & Assert
        assertThrows(BadRequestException.class,
                () -> userServiceImp.unfollowVendor(inputDto),
                "Error: Ambos id son identicos");
    }

    // T_0002 & US_0007
    @Test
    @DisplayName("[T-0002] -> [US_0007] Sad path: Client can't unfollow an unfollowed vendor")
    void clientCantUnfollowUnfollowedVendorTest() {
        // Arrange
        Client mockClient = objectFactory.getValidClient();
        Vendor mockVendor = objectFactory.getValidVendor();
        UserUnfollowVendorDto inputDto = new UserUnfollowVendorDto(mockClient.getUserId(), mockVendor.getUserId());

        when(clientRepositoryImp.findOne(mockClient.getUserId())).thenReturn(mockClient);
        when(vendorRepositoryImp.findOne(mockVendor.getUserId())).thenReturn(mockVendor);

        // Act & Assert
        assertThrows(BadRequestException.class,
                () -> userServiceImp.unfollowVendor(inputDto),
                "Error: El usuario con id " + mockClient.getUserId() + " no está siguiendo al vendedor con id " + mockVendor.getUserId());
    }

    // T_0003 & US_0003 & US_0008
    @Test
    @DisplayName("[T_0003] -> [US_0003] & [US_0008] Sad path: No se acepta un ordenamiento inválido al obtener lista de seguidores")
    void followersListInvalidOrder() {
        // Arrange
        Vendor vendor = objectFactory.getValidVendor();

        Integer idVendedorValido = vendor.getUserId();
        String ordenamientoInvalido = objectFactory.getInvalidOrder();
        FollowersListReqDto serviceRequest = new FollowersListReqDto(idVendedorValido, ordenamientoInvalido);

        String expectedErrorMessage = "El ordenamiento pedido es inválido";

        // Act and Assert
        BadRequestException actualException = assertThrows(
                BadRequestException.class,
                () -> userServiceImp.getFollowersList(serviceRequest),
                "No se arrojó el error esperado");
        assertThat(actualException.getMessage()).isEqualTo(expectedErrorMessage);
    }

    // T_0003 & US_0004 & US_0008
    @Test
    @DisplayName("[T_0003] -> [US_0004] & [US_0008] Sad path: No se acepta un ordenamiento inválido al obtener lista de seguidos")
    void followedListInvalidOrder() {
        // Arrange
        Vendor vendor = objectFactory.getValidVendor();

        Integer idVendedorValido = vendor.getUserId();
        String ordenamientoInvalido = objectFactory.getInvalidOrder();
        FollowingListReqDto serviceRequest =
                new FollowingListReqDto(idVendedorValido, ordenamientoInvalido);

        String expectedErrorMessage = "El ordenamiento pedido es inválido";

        // Act and Assert
        BadRequestException actualException = assertThrows(
                BadRequestException.class,
                () -> userServiceImp.getFollowingList(serviceRequest),
                "No se arrojó el error esperado");
        assertThat(actualException.getMessage()).isEqualTo(expectedErrorMessage);
    }

    // T_0004 & US_0003 & US_0008
    @Test
    @DisplayName("[T_0004] -> [US_0003] & [US_0008] Happy path: Get a list of users who follow a vendor with DESC order")
    void followersListDescOk() {
        // Arrange
        Vendor vendor = objectFactory.getVendorWithTwoFollowers();
        FollowersListReqDto followersListReqDto = new FollowersListReqDto(vendor.getUserId(), objectFactory.getDescendentNameOrder());
        FollowersListDto expected = new FollowersListDto(vendor.getUserId(), vendor.getUserName(), List.of(
                new UserDto(vendor.getFollowers().get(0).getUserId(), vendor.getFollowers().get(0).getUserName()),
                new UserDto(vendor.getFollowers().get(1).getUserId(), vendor.getFollowers().get(1).getUserName())
        ));

        when(vendorRepositoryImp.findOne(vendor.getUserId())).thenReturn(vendor);

        // Act
        var response = userServiceImp.getFollowersList(followersListReqDto);

        // Assert
        assertEquals(expected, response);
    }

    // T_0004 & US_0003 & US_0008
    @Test
    @DisplayName("[T_0004] -> [US_0003] & [US_0008] Happy path: Get a list of users who follow a vendor with ASC order")
    void followersListAscOk() {
        // Arrange
        Vendor vendor = objectFactory.getVendorWithTwoFollowers();
        FollowersListReqDto followersListReqDto = new FollowersListReqDto(vendor.getUserId(), objectFactory.getAscendentNameOrder());
        FollowersListDto expected = new FollowersListDto(vendor.getUserId(), vendor.getUserName(), List.of(
                new UserDto(vendor.getFollowers().get(1).getUserId(), vendor.getFollowers().get(1).getUserName()),
                new UserDto(vendor.getFollowers().get(0).getUserId(), vendor.getFollowers().get(0).getUserName())
        ));

        when(vendorRepositoryImp.findOne(vendor.getUserId())).thenReturn(vendor);

        // Act
        var response = userServiceImp.getFollowersList(followersListReqDto);

        // Assert
        assertEquals(expected, response);
    }

    // T_0004 & US_0004 & US_0008
    @Test
    @DisplayName("[T_0004] -> [US_0003] & [US_0008] Happy path: Get a list of vendors followed by a user with DESC order")
    void followingListDescOk() {
        // Arrange
        Client client = objectFactory.getClientFollowingTwoVendors();
        FollowingListReqDto followingListReqDto = new FollowingListReqDto(client.getUserId(), objectFactory.getDescendentNameOrder());
        FollowingListDto expected = new FollowingListDto(client.getUserId(), client.getUserName(), List.of(
                new UserDto(client.getFollowing().get(0).getUserId(), client.getFollowing().get(0).getUserName()),
                new UserDto(client.getFollowing().get(1).getUserId(), client.getFollowing().get(1).getUserName())
        ));

        when(clientRepositoryImp.findOne(client.getUserId())).thenReturn(client);

        // Act
        var response = userServiceImp.getFollowingList(followingListReqDto);

        // Assert
        assertEquals(expected, response);
    }

    // T_0004 & US_0004 & US_0008
    @Test
    @DisplayName("[T_0004] -> [US_0003] & [US_0008] Happy path: Get a list of vendors followed by a user with ASC order")
    void followingListAscOk() {
        // Arrange
        Client client = objectFactory.getClientFollowingTwoVendors();
        FollowingListReqDto followingListReqDto = new FollowingListReqDto(client.getUserId(), objectFactory.getAscendentNameOrder());
        FollowingListDto expected = new FollowingListDto(client.getUserId(), client.getUserName(), List.of(
                new UserDto(client.getFollowing().get(1).getUserId(), client.getFollowing().get(1).getUserName()),
                new UserDto(client.getFollowing().get(0).getUserId(), client.getFollowing().get(0).getUserName())
        ));

        when(clientRepositoryImp.findOne(client.getUserId())).thenReturn(client);

        // Act
        var response = userServiceImp.getFollowingList(followingListReqDto);

        // Assert
        assertEquals(expected, response);
    }

    // T_0007 & US_0002
    @Test
    @DisplayName("[T_0007] -> [US_0002] Happy path: Nuevo vendedor Arranca con cero seguidores")
    void newVendorHasZeroFollowers() {
        // Arrange
        Vendor vendor = objectFactory.getValidVendor();
        Integer expected = 0;
        UserIdDto userIdDto = new UserIdDto(vendor.getUserId());
        when(vendorRepositoryImp.findOne(vendor.getUserId())).thenReturn(vendor);

        // Act
        FollowerCountDto countDto = userServiceImp.vendorFollowersCount(userIdDto);
        Integer result = countDto.getFollowersCount();

        // Assert
        assertEquals(expected,result);

    }

    // T_0007 & US_0002
    @Test
    @DisplayName("[T_0007] -> [US_0002] Happy path: Cliente sigue a vendedor e incrementa la cuenta de seguidores")
    void clientFollowsVendorIncreaseFollowersCount() {
        // Arrange
        Vendor vendor = objectFactory.getValidVendor();
        Client client = objectFactory.getValidClient();
        UserIdDto userIdDto = new UserIdDto(vendor.getUserId());

        UserFollowVendorDto userDto = new UserFollowVendorDto(client.getUserId(), vendor.getUserId());
        Integer actualFollowersCount = vendor.getFollowers().size();
        Integer expected = actualFollowersCount + 1;

        when(clientRepositoryImp.findOne(client.getUserId())).thenReturn(client);
        when(vendorRepositoryImp.findOne(vendor.getUserId())).thenReturn(vendor);
        userServiceImp.userFollowVendor(userDto);

        // Act
        FollowerCountDto countDto = userServiceImp.vendorFollowersCount(userIdDto);
        Integer result = countDto.getFollowersCount();

        // Assert
        assertEquals(expected,result);
    }
}
