package com.example.bootcampsprint1g6.controller;

import com.example.bootcampsprint1g6.dto.FollowedDTO;
import com.example.bootcampsprint1g6.dto.FollowersDTO;
import com.example.bootcampsprint1g6.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.ser.DurationSerializer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    public static void setUpWriter(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("IT User - Follow an user Ok")
    public void followTestOk() throws Exception {
        Integer userId = 1;
        Integer userToFollowId = 2;
        mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", userId, userToFollowId))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("200"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Ok"))
            .andReturn();
    }

    @Test
    @DisplayName("IT User - Follow an user user id is not numeric")
    public void followTestMethodArgumentMismatchException() throws Exception {
        String userId = "A";
        Integer userToFollowId = 2;
        mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", userId, userToFollowId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("400"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Error en el tipo de datos de los parámetros"))
                .andReturn();
    }

    @Test
    @DisplayName("IT User - Follow an user, user id doesnt exists")
    public void followTestUserIdDoesntExists() throws Exception {
        Integer userId = 99;
        Integer userToFollowId = 2;
        mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", userId, userToFollowId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("404"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No existe el usuario con id: " + userId))
                .andReturn();
    }

    @Test
    @DisplayName("IT User - Follow an user, user to be follow is not seller")
    public void followTestUserToBeFollowedIsNotASeller() throws Exception {
        Integer userId = 1;
        Integer userToFollowId = 4;
        mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", userId, userToFollowId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("400"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El usuario no se puede seguir porque no es un vendedor ID: " + userToFollowId))
                .andReturn();
    }


    @Test
    @DisplayName("IT User - Follow count Ok")
    public void followersCountTestOk() throws Exception{
        Integer userId = 1;

        mockMvc.perform(get("/api/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(userId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("seller1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(2))
                .andReturn();
    }

    @Test
    @DisplayName("IT User - Follow count, user is not seller")
    public void followersCountTestUserIsABuyer() throws Exception{
        Integer userId = 4;

        mockMvc.perform(get("/api/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("400"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Los usuarios del tipo 'buyer' no tienen seguidores."))
                .andReturn();
    }

    @Test
    @DisplayName("IT User - Get followers list Ok")
    public void getFollowersListTestOk() throws Exception{
        Integer userId = 1;
        FollowersDTO expectedFollowers = new FollowersDTO(userId, "seller1", new ArrayList<>(List.of(
                new UserDTO(4, "buyer1"),
                new UserDTO(5, "buyer2")
        )));

        String expectedResponse = writer.writeValueAsString(expectedFollowers);

        MvcResult response = mockMvc.perform(get("/api/users/{userId}/followers/list", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResponse, response.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("IT User - Get followers list ascendant sorted Ok")
    public void getFollowersListTestSortedAscOk() throws Exception{
        Integer userId = 1;
        FollowersDTO expectedFollowers = new FollowersDTO(userId, "seller1", new ArrayList<>(List.of(
                new UserDTO(4, "buyer1"),
                new UserDTO(5, "buyer2")
        )));

        String expectedResponse = writer.writeValueAsString(expectedFollowers);

        MvcResult response = mockMvc.perform(get("/api/users/{userId}/followers/list?order=name_asc", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResponse, response.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("IT User - Get followers list descendent sorted Ok")
    public void followersListTestSortedDescOk() throws Exception{
        Integer userId = 1;
        FollowersDTO expectedFollowers = new FollowersDTO(userId, "seller1", new ArrayList<>(List.of(
                new UserDTO(5, "buyer2"),
                new UserDTO(4, "buyer1")
        )));

        String expectedResponse = writer.writeValueAsString(expectedFollowers);

        MvcResult response = mockMvc.perform(get("/api/users/{userId}/followers/list?order=name_desc", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResponse, response.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("IT User - Get followers list invalid order")
    public void getFollowersListTestInvalidOrder() throws Exception{
        Integer userId = 1;
        String order = "name_aaa";
        mockMvc.perform(get("/api/users/{userId}/followers/list?order=" + order, userId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("La variable 'order' enviada es inválida (" + order + ")."))
                .andReturn();
    }

    @Test
    @DisplayName("IT User - Get followed list Ok")
    public void getFollowedListTestOk() throws Exception{
        Integer userId = 4;
        FollowedDTO expectedFollowers = new FollowedDTO(userId, "buyer1", new ArrayList<>(List.of(
                new UserDTO(1, "seller1"),
                new UserDTO(2, "seller2")
        )));

        String expectedResponse = writer.writeValueAsString(expectedFollowers);

        MvcResult response = mockMvc.perform(get("/api/users/{userId}/followed/list", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResponse, response.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("IT User - Unfollow user Ok")
    public void unfollowTestOk() throws Exception {

        Integer userId = 4;
        Integer userToUnfollowId = 2;
        mockMvc.perform(post("/api/users/{userId}/unfollow/{userIdToFollow}", userId, userToUnfollowId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("200"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Ok"))
                .andReturn();
    }

    @Test
    @DisplayName("IT User - Unfollow user, unfollow a non follow user")
    public void unfollowTestUserIsNotFollowingSeller() throws Exception {

        Integer userId = 1;
        Integer userToUnfollowId = 3;
        mockMvc.perform(post("/api/users/{userId}/unfollow/{userIdToFollow}", userId, userToUnfollowId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("400"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El usuario no está siguiendo al usuario con ID: " + userToUnfollowId))
                .andReturn();
    }

    @Test
    @DisplayName("IT User - Unfollow user, user can't unfollow himself")
    public void unfollowTestUserCannotUnfollowHimself() throws Exception {

        Integer userId = 1;
        Integer userToUnfollowId = 1;
        mockMvc.perform(post("/api/users/{userId}/unfollow/{userIdToFollow}", userId, userToUnfollowId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("400"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El usuario no se puede dejar de seguir así mismo ID: " + userToUnfollowId))
                .andReturn();
    }


}
