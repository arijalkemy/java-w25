package com.socialMeli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jayway.jsonpath.JsonPath;
import com.socialMeli.dto.request.PostDTO;
import com.socialMeli.dto.response.PostDto;
import com.socialMeli.dto.response.ProductDto;
import com.socialMeli.dto.response.PublicationDto;
import com.socialMeli.entity.Post;
import com.socialMeli.entity.Product;
import com.socialMeli.repository.IPostRepository;
import com.socialMeli.repository.IProductRepository;
import com.socialMeli.repository.IUserRepository;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
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

    @BeforeEach
    void setUp() {
        Period oneWeeksPeriod = Period.ofWeeks(1);
        postRepository.add(
                new Post(1, LocalDate.now(), 1, 1, 12000.0, 8)
        );
        postRepository.add(
                new Post(2, LocalDate.now().minus(oneWeeksPeriod), 2, 1, 12000.0, 8)
        );
        productRepository.add(
                new Product(
                        1, "Silla Gamer", "Gamer", "Racer",
                        "Negra", "Completa"
                )
        );
        productRepository.add(
                new Product(
                        2, "Gabinete 3x", "Gamer", "Negro",
                        "Bequiet", "Completa"
                )
        );

    }

    @Test
    void obtainLastPublicationsByTheFollowedVendorsTest_ok() throws Exception {

        this.mockMvc.perform(
                        get("/products/followed/1/list")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Silla Gamer")));
    }

    @Test
    void obtainLastPublicationsByTheFollowedVendorsTest_ok_orderAsc() throws Exception {
        this.mockMvc.perform(
                        get("/products/followed/1/list").param("order", "date_asc")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts[0].id", greaterThan(1)));
    }

    @Test
    void obtainLastPublicationsByTheFollowedVendorsTest_ok_orderDesc() throws Exception {
        this.mockMvc.perform(
                        get("/products/followed/1/list").param("order", "date_desc")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts[0].id", lessThan(2)));
    }

    @Test
    void obtainLastPublicationsByTheFollowedVendorsTest_throwsNotFound() throws Exception {

        this.mockMvc.perform(
                        get("/products/followed/12/list")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("No se encontro al usuario")));
    }

    @Test
    void obtainLastPublicationsByTheFollowedVendorsTest_throwsBadReq() throws Exception {

        this.mockMvc.perform(
                        get("/products/followed/aaa/list")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().is4xxClientError());
    }

    @Test
    void obtainLastPublicationsByTheFollowedVendorsTest_throws() throws Exception {

        this.mockMvc.perform(
                        get("/products/followed/-1/list")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().is4xxClientError())
        ;
        ;
    }

    @Test
    void addPost_ok() throws Exception {

        ProductDto product = new ProductDto(1, "Silla Gamer", "Gamer", "Razer", "Red", "Premium");
        PostDTO expectedPostDTO = new PostDTO(10, LocalDate.now(), product, 100, 1500.50);

        final ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .registerModule(new JavaTimeModule()).writer();

        String request = writer.writeValueAsString(expectedPostDTO);

        this.mockMvc.perform(
                        post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Post creado")));
    }

    @Test
    void addPost_throws() throws Exception {
        ProductDto product = new ProductDto(1, "Silla Gamer", "Gamer", "Razer", "Red&Blue", "Premium");
        PostDTO expectedPostDTO = new PostDTO(10, LocalDate.now(), product, 100, 1500.50);

        final ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .registerModule(new JavaTimeModule()).writer();

        String request = writer.writeValueAsString(expectedPostDTO);

        this.mockMvc.perform(
                        post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print()).andExpect(status().isBadRequest());

    }
}
