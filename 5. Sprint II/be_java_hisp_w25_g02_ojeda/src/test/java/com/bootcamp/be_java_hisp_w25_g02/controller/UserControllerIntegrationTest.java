package com.bootcamp.be_java_hisp_w25_g02.controller;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerListDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w25_g02.repository.UserRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    // Siguientes 4 etiquetas para reiniciar la base de datos antes de cada test.
    // supuestamente, porque las pruebas fueron erráticas.
    /*
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    @Lazy
    private UserRepositoryImpl userRepositoryImpl;

    @BeforeEach
    public void reiniciarBean() {
        userRepositoryImpl = applicationContext.getBean(UserRepositoryImpl.class);
    }
    */


    @Test
    public void getUserTotalFollowersIntTest() throws Exception {
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
    public void unfollowSellerIntTest() throws Exception{

        // Arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 9;

        // Act and Assert
        MvcResult myResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void followSellerIntTest() throws Exception {

        // Arrange
        Integer userId = 8;
        Integer userIdToFollow = 9;

        // Act and Assert
        MvcResult myResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        MvcResult myResult2 = mockMvc.perform(get("/user/{userId}/followers", 9)
                        .param("order", "name_asc")).andDo(print())
                .andReturn();

        /*
        // Return DB to its normal state -- Not needed at the moment
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow))
                .andReturn();
         */
    }

    @Test
    public void getUserTotalFollowersIntTest2() throws Exception {
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

}
