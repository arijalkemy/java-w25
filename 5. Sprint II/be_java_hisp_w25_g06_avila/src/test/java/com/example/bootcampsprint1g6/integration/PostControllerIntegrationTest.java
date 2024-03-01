package com.example.bootcampsprint1g6.integration;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private final String URI = "/api/products";

    @Test
    public void testCreatePost() throws Exception {
        // PostRequestDTO datos enviados por body
        ProductDTO productDTO = ProductDTO.builder()
                .productId(23)
                .productName("camisa a rayas")
                .type("indumentaria")
                .brand("sarkany")
                .color("rojo")
                .notes("unico color, puro algodon")
                .build();
        PostRequestDTO postRequestDTO = PostRequestDTO.builder()
                .userId(3)
                .date("16-02-2024")
                .product(productDTO)
                .category(123)
                .price(23.4)
                .build();
        // postResponseDTO datos esperados
        PostResponseDTO postResponseDTO = PostResponseDTO.builder()
                .userId(3)
                .postId(0)
                .date("16-02-2024")
                .product(productDTO)
                .category(123)
                .price(23.4)
                .build();

        // Convierto el request y el responseExpected a JSON
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String requestJson = writer.writeValueAsString(postRequestDTO);
        String responseJsonExpected = writer.writeValueAsString(postResponseDTO);

        // Llamo al endpoint y verifico algunas cosas
        MvcResult mvcResult = mockMvc.perform(post(URI + "/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(responseJsonExpected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    public void testGetLastPostsByFollowed() throws Exception {
        Integer userId = 1;
        PostListDTO expectedPostListDTO = createMockPostListDTO();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponse = writer.writeValueAsString(expectedPostListDTO);

        // Realizar la solicitud GET y verificar la respuesta
        String DATE_DESC = "date_desc";
        MvcResult mvcResult = mockMvc.perform(get(URI + "/followed/{userId}/list", userId)
                        .param("order", DATE_DESC))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // verificaciones extras
                .andExpect(jsonPath("$.user_id").value(userId))
                .andReturn();

                Assertions.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    private PostListDTO createMockPostListDTO(){
        // Crear instancia de ProductDTO
        ProductDTO productDTO = ProductDTO.builder()
                .type("indumentaria")
                .brand("sarkany")
                .color("rojo")
                .notes("unico color, puro algodon")
                .productId(23)
                .productName("camisa a rayas")
                .build();
        // Crear instancia de PostResponseDTO
        List<PostResponseDTO> postResponseDTOEmpty = new ArrayList<>();
        // Crear instancia de PostListDTO
        PostListDTO postListDTO = PostListDTO.builder()
                .userId(1)
                .posts(postResponseDTOEmpty)
                .build();

        return postListDTO;
    }

}
