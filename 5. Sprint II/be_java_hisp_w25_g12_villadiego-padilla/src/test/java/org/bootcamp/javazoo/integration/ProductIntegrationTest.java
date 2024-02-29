package org.bootcamp.javazoo.integration;

import org.bootcamp.javazoo.dto.PostResponseDto;
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
    void getPostsBySellerOfUserOkTest() throws Exception {
        String expected = "{\"userId\":4,\"posts\":[{\"user_id\":1,\"post_id\":2,\"date\":\"24-02-2024\",\"product\":{\"product_id\":2,\"product_name\":\"Smartphone\",\"type\":\"Electronics\",\"brand\":\"BrandY\",\"color\":\"Negro\",\"notes\":\"Usado\"},\"category\":2,\"price\":300.0},{\"user_id\":1,\"post_id\":1,\"date\":\"29-02-2024\",\"product\":{\"product_id\":1,\"product_name\":\"Laptop\",\"type\":\"Electronics\",\"brand\":\"BrandX\",\"color\":\"Silver\",\"notes\":\"Buen estado\"},\"category\":1,\"price\":500.0}]}";

        MvcResult mvcResult4 = mockMvc.perform(get("/products/followed/{userId}/list", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, mvcResult4.getResponse().getContentAsString());
    }

    @Test
    void addNewPostOkTest() throws Exception {
        String payload = "{\"user_id\": 2, \"date\": \"29-04-2021\", \"product\": {\"product_id\": 1, \"product_name\": \"Silla Gamer\", \"type\": \"Gamer\", \"brand\": \"Racer\", \"color\": \"Red\", \"notes\": \"Special Edition\"}, \"category\": 100, \"price\": 1500.50}";

        MvcResult mvcResult4 = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("The publication was created successfully"))
                .andReturn();
    }
}
