package com.breakingbytes.be_java_hisp_w25_g04.controller.integrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getUserFollowedTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followed/list", 1)
                        .param("order", "name_asc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followed.size()").value(1))
                .andExpect(jsonPath("$.followed.[0].user_id").value(3))
                .andReturn();

    }

}