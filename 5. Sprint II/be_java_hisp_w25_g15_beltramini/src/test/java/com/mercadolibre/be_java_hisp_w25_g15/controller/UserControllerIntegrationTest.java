package com.mercadolibre.be_java_hisp_w25_g15.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.MessageResponseDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setUp(){
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }
    @Test
    void unfollowUserTestNotFound() throws Exception {
        //Arrange
        Integer userIdParam = 1;
        Integer userIdToUnfollowParam = 2;
        MessageResponseDto messageResponseDto = new MessageResponseDto("Seller is not followed");
        String expected = writer.writeValueAsString(messageResponseDto);
        //Act & Assert
        MvcResult mvcResult = this.mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userIdParam, userIdToUnfollowParam))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().json(expected))
                .andReturn();
    }

    @Test
    void followUserTestOK() throws Exception {
        //Arrange
        Integer userIdParam = 6;
        Integer userIdToFollowParam = 2;
        MessageResponseDto messageResponseDto = new MessageResponseDto("Seller followed correctly");
        String expected = writer.writeValueAsString(messageResponseDto);
        //Act & Assert
        MvcResult mvcResult = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdParam, userIdToFollowParam))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();
    }
}