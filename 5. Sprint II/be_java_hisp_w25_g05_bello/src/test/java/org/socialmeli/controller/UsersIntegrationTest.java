package org.socialmeli.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Disabled
@SpringBootTest
@AutoConfigureMockMvc
public class UsersIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("[US_0001] Happy Path: User tries to follow an existing vendor")
    void followUserIntegrationOkTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Vendedor seguido exitosamente"))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    @DisplayName("[US_0001] Sad Path: User tries to follow a non existing vendor")
    void followUserIntegrationFailTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 99999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El vendedor no existe"))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    @DisplayName("[US_0001] Sad Path: User tries to follow himself")
    void followUserIntegrationFailTest2() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Un usuario no se puede seguir a si mismo"))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }
}
