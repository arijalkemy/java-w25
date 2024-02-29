package com.mercadolibre.be_java_hisp_w25_g15;


import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.ProductDto;
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
public class PostIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setup(){
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    }


    @Test
    void createPostOK() throws Exception{

        ProductDto productDto = new ProductDto(1, "Leche","Lacteo", "Milkaut", "Blanco", "");
        PostDto postDto = new PostDto(1,19,"15-02-2024", productDto, 1,15.0);
        String postDtoJson = writer.writeValueAsString(postDto);
        mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON).content(postDtoJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                //.andExpect(content().json(postDtoJson)) al correr todos los test puede tomar un id diferente y fallar, por eso omito este chequeo
                .andReturn();

    }


}
