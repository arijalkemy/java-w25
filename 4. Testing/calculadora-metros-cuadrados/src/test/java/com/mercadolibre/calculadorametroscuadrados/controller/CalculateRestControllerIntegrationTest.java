package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void calculateOK() throws Exception {
        HouseDTO houseDTO = mockHouseDTO();
        houseDTO.setRooms(Arrays.asList(
                new RoomDTO("Living",6,7),
                new RoomDTO("Principal Room",10,10),
                new RoomDTO("Bathroom",2,3)
        ));
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(houseDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    private HouseDTO mockHouseDTO(){
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("test");
        houseDTO.setAddress("test");
        return houseDTO;
    }
}
