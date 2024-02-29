package com.mercadolibre.be_java_hisp_w25_g15.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void countFollowersByUserIdOkTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 9))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(9))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("Capitan America"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followersCount").value(1));
    }

    @Test
    public void countFollowersByUserIdNotFoundUserTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 100))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User not found"));
    }

    @Test
    public void countFollowersByUserIdUserIsNotASellerTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 5))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User is not a Seller"));
    }
}
