package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.PostResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegratedTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    void insertNewPostTestOK() throws Exception{

        PostRequestDto postRequestDto = new PostRequestDto(26, LocalDate.of(2024, 2, 15),
                new ProductDto(16, "Silla Gamer", "Gamer", "Racer", "Red And Black", "Special Edition"),
                100, 1500.50);

        String payloadJson = writer.writeValueAsString(postRequestDto);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Publicación creada con éxito"))
                .andReturn();
    }

    @Test
    void insertNewPostTestNotFoundException() throws Exception{

        PostRequestDto postRequestDto = new PostRequestDto(1, LocalDate.of(2024, 2, 15),
                new ProductDto(16, "Silla Gamer", "Gamer", "Racer", "Red And Black", "Special Edition"),
                100, 1500.50);

        String payloadJson = writer.writeValueAsString(postRequestDto);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario no se encuentra o no es vendedor"))
                .andReturn();
    }

    @Test
    void insertNewPostTestProductNotFoundException() throws Exception{

        PostRequestDto postRequestDto = new PostRequestDto(26, LocalDate.of(2024, 2, 15),
                new ProductDto(15, "Silla Gamer", "Gamer", "Racer", "Red And Black", "Special Edition"),
                100, 1500.50);

        String payloadJson = writer.writeValueAsString(postRequestDto);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El identificador del producto no corresponde con el registrado"))
                .andReturn();
    }

    @Test
    void insertNewPostTestMethodArgumentNotValid() throws Exception{

        PostRequestDto postRequestDto = new PostRequestDto(26, LocalDate.of(2024, 2, 15),
                new ProductDto(15, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                100, 1500.50);

        String payloadJson = writer.writeValueAsString(postRequestDto);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].field").value("product.color"))
                .andExpect(jsonPath("$[0].message").value("El campo no puede poseer caracteres especiales."))
                .andReturn();
    }

    @Test
    void getFollowedPostOrderByDateTestOk() throws Exception {

        ProductDto productDto1 = new ProductDto(1, "Camisa", "Ropa", "Marca A", "Azul", "Algodón");
        ProductDto productDto2 = new ProductDto(2, "Pantalón", "Ropa", "Marca B", "Negro", "Poliéster");
        ProductDto productDto3 = new ProductDto(3, "Zapatos", "Calzado", "Marca C", "Blanco", "Cuero");
        FollowedPostsDto followedPostsDto = new FollowedPostsDto(1,
                List.of(new PostResponseDto(3, 29, LocalDate.of(2024,2,27), productDto1, 43, 65.0),
                        new PostResponseDto(5, 30, LocalDate.of(2024,2,25), productDto2, 32, 65.0),
                        new PostResponseDto(4, 30, LocalDate.of(2024,2,24), productDto3, 12,9.0),
                        new PostResponseDto(2, 29, LocalDate.of(2024,2,19), productDto2, 40, 82.0)));

        String payloadJson = writer.writeValueAsString(followedPostsDto);

        MvcResult mvcResult = mockMvc.perform(get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(payloadJson, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}