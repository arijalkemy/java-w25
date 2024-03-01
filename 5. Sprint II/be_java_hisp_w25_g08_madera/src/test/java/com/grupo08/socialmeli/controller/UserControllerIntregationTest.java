package com.grupo08.socialmeli.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.grupo08.socialmeli.dto.response.FollowDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.grupo08.socialmeli.dto.response.FollowedDTO;
import com.grupo08.socialmeli.utils.TestData;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getUserbyIdTest() throws Exception {
        int userId = 3;
        String order = "name_desc";

        FollowedDTO expectedFollowedDTO = new FollowedDTO(3, "Andres", List.of());

        MvcResult mvcResult =
                mockMvc.perform(get("/users/{userId}/followed/list",userId).param("order", order))
                        .andDo(print())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(status().isOk())
                        .andReturn();

        assertEquals(TestData.objectToJson(expectedFollowedDTO), mvcResult.getResponse().getContentAsString());
    }

    @Test
    void followSellerTest() throws Exception {
        int userId = 1;
        int userToFollow = 1;

        FollowDto expectedFollowDto = new FollowDto(1, "Brayan");

        MvcResult mvcResult =
                mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,1))
                        .andDo(print())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(status().isOk())
                        .andReturn();

        assertEquals(TestData.objectToJson(expectedFollowDto), mvcResult.getResponse().getContentAsString());
    }

}