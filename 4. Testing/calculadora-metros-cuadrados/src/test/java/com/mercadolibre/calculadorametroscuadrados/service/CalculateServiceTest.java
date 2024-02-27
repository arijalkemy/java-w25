package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {


    CalculateService calculateService = new CalculateService();

    @Test
    void testCalculatePriceOK() {
        HouseDTO houseDTO = new HouseDTO("House1", "Carrera 1 # 12a - 12", List.of(
                new RoomDTO("Room1", 12, 20),
                new RoomDTO("Room2", 20, 20),
                new RoomDTO("Room3", 10, 12)
        ));




    }
}