package com.example.be_java_hisp_w25_g11.integration;

import com.example.be_java_hisp_w25_g11.dto.response.SuccessDTO;
import com.example.be_java_hisp_w25_g11.repository.buyer.BuyerRepositoryImp;
import com.example.be_java_hisp_w25_g11.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.ISellerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.SellerRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    static void init() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach
    void setup() {
        
    }

    @Test
    void testFollowOk() throws Exception {
        SuccessDTO expectedDTO = new SuccessDTO("El usuario con id=3 ahora sigue al vendedor con id=6.");
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        this.mockMvc.perform(post("/users/3/follow/6"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testFollowNoOk() throws Exception {
        SuccessDTO expectedDTO = new SuccessDTO("El usuario con id=3 ahora sigue al vendedor con id=6.");
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        this.mockMvc.perform(post("/users/3/follow/6"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testFollowersCountOk() {
    }

    @Test
    void testFollowersListOk() {
    }

    @Test
    void testFollowedListOk() {
    }

    @Test
    void testUnfollowOk() {
    }
}