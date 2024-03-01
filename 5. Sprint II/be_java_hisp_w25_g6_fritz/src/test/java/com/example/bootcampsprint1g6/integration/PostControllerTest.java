package com.example.bootcampsprint1g6.integration;

import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.Buyer;
import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.Product;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.util.DateFormatter;
import com.example.bootcampsprint1g6.util.PostTestGenerator;
import com.example.bootcampsprint1g6.util.UserTestGenerator;
import com.example.bootcampsprint1g6.util.mapper.PostMapper;
import com.example.bootcampsprint1g6.util.mapper.ProductMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    private PostResponseDTO postResponseDTO;
    private PostRequestDTO postRequestDTO;
    @BeforeEach
    void setUp(){
        Product product1 = new Product(23, "camisa a rayas", "indumentaria", "sarkany", "rojo", "unico color, puro algodon");
        Post post1 = PostTestGenerator.getPostFromUserProductDate(new Seller(3, "seller3", "seller3@test.com"),product1, LocalDate.now().minusWeeks(2).plusDays(1));
        postRequestDTO = new PostRequestDTO(3, DateFormatter.parseDateLocalDate(LocalDate.now().minusWeeks(2).plusDays(1)), ProductMapper.getInstance(product1),123,23.4);
        postResponseDTO = PostMapper.getResponseInstance(post1);
    }

    @Test
    void createPostOkTest() throws Exception{
        String expected = writer.writeValueAsString(postResponseDTO);
        String post = writer.writeValueAsString(postRequestDTO);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(post))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void createPostFieldExceptionTest() throws Exception{
        postRequestDTO.setPrice(null);
        String post = writer.writeValueAsString(postRequestDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(post))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El campo no puede estar vacío."));

    }

    @Test
    void createPostDateExceptionTest() throws Exception{
        postRequestDTO.setDate("30-22-2020");
        String post = writer.writeValueAsString(postRequestDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(post))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Formato de fecha incorrecto"));
    }

    @Test
    void createPostFutureDateExceptionTest() throws Exception{
        postRequestDTO.setDate(DateFormatter.parseDateLocalDate(LocalDate.now().plusYears(1)));
        String post = writer.writeValueAsString(postRequestDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(post))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Datos incorrectos en la solicitud"));
    }

    @Test
    void createPostDateEmptyExceptionTest() throws Exception{
        postRequestDTO.setDate(null);
        String post = writer.writeValueAsString(postRequestDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(post))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("La fecha no puede estar vacía."));
    }

    @Test
    void createPostInexistentUserExceptionTest() throws Exception{
        postRequestDTO.setUserId(10);
        String post = writer.writeValueAsString(postRequestDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(post))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No se puede crear el post ya que el usuario con id "+10+" no existe."));
    }

    @Test
    void createPostFromBuyerExceptionTest() throws Exception{
        Buyer buyer = UserTestGenerator.getBuyerWithId(5);
        postRequestDTO.setUserId(buyer.getUserId());
        String post = writer.writeValueAsString(postRequestDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(post))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario no es un vendedor. No se puede concretar la operación."));
    }
}
