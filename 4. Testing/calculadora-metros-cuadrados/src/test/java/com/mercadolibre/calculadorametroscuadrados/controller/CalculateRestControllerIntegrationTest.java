package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    void calculate() throws Exception {
        RoomDTO testRoom1 = new RoomDTO();
        testRoom1.setName("Living");
        testRoom1.setLength(6);
        testRoom1.setWidth(6);
        RoomDTO testRoom2 = new RoomDTO();
        testRoom2.setName("Bathroom");
        testRoom2.setLength(3);
        testRoom2.setWidth(3);
        HouseDTO testHouse = new HouseDTO();
        testHouse.setName("Casa");
        testHouse.setAddress("avenida siempre viva");
        testHouse.setRooms(List.of(testRoom1, testRoom2));

        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setName("Casa");
        expected.setAddress("avenida siempre viva");
        expected.setRooms(List.of(testRoom1, testRoom2));
        expected.setBiggest(testRoom1);
        expected.setSquareFeet(45);
        expected.setPrice(45*800);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String postJson = writer.writeValueAsString(testHouse);
        String expectedJson = writer.writeValueAsString(expected);

        MvcResult result = mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(postJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
    }
}