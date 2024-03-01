package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.ProductDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerTestsIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Add post Integration")
    public void addPost() throws Exception {
        ProductDTO productDTO = new ProductDTO(77, "MacBook Pro", "Mac", "Apple", "gray", "Special Edition");

        RequestPostDTO payload = new RequestPostDTO(3, LocalDate.of(2024,3,1), productDTO, 100, 25000.00);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payload);
        System.out.println(payloadJson);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

    }

}
