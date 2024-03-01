package org.bootcamp.javazoo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.ProductDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.time.LocalDate;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void addNewPostTest() throws Exception {
        ProductDto product = new ProductDto(1, "Laptop", "Electronics", "BrandX", "Silver", "Buen estado");
        PostDto post = new PostDto(1, "28-02-2024", product, 1, 500.0);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String json = writer.writeValueAsString(post);



        this.mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("The publication was created successfully"));
    }
}
