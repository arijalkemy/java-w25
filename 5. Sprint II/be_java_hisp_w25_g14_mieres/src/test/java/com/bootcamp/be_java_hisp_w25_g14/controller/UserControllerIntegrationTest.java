package com.bootcamp.be_java_hisp_w25_g14.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("T0012 - Follow User OK")
    void followUserIntegrationTest() throws Exception {
        String userId = "3";
        String userIdToFollow = "1" ;

        mockMvc.perform(get(String.format("/users/%s/follow/%s",userId,userIdToFollow)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Follow successfully"));
    }
    @Test
    @DisplayName("T0013 - Unfollow User OK")
    void unfollowUserIntegrationTestOk() throws Exception {
        String userId = "1";
        String userIdToFollow = "2";

        mockMvc.perform(get(String.format("/users/%s/unfollow/%s",userId,userIdToFollow)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Unfollow successfully"));
    }

    @Test
    @DisplayName("T0014 - Get Followed Users OK")
    void getFollowedUsersIntegrationTest() throws Exception {
        String userId = "1";
        String order = "name_asc";

        mockMvc.perform(get(String.format("/users/%s/followed/list?order=%s",userId,order)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers").isNotEmpty());
    }

    @Test
    @DisplayName("T0015 - Get Follower Count OK")
    void getFollowerCountIntegrationTest() throws Exception {
        String userId = "1";

        mockMvc.perform(get(String.format("/users/%s/followers/count",userId)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").isNumber());
    }

    @Test
    @DisplayName("T0016 - Get Followers List OK")
    void getFollowersListIntegrationTest() throws Exception {
        String userId = "1";

        mockMvc.perform(get(String.format("/users/%s/followers/list",userId)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers").isNotEmpty());
    }

}
