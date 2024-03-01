package com.bootcamp.be_java_hisp_w25_g9.integration;

import com.bootcamp.be_java_hisp_w25_g9.dto.UserDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowersDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeEach
    void setUp() throws Exception {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    void followUser() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 4, 26)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Vendedor seguido con éxito"));
    }

    @Test
    void unfollowUser() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 3, 27)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(
                        "El vendedor ha sido quitado de la lista de seguidos del cliente"));
    }

    @Test
    void countFollowers() throws Exception {
        int sellerId = 28;
        String sellerName = "Zelda Atlas";
        int followersCount = 2;
        FollowersCountDto followersCountDto = new FollowersCountDto(sellerId, sellerName,
                followersCount);

        mockMvc.perform(get("/users/{userId}/followers/count", sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(writer.writeValueAsString(followersCountDto)));
    }

    @Test
    void getFollowersList() throws Exception {
        int sellerId = 28;
        String sellerName = "Zelda Atlas";
        List<UserDto> followers = new ArrayList<>(List.of(
                new UserDto(1, "Quynn Nunez"),
                new UserDto(3, "Sylvia Catalina")
        ));
        FollowersDto followersDto = new FollowersDto(sellerId, sellerName, followers);

        mockMvc.perform(get("/users/{userId}/followers/list", sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(writer.writeValueAsString(followersDto)));
    }

    @Test
    void getFollowedList() throws Exception {
        int clientId = 3;
        String clientName = "Sylvia Catalina";
        List<UserDto> followed = new ArrayList<>(List.of(
                new UserDto(26, "Chase Sanchez"),
                new UserDto(27, "Gregory Bravo"),
                new UserDto(28, "Zelda Atlas")
        ));
        FollowedDto followedDto = new FollowedDto(clientId, clientName, followed);

        mockMvc.perform(get("/users/{userId}/followed/list", clientId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(writer.writeValueAsString(followedDto)));
    }
}