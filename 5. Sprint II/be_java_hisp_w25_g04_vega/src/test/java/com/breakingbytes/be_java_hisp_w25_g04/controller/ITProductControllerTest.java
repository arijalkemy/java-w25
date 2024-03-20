package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.ProductDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponsePostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04.repository.DbMock;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class ITProductControllerTest {

    @Autowired private ProductController productController;
    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    void init(){
            writer = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .registerModule(new JavaTimeModule())//Se carga dependencia de tiempo
                    .writer();
    }

    @Test
    void getPostOfVendorsFollowedByUserTestOk() throws Exception{
        //Usuario a buscar en DbMock
        Integer userId = 1;
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/products/followed/{userId}/list", userId)) //Se accede a la url, no se pasa ordenamiento
                .andDo(print())
                .andReturn(); //Obtenemos el resultado

        User user = DbMock.getInstance().getListOfUsers().get(0);//User con id 1
        LastPostsDTO expected = new LastPostsDTO(userId,
                user.getFollowing().stream().map(Seller::getPosts)
                        .flatMap(List::stream).toList()//Obtenemos listado completo de POSTS de los vendedores que sigue el user
                        .stream().filter //Seleccionamos aquellos que tienen menos de 2 semanas de antiguedad
                                (p -> p.getDate().isAfter(LocalDate.now().minusWeeks(2))).map(post ->
                        new ResponsePostDTO(post.getUserId(),
                                post.getPostId(),
                                post.getDate(),
                                post.getProduct(),
                                post.getCategory(),
                                post.getPrice())).toList());

        String expectedPayload = writer.writeValueAsString(expected);
        assertEquals(expectedPayload, result.getResponse().getContentAsString());
    }

    @Test
    void addPostTestOk() throws Exception{
        //Usuario a buscar en DbMock
        RequestPostDTO request = new RequestPostDTO(3,
                LocalDate.of(2021,4,29),
                new ProductDTO(10,
                        "Mouse Gamer",
                        "Electronics",
                        "Genius",
                        "Red and Black",
                        "Special Edition"),
                100,
                120.0);
        String payload = writer.writeValueAsString(request);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    void addPostTestInvalidFields() throws Exception{
        //Usuario a buscar en DbMock
        RequestPostDTO request = new RequestPostDTO(-3,
                LocalDate.of(2021,4,29),
                new ProductDTO(10,
                        "Mouse $Gamer$",
                        "Electronics",
                        "",
                        "Red & Black",
                        "Special Edition"),
                100,
                120.0);
        String payload = writer.writeValueAsString(request);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.validations").isArray());


    }
}
