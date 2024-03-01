package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.GenericResponseDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostServiceImpIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    @SneakyThrows
    public void postProductSavePost(){
        //Arrange
        ProductDTO product = new ProductDTO(178, "Lechuga", "Verduras", "Sabrostar", "verde", "asd");
        LocalDate date = LocalDate.parse("01-10-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        PostDTO post = new PostDTO(3, date, product, 7, 167.3);
        GenericResponseDTO expectedResponse = new GenericResponseDTO("Post creado con exito con el id: 5");

        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String postJson = writer.writeValueAsString(post);
        String responseJson = writer.writeValueAsString(expectedResponse);
        //Act
        MvcResult testResponse =
                mockMvc.perform(post("/products/post").contentType("application/json").content(postJson))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();
        //Assert
        assertThat(testResponse.getResponse().getContentAsString()).isEqualTo(responseJson);
    }
}
