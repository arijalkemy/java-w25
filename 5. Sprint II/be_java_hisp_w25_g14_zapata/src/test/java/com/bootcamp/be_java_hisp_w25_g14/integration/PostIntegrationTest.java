package com.bootcamp.be_java_hisp_w25_g14.integration;

import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.ProductDto;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotSellerException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {

    @Autowired
    MockMvc mockMvc;


    /*
     * test to list all posts on the database
     *
     * */
    @Test
    public void testFindAllPostOk() throws Exception {

        this.mockMvc.perform(get("/products/getAllPosts"))
                .andDo(print())
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.message").value("Follow successfully"))
                .andExpect(content().contentType("application/json"));
    }

    /*
    * test to create a post when all data is correct
    * */

    @Test
    public void testSavePostOk() throws Exception {

        PostDto postDto = new PostDto();
        ProductDto productDto = new ProductDto();

        productDto.setProduct_id(1);
        productDto.setProduct_name("Nintendo 3ds");
        productDto.setColor("metalic blue");
        productDto.setBrand("Nintendo");
        productDto.setType("videogames");
        productDto.setNotes("refurbished");

        postDto.setUser_id(1);
        postDto.setDate("04-02-2024");
        postDto.setProduct(productDto);
        postDto.setCategory(100);
        postDto.setPrice(450000.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(postDto);

        this.mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Post added"))
                .andExpect(jsonPath("$.description").value("The post was added succesfully"));

    }/*
    * test that fails when one needed argument in the body es
    * */

    @Test
    public void testSavePostMethodArgumentNotValidException() throws Exception {

        PostDto postDto = new PostDto();
        ProductDto productDto = new ProductDto();

        productDto.setProduct_id(1);
        productDto.setProduct_name("Nintendo 3ds");
        productDto.setColor("metalic blue");
        productDto.setBrand("Nintendo");
        productDto.setType("videogames");
        productDto.setNotes("refurbished");

        postDto.setUser_id(null);
        postDto.setDate("04-02-2024");
        postDto.setProduct(productDto);
        postDto.setCategory(100);
        postDto.setPrice(450000.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(postDto);

        this.mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andExpect(jsonPath("$.message").value("invalid argument"))
                .andExpect(jsonPath("$.description").value("The field user_id cannot be null"));

    }


    /**
     * test to returns an exception when the user is not a seller
     *
     * */

    @Test
    public void testSavePostNotSellerException() throws Exception {

        PostDto postDto = new PostDto();
        ProductDto productDto = new ProductDto();

        productDto.setProduct_id(5);
        productDto.setProduct_name("Nintendo 3ds");
        productDto.setColor("metalic blue");
        productDto.setBrand("Nintendo");
        productDto.setType("videogames");
        productDto.setNotes("refurbished");

        postDto.setUser_id(4);
        postDto.setDate("04-02-2024");
        postDto.setProduct(productDto);
        postDto.setCategory(100);
        postDto.setPrice(450000.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(postDto);

        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NotSellerException))
                .andExpect(jsonPath("$.message").value("The user is not a seller"));

    }


}
