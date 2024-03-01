package org.bootcamp.javazoo.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.ProductDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    void addNewPostOkTest() throws Exception {

        PostDto postDto = new PostDto(2, "29-04-2021", new ProductDto(1, "Silla Gamer", "Gamer", "Racer", "Red", "Special Edition"), 100, 1500.50);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String json = writer.writeValueAsString(postDto);
        MvcResult mvcResult4 = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("The publication was created successfully"))
                .andReturn();
    }
}
