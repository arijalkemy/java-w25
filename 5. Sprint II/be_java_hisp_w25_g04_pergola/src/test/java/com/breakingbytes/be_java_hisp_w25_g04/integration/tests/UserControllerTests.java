package com.breakingbytes.be_java_hisp_w25_g04.integration.tests;

import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponseDTO;
import com.breakingbytes.be_java_hisp_w25_g04.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserServiceImpl userService;

    @Test
    public void unfollowUserIntegrationTestOk() throws Exception {
        Integer userId = 1,
                userIdToUnfollow = 3;
        String expectedResponse = convertirAJson(new ResponseDTO("El usuario Pepe ha dejado de seguir a: Juan"));

        MvcResult mvcResult = mockMvc.perform(post("/users/{user_id}/unfollow/{user_id_to_unfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    private String convertirAJson(ResponseDTO expected) throws JsonProcessingException {
        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        return writter.writeValueAsString(expected);
    }
}
