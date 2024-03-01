package com.grupo08.socialmeli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.entity.Post;
import com.grupo08.socialmeli.repository.PostRepositoryImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@AutoConfigureMockMvc
@SpringBootTest
class ProductControllerIntegralTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllPosts() throws Exception {
        List<PostDto> listPosts= new ArrayList<>();
        PostDto post1 = new PostDto(1, LocalDate.of(2024, 2, 28), null, 1, 10.0);
        listPosts.add(post1);

        // Objeto 2
        PostDto post2 = new PostDto(1, LocalDate.of(2024, 2, 27), null, 1, 10.0);
        listPosts.add(post2);

        // Objeto 3
        PostDto post3 = new PostDto(1, LocalDate.of(2024, 2, 25), null, 1, 10.0);
        listPosts.add(post3);

        // Objeto 4
        PostDto post4 = new PostDto(1, LocalDate.of(2024, 2, 29), null, 1, 10.0);
       listPosts.add(post4);
        MvcResult mvcResult =  mockMvc.perform(get("/products/post/getAll"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        ObjectMapper mapper = new ObjectMapper();
        // Registrar el módulo JavaTime para que Jackson pueda manejar LocalDate, LocalDateTime, etc.
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        // Configurar el formato personalizado para LocalDate
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateSerializer localDateSerializer = new LocalDateSerializer(dateFormatter);
        javaTimeModule.addSerializer(LocalDate.class, localDateSerializer);
        mapper.registerModule(javaTimeModule);
        assertEquals(mapper.writeValueAsString(listPosts), mvcResult.getResponse().getContentAsString());;
    }

    @Test
    void followProducts() {
    }

    @Test
    void insertPost() {
    }
}