package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.ProductDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test integracion - seguir a usuario")
    public void testFollowUser() throws Exception {
        Integer idUser = 1;
        Integer idUserToFollow = 4;
        mockMvc.perform(post("/users/{user_id}/follow/{user_id_to_follow}", idUser, idUserToFollow))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test integracion - agregar un nuevo post")
    public void testAddPost() throws Exception {
        RequestPostDTO requestPostDTO = new RequestPostDTO(4,
                LocalDate.of(2024,02,19),
                new ProductDTO(19,"Mouse Gamer","Gamer", "Racer", "Red", "Special Edition"),
                210,
                24.8);
        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();

        String jsonPayload = mapper.writeValueAsString(requestPostDTO);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
