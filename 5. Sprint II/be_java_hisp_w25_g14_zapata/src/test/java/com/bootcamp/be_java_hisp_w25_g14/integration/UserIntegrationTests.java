package com.bootcamp.be_java_hisp_w25_g14.integration;

import com.bootcamp.be_java_hisp_w25_g14.exceptions.FollowException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTests {

    @Autowired
    MockMvc mockMvc;



    /*
    * test for follow seller when is the success case
    * */
    @Test
    public void testFollowUserOKCase() throws Exception {

        this.mockMvc.perform(get("/users/{userId}/follow/{userIdToFollow}", "4","2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Follow successfully"))
                .andExpect(content().contentType("application/json"));
    }



    /*
     * test that returns a exception when de user try to follow a seller that already follow
     * */
    @Test
    public void testFollowUserFollowException() throws Exception {

        this.mockMvc.perform(get("/users/{userId}/follow/{userIdToFollow}", "1","2"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof FollowException))
                .andExpect(jsonPath("$.message").value("Already follow"))
                .andExpect(content().contentType("application/json"));
    }



    /*
     * test that returns a exception the seller does not exists
     * */
    @Test
    public void testFollowUserNotFoundExceptionSeller() throws Exception {

        this.mockMvc.perform(get("/users/{userId}/follow/{userIdToFollow}", "1","1000"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NotFoundException))
                .andExpect(jsonPath("$.message").value("Unable to find user to follow"))
                .andExpect(content().contentType("application/json"));
    }


    /*
     * test that returns a exception the user who wants follow a seller does not exists
     * */
    @Test
    public void testFollowUserNotFoundExceptionFollower() throws Exception {

        this.mockMvc.perform(get("/users/{userId}/follow/{userIdToFollow}", "1000000","1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NotFoundException))
                .andExpect(jsonPath("$.message").value("Unable to find user"))
                .andExpect(content().contentType("application/json"));
    }

    /*
     * test that returns a exception when the user tries to follow himself
     * */
    @Test
    public void testFollowUserException() throws Exception {

        this.mockMvc.perform(get("/users/{userId}/follow/{userIdToFollow}", "1","1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof FollowException))
                .andExpect(jsonPath("$.message").value("Unable to follow itself"))
                .andExpect(content().contentType("application/json"));
    }




}
