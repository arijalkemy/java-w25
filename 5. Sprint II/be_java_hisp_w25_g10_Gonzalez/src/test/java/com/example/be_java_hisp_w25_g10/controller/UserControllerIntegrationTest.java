package com.example.be_java_hisp_w25_g10.controller;

import com.example.be_java_hisp_w25_g10.entities.RolEnum;
import com.example.be_java_hisp_w25_g10.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    void getFollowersIntegrationTest() throws Exception{

        List<User> usersExpected = List.of(
                new User(1, "user1", "lastName", RolEnum.SELLER ),
                new User(3, "user3", "lastName", RolEnum.BUYER )
        );

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String expectedResponse = objectWriter.writeValueAsString(usersExpected);

        MvcResult mvcResult =  mockMvc
                .perform(get("/users/{userId}/followers/list", 2).param("sortOrder", "asc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void FollowIntegrationTest() throws Exception{

        int userId = 4;
        int userToFollow= 2;

        MvcResult mvcResult =  mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userToFollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    void UnfollowIntegrationTest() throws Exception{

        int userId = 4;
        int userToUnfollow= 2;

        MvcResult mvcResult =  mockMvc
                .perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId, userToUnfollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }
}
