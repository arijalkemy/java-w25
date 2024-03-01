package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.controller;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.ProductDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service.PostServiceImpl;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service.UserServiceImpl;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    PostServiceImpl postService;

    @Test
    void getPostPerSellerOK() throws Exception {
        userService.followUser(8,28);
        userService.followUser(8,29);
        LocalDate hourNow = LocalDate.now();
        postService.addPost(new PostDTO(28, hourNow,
                new ProductDTO(1,"Arepa", "Arepa", "Quesudas", "rosa", "esto es un test"),
                1, 12D));
        postService.addPost(new PostDTO(29, hourNow,
                new ProductDTO(2,"Hamburguesa", "comida", "Quesudas", "rosa", "esto es un test"),
                1, 12D));

        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
    @Test
    void getPostPerSellerUserNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_NOT_FOUND_ERROR_MESSAGE));
    }

}