package com.mercadolibre.be_java_hisp_w25_g15.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.MessageResponseDto;
import com.mercadolibre.be_java_hisp_w25_g15.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {
    @Autowired
    IUserService userService;
    @Autowired
    MockMvc mockMvc;
    @Test
    void followUserOK() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        Integer userId=4;
        Integer userIdToFollow=1;
        String expected = writer.writeValueAsString(new MessageResponseDto("Seller followed correctly"));

        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",userId,userIdToFollow))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals(expected, result.getResponse().getContentAsString());
    }
    @Test
    void followUserConflictException() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        Integer userId=4;
        Integer userIdToFollow=4;
        String expected = writer.writeValueAsString(new MessageResponseDto("Users must be different"));

        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",userId,userIdToFollow))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isConflict())
                .andReturn();
        Assertions.assertEquals(expected, result.getResponse().getContentAsString());
    }
    @Test
    void followUserNotFoundException() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        Integer userId=9999;
        Integer userIdToFollow=4;
        String expected = writer.writeValueAsString(new MessageResponseDto("User not found"));

        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",userId,userIdToFollow))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andReturn();
        Assertions.assertEquals(expected, result.getResponse().getContentAsString());
    }
    @Test
    void unfollowUserOk() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        Integer userId=10;
        Integer userIdToUnfollow=9;
        String expected = writer.writeValueAsString(new MessageResponseDto("User unfollowed successfully"));

        MvcResult result = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}",userId,userIdToUnfollow))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals(expected, result.getResponse().getContentAsString());
    }
    @Test
    void unfollowUserBadPathVariable() throws Exception {
        Integer userId=4;
        Integer userIdToUnfollow=-1;
        String expected = "{\"userIdToUnfollow\":\"The user id to unfollow must be a positive integer\"}";

        MvcResult result = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}",userId,userIdToUnfollow))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();
        Assertions.assertEquals(expected, result.getResponse().getContentAsString());
    }
}