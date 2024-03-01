package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter objectWriter;

    @BeforeAll
    public static void setUp(){
        objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    void insertNewPostNotOk() throws Exception{

        PostRequestDto postRequestDto = new PostRequestDto(
                26,
                LocalDate.now(),
                new ProductDto(
                        44,
                        "testProductName",
                        "TestType",
                        "TestBrand",
                        "TestColor",
                        "no notes"
                ),
                100,
                3000.0
        );
        MessageDto expectedDto = new MessageDto("Publicación creada con éxito");
        String postTestData = objectWriter.writeValueAsString(postRequestDto);
        String expected = objectWriter.writeValueAsString(expectedDto);

        mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON).content(postTestData))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expected));

    }


    @Test
    void insertNewPostNotValid() throws Exception{

        String postTestData = "{\"user_id\":a,\"date\":\"29-02-2024\",\"product\":{\"product_id\":44,\"product_name\":" +
                "\"testProductName\",\"type\":\"TestType\",\"brand\":\"TestBrand\",\"color\":\"TestColor\",\"notes\":" +
                "\"no notes\"},\"category\":100,\"price\":3000.0}";

        mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON).content(postTestData))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest());

    }

    @Test
    void insertNewPostNotValidList() throws Exception{

        String postTestData = "{}";

        mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON).content(postTestData))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest());

    }

    @Test
    void insertNewPostNotSellerOrNotFound() throws Exception{

        PostRequestDto postRequestDto = new PostRequestDto(
                1,
                LocalDate.now(),
                new ProductDto(
                        44,
                        "testProductName",
                        "TestType",
                        "TestBrand",
                        "TestColor",
                        "no notes"
                ),
                100,
                3000.0
        );
        MessageDto expectedDto = new MessageDto("El usuario no se encuentra o no es vendedor");
        String postTestData = objectWriter.writeValueAsString(postRequestDto);
        String expected = objectWriter.writeValueAsString(expectedDto);

        mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON).content(postTestData))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(content().json(expected));

    }

    @Test
    void insertNewPostPostAlreadyExists() throws Exception{

        PostRequestDto postRequestDto = new PostRequestDto(
                26,
                LocalDate.now(),
                new ProductDto(
                        1,
                        "testProductName",
                        "TestType",
                        "TestBrand",
                        "TestColor",
                        "no notes"
                ),
                100,
                3000.0
        );
        MessageDto expectedDto = new MessageDto("El identificador del producto no corresponde con el registrado");
        String postTestData = objectWriter.writeValueAsString(postRequestDto);
        String expected = objectWriter.writeValueAsString(expectedDto);

        mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON).content(postTestData))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));

    }

    @Test
    void getFollowedPostOrderByDateAsc() throws Exception {
        int userId = 1;
        String order = "date_asc";

        mockMvc.perform(get("/products/followed/{userId}/list", userId).param("order",order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());

    }

    @Test
    void getFollowedPostOrderByDateDesc() throws Exception {
        int userId = 1;
        String order = "date_desc";

        mockMvc.perform(get("/products/followed/{userId}/list", userId).param("order",order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());

    }

    @Test
    void getFollowedPostOrderByDateNoFollowed() throws Exception {
        int userId = 3;
        String order = "date_asc";

        MessageDto dto = new MessageDto("El usuario 3 no tiene vendedores seguidos");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(get("/products/followed/{userId}/list", userId).param("order",order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(content().json(expected));

    }

    @Test
    void getFollowedPostOrderByDateBadOrder() throws Exception {
        int userId = 2;
        String order = "date";

        MessageDto dto = new MessageDto("date no es valido, recuerde que debe ingresar date_asc o date_desc");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(get("/products/followed/{userId}/list", userId).param("order",order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));

    }
}