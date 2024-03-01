package com.social.meli.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.social.meli.dto.request.PostDTO;
import com.social.meli.dto.response.MessageDto;
import com.social.meli.dto.response.PostDto;
import com.social.meli.dto.response.ProductDto;
import com.social.meli.dto.response.PublicationDto;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.*;
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
    static Stream<Arguments> invalidUserData() {
        return Stream.of(
                Arguments.of(11, NOT_FOUND, "No se encontro al usuario"),
                Arguments.of(1, BAD_REQUEST, "El usuario Luciano Gonzalez no es un vendedor")
        );
    }
    final ObjectWriter objectWriter = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
            .registerModule(new JavaTimeModule()).writer();
    PostDTO requestPostDto;

    String expectedPublicationDto;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        ProductDto productDto = new ProductDto(1,"auto","Vehicular","Ferrari","Rojo","Premium");
        requestPostDto = new PostDTO(8,LocalDate.now(),productDto,1,2.0);
        PostDto postDto = new PostDto(1, 8, LocalDate.now(), productDto, 1, 2.0);
        PublicationDto publicationDto = new PublicationDto(1, List.of(postDto));
        expectedPublicationDto = objectWriter.writeValueAsString(publicationDto);

    }


    @Test
    void addNewPostOkTest() throws Exception {
        requestPostDto.setUserId(9);
        MvcResult mockResponse = mockMvc.perform(post("/products/post")
                        .contentType(APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(requestPostDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn();
        assertEquals(objectWriter.writeValueAsString(new MessageDto("Post creado con Ã©xito")),
                mockResponse.getResponse().getContentAsString());
    }

    @ParameterizedTest
    @MethodSource("invalidUserData")
    void addNewPostUserNotFoundTest(Integer userId, HttpStatus status,String errorMessage) throws Exception {
        requestPostDto.setUserId(userId);
        mockMvc.perform(post("/products/post")
                        .contentType(APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(requestPostDto)))
                .andDo(print())
                .andExpect(status().is(status.value()))
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(errorMessage));

    }


    @Test
    void obtainLastPublicationsByTheFollowedVendorsOk() throws Exception {
        String response = mockMvc.perform(get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();
        assertEquals(expectedPublicationDto,response);
    }
    @ParameterizedTest
    @ValueSource(strings = {"date_asc","date_desc"})
    void obtainLastPublicationsByTheFollowedVendorsOrderOk(String order) throws Exception {
        String response = mockMvc.perform(get("/products/followed/{userId}/list", 1).param("order",order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();
        assertEquals(expectedPublicationDto,response);
    }
    @Test
    void obtainLastPublicationsByTheFollowedVendorsIncorrectOrderOk() throws Exception {
       mockMvc.perform(get("/products/followed/{userId}/list", 1).param("order","order"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON));
    }


}