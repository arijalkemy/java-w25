package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateRestControllerTest {

    CalculateRestController calculateRestController = new CalculateRestController();

    @Test
    void calculateOK(){
        HouseDTO houseDTO = mockHouseDTO();
        houseDTO.setRooms(Arrays.asList(
                new RoomDTO("Living",6,7),
                new RoomDTO("Principal Room",10,10),
                new RoomDTO("Bathroom",2,3)
        ));
        HouseResponseDTO houseResponseDTOExpected = new HouseResponseDTO(houseDTO);
        houseResponseDTOExpected.setBiggest(new RoomDTO("Principal Room",10,10));
        houseResponseDTOExpected.setSquareFeet(148);
        houseResponseDTOExpected.setPrice(118400);

        HouseResponseDTO houseResponseDTOObtained = calculateRestController.calculate(houseDTO);

        assertThat(houseResponseDTOObtained).usingRecursiveComparison().isEqualTo(houseResponseDTOExpected);

    }
    private HouseDTO mockHouseDTO(){
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("test");
        houseDTO.setAddress("test");
        return houseDTO;
    }
}
