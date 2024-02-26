package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {
    static CalculateService calculateService;
    static RoomDTO testRoom1;
    static RoomDTO testRoom2;
    static HouseDTO testHouse;
    static HouseResponseDTO expectedHouse;
    HouseResponseDTO result;
    @BeforeAll
    static void arrange() {
        calculateService = new CalculateService();

        testRoom1 = new RoomDTO();
        testRoom1.setName("Living");
        testRoom1.setLength(6);
        testRoom1.setWidth(6);

        testRoom2 = new RoomDTO();
        testRoom2.setName("Bathroom");
        testRoom2.setLength(3);
        testRoom2.setWidth(3);

        testHouse = new HouseDTO();
        testHouse.setName("Casa");
        testHouse.setAddress("avenida siempre viva");
        testHouse.setRooms(List.of(testRoom1, testRoom2));

        expectedHouse = new HouseResponseDTO();
        expectedHouse.setName("Casa");
        expectedHouse.setAddress("avenida siempre viva");
        expectedHouse.setRooms(List.of(testRoom1, testRoom2));
        expectedHouse.setBiggest(testRoom1);
        expectedHouse.setSquareFeet(45);
        expectedHouse.setPrice(45 * 800);
    }
    @BeforeEach
    void act(){
        result = calculateService.calculate(testHouse);
    }
    @Test
    void assertCalculatePrice() {
        Assertions.assertEquals(expectedHouse.getPrice(), result.getPrice());
    }
    @Test
    void assertCalculateBiggest() {
        Assertions.assertEquals(expectedHouse.getBiggest(), result.getBiggest());
    }
    @Test
    void assertCalculateSquareFeet() {
        Assertions.assertEquals(expectedHouse.getSquareFeet(), result.getSquareFeet());
    }
    @Test
    void assertCalculateRoomsSquareFeet() {
        Assertions.assertEquals(expectedHouse.getRooms().get(0).getSquareFeet(), testRoom1.getLength() * testRoom1.getWidth());
        Assertions.assertEquals(expectedHouse.getRooms().get(1).getSquareFeet(), testRoom2.getLength() * testRoom2.getWidth());
    }
}