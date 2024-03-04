package com.bootcamp.be_java_hisp_w25_g02.integration;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerCountDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerListDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserFollowingDTO;
import com.bootcamp.be_java_hisp_w25_g02.util.TestUtilGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    @DisplayName("Individual - getFollowedSellers - Integration Test")
    void getFollowedSellersOK() throws Exception {
        // Arrange
        Integer id = 12;

        UserFollowingDTO responseDTO = TestUtilGenerator.getCorrectAscUserFollowingDTO_id12();

        String expectedJson = writer.writeValueAsString(responseDTO);

        // Act
        MvcResult result = mockMvc.perform(get("/users/{userId}/followed/list", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Assert
        assertEquals(expectedJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Individual Bonus - followSeller - Integration Test")
    void followSellerOK() throws Exception {
        // Arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 9;

        // Act + Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Individual Bonus - unfollowSeller - Integration Test")
    void unfollowSellerOK() throws Exception {
        // Arrange
        Integer userId = 1;
        Integer userIdToFollow = 9;

        // Act + Assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Individual Bonus - getFollowersList - Integration Test")
    void getFollowersList() throws Exception {
        // Arrange
        Integer id = 7;
        FollowerListDTO expected = TestUtilGenerator.getFollowerListDTOId7();
        String expectedJson = writer.writeValueAsString(expected);

        // Act
        MvcResult result = mockMvc.perform(get("/user/{userId}/followers", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Assert
        assertEquals(expectedJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Individual Bonus - getUserTotalFollowers - Integration Test")
    void getUserTotalFollowers() throws Exception {
        // Arrange
        Integer id = 7;
        FollowerCountDTO expected = TestUtilGenerator.getCorrectFollowerCountDTOId1();
        String expectedJson = writer.writeValueAsString(expected);

        // Act
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/count", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Assert
        assertEquals(expectedJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
