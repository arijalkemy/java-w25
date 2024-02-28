package com.bootcamp.be_java_hisp_w25_g02.controller;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerListDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegral {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getFollowersListTest() throws Exception {
        Integer userId = 9;
        String order = "name_asc";
        FollowerListDTO followerListDTO = new FollowerListDTO(
                9, "Malena",
                List.of(new UserDTO(1, "Javier"),
                        new UserDTO(7, "Maria"),
                        new UserDTO(3, "Martin")));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(followerListDTO);
        mockMvc.perform(post("/user/{userId}/followers")
                .contentType("application/json")
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
