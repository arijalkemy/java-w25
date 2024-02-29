package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.TestUtilGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CalculateRestControllerTest {

    @Mock
    private CalculateService calculateService;

    @InjectMocks
    private CalculateRestController calculateRestController;

    @Test
    public void calculateTestHouseWithNoRooms() {
        //Arrange
        HouseDTO houseDTO = TestUtilGenerator.getHouseWithNoRooms();
        HouseResponseDTO expectedResponse = TestUtilGenerator.getResponse(0, 0, null);
        when(calculateService.calculate(houseDTO)).thenReturn(expectedResponse);

        //Act
        HouseResponseDTO result = calculateRestController.calculate(houseDTO);

        //Assert
        assertEquals(expectedResponse.getSquareFeet(), result.getSquareFeet());
        assertEquals(expectedResponse.getPrice(), result.getPrice());
        assertEquals(expectedResponse.getBiggest(), result.getBiggest());
    }

    @Test
    public void calculateTestHouseWithOneRoom() {
        //Arrange
        HouseDTO houseDTO = TestUtilGenerator.getHouseWithOneRoom();
        HouseResponseDTO expectedResponse = TestUtilGenerator.getResponse(3 * 2, 4800, houseDTO.getRooms().get(0));
        when(calculateService.calculate(houseDTO)).thenReturn(expectedResponse);

        //Act
        HouseResponseDTO result = calculateRestController.calculate(houseDTO);

        //Assert
        assertEquals(expectedResponse.getSquareFeet(), result.getSquareFeet());
        assertEquals(expectedResponse.getPrice(), result.getPrice());
        assertEquals(expectedResponse.getBiggest(), result.getBiggest());
    }

    @Test
    public void calculateTestHouseWithThreeRooms() {
        //Arrange
        HouseDTO houseDTO = TestUtilGenerator.getHouseWithThreeRooms();
        int expectedSquareFeet = (3 * 2) + (2 * 2) + (6 * 4);
        int expectedPrice = expectedSquareFeet * 800;
        RoomDTO expectedBiggestRoom = houseDTO.getRooms().get(2);
        HouseResponseDTO expectedResponse = TestUtilGenerator.getResponse(expectedSquareFeet, expectedPrice, expectedBiggestRoom);
        when(calculateService.calculate(houseDTO)).thenReturn(expectedResponse);

        //Act
        HouseResponseDTO result = calculateRestController.calculate(houseDTO);

        //Assert
        assertEquals(expectedResponse.getSquareFeet(), result.getSquareFeet());
        assertEquals(expectedResponse.getPrice(), result.getPrice());
        assertEquals(expectedResponse.getBiggest(), result.getBiggest());
    }

    @Test
    public void calculateTestHouseWithNullAtributesThrowsNullPointerException() {
        //Arrange
        HouseDTO houseDTO = new HouseDTO();
        when(calculateService.calculate(houseDTO)).thenThrow(NullPointerException.class);

        //Act & Arrange
        assertThrows(NullPointerException.class, () -> calculateRestController.calculate(houseDTO));
    }

}
