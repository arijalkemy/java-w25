package com.example.bootcampsprint1g6.integration;


import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.util.PostTestBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("Integration Post Test OK")
    void createPostOkTest() throws Exception{
        PostRequestDTO postRequestDTO = PostTestBuilder.buildPostRequestDTO();
        String requestJsonPayload = writer.writeValueAsString(postRequestDTO);

        PostResponseDTO postResponseDTO = PostTestBuilder.buildPostResponseDTO();
        String expectedResponseJson = writer.writeValueAsString(postResponseDTO);

        MvcResult result = mockMvc.perform(
                        post("/api/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String actualResponseJson = result.getResponse().getContentAsString();

        Assertions.assertEquals(expectedResponseJson, actualResponseJson);
    }

    @Test
    @DisplayName("Integration Post Test Wrong Data Request")
    void createPostBadRequest() throws Exception{
        PostRequestDTO postRequestDTO = PostRequestDTO.builder()
                .userId(1)
                .date("23-01-3004")
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Heladera")
                        .type("Electro")
                        .brand("Samsung")
                        .color("Gris")
                        .build()
                )
                .category(1)
                .price(645334.4)
                .build();

        String requestPayloadJSON = writer.writeValueAsString(postRequestDTO);

        mockMvc.perform(
                post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestPayloadJSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Datos incorrectos en la solicitud"));

    }

    @Test
    @DisplayName("Integration Post Test User No Exist")
    void createPostNotFoundUserNoExist() throws Exception{
        PostRequestDTO postRequestDTO = PostTestBuilder.buildPostRequestDTO();
        postRequestDTO.setUserId(999);
        String requestPayloadJSON = writer.writeValueAsString(postRequestDTO);

        mockMvc.perform(post("/api/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestPayloadJSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se puede crear el post ya que el usuario con id 999 no existe."));
    }

    @Test
    @DisplayName("Integration Post Test User No Seller")
    void createPostUserNotSeller() throws Exception{
        PostRequestDTO postRequestDTO = PostTestBuilder.buildPostRequestDTO();
        postRequestDTO.setUserId(4);
        String requestPayloadJSON = writer.writeValueAsString(postRequestDTO);

        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestPayloadJSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no es un vendedor. No se puede concretar la operación."));
    }

}
