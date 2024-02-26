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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculadoraRestControllerTests {
    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    void calculateTestOk() {
        // Arrange
        HouseDTO houseDTO = new HouseDTO();
        RoomDTO room1 = new RoomDTO();
        room1.setName("Espacio abierto");
        room1.setWidth(5);
        room1.setLength(5);
        RoomDTO room2 = new RoomDTO();
        room2.setName("Baño");
        room2.setWidth(1);
        room2.setLength(2);
        RoomDTO room3 = new RoomDTO();
        room3.setName("Cocina");
        room3.setWidth(3);
        room3.setLength(3);
        houseDTO.setName("Oficina");
        houseDTO.setAddress("Monroe 800");
        houseDTO.setRooms(new ArrayList<>(List.of(room1, room2, room3)));
        HouseResponseDTO houseDTOExpected = new HouseResponseDTO(houseDTO, 36, 28800, room1);
        // Act
        when(calculateService.calculate(houseDTO)).thenReturn(houseDTOExpected);
        HouseResponseDTO response =  calculateRestController.calculate(houseDTO);
        // Assert
        Assertions.assertEquals(houseDTOExpected.getBiggest(), response.getBiggest());
        Assertions.assertEquals(houseDTOExpected.getSquareFeet(), response.getSquareFeet());
        Assertions.assertEquals(houseDTOExpected.getPrice(), response.getPrice());

    }
}
