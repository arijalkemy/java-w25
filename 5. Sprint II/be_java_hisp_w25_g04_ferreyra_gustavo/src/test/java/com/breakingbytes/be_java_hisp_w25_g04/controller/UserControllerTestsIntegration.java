package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.UserDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowersDTO;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTestsIntegration {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("listFollowersTestOk Integration")
    public void listFollowersTestOk() throws Exception {
        Integer userId = 4;
        String userName = "Robert";
        List<UserDTO> followers = new ArrayList<>();
        followers.add(new UserDTO(2, "Carlos"));
        UserFollowersDTO expectedResult = new UserFollowersDTO(userId, userName, followers);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(expectedResult);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followers/list", userId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("listFollowersTestOk Integration")
    public void fetFollowersCount() throws Exception {
        Integer userId = 4;
        String userName = "Robert";
        Integer followersCount = 1;

        FollowersCountDTO expectedResult = new FollowersCountDTO(userId,userName, followersCount);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(expectedResult);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followers/count", userId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString());

    }

}
