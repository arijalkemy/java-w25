package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    void calculateOk() {

        //Arrange
        HouseDTO inputHouse = new HouseDTO();
        inputHouse.setAddress("Some Address");
        inputHouse.setName("The House");

        RoomDTO inputRom1 = new RoomDTO();
        inputRom1.setName("Main");
        inputRom1.setLength(10);
        inputRom1.setWidth(5);

        RoomDTO inputRom2 = new RoomDTO();
        inputRom2.setName("Kitchen");
        inputRom2.setLength(15);
        inputRom2.setWidth(10);

        RoomDTO inputRom3 = new RoomDTO();
        inputRom3.setName("BathRoom");
        inputRom3.setLength(5);
        inputRom3.setWidth(3);

        inputHouse.setRooms(List.of(
                inputRom1,
                inputRom2,
                inputRom3,
                inputRom3
        ));

        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setBiggest(inputRom2);
        expected.setName("The House");
        expected.setPrice(184000);
        expected.setAddress("Some Address");
        expected.setRooms(List.of(
                inputRom1,
                inputRom2,
                inputRom3,
                inputRom3
        ));
        expected.setSquareFeet(230);

        //Act
        HouseResponseDTO result = calculateService.calculate(inputHouse);


        //Assert
        assertEquals(expected.getSquareFeet(), result.getSquareFeet());
        assertEquals(expected.getPrice(), result.getPrice());
        assertEquals(expected.getRooms().size(), result.getRooms().size());

    }
}