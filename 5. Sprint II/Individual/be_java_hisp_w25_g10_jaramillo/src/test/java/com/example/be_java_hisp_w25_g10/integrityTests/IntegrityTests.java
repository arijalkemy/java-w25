package com.example.be_java_hisp_w25_g10.integrityTests;

import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.dtos.PostDto;
import com.example.be_java_hisp_w25_g10.dtos.PostsDto;
import com.example.be_java_hisp_w25_g10.dtos.ProductDto;
import com.example.be_java_hisp_w25_g10.entities.Product;
import com.example.be_java_hisp_w25_g10.utils.Builder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrityTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getPostsFollowed() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/3/list")).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(MockMvcResultMatchers.jsonPath("$").exists()).
                andExpect(MockMvcResultMatchers.jsonPath("$.posts.size()").value(3)).andReturn();

        String response = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        PostsDto postsDto = mapper.readValue(response, PostsDto.class);

        LocalDate date = postsDto.posts().get(0).date();

        Assertions.assertTrue(date.isAfter(LocalDate.now().minusDays(20)));

    }

    @Test
    public void addPostTest() throws Exception {
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).
                writer().
                withDefaultPrettyPrinter();

        String payload = writer.writeValueAsString(Builder.postToCreate);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payload)).
                andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addPostInvalidDateTest() throws Exception {
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).
                writer().
                withDefaultPrettyPrinter();

        String payload = writer.writeValueAsString(Builder.postToCreateInvalidDate);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payload)).
                andDo(print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
