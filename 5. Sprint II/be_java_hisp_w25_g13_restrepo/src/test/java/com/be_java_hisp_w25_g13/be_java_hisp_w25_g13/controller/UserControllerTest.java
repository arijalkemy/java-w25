package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.controller;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service.UserServiceImpl;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    UserServiceImpl userService;

    @Test
    void followUserOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,21))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    void followUserNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",999,21))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_NOT_FOUND_ERROR_MESSAGE));
    }
    @Test
    void followSellerNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.SELLER_TO_FOLLOW_NOT_FOUND_ERROR_MESSAGE));
    }
    @Test
    void followUserToFollowNotSeller() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,2))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_IS_NOT_SELLER_ERROR_MESSAGE));
    }
    @Test
    void followUserAlreadyFollow() throws Exception {
        userService.followUser(2,21);
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",2,21))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.ALREADY_FOLLOWED_SELLER_ERROR_MESSAGE));
    }
    @Test
    void unFollowUserOK() throws Exception {
        userService.followUser(3,21);
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}",3,21))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    void unFollowUserNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}",999,21))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_NOT_FOUND_ERROR_MESSAGE));
    }
    @Test
    void unFollowSellerNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}",1,999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.SELLER_NOT_FOUND_ERROR_MESSAGE));
    }
    @Test
    void unFollowSellerNotFollowed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}",1,22))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.NOT_FOLLOWED_SELLER_ERROR_MESSAGE));
    }
    @Test
    void getFollowersCountOK() throws Exception {
        userService.followUser(4,22);
        userService.followUser(5,22);
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",22))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followersCount").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(22));
    }
    @Test
    void getFollowersCountUserNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_NOT_FOUND_ERROR_MESSAGE));
    }
    @Test
    void getFollowersListOK() throws Exception {
        userService.followUser(4,24);
        userService.followUser(5,24);
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",24))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void getFollowersListNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",30))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.SELLER_DONT_HAVE_FOLLOWERS_ERROR_MESSAGE));
    }
    @Test
    void getFollowersListUserNotSeller() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",4))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_IS_NOT_SELLER_ERROR_MESSAGE));
    }
    @Test
    void getFollowedListOK() throws Exception {
        userService.followUser(6,26);
        userService.followUser(6,27);
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",6))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void getFollowedUserNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_NOT_FOUND_ERROR_MESSAGE));
    }
}