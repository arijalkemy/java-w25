package org.bootcamp.javazoo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.javazoo.dto.UserDto;
import org.bootcamp.javazoo.dto.response.FollowersListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getFollowersListTest() throws Exception {
        FollowersListDto followersListDto = new FollowersListDto(1, "Seller 1", List.of(new UserDto(4, "User 4")));
        this.mockMvc.perform(get("/users/1/followers/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(followersListDto.getUser_id()))
                .andExpect(jsonPath("$.user_name").value(followersListDto.getUser_name()))
                .andExpect(jsonPath("$.followers[0].user_id").value(followersListDto.getFollowers().get(0).getUser_id()));
    }

    @Test
    void getFollowersCountTest() throws Exception {
        this.mockMvc.perform(get("/users/1/followers/count"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Seller 1"))
                .andExpect(jsonPath("$.followers_count").value(1));
    }

    @Test
    void getFollowedListTest() throws Exception {
        this.mockMvc.perform(get("/users/4/followed/list")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.user_name").value("User 4"))
                .andExpect(jsonPath("$.followers[0].user_id").value(1))
                .andExpect(jsonPath("$.followers[0].user_name").value("Seller 1"));
    }

    @Test
    void addFollowSeller() throws Exception {
        this.mockMvc.perform(post("/users/4/follow/2")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Ok"));
    }

    @Test
    void unfollowSeller() throws Exception {
        this.mockMvc.perform(post("/users/4/unfollow/1")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("You stopped following the seller"));
    }
}
