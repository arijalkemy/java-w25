package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.TestGeneratorUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {
    @Mock
    CalculateService calculateService;
    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    void calculate() {
        //assert
        HouseDTO houseToBeEvaluated = TestGeneratorUtil.generateHouseWithThreeRoomsDTO();
        HouseResponseDTO expectedResponseHouseDto = TestGeneratorUtil.generateExpectedResponseDTO();
        when(calculateService.calculate(houseToBeEvaluated)).thenReturn(expectedResponseHouseDto);
        //act
        HouseResponseDTO actualResponse = calculateRestController.calculate(houseToBeEvaluated);
        //assert
        verify(calculateService, atLeast(1)).calculate(houseToBeEvaluated);
        assertEquals(expectedResponseHouseDto, actualResponse);
    }
}