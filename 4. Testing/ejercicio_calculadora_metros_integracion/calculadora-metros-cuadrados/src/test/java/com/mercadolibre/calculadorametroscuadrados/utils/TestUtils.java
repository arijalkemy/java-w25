package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public static HouseResponseDTO getHouseResponseDTO(){
        RoomDTO room1=new RoomDTO();
        RoomDTO room2=new RoomDTO();

        room1.setName("room1");
        room1.setLength(10);
        room1.setWidth(10);

        room2.setName("room2");
        room2.setLength(20);
        room2.setWidth(20);

        List<RoomDTO> listRooms=new ArrayList<>();

        listRooms.add(room1);
        listRooms.add(room2);

        HouseResponseDTO house=new HouseResponseDTO();

        house.setName("house1");
        house.setAddress("crr 46 a 134 sur 16");
        house.setRooms(listRooms);
        house.setSquareFeet(3);
        house.setPrice(300);
        house.setBiggest(room1);

        return house;
    }

    public static HouseDTO getHouseDTO(){
        RoomDTO room1=new RoomDTO();
        RoomDTO room2=new RoomDTO();

        room1.setName("room1");
        room1.setLength(2);
        room1.setWidth(2);

        room2.setName("room2");
        room2.setLength(3);
        room2.setWidth(3);

        List<RoomDTO> listRooms=new ArrayList<>();

        listRooms.add(room1);
        listRooms.add(room2);

        HouseDTO house=new HouseDTO();

        house.setName("house1");
        house.setAddress("crr 47 a 133 sur 16");
        house.setRooms(listRooms);

        return house;
    }
}
