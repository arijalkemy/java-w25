package com.mercadolibre.calculadorametroscuadrados.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @InjectMocks
    CalculateService calculateService;

    @Test
    public void calculatePriceTest() {
        // Arrange:
        HouseDTO param = new HouseDTO("casa 1", "calle 1", List.of(new RoomDTO("cuarto 1", 50, 50)));
        // Act:
        HouseResponseDTO response = calculateService.calculate(param);
        // Assert:
        assertEquals(2000000, response.getPrice());
    }

    @Test
    public void calculateDimensionsTest() {
        // Arrange:
        RoomDTO roomDTO1 = new RoomDTO("cuarto 1", 50, 50);
        RoomDTO roomDTO2 = new RoomDTO("cuarto 2", 65, 50);
        HouseDTO param = new HouseDTO("casa 1", "calle 1", List.of(roomDTO1, roomDTO2));
        // Act:
        HouseResponseDTO response = calculateService.calculate(param);
        // Assert:
        assertEquals(roomDTO2, response.getBiggest());
    }

    @Test
    public void calculateM2RoomTest() {
        // Arrange:
        RoomDTO roomDTO1 = new RoomDTO("cuarto 1", 50, 50);
        // Act:
        Integer response = roomDTO1.getSquareFeet();
        // Assert:
        assertEquals(2500, response);
    }
}
