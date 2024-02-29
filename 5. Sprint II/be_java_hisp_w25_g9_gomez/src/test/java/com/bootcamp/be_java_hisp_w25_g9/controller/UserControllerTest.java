package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w25_g9.service.UserService;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest{
    //PARTE B INDIVIDUAL
    @Autowired
    MockMvc mockMvc;
    @Autowired
    UserService userService;
    @Test
    void unfollowUserOk() throws Exception{
        int userId = 1;
        int userIdToUnfollow = 26;
        userService.follow(userId,userIdToUnfollow);

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        String payLoadJsonExpected = objectWriter.writeValueAsString(new MessageDto("El vendedor ha sido quitado de la lista de seguidos del cliente"));

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId,userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(payLoadJsonExpected,mvcResult.getResponse().getContentAsString());
    }
    @Test
    void unfollowUserBadRequestException() throws Exception{
        int userId = 100;
        int userIdToUnfollow = 26;

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        String payLoadJsonExpected = objectWriter.writeValueAsString(new MessageDto("El cliente no existe"));

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId,userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(payLoadJsonExpected,mvcResult.getResponse().getContentAsString());
    }
}