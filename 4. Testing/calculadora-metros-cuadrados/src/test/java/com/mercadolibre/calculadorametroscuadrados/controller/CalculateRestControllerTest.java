package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {

    @Mock
    CalculateService calculateService;
    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    @SneakyThrows
    void CalculateUnitarioOK(){
        //ARRANGE
        HouseDTO casita = new HouseDTO(
                "Casa MELI",
                "Knowhere",
                List.of(new RoomDTO("Primera", 3, 4),
                        new RoomDTO("Segunda", 4, 3),
                        new RoomDTO("Tercera", 5, 3)));
        HouseResponseDTO casitaExpected = calculateService.calculate(casita);
        //ACT
        HouseResponseDTO casitaRespuesta = calculateRestController.calculate(casita);
        //ASSERT
        System.out.println(casitaExpected);
        System.out.println(casitaRespuesta);
        assertThat(casitaExpected).isEqualTo(casitaRespuesta);
    }






    @Autowired
    MockMvc mockMvc;

    @Test
    @SneakyThrows
    void testCalculateOK() {
        HouseDTO house = new HouseDTO(
                "Casita MeLi",
                "En algun lugar",
                List.of(
                        new RoomDTO("Primera habitacion", 5, 5),
                        new RoomDTO("Segunda habitacion", 10, 10),
                        new RoomDTO("Tercera habitacion", 15, 20)
                )
        );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();
        String requestBody = writer.writeValueAsString(house);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Casita MeLi"))
                .andReturn();
    }
}