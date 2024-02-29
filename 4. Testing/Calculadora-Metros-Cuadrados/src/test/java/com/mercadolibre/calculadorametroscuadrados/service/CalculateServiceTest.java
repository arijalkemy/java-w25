package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.util.TestUtilGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    private CalculateService calculateService = new CalculateService();

    @Test
    public void calculateTestHouseWithNoRooms() {
        //Arrange
        HouseDTO houseDTO = TestUtilGenerator.getHouseWithNoRooms();
        Integer expectedSquareFeet = 0;
        Integer expectedPrice = 0;
        RoomDTO expectedBiggestRoom = null;

        //Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);

        //Assert
        assertEquals(expectedSquareFeet, result.getSquareFeet());
        assertEquals(expectedPrice, result.getPrice());
        assertEquals(expectedBiggestRoom, result.getBiggest());
    }

    @Test
    public void calculateTestHouseWithOneRoom() {
        //Arrange
        HouseDTO houseDTO = TestUtilGenerator.getHouseWithOneRoom();
        Integer expectedSquareFeet = 3 * 2;
        Integer expectedPrice = expectedSquareFeet * 800;
        RoomDTO expectedBiggestRoom = houseDTO.getRooms().get(0);

        //Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);

        //Assert
        assertEquals(expectedSquareFeet, result.getSquareFeet());
        assertEquals(expectedPrice, result.getPrice());
        assertEquals(expectedBiggestRoom, result.getBiggest());
    }

    @Test
    public void calculateTestHouseWithThreeRooms() {
        //Arrange
        HouseDTO houseDTO = TestUtilGenerator.getHouseWithThreeRooms();
        Integer expectedSquareFeet = (3 * 2) + (2 * 2) + (6 * 4);
        Integer expectedPrice = expectedSquareFeet * 800;
        RoomDTO expectedBiggestRoom = houseDTO.getRooms().get(2);

        //Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);

        //Assert
        assertEquals(expectedSquareFeet, result.getSquareFeet());
        assertEquals(expectedPrice, result.getPrice());
        assertEquals(expectedBiggestRoom, result.getBiggest());
    }

    @Test
    public void calculateTestHouseWithNullAtributesThrowsNullPointerException() {
        //Arrange
        HouseDTO houseDTO = new HouseDTO();

        //Act & Arrange
        assertThrows(NullPointerException.class, () -> calculateService.calculate(houseDTO));
    }

}
