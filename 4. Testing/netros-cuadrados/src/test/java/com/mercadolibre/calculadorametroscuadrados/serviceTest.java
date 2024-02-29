package com.mercadolibre.calculadorametroscuadrados;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class serviceTest {

    @Test
    void calculateOk(){
        //arrange
        Integer calculateExpected = 28;
        HouseDTO houseDTO= new HouseDTO();
        houseDTO.setName("EdgHouse");
        houseDTO.setAddress("Cdmx");
        houseDTO.setRooms(
                List.of(
                        new RoomDTO("master",4,3),
                        new RoomDTO("BlueRoom",2,2),
                        new RoomDTO("LivingRoom",2,3),
                        new RoomDTO("Laundry",2,3)
                )
        );
        CalculateService calculateService = new CalculateService();

        //Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);
        //Assert
        assertEquals(calculateExpected, result.getSquareFeet());
    }

    @Test
    void validateMaxRoomOk(){
        RoomDTO expectedBiggestRoom = new RoomDTO("master",4,3);
        HouseDTO houseDTO= new HouseDTO();
        houseDTO.setName("EdgHouse");
        houseDTO.setAddress("Cdmx");
        houseDTO.setRooms(
                List.of(
                        new RoomDTO("master",4,3),
                        new RoomDTO("BlueRoom",2,2),
                        new RoomDTO("LivingRoom",2,3),
                        new RoomDTO("Laundry",2,3)
                )
        );
        CalculateService calculateService = new CalculateService();
        //act
        HouseResponseDTO result =  calculateService.calculate(houseDTO);
        //assert

        assertEquals(expectedBiggestRoom.getName(), result.getBiggest().getName());
        assertEquals(expectedBiggestRoom.getWidth(),result.getBiggest().getWidth());
    }
}
