package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.controller;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.ProductDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service.ProductServiceImpl;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Utilities;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {
    @Autowired
    MockMvc mockMvc;

    ProductServiceImpl productService;

    @BeforeEach
    public void setUp(){
        this.productService=new ProductServiceImpl();
    }

    private String serializablePost(PostDTO postDTO)throws JsonProcessingException{
        ObjectMapper om=new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        return om.writeValueAsString(postDTO);
    }

    private String serializablePosts(List<PostDTO> postDTOS)throws JsonProcessingException{
        ObjectMapper om=new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        return om.writeValueAsString(postDTOS);
    }

    @DisplayName("Verify endpoint to create Post")
    @Test
    void createPostOK() throws Exception{
        PostDTO post=Utilities.generatePostDto(
               21,
                1,
                LocalDate.parse("2023-03-01"),
                1,
                "product1"
        );

        mockMvc.perform(post("/products/post")
                    .contentType(APPLICATION_JSON)
                    .content(serializablePost(post)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @DisplayName("Create Post Bad, User not a Seller")
    @Test
    void createPostNotOk() throws Exception{
        PostDTO post=Utilities.generatePostDto(
                1,
                1,
                LocalDate.parse("2023-03-01"),
                1,
                "product1"
        );

        mockMvc.perform(post("/products/post")
                        .contentType(APPLICATION_JSON)
                        .content(serializablePost(post)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El id del usuario no corresponde a un vendedor"));
    }
}