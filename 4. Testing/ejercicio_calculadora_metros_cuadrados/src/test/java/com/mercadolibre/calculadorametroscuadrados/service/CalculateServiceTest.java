package com.mercadolibre.calculadorametroscuadrados.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.TestGeneratorUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {
    private CalculateService calculateService = new CalculateService();
    @Test
    void calculate() throws JsonProcessingException {
        //arrange
        HouseDTO houseToBeEvaluated = TestGeneratorUtil.generateHouseWithThreeRoomsDTO();
        HouseResponseDTO expectedResponse = TestGeneratorUtil.generateExpectedResponseDTO();
        //act
        HouseResponseDTO actualResponse =  calculateService.calculate(houseToBeEvaluated);
        //assert
        assertEquals(expectedResponse, actualResponse);
    }
}