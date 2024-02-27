package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    void calculetaOK(){
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

        HouseResponseDTO houseResponseDTOObtained = calculateService.calculate(houseDTO);

        assertThat(houseResponseDTOObtained).usingRecursiveComparison().isEqualTo(houseResponseDTOExpected);
    }
    @Test
    void calculateHouseWithoutMeters(){
        HouseDTO houseDTO = mockHouseDTO();
        houseDTO.setRooms(Arrays.asList(
                new RoomDTO("Living",0,0),
                new RoomDTO("Principal Room",0,0),
                new RoomDTO("Bathroom",0,0)
        ));
        HouseResponseDTO houseResponseDTOExpected = new HouseResponseDTO(houseDTO);
        houseResponseDTOExpected.setBiggest(new RoomDTO("Living",0,0));
        houseResponseDTOExpected.setSquareFeet(0);
        houseResponseDTOExpected.setPrice(0);

        HouseResponseDTO houseResponseDTOObtained = calculateService.calculate(houseDTO);

        assertThat(houseResponseDTOObtained).usingRecursiveComparison().isEqualTo(houseResponseDTOExpected);
    }
    private HouseDTO mockHouseDTO(){
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("test");
        houseDTO.setAddress("test");
        return houseDTO;
    }
}
