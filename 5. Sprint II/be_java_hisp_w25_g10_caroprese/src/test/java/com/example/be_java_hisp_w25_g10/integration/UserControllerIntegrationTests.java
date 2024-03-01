package com.example.be_java_hisp_w25_g10.integration;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void followUserTestOk() throws Exception {

        int userId = 4;
        int userToFollowId = 2;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userToFollowId)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void tryToFollowBuyerTest() throws Exception {

        int userId = 2;
        int userToFollowId = 4;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userToFollowId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest());

    }

    @Test
    void tryToFollowNonUserTest() throws Exception {

        int userId = 2;
        int userToFollowId = 9;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userToFollowId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());

    }

    @Test
    void unFollowUserTestOk() throws Exception {

        int userId = 1;
        int userToUnfollowId = 2;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", userId, userToUnfollowId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void tryToFollowNonUserTestOk() throws Exception {

        int userId = 1;
        int userToUnfollowId = 9;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", userId, userToUnfollowId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());

    }


}
