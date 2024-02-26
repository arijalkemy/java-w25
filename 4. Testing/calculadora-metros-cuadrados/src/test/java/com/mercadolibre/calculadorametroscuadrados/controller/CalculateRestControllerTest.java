package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {
    @Mock
    CalculateService calculateService;
    @InjectMocks
    CalculateRestController controller;
    @Test
    void calculate() {
        RoomDTO testRoom1 = new RoomDTO();
        testRoom1.setName("Living");
        testRoom1.setLength(6);
        testRoom1.setWidth(6);
        RoomDTO testRoom2 = new RoomDTO();
        testRoom2.setName("Bathroom");
        testRoom2.setLength(3);
        testRoom2.setWidth(3);
        HouseDTO testHouse = new HouseDTO();
        testHouse.setName("Casa");
        testHouse.setAddress("avenida siempre viva");
        testHouse.setRooms(List.of(testRoom1, testRoom2));

        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setName("Casa");
        expected.setAddress("avenida siempre viva");
        expected.setRooms(List.of(testRoom1, testRoom2));
        expected.setBiggest(testRoom1);
        expected.setSquareFeet(45);
        expected.setPrice(45*800);

        Mockito.when(calculateService.calculate(testHouse)).thenReturn(expected);

        HouseResponseDTO result = controller.calculate(testHouse);

        Assertions.assertEquals(expected.getSquareFeet(), result.getSquareFeet());
        Assertions.assertEquals(expected.getBiggest(), result.getBiggest());
        Assertions.assertEquals(expected.getName(), result.getName());
        Assertions.assertEquals(expected.getAddress(), result.getAddress());
        Assertions.assertEquals(expected.getPrice(), result.getPrice());
        Assertions.assertEquals(expected.getRooms(), result.getRooms());
    }
}