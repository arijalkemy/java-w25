package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class TestGeneratorUtil {
    public static HouseDTO generateHouseWithThreeRoomsDTO(){
        return new HouseDTO(
                "Mojo Dojo Casa House",
                "Calle Barbie 129, BarbieLand",
                List.of(
                        new RoomDTO(
                                "Comedor",
                                200,
                                300
                        ),
                        new RoomDTO(
                                "Azotea",
                                150,
                                250
                        ),
                        new RoomDTO(
                                "Habitacion principal",
                                100,
                                100
                        )
                )
        );
    }
    public static HouseResponseDTO generateExpectedResponseDTO(){
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(
                generateHouseWithThreeRoomsDTO()
        );
        houseResponseDTO.setBiggest(
                new RoomDTO(
                        "Comedor",
                        200,
                        300
                )
        );
        houseResponseDTO.setSquareFeet(
                200*300 + 150*250 + 100*100
        );
        houseResponseDTO.setPrice(
                (200*300 + 150*250 + 100*100) * 800
        );
        return houseResponseDTO;
    }

}
