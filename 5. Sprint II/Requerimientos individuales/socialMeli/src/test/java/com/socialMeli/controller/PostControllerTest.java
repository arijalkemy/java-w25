package com.socialMeli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialMeli.dto.request.PostDTO;
import com.socialMeli.dto.response.PostDto;
import com.socialMeli.dto.response.ProductDto;
import com.socialMeli.dto.response.PublicationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void obtainLastPublicationsByTheFollowedVendorsOK() throws Exception {
        ProductDto product = new ProductDto(1, "Silla Gamer", "Gamer", "Razer", "Red", "Premium");
        PostDto expectedPostDTO = new PostDto(1, 10, LocalDate.now(), product, 100, 1500.50);

        final ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .registerModule(new JavaTimeModule()).writer();

        PublicationDto pub = new PublicationDto(1, List.of(expectedPostDTO));
        String expectedJson = writer.writeValueAsString(pub);

        mockMvc.perform(get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedJson));
    }
    @Test
    public void obtainLastPublicationsByTheFollowedVendorsEMPTY() throws Exception {
        final ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .registerModule(new JavaTimeModule()).writer();

        PublicationDto pub = new PublicationDto(5, List.of());
        String expectedJson = writer.writeValueAsString(pub);

        mockMvc.perform(get("/products/followed/{userId}/list", 5))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedJson));
    }
}
