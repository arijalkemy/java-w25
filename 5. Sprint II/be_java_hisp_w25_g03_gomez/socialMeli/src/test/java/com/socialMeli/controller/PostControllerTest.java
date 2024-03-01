package com.socialMeli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.socialMeli.dto.response.FollowedListDto;
import com.socialMeli.dto.response.UserVendorDto;
import com.socialMeli.repository.IPostRepository;
import com.socialMeli.repository.IProductRepository;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    IPostRepository postRepository;

    @Autowired
    IProductRepository productRepository;
    @Test
    void addPost_okIntegrationTest() throws Exception {
        //error con el addPost de service
        String request = """
                {
                    "user_id": 8,
                    "date": "14-02-2024",
                    "product": {
                        "product_id": 10,
                        "product_name": "Silla Gamer",
                        "type": "Gamer",
                        "brand": "Racer",
                        "color": "Black",
                        "notes": "Special Edition"
                    },
                    "category": 100,
                    "price": 1500.50
                }""";
        this.mockMvc.perform(post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request)) //body post
                                .andDo(print()).andExpect(status().isOk())
                                .andExpect(content().string(containsString("Post creado")));
    }
    @Test
    void vendorFollowersOrderNullTestOK() throws Exception{
        Integer idTest = 10;
        FollowedListDto responseDTO = new FollowedListDto(idTest,"Victoria Acosta",
                                                List.of(new UserVendorDto(1,"Luciano Gonzalez")));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult response = this.mockMvc.perform(get("/users/{userId}/followers/list",idTest))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")) //espera json
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(idTest))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }
    @Test
    void vendorFollowersOrderAscOK() throws Exception{
        Integer idTest = 8;
        FollowedListDto responseDTO = new FollowedListDto(idTest,"Valeria Ramirez",
                List.of(new UserVendorDto(1,"Luciano Gonzalez"),
                        new UserVendorDto(2,"Sofia Fernandez")));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult response = this.mockMvc.perform(get("/users/{userId}/followers/list",idTest)
                        .param("order","name_asc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")) //espera json
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(idTest))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }
    @Test
    void vendorFollowersOrderBadRequest() throws Exception{
        this.mockMvc.perform(get("/users/{userId}/followers/list",10).
                        param("order","flsdmfr"))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json")) //espera json
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Los datos de ordenamiento solicitados son incorrectos."));
    }
    @Test
    void vendorFollowersOrderDescOK() throws Exception{
        Integer idTest = 8;
        FollowedListDto responseDTO = new FollowedListDto(idTest,"Valeria Ramirez",
                List.of(new UserVendorDto(2,"Sofia Fernandez"),
                        new UserVendorDto(1,"Luciano Gonzalez")));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult response = this.mockMvc.perform(get("/users/{userId}/followers/list",idTest)
                        .param("order","name_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")) //espera json
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(idTest))
                .andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }
    @Test
    void vendorFollowersIdNotNegative() throws Exception{
        this.mockMvc.perform(get("/users/{userId}/followers/list",-1))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json")) //espera json
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("El id debe ser un valor positivo"));
    }
    @Test
    void vendorFollowersIdNotFoundExceptionTest() throws Exception{
        this.mockMvc.perform(get("/users/{userId}/followers/list",1111))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json")) //espera json
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No se encontro al usuario"));
    }
    @Test
    void vendorFollowersIdNotVendorExceptionTest() throws Exception{
        this.mockMvc.perform(get("/users/{userId}/followers/list",1))
                .andDo(print()).andExpect(status().isForbidden())
                .andExpect(content().contentType("application/json")) //espera json
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El usuario no es un vendedor"));
    }
}
