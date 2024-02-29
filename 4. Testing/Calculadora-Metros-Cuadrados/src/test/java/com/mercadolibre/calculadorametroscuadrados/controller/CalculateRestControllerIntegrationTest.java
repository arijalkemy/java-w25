package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.util.TestUtilGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculateTestHouseWithNoRooms() throws Exception {
        HouseDTO request = TestUtilGenerator.getHouseWithNoRooms();
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(request);
        int expectedSquareFeet = 0;
        int expectedPrice = 0;
        RoomDTO expectedBiggestRoom = null;

        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(expectedSquareFeet))
                .andExpect(jsonPath("$.price").value(expectedPrice))
                .andExpect(jsonPath("$.biggest").value(expectedBiggestRoom));
    }

    @Test
    public void calculateTestHouseWithOneRoom() throws Exception {
        HouseDTO request = TestUtilGenerator.getHouseWithOneRoom();
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(request);
        int expectedSquareFeet = 3 * 2;
        int expectedPrice = expectedSquareFeet * 800;
        RoomDTO expectedBiggestRoom = request.getRooms().get(0);

        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(expectedSquareFeet))
                .andExpect(jsonPath("$.price").value(expectedPrice))
                .andExpect(jsonPath("$.biggest.name").value(expectedBiggestRoom.getName()));
    }

    @Test
    public void calculateTestHouseWithThreeRooms() throws Exception {
        HouseDTO request = TestUtilGenerator.getHouseWithThreeRooms();
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(request);
        Integer expectedSquareFeet = (3 * 2) + (2 * 2) + (6 * 4);
        Integer expectedPrice = expectedSquareFeet * 800;
        RoomDTO expectedBiggestRoom = request.getRooms().get(2);

        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(expectedSquareFeet))
                .andExpect(jsonPath("$.price").value(expectedPrice))
                .andExpect(jsonPath("$.biggest.name").value(expectedBiggestRoom.getName()));
    }

}
