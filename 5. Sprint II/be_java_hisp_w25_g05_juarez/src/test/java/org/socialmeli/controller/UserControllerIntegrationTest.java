package org.socialmeli.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.socialmeli.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @BeforeAll()
    static void  setUp(){
        User.userIdCounter=0;
    }

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("[Integration] User tries to follow a vendor that was actually following ")
    void userfollowsVendorUnhappyPath () throws Exception{

        //Se sigue al vendedor
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}","1","2"))
                .andExpect(status().isOk());

        // se trata de seguir al mismo vendedor y se comprueba el error
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}","1","2"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Ya se esta siguiendo al vendedor"));

    }


    @Test
    @DisplayName("[Integration] Get Vendor's follower count")
    void  follorwersCount() throws Exception {

        //Se sigue al vendedor


        this.mockMvc.perform(get("/users/{userId}/followers/count","2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(1));

    }




}
