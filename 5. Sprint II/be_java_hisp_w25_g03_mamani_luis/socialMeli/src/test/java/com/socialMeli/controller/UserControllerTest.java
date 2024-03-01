package com.socialMeli.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void getFollowerCountTest() throws Exception {
        this.mockMvc.perform(
                get("/users/10/followers/count").contentType(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.followers_count").value(1));
    }

    @Test
    void getFollowerCount_throwUserVendorTest() throws Exception {
        this.mockMvc.perform(
                get("/users/7/followers/count").contentType(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isForbidden()).andExpect(jsonPath("$.message").value("El usuario no es un vendedor"));
    }

    @Test
    void getFollowerCount_throwInvalidDataTest() throws Exception {
        this.mockMvc.perform(
                get("/users/-1/followers/count").contentType(MediaType.APPLICATION_JSON)
        ).andDo(print()).andExpect(status().isBadRequest()).andExpect(jsonPath("$.userId").value("El id debe ser un valor positivo"));
    }
}
