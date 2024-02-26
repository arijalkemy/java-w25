package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.utils.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    @DisplayName("Calcular (Controller) - Éxito")
    public void analyzeScoresCorrect() {
        HouseResponseDTO expectedHouse = MockBuilder.buildHouseResponseDTO();
        HouseDTO mockHouse = MockBuilder.buildHouseDTO();

        HouseResponseDTO currentHouse = calculateRestController.calculate(mockHouse);

        assertEquals(expectedHouse.getPrice(), currentHouse.getPrice());
        assertEquals(expectedHouse.getSquareFeet(), currentHouse.getSquareFeet());
        assertEquals(expectedHouse.getBiggest().getSquareFeet(), currentHouse.getBiggest().getSquareFeet());
    }
}
