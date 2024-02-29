package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {
    CalculateService service;

    @BeforeEach
    public void setUp(){
        service=new CalculateService();
    }

    @Test
    void calculatePriceOK(){
        // Arrange
        HouseDTO house= TestUtils.getHouseDTO();

        // Act
        HouseResponseDTO houseResult=service.calculate(house);

        // Assert
        Assertions.assertEquals(10400, houseResult.getPrice());
    }

    @Test
    void roomWithMostWithAndHeightIsBiggets(){
        // Arrange
        HouseDTO house=TestUtils.getHouseDTO();
        RoomDTO room=new RoomDTO();

        room.setName("room2");
        room.setWidth(3);
        room.setLength(3);

        // Act
        HouseResponseDTO houseResult=service.calculate(house);

        // Assert
        Assertions.assertEquals(room.getLength(), houseResult.getBiggest().getLength());
        Assertions.assertEquals(room.getWidth(), houseResult.getBiggest().getWidth());
    }

    @Test
    void verifySquareMetersByRoom(){
        // Arrange
        HouseDTO house=TestUtils.getHouseDTO();
        RoomDTO room=new RoomDTO();

        room.setName("room1");
        room.setWidth(2);
        room.setLength(2);

        // Act
        HouseResponseDTO houseResult=service.calculate(house);

        // Assert
        Assertions.assertEquals(room.getSquareFeet(), houseResult.getRooms().get(0).getSquareFeet());
    }

}