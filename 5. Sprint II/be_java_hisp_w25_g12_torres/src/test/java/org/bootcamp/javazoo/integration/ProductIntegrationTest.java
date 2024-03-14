package org.bootcamp.javazoo.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.ProductDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.exception.NotFoundException;
import org.bootcamp.javazoo.service.impl.PostServiceImpl;
import org.bootcamp.javazoo.util.MockBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    private static ObjectWriter mapper;
    private static DateTimeFormatter formatter;

    @BeforeAll
    public static void setUp() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void testPostListBySellerWhoUserFollow() throws Exception {
        PostsFollowedUserDto postsFollowedUserDto = new PostsFollowedUserDto(4,
                List.of((new PostResponseDto(1, 1, LocalDate.now().format(formatter), new ProductDto(1, "Laptop", "Electronics", "BrandX", "Silver", "Buen estado"), 1, 500.0)),
                        (new PostResponseDto(1, 2, LocalDate.now().minusDays(5).format(formatter), new ProductDto(2, "Smartphone", "Electronics", "BrandY", "Negro", "Usado"), 2, 300.0))
                ));
        String expected = mapper.writeValueAsString(postsFollowedUserDto);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.posts").isNotEmpty())
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void testPostListBySellerWhoUserFollowThrow() throws Exception {
        MessageDto errorDto = new MessageDto("the user does not follow any seller");
        Integer userId = 5;
        String errorExpected = mapper.writeValueAsString(errorDto);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(errorExpected, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void testAddNewPostOk() throws Exception {
        PostDto postDto = new PostDto(1, "20-02-2024", new ProductDto(1, "Silla Gamer", "Gamer", "Racer", "Red", "Special Edition"),
                100, 1500.50);

        String jsonPayload = mapper.writeValueAsString(postDto);

        this.mockMvc.perform(post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void testAddNewPostAlreadyExists() throws Exception {
        PostDto postDto = new PostDto(1, "20-02-2024", new ProductDto(1, "Silla Gamer", "Gamer", "Racer", "Red", "Special Edition"),
                100, 1500.50);

        String jsonPayload = mapper.writeValueAsString(postDto);

        MvcResult mvcResult = this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }

}
