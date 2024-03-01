package com.grupo08.socialmeli.controller;

import com.grupo08.socialmeli.utils.TestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.grupo08.socialmeli.dto.ExceptionDto;
import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.entity.Product;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllPosts() {
    }

    @Test
    void followProcducts() {
    }

    @Test
    void insertPost() throws Exception {
        PostDto entryPostDto = new PostDto(
            1, 
            LocalDate.of(2024,01, 01),
                new Product(
                        5,
                        "Silla gamer #2",
                        "Gamer",
                        "Racer",
                        "Blue & Green",
                        "Cheap Edition"
                ),
                1, 
                23.0
        );

        ExceptionDto expected = new ExceptionDto("Todo Ok");

        MvcResult mvcResult =
            mockMvc.perform(post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestData.objectToJson(entryPostDto))
            )
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
        assertEquals(TestData.objectToJson(expected), mvcResult.getResponse().getContentAsString());
    }
}