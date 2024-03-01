package com.bootcamp.be_java_hisp_w25_g9.integration;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeEach
    void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    void insertNewPostOk() throws Exception {
        PostRequestDto postRequestDto = new PostRequestDto(
                26, LocalDate.now(), new ProductDto(
                20,
                "Vaso plastico",
                "Hogar",
                "Home elements",
                "Transparente",
                "Vaso plastico transparente de 500 ml"),
                1,
                100000.0
        );

        String jsonPayload = writer.writeValueAsString(postRequestDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Publicación creada con éxito"))
                .andReturn();
    }

    @Test
    void insertNewPostBadBodyParams() throws Exception {
        PostRequestDto postRequestDto = new PostRequestDto(
                -26,
                null,
                new ProductDto(
                        -20,
                        "Vaso plástico, Vaso plástico, Vaso plástico, Vaso plástico, Vaso plástico",
                        null,
                        "Home elements Home elements Home elements Home elements Home elements ",
                        "Cálido, Cálido, Cálido, Cálido, Cálido",
                        "Vaso plástico transparente de 500 ml"),
                null,
                10000000.1
        );

        String jsonPayload = writer.writeValueAsString(postRequestDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void insertNewPostNoBody() throws Exception {
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.length()").value(5))
                .andReturn();
    }

    @Test
    void insertNewPostUserNotFound() throws Exception {
        PostRequestDto postRequestDto = new PostRequestDto(
                26000, LocalDate.now(), new ProductDto(
                20,
                "Vaso plastico",
                "Hogar",
                "Home elements",
                "Transparente",
                "Vaso plastico transparente de 500 ml"),
                1,
                100000.0
        );

        String jsonPayload = writer.writeValueAsString(postRequestDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(
                        jsonPath("$.message").value("El usuario no se encuentra o no es vendedor"))
                .andReturn();
    }

    @Test
    void getFollowedPostOrderByDateOk() throws Exception {
        int userId = 1;
        String dateOrder = "date_asc";
        mockMvc.perform(get("/products/followed/{userId}/list", userId).param("order", dateOrder))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    void getFollowedPostUserDontHaveSellersFollowed() throws Exception {
        int userId = 2;
        mockMvc.perform(get("/products/followed/{userId}/list", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    void getFollowedPostSellerDontHavePosts() throws Exception {
        int userId = 3;
        mockMvc.perform(get("/products/followed/{userId}/list", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    void getFollowedPostClientNotFound() throws Exception {
        int userId = 100;
        mockMvc.perform(get("/products/followed/{userId}/list", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
}