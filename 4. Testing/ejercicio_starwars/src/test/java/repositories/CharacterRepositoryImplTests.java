package repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CharacterRepositoryImplTests {
    @Test
    public void findTestOk() {
        // Arrange
        String query = "luke";
        List<CharacterDTO> expectedResult = new ArrayList<>();
        expectedResult.add(new CharacterDTO("Luke Skywalker", "blond", "failr", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        // Act
        List<CharacterDTO> result = CharacterRepositoryImpl.f
        assertEquals(expectedResult, result);
    }
}
