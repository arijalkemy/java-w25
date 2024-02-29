package com.mercadolibre.be_java_hisp_w25_g15.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void followUser() throws Exception{
        Integer userId = 1;
        Integer userIdToFollow = 2;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
        .andExpect(status().isOk())
        .andDo(print())
        .andExpect(content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Seller followed correctly"));
    }

    @Test
    void countFollowers() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", 1))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followersCount").value(0));
    }


    @Test
    void getAllUsers() throws Exception{
        mockMvc.perform(get("/users/get-users"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    void getAllFollowedByUser() {
    }

    @Test
    void getAllFollowersByUser() {
    }
}