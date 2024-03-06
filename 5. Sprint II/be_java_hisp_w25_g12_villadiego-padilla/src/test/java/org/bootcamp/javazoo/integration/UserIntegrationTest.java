package org.bootcamp.javazoo.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {a

    @Autowired
    MockMvc mockMvc;

    @Test
    void getFollowersCountOkTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").exists())
                .andExpect(jsonPath("$.user_name").exists())
                .andExpect(jsonPath("$.followers_count").exists())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Seller 1"))
                .andExpect(jsonPath("$.followers_count").value(1))
                .andReturn();
    }

    @Test
    void getFollowersListOkTest() throws Exception {
        MvcResult mvcResult2 = mockMvc.perform(get("/users/{userId}/followers/list", 1)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").exists())
                .andExpect(jsonPath("$.user_name").exists())
                .andExpect(jsonPath("$.followers").exists())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Seller 1"))
                .andExpect(jsonPath("$.followers").isArray())
                .andReturn();
    }

    @Test
    void getFollowedListOkTest() throws Exception {
        MvcResult mvcResult3 = mockMvc.perform(get("/users/{userId}/followed/list", 4)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").exists())
                .andExpect(jsonPath("$.user_name").exists())
                .andExpect(jsonPath("$.followers").exists())
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.user_name").value("User 4"))
                .andExpect(jsonPath("$.followers").isArray())
                .andReturn();
    }

    @Test
    void addFollowSellerOkTest() throws Exception {
        MvcResult mvcResult4 = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 4, 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Ok"))
                .andReturn();
    }

    @Test
    void unfollowSellerIsNoOkTest() throws Exception {
        MvcResult mvcResult5 = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 5, 2))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User not follow the seller"))
                .andReturn();
    }
}
