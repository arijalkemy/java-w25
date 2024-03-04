package com.example.be_java_hisp_w25_g10.controller;

import com.example.be_java_hisp_w25_g10.dtos.PostDto;
import com.example.be_java_hisp_w25_g10.dtos.PostsDto;
import com.example.be_java_hisp_w25_g10.entities.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;



@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;


    @Test
    @DisplayName("test to get user followeds of a user integration")
    public void getUserFollowed() throws Exception {
        Integer param = 1;
        String url = "/products/followed/{userId}/list";

        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        PostsDto postCreatedExpected = new PostsDto(1,
                List.of(new PostDto(2, 2, LocalDate.of(2024, 1, 24),
                                new Product(
                                        1,
                                        123,
                                        29.99,
                                        "Producto1",
                                        "Electrónico",
                                        "MarcaA",
                                        "Rojo",
                                        "Notas sobre el producto"),

                        new PostDto(11, 2, LocalDate.of(2024, 10, 20),
                                new Product(
                                        1,
                                        123,
                                        29.99,
                                        "Producto1",
                                        "Electrónico",
                                        "MarcaA",
                                        "Rojo",
                                        "Notas sobre el producto");


        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(postCreatedExpected)
        );
        ResultMatcher contetTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //act
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) //verifica status
                .andExpect(bodyExpected) //verifica el body
                .andExpect(contetTypeExpected); //verifica el contentType
    }
}
