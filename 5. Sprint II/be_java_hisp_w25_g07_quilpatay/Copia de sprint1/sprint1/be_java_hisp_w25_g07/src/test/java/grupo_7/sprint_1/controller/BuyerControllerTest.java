package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.GenericResponseDTO;
import grupo_7.sprint_1.dtos.MessageDto;
import grupo_7.sprint_1.service.BuyerServiceImp;
import grupo_7.sprint_1.utils.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BuyerControllerTest {

    @Mock
    BuyerServiceImp buyerService;
    @InjectMocks
    BuyerController controller;

    @Test
    @DisplayName("T-0002: Verificar que el usuario a dejar de seguir exista. (US-0007) - Éxito")
    public void unfollowSellerTestOk() {
        int idUser = 11;
        int idUserUnfollow = 1;
        MessageDto devolucion = new MessageDto("Se eliminó de seguidores correctamente");
        when(buyerService.unfollowSeller(anyInt(), anyInt())).thenReturn(devolucion);

        var obtained = controller.unfollowSeller(idUser, idUserUnfollow);

        verify(buyerService, atLeastOnce()).unfollowSeller(idUser, idUserUnfollow);
        assertEquals(devolucion, obtained.getBody());
    }

    @Test
    public void followSellerSuccessTest() {
        int buyerId = 1;
        int sellerId = 2;
        GenericResponseDTO expectedResponse = new GenericResponseDTO("Se ha seguido al vendedor correctamente");

        when(buyerService.followSeller(buyerId, sellerId)).thenReturn(expectedResponse);

        ResponseEntity<?> responseEntity = controller.followSeller(buyerId, sellerId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }

    @Test
    public void getFollowedListAscTestOk() {

        Integer userId = 1;
        String order = "name_asc";
        BuyerDto expectedResponse = MockBuilder.mockBuyerAscDto();

        when(buyerService.getBuyerfollow(userId, order)).thenReturn(expectedResponse);

        ResponseEntity<?> responseEntity = controller.getfollowedlist(userId, order);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());

        verify(buyerService, atLeastOnce()).getBuyerfollow(userId, order);
    }

    @Test
    public void getFollowedListDescTestOk() {

        Integer userId = 1;
        String order = "name_desc";
        BuyerDto expectedResponse = MockBuilder.mockBuyerDescDto();

        when(buyerService.getBuyerfollow(userId, order)).thenReturn(expectedResponse);

        ResponseEntity<?> responseEntity = controller.getfollowedlist(userId, order);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());

        verify(buyerService, atLeastOnce()).getBuyerfollow(userId, order);
    }

}
