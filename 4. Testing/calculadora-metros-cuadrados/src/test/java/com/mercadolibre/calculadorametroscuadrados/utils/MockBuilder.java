package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class MockBuilder {

    public static List<HouseDTO> buildHouseDTOList() {
        return List.of(
                buildHouseDTO(),
                buildHouseDTO2(),
                buildHouseDTO3()
        );
    }

    public static HouseDTO buildHouseDTO() {
        return new HouseDTO(
                "Sinson's",
                "Av. Siempreviva 123",
                buildRoomDTOList()
        );
    }

    public static HouseResponseDTO buildHouseResponseDTO() {
        return new HouseResponseDTO(
                455,
                364000,
                buildRoomDTOList().get(2)
        );
    }

    public static HouseDTO buildHouseDTO2() {
        return new HouseDTO(
                "Bojack's",
                "California 2021",
                buildRoomDTOList2()
        );
    }

    public static HouseResponseDTO buildHouseResponseDTO2() {
        return new HouseResponseDTO(
                290,
                232000,
                buildRoomDTOList().get(2)
        );
    }

    public static HouseDTO buildHouseDTO3() {
        return new HouseDTO(
                "White Residence",
                "Dr. Piermont 3828",
                buildRoomDTOList3()
        );
    }

    public static HouseResponseDTO buildHouseResponseDTO3() {
        return new HouseResponseDTO(
                382,
                305600,
                buildRoomDTOList().get(1)
        );
    }

    private static List<RoomDTO> buildRoomDTOList() {
        return List.of(
                new RoomDTO("Baño", 5, 7),
                new RoomDTO("Cocina", 10, 12),
                new RoomDTO("Habitación 2 Personas", 15, 20)
        );
    }

    private static List<RoomDTO> buildRoomDTOList2() {
        return List.of(
                new RoomDTO("Baño", 4, 6),
                new RoomDTO("Cocina", 8, 10),
                new RoomDTO("Sala de estar", 12, 15)
        );
    }

    private static List<RoomDTO> buildRoomDTOList3() {
        return List.of(
                new RoomDTO("Baño", 3, 5),
                new RoomDTO("Dormitorio Principal", 14, 18),
                new RoomDTO("Oficina", 8, 10)
        );
    }
}
