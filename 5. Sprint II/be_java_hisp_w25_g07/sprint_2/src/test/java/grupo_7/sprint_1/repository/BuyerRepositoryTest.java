package grupo_7.sprint_1.repository;

import grupo_7.sprint_1.entity.Buyer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BuyerRepositoryTest {

    @Mock
    BuyerRepositoryImp buyerRepository;

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Éxito")
    public void findByIdTest() {
        int userId = 1;
        Buyer expected = new Buyer();
        expected.setUserId(userId);

        when(buyerRepository.findBuyerById(userId)).thenReturn(expected);
        Buyer actual = buyerRepository.findBuyerById(userId);
        assertEquals(expected.getUserId(), actual.getUserId());
    }

    @Test
    @DisplayName("T-0005: Verificar que el tipo de ordenamiento por fecha exista (US-0009) - Error")
    public void findByIdTestException() {
        int nonExistentUserId = 999999;
        Buyer current = buyerRepository.findBuyerById(nonExistentUserId);

        assertNull(null, current);
    }

}
