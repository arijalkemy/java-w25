package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.controller;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.ProductDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service.IPostService;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service.IUserService;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Utilities;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PostControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    IUserService userService;
    @Autowired
    IPostService postService;

    @Test
    void createPostOK() throws Exception {
        PostDTO postDTO = new PostDTO(25, LocalDate.parse("2024-02-20"),
                new ProductDTO(101, "Laptop","Mueble","GZ","Azul","Nueva"),
                23,150000.0 );
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(serializePost(postDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(25));
    }
    @Test
    void listProductsOK() throws Exception {
        Seller seller1 =  Utilities.generateSeller(30,"Johnny Depp", Utilities.generateListUsers());
        List<ProductDTO> listProductDTOExpected = Arrays.asList(Utilities.generateProductDto(102,"Ensalada"),
                Utilities.generateProductDto(103,"Znahoria"));
        int postID=202;
        for (ProductDTO productDTO: listProductDTOExpected){
            PostDTO postDTO = Utilities.generatePostDto(seller1.getUserId(),postID, LocalDate.parse("2024-02-20"),
                    productDTO.getProductId(),productDTO.getProductName());
            postService.addPost(postDTO);
            postID=postID+1;
        }

        MvcResult respose = mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(serializeProductList(listProductDTOExpected),(respose.getResponse().getContentAsString()));

    }
    @Test
    void getPostPerSellerOK() throws Exception {
        User user1 =  Utilities.generateUser(5,"Emma Watson");
        Seller seller1 =  Utilities.generateSeller(29,"Kate Winslet", Utilities.generateListUsers());
        userService.followUser(user1.getUserId(),seller1.getUserId());
        PostDTO postDTOSeller =Utilities.generatePostDto(seller1.getUserId(), 204,LocalDate.parse("2024-02-20"),
                104,"Spagueti");

        postService.addPost(postDTOSeller);
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",5))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }
    private String serializeProductList(List<ProductDTO> productDTOList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(productDTOList);
    }
    private String serializePost(PostDTO postDto) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().registerModule(new JavaTimeModule()).writer();
        return ow.writeValueAsString(postDto);
    }

}
