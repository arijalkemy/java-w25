package com.grupo08.socialmeli;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class integrationTest {

    @Autowired
    private MockMvc mockMvc;
    MvcResult mvcResult;

    @Test
    @DisplayName("0007| Integration test ok case")
    public void followersCountIntegrationTestOkCase() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followers/count"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1));
    }
}
