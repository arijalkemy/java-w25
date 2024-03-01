package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.integration.userControllerIntegration;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.UserRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestFollow {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepositoryImpl userRepository;


    private static ObjectWriter writer;

    @BeforeEach
    public void beforeEach(){
        userRepository.cleanData();
        User userTestUnfollow = userRepository.getUserById(3).get();
        Seller sellerTestUnfollow = (Seller) userRepository.getUserById(25).get();

        userTestUnfollow.getFollowing().add(sellerTestUnfollow);
        sellerTestUnfollow.getFollowers().add(userTestUnfollow);
    }


    @Test
    void followOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 26))
                .andExpect(status().isNoContent());

    }

    @Test
    void followNotSeller() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El id del usuario no corresponde a un vendedor"));

    }

    @Test
    void followUserNotFound() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 33, 21))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El id de este usuario no se encuentra registrado"));

    }

    @Test
    void followSellerNotFound() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 33))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El id del vendedor a seguir no se encuentra registrado"));

    }


    @Test
    void unFollowOk() throws Exception{
        System.out.println(userRepository.getUserById(3).get().getFollowing().get(0).getUserId());
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 3, 25))
                .andExpect(status().isNoContent());

    }

    @Test
    void unFollowNotSeller() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 3, 1))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El id del usuario no corresponde a un vendedor"));

    }

    @Test
    void unFollowUserNotFound() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 33, 25))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El id de este usuario no se encuentra registrado"));

    }

    @Test
    void unFollowSellerNotFound() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 3, 33))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El id del vendedor no se encuentra registrado"));

    }
}
