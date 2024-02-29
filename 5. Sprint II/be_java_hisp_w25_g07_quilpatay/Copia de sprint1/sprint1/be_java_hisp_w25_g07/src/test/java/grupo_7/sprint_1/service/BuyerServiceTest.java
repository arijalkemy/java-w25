package grupo_7.sprint_1.service;

import grupo_7.sprint_1.dtos.BuyerDto;
import grupo_7.sprint_1.dtos.MessageDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.BadRequestException;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.repository.BuyerRepositoryImp;
import grupo_7.sprint_1.repository.SellerRepositoryImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static grupo_7.sprint_1.utils.MockBuilder.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BuyerServiceTest {

    @Mock
    BuyerRepositoryImp buyerRepositoryImp;
    @Mock
    SellerRepositoryImp sellerRepository;

    @InjectMocks
    BuyerServiceImp buyerServiceImp;

    @Test
    @DisplayName("T-0002: Verificar que el usuario a dejar de seguir exista. (US-0007) - Éxito")
    public void unfollowSellerTestOk() {
        int idUsuario = 11;
        int idUnfollow = 1;

        Seller seller = new Seller();
        seller.setUserId(1);
        List<Seller> vendedoresSeguidos = new ArrayList<>();
        vendedoresSeguidos.add(seller);

        Buyer buyer = new Buyer();
        buyer.setFollowed(vendedoresSeguidos);

        Mockito.when(buyerRepositoryImp.findBuyerById(idUsuario)).thenReturn(buyer);

        MessageDto devolucion = new MessageDto("Se eliminó de seguidores correctamente");

        var obtained = buyerServiceImp.unfollowSeller(idUsuario, idUnfollow);

        assertEquals(devolucion, obtained);
    }

    @Test
    @DisplayName("T-0002: Verificar que el usuario a dejar de seguir exista. (US-0007) - Exception Buyer")
    public void unfollowSellerNoExistBuyerBadTest() {
        int idUsuario = 111;
        int idUnfollow = 1;

        Mockito.when(buyerRepositoryImp.findBuyerById(idUsuario)).thenReturn(null);

        Assertions.assertThrows(NotFoundException.class,
                () -> buyerServiceImp.unfollowSeller(idUsuario, idUnfollow));

    }

    @Test
    @DisplayName("T-0002: Verificar que el usuario a dejar de seguir exista. (US-0007) - Exception Seller")
    public void unfollowSellerNoExistFollowedBadTest() {
        int idUsuario = 11;
        int idUnfollow = 1;

        Buyer buyer = new Buyer();
        buyer.setFollowed(Collections.emptyList());

        Mockito.when(buyerRepositoryImp.findBuyerById(idUsuario)).thenReturn(buyer);

        Assertions.assertThrows(NotFoundException.class,
                () -> buyerServiceImp.unfollowSeller(idUsuario, idUnfollow));

    }

    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista. (US-0001) - Exception")
    public void followSellerThrowsException() {
        Integer buyerId = 1;
        Integer sellerId = 2;
        Buyer buyer = new Buyer();

        when(buyerRepositoryImp.findBuyerById(buyerId)).thenReturn(buyer);
        when(sellerRepository.findById(sellerId)).thenReturn(Optional.empty());
        assertThrows(BadRequestException.class, () -> {
            buyerServiceImp.followSeller(buyerId, sellerId);
        });
    }

    @Test
    @DisplayName("T-0001:  Verificar que el usuario a seguir exista. (US-0001) - Éxito")
    public void followSellerSuccess() {
        Integer buyerId = 1;
        Integer sellerId = 2;
        Buyer buyer = new Buyer();
        buyer.setFollowed(new ArrayList<>());
        Seller seller = new Seller();

        when(buyerRepositoryImp.findBuyerById(buyerId)).thenReturn(buyer);
        when(sellerRepository.findById(sellerId)).thenReturn(Optional.of(seller));
        assertDoesNotThrow(() -> {
            buyerServiceImp.followSeller(buyerId, sellerId);
        });
    }

    @Test
    @DisplayName("T-0003: Verificar que el tipo de ordenamiento alfabético exista (US-0008) - Excepción")
    public void getFollowedListOrderExistenceBadTest() {
        int id = 1;
        String order = "";
        when(buyerRepositoryImp.findBuyerById(id)).thenReturn(mockBuyer());
        assertThrows(BadRequestException.class, () -> {
            buyerServiceImp.getBuyerfollow(id, order);
        });

    }

    @Test
    @DisplayName("T-0004: Verificar que el tipo de ordenamiento alfabético funcione correctamente (US-0008) - Éxito")
    public void getFollowedListOrderAscExistenceOKTest() {
        Integer id = 11;
        String order = "name_asc";
        when(buyerRepositoryImp.findBuyerById(id)).thenReturn(mockBuyer());
        BuyerDto buyerDto = mockBuyerAscDto();

        BuyerDto buyerDto2 = buyerServiceImp.getBuyerfollow(id, order);
        assertEquals(buyerDto, buyerDto2);
    }

    @Test
    @DisplayName("T-0004: Verificar que el tipo de ordenamiento alfabético invertido funcione correctamente (US-0008) - Éxito")
    public void getFollowedListOrderDescExistenceOKTest() {
        Integer id = 11;
        String order = "name_desc";
        when(buyerRepositoryImp.findBuyerById(id)).thenReturn(mockBuyer());
        BuyerDto buyerDto = mockBuyerDescDto();

        BuyerDto buyerDto2 = buyerServiceImp.getBuyerfollow(id, order);
        assertEquals(buyerDto, buyerDto2);
    }
}
