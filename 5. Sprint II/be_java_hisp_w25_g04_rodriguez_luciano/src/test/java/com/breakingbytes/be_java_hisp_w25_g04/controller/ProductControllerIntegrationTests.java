package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.ProductDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;
    @Test
    @DisplayName("Actividad B - Se crea el post exitosamente")
    public void addPostTestOk() throws Exception {
        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        ProductDTO productDTO = new ProductDTO(70,"Computadora","Electronica", "HP", "red", "Thin and lightweight design");
        RequestPostDTO request = new RequestPostDTO(3, LocalDate.now(),
                productDTO, 100, 400D);
        String jsonPayload = writter.writeValueAsString(request);
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType("application/json")
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    @DisplayName("Actividad B - No se encontró el ID del vendedor")
    public void addPostsExceptionTest() throws Exception {
        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        ProductDTO productDTO = new ProductDTO(70,"Computadora","Electronica", "HP", "red", "Thin and lightweight design");
        RequestPostDTO request = new RequestPostDTO(1, LocalDate.now(),
                productDTO, 100, 400D);
        String jsonPayload = writter.writeValueAsString(request);
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType("application/json")
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }
}
