package org.socialmeli.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.PostDto;
import org.socialmeli.dto.response.PostIdDto;
import org.socialmeli.entity.Client;
import org.socialmeli.entity.Post;
import org.socialmeli.entity.Vendor;
import org.socialmeli.exception.BadRequestException;
import org.socialmeli.exception.NotFoundException;
import org.socialmeli.repository.implementation.ClientRepositoryImp;
import org.socialmeli.repository.implementation.PostRepositoryImp;
import org.socialmeli.repository.implementation.VendorRepositoryImp;
import org.socialmeli.service.implementation.PostsServiceImp;
import org.socialmeli.util.ObjectFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.socialmeli.util.TestDTOMapper.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PostServiceImpTest {

    @Mock
    PostRepositoryImp postRepositoryImp;
    @Mock
    VendorRepositoryImp vendorRepositoryImp;
    @Mock
    ClientRepositoryImp clientRepositoryImp;
    @InjectMocks
    PostsServiceImp postsServiceImp;

    ObjectFactory objectFactory = new ObjectFactory();

    // T_0008 & US_0006
    @Test
    @DisplayName("[T_0008] -> [US_0006] Happy path")
    void getFollowedListOkTest() {
        // Arrange
        Client client = objectFactory.getValidClient();
        client.setUserId(1);
        Vendor vendor = objectFactory.getValidVendor();
        String order = "date_asc";
        List<Vendor> vendorList = List.of(objectFactory.getValidVendor());
        when(clientRepositoryImp.findOne(client.getUserId())).thenReturn(client);
        when(vendorRepositoryImp.findOne(1)).thenReturn(null);
        when(vendorRepositoryImp.findAll()).thenReturn(vendorList);
        when(postRepositoryImp.getFollowedList(client, vendorList)).thenReturn(vendorList);
        when(postRepositoryImp.getPostsByUserId(vendor.getUserId())).thenReturn(objectFactory.getPostsFromTodayAndTwoDaysAgo(vendor));

        // Act
        FollowedListDto followersList = postsServiceImp
                .getFollowedList(new FollowedListReqDto(client.getUserId(), order));

        // Assert
        assertEquals(2, followersList.getPosts().size());
        assertEquals(1, followersList.getUserId());
    }

    // T_0008 & US_0006
    @Test
    @DisplayName("[T_0008] -> [US_0006] Sad path: No hay usuario registrado con el id indicado")
    void getFollowedListUserNotRegisterTest() {
        // Arrange
        String order = "date_asc";
        Integer id = 1;
        when(clientRepositoryImp.findOne(id)).thenReturn(null);
        when(vendorRepositoryImp.findOne(id)).thenReturn(null);

        // Act & Assert
        String mess = assertThrows(
                NotFoundException.class,
                () -> postsServiceImp.getFollowedList(new FollowedListReqDto(id, order))).getMessage();
        verify(clientRepositoryImp, atLeastOnce()).findOne(id);
        verify(vendorRepositoryImp, atLeastOnce()).findOne(id);
        assertEquals("No se encontró ningun usuario en el sistema con el ID indicado.", mess);
    }

    // T_0008 & US_0006
    @Test
    @DisplayName("[T_0008] -> [US_0006] Sad path: El cliente ingresado no sigue a ningun vendedor")
    void getFollowedListUserNotFollowVendorTest() {
        // Arrange
        Client client = objectFactory.getValidClient();
        client.setUserId(1);
        String order = "date_asc";
        List<Vendor> emptyVendorList = new ArrayList<>();
        when(clientRepositoryImp.findOne(client.getUserId())).thenReturn(client);
        when(vendorRepositoryImp.findOne(client.getUserId())).thenReturn(null);
        when(vendorRepositoryImp.findAll()).thenReturn(emptyVendorList);
        when(postRepositoryImp.getFollowedList(client, emptyVendorList)).thenReturn(emptyVendorList);

        // Act & Assert
        String mess = assertThrows(
                NotFoundException.class,
                () -> postsServiceImp.getFollowedList(new FollowedListReqDto(client.getUserId(), order))).getMessage();
        verify(clientRepositoryImp, atLeastOnce()).findOne(client.getUserId());
        verify(vendorRepositoryImp, atLeastOnce()).findOne(client.getUserId());
        assertEquals("El usuario ingresado no sigue a ningun vendedor.", mess);
    }

    // T_0008 & US_0006
    @Test
    @DisplayName("[T_0008] -> [US_0006] Sad path: El vendedor ingresado no sigue a ningun vendedor")
    void getFollowedListVendorNotFollowVendorTest() {
        // Arrange
        Vendor vendor = objectFactory.getValidVendor();
        vendor.setUserId(1);
        String order = "date_asc";
        List<Vendor> emptyVendorList = new ArrayList<>();
        when(clientRepositoryImp.findOne(vendor.getUserId())).thenReturn(null);
        when(vendorRepositoryImp.findOne(vendor.getUserId())).thenReturn(vendor);
        when(vendorRepositoryImp.findAll()).thenReturn(emptyVendorList);
        when(postRepositoryImp.getFollowedList(vendor, emptyVendorList)).thenReturn(emptyVendorList);

        // Act & Assert
        String mess = assertThrows(
                NotFoundException.class,
                () -> postsServiceImp.getFollowedList(new FollowedListReqDto(vendor.getUserId(), order))).getMessage();
        verify(clientRepositoryImp, atLeastOnce()).findOne(vendor.getUserId());
        verify(vendorRepositoryImp, atLeastOnce()).findOne(vendor.getUserId());
        assertEquals("El usuario ingresado no sigue a ningun vendedor.", mess);
    }

    // T_0008 & US_0006
    @Test
    @DisplayName("[T_0008] -> [US_0006] Sad path: No hay posteos realizados por los vendedores.")
    void getFollowedListEmptyPostListTest() {
        // Arrange
        Client client = objectFactory.getValidClient();
        String order = "date_asc";
        List<Post> emptyPostList = new ArrayList<>();
        List<Vendor> vendorList = List.of(objectFactory.getValidVendor());
        when(clientRepositoryImp.findOne(client.getUserId())).thenReturn(client);
        when(vendorRepositoryImp.findOne(1)).thenReturn(null);
        when(vendorRepositoryImp.findAll()).thenReturn(vendorList);
        when(postRepositoryImp.getFollowedList(client, vendorList)).thenReturn(vendorList);
        when(postRepositoryImp.getPostsByUserId(objectFactory.getValidVendor().getUserId())).thenReturn(emptyPostList);

        // Act & Assert
        String exMesage = assertThrows(
                NotFoundException.class,
                () -> postsServiceImp.getFollowedList(new FollowedListReqDto(client.getUserId(), order))).getMessage();
        verify(clientRepositoryImp, atLeastOnce()).findOne(client.getUserId());
        assertEquals("No hay posteos realizados por los vendedores que sigue el usuario las últimas dos semanas.",
                exMesage);
    }

    // T_0008 & US_0006
    @Test
    @DisplayName("[T_0008] -> [US_0006] Sad path: No hay posteos realizados por los vendedores que sigue el usuario las últimas dos semanas.")
    void getFollowedListNoPostTest() {
        // Arrange
        Client client = objectFactory.getValidClient();
        client.setUserId(1);
        Vendor vendor = objectFactory.getValidVendor();
        String order = "date_asc";
        List<Vendor> vendorList = List.of(objectFactory.getValidVendor());
        when(clientRepositoryImp.findOne(client.getUserId())).thenReturn(client);
        when(vendorRepositoryImp.findOne(1)).thenReturn(null);
        when(vendorRepositoryImp.findAll()).thenReturn(vendorList);
        when(postRepositoryImp.getFollowedList(client, vendorList)).thenReturn(vendorList);
        when(postRepositoryImp.getPostsByUserId(vendor.getUserId())).thenReturn(objectFactory.getTwoPostsOlderThanTwoWeeks(vendor));

        // Act & Assert
        String exMesage = assertThrows(
                NotFoundException.class,
                () -> postsServiceImp.getFollowedList(new FollowedListReqDto(client.getUserId(), order))).getMessage();
        verify(clientRepositoryImp, atLeastOnce()).findOne(client.getUserId());
        assertEquals("No hay posteos realizados por los vendedores que sigue el usuario las últimas dos semanas.",
                exMesage);
    }

    // T_0005 & US_0009
    @Test
    @DisplayName("[T-0005] -> [US_0009] Happy path: Existe ordenamiento por fecha ascendente")
    void sortByDateAscExistsTest() {
        // Arrange
        Client mockClient = objectFactory.getValidClientFollowingVendor();
        Vendor mockVendor = mockClient.getFollowing().get(0);
        Integer userId = mockClient.getUserId();
        String order = "date_asc";

        List<Vendor> mockFollowingVendorList = mockClient.getFollowing();
        List<Post> mockPostList = objectFactory.getListOfSinglePost(mockVendor);
        List<PostDto> mockPostDtoList = mockPostList.stream().map(p -> convertToPostDto(p)).toList();
        FollowedListReqDto inputDto = new FollowedListReqDto(userId, order);
        FollowedListDto expectedDto = new FollowedListDto(userId, mockPostDtoList);

        when(clientRepositoryImp.findOne(userId)).thenReturn(mockClient);
        when(vendorRepositoryImp.findOne(userId)).thenReturn(null);
        when(vendorRepositoryImp.findAll()).thenReturn(mockFollowingVendorList);
        when(postRepositoryImp.getFollowedList(mockClient, mockFollowingVendorList)).thenReturn(mockFollowingVendorList);
        when(postRepositoryImp.getPostsByUserId(mockVendor.getUserId())).thenReturn(objectFactory.getListOfSinglePost(mockVendor));

        // Act
        FollowedListDto response = postsServiceImp.getFollowedList(inputDto);

        // Assert
        assertEquals(expectedDto, response);
    }

    // T_0005 & US_0009
    @Test
    @DisplayName("[T_0005] -> [US_0009] Happy path: Existe ordenamiento por fecha descendente")
    void sortByDateDescExistsTest() {
        // Arrange
        Client mockClient = objectFactory.getValidClientFollowingVendor();
        Vendor mockVendor = mockClient.getFollowing().get(0);
        Integer userId = mockClient.getUserId();
        String order = "date_desc";

        List<Vendor> mockFollowingVendorList = mockClient.getFollowing();
        List<Post> mockPostList = objectFactory.getListOfSinglePost(mockVendor);
        List<PostDto> mockPostDtoList = mockPostList.stream().map(p -> convertToPostDto(p)).toList();
        FollowedListReqDto inputDto = new FollowedListReqDto(userId, order);
        FollowedListDto expectedDto = new FollowedListDto(userId, mockPostDtoList);

        when(clientRepositoryImp.findOne(userId)).thenReturn(mockClient);
        when(vendorRepositoryImp.findOne(userId)).thenReturn(null);
        when(vendorRepositoryImp.findAll()).thenReturn(mockFollowingVendorList);
        when(postRepositoryImp.getFollowedList(mockClient, mockFollowingVendorList)).thenReturn(mockFollowingVendorList);
        when(postRepositoryImp.getPostsByUserId(mockVendor.getUserId())).thenReturn(objectFactory.getListOfSinglePost(mockVendor));

        // Act
        FollowedListDto response = postsServiceImp.getFollowedList(inputDto);

        // Assert
        assertEquals(expectedDto, response);
    }


    // T_0005 & US_0009
    @Test
    @DisplayName("[T_0005] -> [US_0009] Sad path: indicación de orden no valida")
    void getFollowedListNotValidOrdenTest() {
        // Arrange
        Client client = objectFactory.getValidClient();
        client.setUserId(1);
        Vendor vendor = objectFactory.getValidVendor();
        String order = "date_descd";
        List<Vendor> vendorList = List.of(objectFactory.getValidVendor());
        when(clientRepositoryImp.findOne(client.getUserId())).thenReturn(client);
        when(vendorRepositoryImp.findOne(1)).thenReturn(null);
        when(vendorRepositoryImp.findAll()).thenReturn(vendorList);
        when(postRepositoryImp.getFollowedList(client, vendorList)).thenReturn(vendorList);
        when(postRepositoryImp.getPostsByUserId(vendor.getUserId())).thenReturn(objectFactory.getPostsFromTodayAndTwoDaysAgo(vendor));

        // Act & Assert
        String exMesage = assertThrows(
                BadRequestException.class,
                () -> postsServiceImp.getFollowedList(new FollowedListReqDto(client.getUserId(), order))).getMessage();
        assertEquals("Indicación de ordenamiento no válida. La misma tiene que ser \"date_asc\" o \"date_desc\"",
                exMesage);
    }

    // T_0006 & US_0009
    @Test
    @DisplayName("[T_0006] -> [US_0009] Happy path: Ordena de forma ascendente")
    void getFollowedListOrdenAscOkTest() {
       // Arrange
       Client client = objectFactory.getValidClient();
       client.setUserId(1);
       Vendor vendor = objectFactory.getValidVendor();
       String order = "date_asc";
       List<Vendor> vendorList = List.of(objectFactory.getValidVendor());
       when(clientRepositoryImp.findOne(client.getUserId())).thenReturn(client);
       when(vendorRepositoryImp.findOne(1)).thenReturn(null);
       when(vendorRepositoryImp.findAll()).thenReturn(vendorList);
       when(postRepositoryImp.getFollowedList(client, vendorList)).thenReturn(vendorList);
       when(postRepositoryImp.getPostsByUserId(vendor.getUserId())).thenReturn(objectFactory.getPostsFromTodayAndTwoDaysAgo(vendor));

       // Act
       FollowedListDto followersList = postsServiceImp.getFollowedList(new FollowedListReqDto(client.getUserId(), order));
       // Assert
       assertEquals(LocalDate.now().minusDays(2), followersList.getPosts().get(0).getDate());
       assertEquals(LocalDate.now(), followersList.getPosts().get(1).getDate());
    }

    // T_0006 & US_0009
    @Test
    @DisplayName("[T_0006] -> [US_0009] Happy path: Ordena de forma ascendente")
    void getFollowedListOrdenDescOkTest() {
        // Arrange
        Client client = objectFactory.getValidClient();
        client.setUserId(1);
        Vendor vendor = objectFactory.getValidVendor();
        String order = "date_desc";
        List<Vendor> vendorList = List.of(objectFactory.getValidVendor());
        when(clientRepositoryImp.findOne(client.getUserId())).thenReturn(client);
        when(vendorRepositoryImp.findOne(1)).thenReturn(null);
        when(vendorRepositoryImp.findAll()).thenReturn(vendorList);
        when(postRepositoryImp.getFollowedList(client, vendorList)).thenReturn(vendorList);
        when(postRepositoryImp.getPostsByUserId(vendor.getUserId())).thenReturn(objectFactory.getPostsFromTodayAndTwoDaysAgo(vendor));

        // Act
        FollowedListDto followersList = postsServiceImp.getFollowedList(new FollowedListReqDto(client.getUserId(), order));

        // Assert
        assertEquals(LocalDate.now(), followersList.getPosts().get(0).getDate());
        assertEquals(LocalDate.now().minusDays(2), followersList.getPosts().get(1).getDate());
    }

    // COV_0003
    @Test
    @DisplayName("[COV_0003] Happy path")
    void savePostOkTest() {
        // Arrange
        Vendor vendor = objectFactory.getValidVendor();
        Post post = new Post(vendor.getUserId(), LocalDate.now(), objectFactory.getValidProduct(), 1, 10.0);
        when(vendorRepositoryImp.findOne(vendor.getUserId())).thenReturn(vendor);
        when(postRepositoryImp.save(post)).thenReturn(post.getPostId());

        // Act
        PostIdDto postIdDto = postsServiceImp.savePost(new PostReqDto(post.getUserId(), post.getDate(), convertToProductDto(post.getProduct()), post.getCategory(), post.getPrice()));

        // Assert
        assertEquals(post.getPostId(), postIdDto.getPostId());
    }

    // COV_0003
    @Test
    @DisplayName("[COV_0003] Sad path")
    void savePostNotOkTest() {
        // Arrange
        Vendor vendor = objectFactory.getValidVendor();
        vendor.setUserId(null);
        when(vendorRepositoryImp.findOne(vendor.getUserId())).thenReturn(vendor);

        // Act & Assert
        String exMesage = assertThrows(
                NotFoundException.class,
                () -> postsServiceImp.savePost(new PostReqDto(vendor.getUserId(), LocalDate.now(), objectFactory.getValidProductDto(), 1, 10.0))).getMessage();
                assertEquals("No se encontró ningun usuario en el sistema con el ID indicado.", exMesage);
    }
}
