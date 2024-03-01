package com.example.be_java_hisp_w25_g10.controller;

import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.entities.Post;
import com.example.be_java_hisp_w25_g10.entities.Product;
import com.example.be_java_hisp_w25_g10.utils.Builder;
import com.example.be_java_hisp_w25_g10.utils.PostMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void addPostIntegrationOKTest() throws Exception {
        PostCreatedDto entry = Builder.postCreatedEntry();
        PostCreatedDto expected = Builder.postCreatedOutput();

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String entrypost = objectWriter.writeValueAsString(entry);
        String expectedPost = objectWriter.writeValueAsString(expected);

        MvcResult mvcResult =
        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(entrypost)
        )
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(expectedPost, mvcResult.getResponse().getContentAsString() );

    }
}
