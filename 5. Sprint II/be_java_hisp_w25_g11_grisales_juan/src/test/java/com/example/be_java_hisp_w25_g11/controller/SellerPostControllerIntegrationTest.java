package com.example.be_java_hisp_w25_g11.controller;

import com.example.be_java_hisp_w25_g11.dto.SellerPostDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.ProductDTO;
import com.example.be_java_hisp_w25_g11.entity.Buyer;
import com.example.be_java_hisp_w25_g11.entity.Seller;
import com.example.be_java_hisp_w25_g11.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.ISellerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller_post.ISellerPostRepository;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerPostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private IBuyerRepository buyerRepository;

    @Autowired
    private ISellerRepository sellerRepository;

    @Autowired
    private ISellerPostRepository sellerPostRepository;

    @BeforeEach
    public void repositoryReset() {
        buyerRepository.clearData();
        sellerRepository.clearData();
        sellerPostRepository.clearData();
    }

    private void repositoryData(){
        Integer userId1 = 1;
        Integer userId2 = 2;
        Integer userId3 = 3;

        Seller seller1 = new Seller(userId1, "Federico");
        Seller seller2 = new Seller(userId2, "Estefania");
        Buyer buyer1 = new Buyer(userId3, "Juliana");

        sellerRepository.createAll(List.of(seller1, seller2));
        buyerRepository.create(buyer1);
    }

    @Test
    public void testPostNewProductOk() throws Exception {
        repositoryData();
        CreatePostRequestDTO payloadDTO = new CreatePostRequestDTO(
                1,
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new ProductDTO(
                        1,
                        "Cuaderno cuadriculado",
                        "Papeleria",
                        "Scribe",
                        "Amarillo",
                        "Producto regular"
                ),
                1,
                100.0
        );
        SellerPostDTO responseDTO = new SellerPostDTO(
                1,
                0,
                LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                new ProductDTO(
                        1,
                        "Cuaderno cuadriculado",
                        "Papeleria",
                        "Scribe",
                        "Amarillo",
                        "Producto regular"
                ),
                1,
                100.0
        );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult response = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(responseJson, response.getResponse().getContentAsString());
    }
}
