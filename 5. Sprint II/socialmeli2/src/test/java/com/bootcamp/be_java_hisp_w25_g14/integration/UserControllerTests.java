package com.bootcamp.be_java_hisp_w25_g14.integration;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    private final String USER_ENDPOINT = "/users";

    @Test
    @DisplayName("Follow User - Success")
    void testFollowUser_Success() throws Exception {
        mockMvc.perform(get(USER_ENDPOINT + "/{userId}/follow/{userIdToFollow}",
                        4, 2))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Follow successfully"));
    }



    @Test
    @DisplayName("Unfollow User - Success")
    void testUnfollowUser_Success() throws Exception {
        mockMvc.perform(get(USER_ENDPOINT + "/{userId}/unfollow/{userIdToUnfollow}",
                        4, 2))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Unfollow successfully"));


    }

    @Test
    @DisplayName("Follow User - Exception")
    public void testFollowUserException() throws Exception {
        mockMvc.perform(get(USER_ENDPOINT + "/{userId}/follow/{userIdToFollow}", "1", "1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Unable to follow itself"))
                .andExpect(content().contentType("application/json"));
    }



}
