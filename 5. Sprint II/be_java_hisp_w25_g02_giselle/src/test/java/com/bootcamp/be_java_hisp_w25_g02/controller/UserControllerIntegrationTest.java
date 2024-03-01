package com.bootcamp.be_java_hisp_w25_g02.controller;


import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerListDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    @SneakyThrows
    @DisplayName("Integration test - getUsertotalFollowers")

    // Requerimientos incrementales (Desarrollo INDIVIDUAL)
    public void getUserTotalFollowersTest(){
        // Arrange

        Integer userId = 9;
        String order = "name_asc";
        FollowerListDTO followerListDTO = new FollowerListDTO(
                9,
                "Malena",
                List.of(
                        new UserDTO(1, "Javier"),
                        new UserDTO(7, "Maria"),
                        new UserDTO(3, "Martin")
                ));

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String expectedResult = objectWriter.writeValueAsString(followerListDTO);

        // Act

        MvcResult myResult = mockMvc.perform(get("/user/{userId}/followers", userId)
                        .param("order", order)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Assert
        Assertions.assertEquals(expectedResult, myResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

@Test
@SneakyThrows
@DisplayName("Integration test - followUser")
    public void followUserTest(){
        //Arrange
        Integer userId = 1;
        Integer userFollowId = 7;

        //Act + Assert
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userFollowId))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    @DisplayName("Integration test - unfollowUser")
    public void unfollowUserTest(){
        //Arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 7;

        //Act + Assert
        this.mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
