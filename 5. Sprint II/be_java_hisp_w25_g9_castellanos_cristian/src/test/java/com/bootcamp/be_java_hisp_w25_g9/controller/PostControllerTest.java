package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.PostResponseDto;
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

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void insertNewPostOk() throws Exception {
        //ARRANGE
        ProductDto productEntry = new ProductDto(1, "Camisa", "Ropa", "Marca A", "Azul", "Algodon");
        PostRequestDto entry = new PostRequestDto(26, LocalDate.now(), productEntry, 1, 12.0);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String payloadJson = writer.writeValueAsString(entry);
        //ASSERT
        MvcResult response = mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Publicación creada con éxito"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void insertNewPostNotOkNotFoundException() throws Exception{
        //ARRANGE
        ProductDto productEntry = new ProductDto(1, "Camisa", "Ropa", "Marca A", "Azul", "Algodon");
        PostRequestDto entry = new PostRequestDto(101, LocalDate.now(), productEntry, 1, 12.0);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String payloadJson = writer.writeValueAsString(entry);
        //ASSERT
        MvcResult response = mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El usuario no se encuentra o no es vendedor"))
                .andReturn();
    }

    @Test
    void insertNewPostNotOkNotSeller() throws Exception{
        //ARRANGE
        ProductDto productEntry = new ProductDto(1, "Camisa", "Ropa", "Marca A", "Azul", "Algodon");
        PostRequestDto entry = new PostRequestDto(1, LocalDate.now(), productEntry, 1, 12.0);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String payloadJson = writer.writeValueAsString(entry);
        //ASSERT
        MvcResult response = mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El usuario no se encuentra o no es vendedor"))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void insertNewPostNotOkBadRequest() throws Exception{
        //ARRANGE
        ProductDto productEntry = new ProductDto(1, "Camisa", "Ropa", "Marca B", "Azul", "Algodon");
        PostRequestDto entry = new PostRequestDto(26, LocalDate.now(), productEntry, 1, 12.0);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String payloadJson = writer.writeValueAsString(entry);
        //ASSERT
        MvcResult response = mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El identificador del producto no corresponde con el registrado"))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void insertNewPostOkNewProduct() throws Exception{
        //ARRANGE
        ProductDto productEntry = new ProductDto(101, "Camisa", "Ropa", "Marca A", "Azul", "Algodon");
        PostRequestDto entry = new PostRequestDto(26, LocalDate.now(), productEntry, 1, 12.0);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String payloadJson = writer.writeValueAsString(entry);
        //ASSERT
        MvcResult response = mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    void getFollowedPost() throws Exception {
        //ARRANGE
        int userId = 1;
        //ASSERT
        MvcResult response = mockMvc.perform(get("/products/followed/{userId}/list",userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(1))
                .andReturn();
    }

    @Test
    void getFollowedPostOrderByDate() throws Exception {
        //ARRANGE
        int userId = 1;
        //ASSERT
        MvcResult response = mockMvc.perform(get("/products/followed/{userId}/list?order=date_asc",userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(1))
                .andReturn();
    }
}