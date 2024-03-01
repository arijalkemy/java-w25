package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.controller;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTestUserController {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getFollowersCountOk() throws Exception{
        //simulo que se hace una peticion de seguimiento previo a la prueba
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2,21));

        mockMvc.perform(get("/users/{userId}/followers/count", 21))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followersCount").value(1));
    }

    @Test
    void getFollowersCountBadRequest() throws Exception{
        mockMvc.perform(get("/users/{userId}/followers/count", 2))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El id del usuario no corresponde a un vendedor"));
    }

    @Test
    void getFollowersCountNotFound() throws Exception{
        mockMvc.perform(get("/users/{userId}/followers/count", 22))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("El usuario no tiene seguidores"));
    }

    @Test
    void getFollowersCountBadType() throws Exception{
        mockMvc.perform(get("/users/{userId}/followers/count", "s"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'; For input string: \"s\""));
    }

    @Test
    void followOk() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 3,21))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    void followSellerIsNotSeller() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2,1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El id del usuario no corresponde a un vendedor"));
    }
    @Test
    void followUserEqualsSeller() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no se puede seguir a si mismo"));
    }
    @Test
    void followUserNotExist() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 29394,1))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El id de este usuario no se encuentra registrado"));
    }
    @Test
    void followSellerNotExist() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,124142))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El id del vendedor a seguir no se encuentra registrado"));
    }

    @Test
    void followAlreadyFollow() throws Exception{
        //Simulo que el usuario ya sigue al vendedor
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,21));

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,21))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario ya sigue al vendedor con ese id"));
    }

}
