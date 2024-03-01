package com.bootcamp.be_java_hisp_w25_g02.controller;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.GenericResponseDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {


    @Autowired
    MockMvc mockMvc;

    // Bonus  (Desarrollo Individual EXTRA)
    @Test
    @SneakyThrows
    @DisplayName("Integration test - savePost")
    public void savePostTest(){
        //Arrange
        //Primero preparo lo que voy a enviar y lo que voy a recibir
        LocalDate date = LocalDate.parse("15-03-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        PostDTO post = new PostDTO(2, date,
                new ProductDTO(8, "Lentes de sol", "Lentes", "Ray Ban",
                        "Gris", "Lorem ipsum"),  3, 13500.0);

        GenericResponseDTO expectedResponse = new GenericResponseDTO("Post creado con exito con el id: 5");

        //Los transformo
        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String postJson = writer.writeValueAsString(post);
        String responseJson = writer.writeValueAsString(expectedResponse);

        // Act
        MvcResult result =
                mockMvc.perform(post("/products/post").contentType("application/json").content(postJson))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();
       // Assert
        assertThat(result.getResponse().getContentAsString()).isEqualTo(responseJson);
    }

}
