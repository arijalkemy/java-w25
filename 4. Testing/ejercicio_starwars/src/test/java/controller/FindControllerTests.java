package controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class FindControllerTests {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    public void findTestOk() {
        String query = "luke";
        List<CharacterDTO> expectedResult = new ArrayList<>();
        expectedResult.add(new CharacterDTO("Luke Skywalker", "blond", "failr", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));

        when(findService.find(query)).thenReturn(expectedResult);

        List<CharacterDTO> result = findController.find(query);

        verify(findService, atLeastOnce()).find(query);
        assertEquals(expectedResult, result);
    }


}
