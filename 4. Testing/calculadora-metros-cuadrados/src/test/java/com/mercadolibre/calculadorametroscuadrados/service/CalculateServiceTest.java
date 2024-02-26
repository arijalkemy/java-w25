package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CalculateServiceTest {
    private CalculateService calculateService;

    @BeforeEach
    public void setup() {
        calculateService = new CalculateService();
    }

    @Test
    public void testCalculate() {

        // Arrange
        HouseDTO houseDTO = new HouseDTO();
        RoomDTO roomDTO1 = new RoomDTO();
        RoomDTO roomDTO2 = new RoomDTO();

        houseDTO.setAddress("Penna 235");
        houseDTO.setName("Casa de test");

        roomDTO1.setName("Domitorio 1");
        roomDTO1.setLength(3);
        roomDTO1.setWidth(4);

        roomDTO2.setName("Domitorio 2");
        roomDTO2.setLength(4);
        roomDTO2.setWidth(4);

        houseDTO.setRooms(List.of(roomDTO1,roomDTO2));

        HouseResponseDTO expectedHouseResponseDTO = new HouseResponseDTO();


        expectedHouseResponseDTO.setAddress("Penna 235");
        expectedHouseResponseDTO.setName("Casa de test");

        expectedHouseResponseDTO.setRooms(List.of(roomDTO1,roomDTO2));
        expectedHouseResponseDTO.setBiggest(roomDTO2);
        expectedHouseResponseDTO.setSquareFeet(28);
        expectedHouseResponseDTO.setPrice(28*800);

        // Act
        HouseResponseDTO response = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(28, response.getSquareFeet());
        assertEquals(22400, response.getPrice());
        assertEquals(roomDTO2.getName(), response.getBiggest().getName());
        assertEquals(roomDTO2.getLength(), response.getBiggest().getLength());
        assertEquals(roomDTO2.getWidth(), response.getBiggest().getWidth());
    }

}


