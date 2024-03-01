package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    private PostRequestDto requestDto;

    @BeforeAll
    static void setup(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    void beforeEach(){

        requestDto = new PostRequestDto(26,
                LocalDate.now(),
                new ProductDto(17,
                        "Silla",
                        "Gammer",
                        "ASE",
                        "Rojo",
                        "En cuero"
                ),
                1,
                1000.00
        );
    }

    @Test
    void insertNewPostOk() throws Exception {
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(requestDto))
                )
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Publicación creada con éxito"));
    }

    @Test
    void insertNewPostNotSellerOrNotFound() throws Exception {

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(requestDto).replaceAll("26", "1"))
                )
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El usuario no se encuentra o no es vendedor"));
    }

    @Test
    void insertNewPostNotValidProduct() throws Exception {

        String invalidIdProduct = "1";
        String idProduct = "17";
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(requestDto).replaceAll(idProduct, invalidIdProduct)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El identificador del producto no corresponde con el registrado"));
    }

    @Test
    void getFollowedPostOk() throws Exception {

        int idClient = 1;
        mockMvc.perform(get("/products/followed/{userId}/list", idClient)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value("1"));

    }

    @Test
    void getFollowedPostOrderByDateAscOk() throws Exception {

        int idClient = 1;
        String order = "date_asc";
        mockMvc.perform(get("/products/followed/{userId}/list", idClient)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value("1"));
    }

    @Test
    void getFollowedPostOrderByDateDescOk() throws Exception {

        int idClient = 1;
        String order = "date_desc";
        mockMvc.perform(get("/products/followed/{userId}/list", idClient)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value("1"));
    }

    @Test
    void getFollowedPostOrderByDateError() throws Exception {

        int idClient = 1;
        String order = "date";
        mockMvc.perform(get("/products/followed/{userId}/list", idClient)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(order + " no es valido, recuerde que debe ingresar date_asc o date_desc"));
    }

    @Test
    void getFollowedPostNotFound() throws Exception {

        int idClient = 100;
        mockMvc.perform(get("/products/followed/{userId}/list", idClient)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El usuario con id " + idClient + " no existe"));

    }

    @Test
    void getFollowedPostNotFoundListSeller() throws Exception {

        int idClient = 3;
        mockMvc.perform(get("/products/followed/{userId}/list", idClient)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El usuario " + idClient + " no tiene vendedores seguidos"));

    }

    @Test
    void getFollowedPostNotFoundListPost() throws Exception {

        int idClient = 2;
        mockMvc.perform(get("/products/followed/{userId}/list", idClient)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontraron post de los vendedores seguidos del usuario " + idClient));

    }

    @Test
    void insertNewPostNotValid() throws Exception {
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(requestDto).replaceAll("17", "\"\""))
                )
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.[0]field").value("product.product_id"));
    }

    @Test
    void invalidRequest() throws Exception {
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(requestDto).replaceAll("17", "a"))
                )
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest());
    }
}