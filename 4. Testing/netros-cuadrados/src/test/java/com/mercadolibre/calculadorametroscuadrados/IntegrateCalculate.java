package com.mercadolibre.calculadorametroscuadrados;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrateCalculate {
    @Autowired
    MockMvc mockMvc;

    @Test
    void verfifyCalculateTest() throws Exception{
        Integer expectSquereFeets = 28;
        HouseDTO houseDTO= new HouseDTO();
        houseDTO.setName("EdgHouse");
        houseDTO.setAddress("Cdmx");
        houseDTO.setRooms(
                List.of(
                        new RoomDTO("master",4,3),
                        new RoomDTO("BlueRoom",2,2),
                        new RoomDTO("LivingRoom",2,3),
                        new RoomDTO("Laundry",2,3)
                )
        );

        mockMvc.perform(post("/calculate")
                .contentType("application/json")
                .content(parseObjetToJsonString(houseDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(expectSquereFeets));
    }

    @Test
    void verfifyBiggestRoomTest() throws Exception{
        HouseDTO houseDTO= new HouseDTO();
        houseDTO.setName("EdgHouse");
        houseDTO.setAddress("Cdmx");
        houseDTO.setRooms(
                List.of(
                        new RoomDTO("master",4,3),
                        new RoomDTO("BlueRoom",2,2),
                        new RoomDTO("LivingRoom",2,3),
                        new RoomDTO("Laundry",2,3)
                )
        );

        mockMvc.perform(post("/calculate")
                .contentType("application/json")
                .content(parseObjetToJsonString(houseDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.biggest.name").value("master"));
    }

    private String parseObjetToJsonString(Object payload) throws JsonProcessingException {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        return writer.writeValueAsString(payload);
    }

}
