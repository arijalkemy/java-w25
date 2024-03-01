package com.socialMeli.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void followUserTestOK() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2, 10))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Comenzaste a seguir al usuario Victoria Acosta"));
    }
    @Test
    public void followUserTestNotFound() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 14, 9))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("No se encontro al usuario"));
    }
    @Test
    public void followUserTestIsForbiddenAlreadyFollowed() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 10))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Ya sigues a este usuario"));
    }
    @Test
    public void followUserTestIsForbiddenIsNotVendor() throws Exception {
        mockMvc.perform((post("/users/{userId}/follow/{userIdToFollow}", 1, 2)))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El usuario no es un vendedor"));
    }
    @Test
    public void followUserTestBadRequestValidations() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", -1, -10))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId")
                        .value("El id debe ser un valor positivo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userIdToFollow")
                        .value("El id debe ser un valor positivo"));
    }
}
