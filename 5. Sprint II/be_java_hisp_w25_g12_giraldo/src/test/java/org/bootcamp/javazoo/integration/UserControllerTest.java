package org.bootcamp.javazoo.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bootcamp.javazoo.dto.UserDto;
import org.bootcamp.javazoo.dto.response.CountFollowersDto;
import org.bootcamp.javazoo.dto.response.FollowersListDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getFollowersCountTestOk () throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/users/{userId}/followers/count", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        CountFollowersDto expected = new CountFollowersDto(1, "Seller 1", 1);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(expected);

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());

    }

    @Test
    void getFollowersCountTestFail () throws Exception {

        this.mockMvc.perform(get("/users/{userId}/followers/count", "100"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Seller not found"));

    }

    @Test
    void addFollowSellerTestOk () throws Exception{

        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",5,2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Ok"));

    }

    @Test
    @DisplayName("add a follow already followed")
    void addFollowSellerTestFailAlreadyFollow () throws Exception {

        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",5,2))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("The user is already following the seller."));

    }

    @Test
    @DisplayName("add a follow already followed")
    void addFollowSellerTestFailFollowThemselves () throws Exception {

        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",4,4))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("A user cannot follow themselves."));

    }

    @Test
    void unfollowSellerTestOk () throws Exception {

        this.mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",4,1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("You stopped following the seller"));

    }

    @Test
    void unfollowSellerTestFail () throws Exception {

        this.mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",5,3))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User not follow the seller"));

    }

    @Test
    void getFollowersListTestOk () throws Exception {

        List<UserDto> followers = new ArrayList<>(
                List.of(new UserDto(4, "User 4"))
        );
        FollowersListDto followersListDto = new FollowersListDto(1, "Seller 1", followers);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(followersListDto);

        MvcResult mvcResult = this.mockMvc.perform(get("/users/{userId}/followers/list", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getFollowersListTestFail () throws Exception {

        this.mockMvc.perform(get("/users/{userId}/followers/list", "80"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Seller not found"));

    }

    @Test
    void getFollowedListTestOk () throws Exception {

        List<UserDto> followed = new ArrayList<>(
                List.of(new UserDto(1, "Seller 1"))
        );
        FollowersListDto followedListDto = new FollowersListDto(4, "User 4", followed);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(followedListDto);

        MvcResult mvcResult = this.mockMvc.perform(get("/users/{userId}/followed/list", "4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getFollowedListTestFail () throws Exception {

        this.mockMvc.perform(get("/users/{userId}/followed/list", "80"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User not found"));

    }




}
