package com.bootcamp.be_java_hisp_w25_g02.integration;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowingPostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.GenericResponseDTO;
import com.bootcamp.be_java_hisp_w25_g02.util.TestUtilGenerator;
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
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    ObjectWriter writerWithDate = new ObjectMapper().registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    @DisplayName("Individual Bonus - savePost - Integration Test")
    void savePost() throws Exception {
        // Arrange
        Integer id = 7;
        PostDTO request = TestUtilGenerator.getSavingPostDTO();
        GenericResponseDTO expected = TestUtilGenerator.getSavedPostGenericResponseDTO(id);

        String requestJson = writerWithDate.writeValueAsString(request);
        String expectedJson = writer.writeValueAsString(expected);

        // Act
        MvcResult result = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Assert
        assertEquals(expectedJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Individual Bonus - getFollowedPosts - Integration Test")
    void getFollowedPosts() throws Exception {
        // Arrange
         Integer id = 12;
         FollowingPostDTO expected = TestUtilGenerator.getFollowingPostDTOForId12();
         String expectedJson = writerWithDate.writeValueAsString(expected);

        // Act
        MvcResult result = mockMvc.perform(get("/products/followed/{userId}/list", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Assert
        assertEquals(expectedJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
