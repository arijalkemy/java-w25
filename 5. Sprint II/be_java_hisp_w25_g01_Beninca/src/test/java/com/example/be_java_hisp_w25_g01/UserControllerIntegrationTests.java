package com.example.be_java_hisp_w25_g01;

import com.example.be_java_hisp_w25_g01.dto.response.FollowersDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static util.TestUtilGenerator.getFollowersDTOasc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Beninca Agustín Integration Test")
    @Test
    public void getFollowersListTest_Ok() throws Exception {
        FollowersDTO expected = getFollowersDTOasc();
        String order = "name_asc";

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedMessage = writer.writeValueAsString(expected);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/users/{userId}/followers/list", 4).param("order", order))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedMessage, result.getResponse().getContentAsString());
    }

    @DisplayName("BONUS Integration Test")
    @Test
    public void followUserTest_BadRequest() throws Exception {
        String expected = "{\"message\":\"User is already following this user.\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/users/{UserId}/follow/{userIdToFollow}", 1, 5))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }
}
