package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.dtos.AddPostDto;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.SellerDTO;
import grupo_7.sprint_1.dtos.SellerFollowersListDto;
import grupo_7.sprint_1.service.IBuyerService;
import grupo_7.sprint_1.service.ISellerService;
import grupo_7.sprint_1.utils.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SellerControllerTest {

    @Mock
    IBuyerService buyerService;

    @Mock
    ISellerService sellerService;

    @InjectMocks
    SellerController sellerController;

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Éxito")
    public void recentPostsTest() {
        List<PostDto> expectedPosts = MockBuilder.mockPostDtos();
        when(sellerService.getRecentPostsFromFollowedSellers(1, "date_asc")).thenReturn(expectedPosts);

        List<PostDto> currentPosts = sellerController.getRecentPostsFromFollowedSellers(1, "date_asc").getBody();

        verify(sellerService, atLeastOnce()).getRecentPostsFromFollowedSellers(1, "date_asc");
        assertEquals(expectedPosts, currentPosts);
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Error")
    public void recentPostsTestError() {
        List<PostDto> expectedPosts = MockBuilder.mockPostDtos();

        List<PostDto> currentPosts = sellerController.getRecentPostsFromFollowedSellers(1, "date_asc").getBody();

        verify(sellerService, atLeastOnce()).getRecentPostsFromFollowedSellers(1, "date_asc");
        assertNotEquals(expectedPosts, currentPosts);
    }

    @Test
    public void getFollowersCountTest() {
        int sellerId = 1;
        SellerDTO expectedSeller = MockBuilder.mockSellersDtos().get(0);

        when(sellerService.cantidadSeguidores(sellerId)).thenReturn(expectedSeller);

        ResponseEntity<SellerDTO> responseEntity = sellerController.getFollowersCount(sellerId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedSeller, responseEntity.getBody());
    }

    @Test
    public void getFollowersListTest() {
        int sellerId = 1;
        String order = "name_asc";
        SellerFollowersListDto expectedFollowers = MockBuilder.mockSellerFollowersList();

        when(sellerService.getListOrderedAlphabetically(sellerId, order)).thenReturn(expectedFollowers);

        ResponseEntity<SellerFollowersListDto> responseEntity = sellerController.getFollowersList(sellerId, order);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedFollowers, responseEntity.getBody());
    }

    @Test
    public void addPostTest() {
        AddPostDto newPost = MockBuilder.mockPostDto();
        PostDto expectedPost = MockBuilder.mockPostDtoResponse();

        when(sellerService.addPost(newPost.userId(), newPost)).thenReturn(expectedPost);

        ResponseEntity<?> responseEntity = sellerController.addPost(newPost);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedPost, responseEntity.getBody());
    }
}
