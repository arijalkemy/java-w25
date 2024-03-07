package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class ObjectFactory {

    public HouseDTO getOneRoomHouse() {
        return new HouseDTO(
                "Monoambiente",
                "221B Baker Street, London",
                List.of(getCocina()));
    }

    public HouseDTO getMultipleRoomHouse() {
        return new HouseDTO(
                "Casa familiar",
                "Av. Libertador 123, Argentina",
                getRoomsList());
    }

    public List<RoomDTO> getRoomsList() {
        return List.of(
                getCocina(),
                getBanio(),
                getSalon()
        );
    }

    public RoomDTO getSalon() {
        return new RoomDTO("salon", 400, 500);
    }

    public RoomDTO getBanio() {
        return new RoomDTO("baño", 50, 10);
    }

    public RoomDTO getCocina() {
        return new RoomDTO("cocina", 100, 100);
    }

    public int getMultipleRoomHousePrice() {
        return 168400000;
    }

    public int getMultipleRoomHouseSquareFeet() {
        return 210500;
    }

    public RoomDTO getMultipleRoomHouseBiggestRoom() {
        return getSalon();
    }

    public int getOneRoomHousePrice() {
        return 8000000;
    }

    public int getOneRoomHouseSquareFeet() {
        return 10000;
    }

    public RoomDTO getOneRoomHouseBiggestRoom() {
        return getCocina();
    }
}
