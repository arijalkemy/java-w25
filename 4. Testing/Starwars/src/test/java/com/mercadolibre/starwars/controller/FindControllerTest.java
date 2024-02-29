package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    public void findTestOk() {
        //Arrange
        String query = "Luke";
        List<CharacterDTO> expectedList = List.of(
                TestUtilsGenerator.getLukeSkywalker()
        );
        when(findService.find(query)).thenReturn(expectedList);

        //Act
        List<CharacterDTO> obtainedList = findController.find(query);

        //Assert
        assertEquals(expectedList, obtainedList);
    }


}
