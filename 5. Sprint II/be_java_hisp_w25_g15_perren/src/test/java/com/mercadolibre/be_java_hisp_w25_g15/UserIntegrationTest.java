package com.mercadolibre.be_java_hisp_w25_g15;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.ProductDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.MessageResponseDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setup() {
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }


    @Test
    void followUserOK() throws Exception {

        Integer userId = 1;
        Integer userToFollow = 2;

        MessageResponseDto messageResponseDto = new MessageResponseDto("Seller followed correctly");
        String expected = writer.writeValueAsString(messageResponseDto);
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userToFollow))
                .andDo(print())
                .andExpect(content().json(expected))
                .andExpect(status().isOk())
                .andReturn();


    }


    @Test
    void followUserNotSellerFail() throws Exception {

        Integer userId = 1;
        Integer userToFollow = 5;

        MessageResponseDto messageResponseDto = new MessageResponseDto("User to follow is not a Seller");
        String expected = writer.writeValueAsString(messageResponseDto);
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userToFollow))
                .andDo(print())
                .andExpect(content().json(expected))
                .andExpect(status().isConflict())
                .andReturn();


    }

}
