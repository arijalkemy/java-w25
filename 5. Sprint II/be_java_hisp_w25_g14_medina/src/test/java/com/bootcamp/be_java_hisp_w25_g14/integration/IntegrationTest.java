package com.bootcamp.be_java_hisp_w25_g14.integration;

import com.bootcamp.be_java_hisp_w25_g14.dto.FollowedListResponseDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserDataDto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Int001 - followNewSellerTestOk")
    void getFollowerTestOk() throws Exception {
        Integer idUser = 2;
        Integer idUserToFollow =3;
        mockMvc.perform(get("/users/{userId}/follow/{userIdToFollow}", idUser, idUserToFollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Follow successfully"));

    }

    @Test
    @DisplayName("Int001 - userIdNegative")
    void userIdNegative() throws Exception {
        Integer idUser = -2;
        Integer idUserToFollow =3;
        mockMvc.perform(get("/users/{userId}/follow/{userIdToFollow}", idUser, idUserToFollow))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("UserId can't be negative or zero"));

    }
    @Test
    @DisplayName("Int001 - userIdNegative")
    void userIdToFollowNegative() throws Exception {
        Integer idUser = 2;
        Integer idUserToFollow =-3;
        mockMvc.perform(get("/users/{userId}/follow/{userIdToFollow}", idUser, idUserToFollow))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("UserIdToFollow can't be negative or zero"));

    }

    @Test
    @DisplayName("Int001 - userIdToFollowNotSellerTest")
    void followNotSellerTest() throws Exception {
        Integer idUser = 2;
        Integer idUserToFollow =5;
        mockMvc.perform(get("/users/{userId}/follow/{userIdToFollow}", idUser, idUserToFollow))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").value("The user to follow isn't seller"));

    }
    @Test
    @DisplayName("Int001 - userIdNotExistsTest")
    void followUserIdNotExistsTest() throws Exception {
        Integer idUser = 20;
        Integer idUserToFollow =2;
        mockMvc.perform(get("/users/{userId}/follow/{userIdToFollow}", idUser, idUserToFollow))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").value("Unable to find user"));

    }

    @Test
    @DisplayName("Int002 - unfollowTestOk")
    void unfollowTestOk() throws Exception {
        Integer idUser = 2;
        Integer idUserUnToFollow =1;
        mockMvc.perform(get("/users/{userId}/unfollow/{userIdToUnfollow}", idUser, idUserUnToFollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Unfollow successfully"));

    }

    @Test
    @DisplayName("Int002 - userIdNegative")
    void unfollowUserIdNegative() throws Exception {
        Integer idUser = -2;
        Integer idUserUnToFollow =3;
        mockMvc.perform(get("/users/{userId}/unfollow/{userIdToUnfollow}", idUser, idUserUnToFollow))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("UserId can't be negative or zero"));

    }
    @Test
    @DisplayName("Int002 - userIdNegative")
    void UnfollowUserIdToFollowNegative() throws Exception {
        Integer idUser = 2;
        Integer idUserUnToFollow =-3;
        mockMvc.perform(get("/users/{userId}/unfollow/{userIdToUnfollow}", idUser, idUserUnToFollow))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("UserIdToUnFollow can't be negative or zero"));

    }

    @Test
    @DisplayName("Int002 - userIdToUnFollowIsNotFollowTest")
    void unfollowNotFollowTest() throws Exception {
        Integer idUser = 3;
        Integer idUserUnToFollow =1;
        mockMvc.perform(get("/users/{userId}/unfollow/{userIdToUnfollow}", idUser, idUserUnToFollow))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").value("Can't unfollow, You don't follow this user"));

    }
    @Test
    @DisplayName("Int002 - userIdNotExistsTest")
    void unfollowUserIdNotExistsTest() throws Exception {
        Integer idUser = 20;
        Integer idUserUnToFollow =2;
        mockMvc.perform(get("/users/{userId}/unfollow/{userIdToUnfollow}", idUser, idUserUnToFollow))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").value("Unable to find user"));

    }

    @Test
    @DisplayName("Int003 - listFollowerOkTest")
    void listFollowerOkTest() throws Exception {
        Integer idUser = 1;

        List<UserDataDto> listFollowerExpected= List.of(new UserDataDto(2,"jac"),
                new UserDataDto(4,"rosa"));
        FollowedListResponseDto expected = new FollowedListResponseDto(1,"edgar",listFollowerExpected);
        String expecteString = parseObjetToJsonString(expected);
        MvcResult result =mockMvc.perform(get("/users//{id}/followers/list", idUser))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_name").value("edgar"))
                .andReturn();

        assertEquals(expecteString, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Int003 - userIdNotExistsTest")
    void listUserIdNotExitstTest() throws Exception {
        Integer idUser = 20;

        mockMvc.perform(get("/users//{id}/followers/list", idUser))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").value("The user does not exists"))
                ;
    }

    @Test
    @DisplayName("Int003 - userIdNegativeTest")
    void listUserIdNegativeTest() throws Exception {
        Integer idUser = -20;

        mockMvc.perform(get("/users//{id}/followers/list", idUser))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("UserId can't be negative or zero"))
                ;
    }

    @Test
    @DisplayName("Int003 - userIdNotSellerTest")
    void listUserIdNorSellerTest() throws Exception {
        Integer idUser = 4;

        mockMvc.perform(get("/users//{id}/followers/list", idUser))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").value("the user is not a seller"))
        ;
    }

    @Test
    @DisplayName("Int004 - listFollowedOkTest")
    void listFollowedOkTest() throws Exception {
        Integer idUser = 1;

        List<UserDataDto> listFollowerExpected= List.of(new UserDataDto(2,"jac"),
                new UserDataDto(3,"hector"));
        FollowedListResponseDto expected = new FollowedListResponseDto(1,"edgar",listFollowerExpected);
        String expecteString = parseObjetToJsonString(expected);
        MvcResult result =mockMvc.perform(get("/users//{id}/followed/list", idUser))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_name").value("edgar"))
                .andReturn();

        assertEquals(expecteString, result.getResponse().getContentAsString());
    }

    private String parseObjetToJsonString(Object payload) throws JsonProcessingException {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        return writer.writeValueAsString(payload);
    }
}
