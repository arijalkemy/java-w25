package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtilGenerator {

    public static HouseDTO getHouseWithNoRooms() {
        return getHouse("Simpson's", "Fake street 123", new ArrayList<>());
    }

    public static HouseDTO getHouseWithOneRoom() {
        RoomDTO room = getRoom("Bart's Bedroom", 3, 2);
        return getHouse("Simpson's", "Fake street 123", List.of(room));
    }

    public static HouseDTO getHouseWithThreeRooms() {
        RoomDTO room1 = getRoom("Bart's Bedroom", 3, 2);
        RoomDTO room2 = getRoom("Lisa's Bedroom", 2, 2);
        RoomDTO room3 = getRoom("Living Room", 6, 4);
        return getHouse("Simpson's", "Fake street 123", List.of(room1, room2, room3));
    }

    public static HouseResponseDTO getResponse(Integer squareFeet, Integer price, RoomDTO biggest){
        HouseResponseDTO response = new HouseResponseDTO();
        response.setSquareFeet(squareFeet);
        response.setPrice(price);
        response.setBiggest(biggest);
        return response;
    }

    private static HouseDTO getHouse(String name, String address, List<RoomDTO> rooms) {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName(name);
        houseDTO.setAddress(address);
        houseDTO.setRooms(rooms);
        return houseDTO;
    }

    private static RoomDTO getRoom(String name, Integer length, Integer width) {
        RoomDTO room = new RoomDTO();
        room.setName(name);
        room.setLength(length);
        room.setWidth(width);
        return room;
    }

}
