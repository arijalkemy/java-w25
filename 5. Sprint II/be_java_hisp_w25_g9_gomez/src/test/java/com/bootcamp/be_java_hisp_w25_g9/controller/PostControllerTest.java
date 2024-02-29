package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageWithFieldDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w25_g9.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {
    //PARTE C BONUS INDIVIDUAL
    //SE LOGRA COVERAGE DEL 95% EN LINEAS
    @Autowired
    MockMvc mockMvc;
    @Autowired
    PostService postService;

    @Test
    void insertNewPostOk() throws Exception{
        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();

        PostResponseDto newPost = new PostResponseDto(null,26, LocalDate.of(2024,2,15),
                new ProductDto(19,"Silla","Gamer","Racer","Red Blak","Special Editiion"),
                100,
                1500.50);
        String message = "Publicación creada con éxito";
        String payLoadNewPost = objectWriter.writeValueAsString(newPost);
        String payLoadJsonExpected = objectWriter.writeValueAsString(new MessageDto(message));

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoadNewPost))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(message))
                .andReturn();

        assertEquals(payLoadJsonExpected,mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }
    @Test
    void insertNewPostNotFoundException() throws Exception{
        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();

        PostResponseDto newPost = new PostResponseDto(null,100, LocalDate.of(2024,2,15),
                new ProductDto(19,"Silla","Gamer","Racer","Red Blak","Special Editiion"),
                100,
                1500.50);
        String message = "El usuario no se encuentra o no es vendedor";
        String payLoadNewPost = objectWriter.writeValueAsString(newPost);
        String payLoadJsonExpected = objectWriter.writeValueAsString(new MessageDto(message));

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoadNewPost))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(message))
                .andReturn();

        assertEquals(payLoadJsonExpected,mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }
    @Test
    void insertNewPostBadRequest() throws Exception{
        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();

        PostResponseDto newPost = new PostResponseDto(null,26, LocalDate.of(2024,2,15),
                new ProductDto(1,"Silla","Gamer","Racer","Red Blak","Special Editiion"),
                100,
                1500.50);
        String message = "El identificador del producto no corresponde con el registrado";
        String payLoadNewPost = objectWriter.writeValueAsString(newPost);
        String payLoadJsonExpected = objectWriter.writeValueAsString(new MessageDto(message));

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoadNewPost))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(message))
                .andReturn();

        assertEquals(payLoadJsonExpected,mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }
    @Test
    void insertNewPostMethodArgumentNotValidException() throws Exception{
        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();

        PostResponseDto newPost = new PostResponseDto(null,26, LocalDate.of(2024,2,15),
                new ProductDto(1,"Silla","Gamer","Racer","Red Blak","Special Editiion"),
                null,
                1500.50);
        String message = "El campo no puede estar vacío.";
        String payLoadNewPost = objectWriter.writeValueAsString(newPost);
        String payLoadJsonExpected = objectWriter.writeValueAsString(new ArrayList<MessageWithFieldDto>(List.of(new MessageWithFieldDto("category",message))));

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoadNewPost))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                //.andExpect(jsonPath("$.message").value(message))
                .andReturn();

        assertEquals(payLoadJsonExpected,mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }
}