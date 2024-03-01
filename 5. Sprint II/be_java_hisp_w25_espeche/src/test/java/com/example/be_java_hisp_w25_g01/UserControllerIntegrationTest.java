package com.example.be_java_hisp_w25_g01;

import com.example.be_java_hisp_w25_g01.dto.response.MessagesDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void unfollowUserOk() throws Exception{
        int userId1 = 1;
        int userId2 = 5;
        String expectedMessage = "User with id: 1 is now unfollowing user with id: 5";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/{userId}/unfollow/{userIdToUnfollow}", userId1, userId2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        MessagesDTO response = new ObjectMapper().readValue(jsonResponse, MessagesDTO.class);

        Assertions.assertEquals(expectedMessage, response.getMessage());
    }


}
