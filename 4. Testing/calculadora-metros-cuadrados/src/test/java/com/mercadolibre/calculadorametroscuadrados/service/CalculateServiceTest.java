package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mercadolibre.calculadorametroscuadrados.utils.MockBuilder.buildHouseDTO;
import static com.mercadolibre.calculadorametroscuadrados.utils.MockBuilder.buildHouseResponseDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    CalculateService calculateService;

    @BeforeEach
    void setup() {
        calculateService = new CalculateService();
    }

    /*Devuelve el cálculo correcto del valor de la propiedad basado en la cantidad de metros cuadrados*/
    @Test
    @DisplayName("Cálculo del valor de la propiedad (Service) - Éxito")
    void calculateTestOk() {
        HouseDTO mockHouse = buildHouseDTO();
        HouseResponseDTO expectedHouse = buildHouseResponseDTO();

        HouseResponseDTO currentHouse = calculateService.calculate(mockHouse);

        assertEquals(expectedHouse.getPrice(), currentHouse.getPrice());
        assertEquals(expectedHouse.getSquareFeet(), currentHouse.getSquareFeet());
        assertEquals(expectedHouse.getBiggest().getSquareFeet(), currentHouse.getBiggest().getSquareFeet());
    }

    /*Retornar los datos de la habitación más grande basado en las propiedades “width” y “height”*/
    @Test
    @DisplayName("Habitación con las mayores dimensiones = la más grande (Service) - Éxito")
    void biggestRoomOk() {
        HouseDTO mockHouse = buildHouseDTO();
        HouseResponseDTO expectedHouse = buildHouseResponseDTO();

        HouseResponseDTO currentHouse = calculateService.calculate(mockHouse);

        assertEquals(expectedHouse.getBiggest().getSquareFeet(), currentHouse.getBiggest().getSquareFeet());
    }

    /*Devolver la cantidad correcta de metros cuadrados por habitación*/
    @Test
    @DisplayName("Cant. de m2 por habitación (Service) - Éxito")
    void squareMetersPerRoom() {
        HouseDTO mockHouse = buildHouseDTO();

        for (RoomDTO room : mockHouse.getRooms()) {
            Integer expectedSquareFeet = room.getWidth() * room.getLength();
            assertEquals(expectedSquareFeet, room.getSquareFeet());
        }
    }
}
