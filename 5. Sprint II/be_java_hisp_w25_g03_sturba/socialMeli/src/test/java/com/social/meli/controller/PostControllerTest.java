package com.social.meli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.social.meli.dto.response.MessageDto;
import com.social.meli.dto.response.PublicationDto;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@FieldDefaults(level = PRIVATE)
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;
    final ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    PublicationDto publicationDto;
    @BeforeEach
    void setUp() {
        publicationDto = new PublicationDto(1, List.of());
    }

    final String request = "{\n" +
            "    \"user_id\": 8,\n" +
            addJson();
    final String userNotFoundRequest = "{\n" +
            "    \"user_id\": 11,\n" +
            addJson();
    final String userNotVendorRequest = "{\n" +
            "    \"user_id\": 1,\n" +
            addJson();

    private String addJson() {
        return """
                    "date": "14-02-2024",
                    "product": {
                        "product_id": 1,
                        "product_name": "Silla Gamer",
                        "type": "Gamer",
                        "brand": "Racer",
                        "color": "Black",
                        "notes": "Special Edition"
                    },
                    "category": 100,
                    "price": 1500.50
                }""";
    }

    String expectedErrorMessage = """
            {"product.note":"La longitud no puede superar los 15 caracteres","price":"El precio debe ser positivo","product.id":"El id debe ser un valor positivo","product.brand":"La longitud no puede superar los 15 caracteres","product.color":"La longitud no puede superar los 15 caracteres","product.name":"La longitud no puede superar los 40 caracteres","userId":"El id debe ser un valor positivo","product.type":"La longitud no puede superar los 15 caracteres"}""";


    @Test
    void addNewPostOkTest() throws Exception {
        MvcResult mockResponse = mockMvc.perform(post("/products/post")
                        .contentType(APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn();
        assertEquals(objectWriter.writeValueAsString(new MessageDto("Post creado con Ã©xito")),
                mockResponse.getResponse().getContentAsString());
    }

    @Test
    void addNewPostUserNotFoundTest() throws Exception {
        mockMvc.perform(post("/products/post")
                        .contentType(APPLICATION_JSON)
                        .content(userNotFoundRequest))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No se encontro al usuario"));

    }

    @Test
    void addNewPostUserNotVendorTest() throws Exception {
        mockMvc.perform(post("/products/post")
                        .contentType(APPLICATION_JSON)
                        .content(userNotVendorRequest))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El usuario Luciano Gonzalez no es un vendedor"));

    }

   /* @Test
    void addNewPostUserNotValidJsonTest() throws Exception {
        String notValidValuesRequest = """
                {
                    "user_id": -1,
                    "date": "14-02-2025",
                    "product": {
                        "product_id": -1,
                        "product_name": "",
                        "type": "",
                        "brand": "",
                        "color": "",
                        "notes": ""
                    },
                    "category": -1,
                    "price": -1
                }""";
        String response = mockMvc.perform(post("/products/post")
                        .contentType(APPLICATION_JSON)
                        .content(notValidValuesRequest))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();
        assertEquals(expectedErrorMessage, response);
    }*/

    @Test
    void obtainLastPublicationsByTheFollowedVendorsOk() throws Exception {
        String response = mockMvc.perform(get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();
        assertEquals(objectWriter.writeValueAsString(publicationDto),response);
    }
    @ParameterizedTest
    @ValueSource(strings = {"date_asc","date_desc"})
    void obtainLastPublicationsByTheFollowedVendorsOrderOk(String order) throws Exception {
        String response = mockMvc.perform(get("/products/followed/{userId}/list", 1).param("order",order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();
        assertEquals(objectWriter.writeValueAsString(publicationDto),response);
    }
    @Test
    void obtainLastPublicationsByTheFollowedVendorsIncorrectOrderOk() throws Exception {
       mockMvc.perform(get("/products/followed/{userId}/list", 1).param("order","order"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON));
    }


}