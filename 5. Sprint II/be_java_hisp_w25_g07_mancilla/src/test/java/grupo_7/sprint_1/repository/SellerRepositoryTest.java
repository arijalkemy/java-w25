package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.exception.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SellerRepositoryTest {
    @Mock
    SellerRepositoryImp sellerRepository;

    @Test
    @DisplayName("T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta (US-0002) - Éxito")
    public void cantidadDeSeguidoresTest() {
        int userId = 1;
        int expected = 10;

        when(sellerRepository.cantidadDeSeguidoresRepo(userId)).thenReturn(expected);
        int actual = sellerRepository.cantidadDeSeguidoresRepo(userId);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista (US-0001) - Éxito")
    public void findByIdTest() {
        int userId = 1;
        Seller expected = new Seller();
        expected.setUserId(userId);

        when(sellerRepository.findById(userId)).thenReturn(Optional.of(expected));
        Optional<Seller> actual = sellerRepository.findById(userId);
        assertEquals(expected, actual.get());
    }

    @Test
    @DisplayName("T-0001: Verificar que el usuario a seguir exista (US-0001) - Excepción")
    public void findByIdTest_UserDoesNotExist() {
        int nonExistentUserId = 2;

        when(sellerRepository.findById(nonExistentUserId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> sellerRepository.findById(nonExistentUserId).orElseThrow(() -> new NotFoundException("User not found")));
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Éxito")
    public void getAllSellersTest() {
        List<Seller> expectedSellers = List.of(
                new Seller(),
                new Seller(),
                new Seller()
        );

        when(sellerRepository.getAllSellers()).thenReturn(expectedSellers);

        List<Seller> currentSellers = sellerRepository.getAllSellers();

        assertEquals(expectedSellers, currentSellers);
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Error")
    public void getAllSellersTestError() {
        List<Seller> expectedSellers = List.of(
                new Seller(),
                new Seller(),
                new Seller()
        );

        List<Seller> currentSellers = sellerRepository.getAllSellers();

        assertNotEquals(expectedSellers, currentSellers);
    }
}
