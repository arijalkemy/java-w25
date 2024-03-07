package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.util.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    ObjectFactory objectFactory = new ObjectFactory();

    /*@Test
    void calculateHouseWithNoRooms() {
        HouseDTO house = new HouseDTO();
        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);

        HouseResponseDTO actualResponse = calculateService.calculate(house);
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }*/

    @Test
    void calculateHouseWithOneRoom() {
        HouseDTO house = objectFactory.getOneRoomHouse();
        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);

        int expectedPrice = objectFactory.getOneRoomHousePrice();
        int expectedSquareFeet = objectFactory.getOneRoomHouseSquareFeet();
        RoomDTO expectedBiggestRoom = objectFactory.getOneRoomHouseBiggestRoom();
        expectedResponse.setBiggest(expectedBiggestRoom);
        expectedResponse.setPrice(expectedPrice);
        expectedResponse.setSquareFeet(expectedSquareFeet);

        HouseResponseDTO actualResponse = calculateService.calculate(house);
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Test
    void calculateHouseWithMultipleRooms() {

        HouseDTO house = objectFactory.getMultipleRoomHouse();
        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);


        int expectedPrice = objectFactory.getMultipleRoomHousePrice();
        int expectedSquareFeet = objectFactory.getMultipleRoomHouseSquareFeet();
        RoomDTO expectedBiggestRoom = objectFactory.getMultipleRoomHouseBiggestRoom();
        expectedResponse.setBiggest(expectedBiggestRoom);
        expectedResponse.setPrice(expectedPrice);
        expectedResponse.setSquareFeet(expectedSquareFeet);

        HouseResponseDTO actualResponse = calculateService.calculate(house);

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }

}
