package com.mercadolibre.be_java_hisp_w25_g15.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.be_java_hisp_w25_g15.model.Post;
import com.mercadolibre.be_java_hisp_w25_g15.model.Product;
import com.mercadolibre.be_java_hisp_w25_g15.service.IPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegrationTest {
    @Autowired
    IPostService postService;
    @Autowired
    MockMvc mockMvc;
    @Test
    void createPostOK() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter writer = objectMapper.writer();
        Post postToCreate = new Post(
                1,
                LocalDate.now().minusDays(1),
                new Product(1, "Mouse", "Electronico", "Logitech", "Negro", ""),
                1,
                300.0
        );
        String jsonPostToCreate = writer.writeValueAsString(postToCreate);

        mockMvc.perform(post("/products/post")
                .content(jsonPostToCreate).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void createPostNotesSpecialCharactersException() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter writer = objectMapper.writer();
        Post postToCreate = new Post(
                1,
                LocalDate.now().minusDays(1),
                new Product(1, "Mouse", "Electronico", "Logitech", "Negro", "&"),
                1,
                300.0
        );
        String jsonPostToCreate = writer.writeValueAsString(postToCreate);
        String expectedJson = "{\"product.notes\":\"The notes cannot contain special characters\"}";

        MvcResult result = mockMvc.perform(post("/products/post")
                        .content(jsonPostToCreate).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(expectedJson, result.getResponse().getContentAsString());
    }
    @Test
    void createPostPriceNotValidException() throws Exception {
        String jsonPostToCreate = "{\"date\":\"28-02-2024\",\"product\":{\"type\":\"Electronico\",\"brand\":\"Logitech\",\"color\":\"Negro\",\"notes\":\"\",\"product_id\":1,\"product_name\":\"Mouse\"},\"category\":1,\"price\":\"a\",\"post_id\":5,\"user_id\":1}";
        String expectedJson = "{\"message\":\"JSON parse error: Cannot deserialize value of type `java.lang.Double` from String \\\"a\\\": not a valid `Double` value\"}";

        MvcResult result = mockMvc.perform(post("/products/post")
                        .content(jsonPostToCreate).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(expectedJson, result.getResponse().getContentAsString());
    }
}