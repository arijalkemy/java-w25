package com.grupo08.socialmeli.controller.integration;

import io.micrometer.observation.transport.RequestReplyReceiverContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegration {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Get Followers ok")
    public void testGetFollowers() throws Exception{
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value("1"))
                .andExpect(jsonPath("$.user_name").value("Brayan"))
                .andExpect(jsonPath("$.followers").isArray())
                .andReturn();

        assertEquals("application/json",result.getResponse().getContentType());
    }

    @Test
    @DisplayName("Get Followers not found")
    public void testGetFollowersNotFound() throws Exception{
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list",100))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No hay vendedor con ese ID."))
                .andReturn();

        assertEquals("application/json",result.getResponse().getContentType());
    }

    @Test
    @DisplayName("Get Followers bad request")
    public void testGetFollowersBadRequest() throws Exception{
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list",1)
                .param("order","dsadasda"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Parametro de orden no valido"))
                .andReturn();

        assertEquals("application/json",result.getResponse().getContentType());
    }
}
