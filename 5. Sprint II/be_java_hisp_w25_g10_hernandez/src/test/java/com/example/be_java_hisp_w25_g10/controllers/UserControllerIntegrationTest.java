package com.example.be_java_hisp_w25_g10.controllers;

import com.example.be_java_hisp_w25_g10.dtos.CountDto;
import com.example.be_java_hisp_w25_g10.services.users.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;



    @Test
    public void testGetFollowersCount_NormalScenario() throws Exception {

        // Act
        ResultActions resultActions = mockMvc.perform(get("/users/{userId}/followers/count",1))
                // Assert
                .andExpect(status().isOk()).andExpect(jsonPath("$.followers_count").value(2))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("user1"));
    }

    @Test
    public void testGetFollowersCount_UserNotFoundScenario() throws Exception {

        // Act
        ResultActions resultActions = mockMvc.perform(get("/users/{userId}/followers/count",2000))
                // Assert
                .andExpect(status().isNotFound());
    }
}
