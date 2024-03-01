package com.example.be_java_hisp_w25_g11;


import com.example.be_java_hisp_w25_g11.dto.SellerPostDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.ProductDTO;
import com.example.be_java_hisp_w25_g11.entity.Buyer;
import com.example.be_java_hisp_w25_g11.entity.Product;
import com.example.be_java_hisp_w25_g11.entity.Seller;
import com.example.be_java_hisp_w25_g11.entity.SellerPost;
import com.example.be_java_hisp_w25_g11.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.ISellerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller_post.ISellerPostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class SellerPostIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ISellerPostRepository sellerPostRepository;

    @Autowired
    private IBuyerRepository buyerRepository;

    @Autowired
    private ISellerRepository sellerRepository;

    public void repositorySetup() {
        sellerPostRepository.clearData();
        buyerRepository.clearData();
        sellerRepository.clearData();
    }

    private void dummySetup() {
        Buyer buyer1 = new Buyer(1, "Carlos");
        Buyer buyer2 = new Buyer(2, "Juan");
        Seller seller1 = new Seller(3, "Pepe");
        Seller seller2 = new Seller(4, "Curamani");

        buyerRepository.createAll(List.of(buyer1, buyer2));
        sellerRepository.createAll(List.of(seller1, seller2));
        sellerRepository.addFollower(seller1,buyer1.getId());
        buyerRepository.addFollowed(buyer1,seller1.getId());

    }
    @Test
public void testPostNewProductOk() throws Exception {
    dummySetup();
    CreatePostRequestDTO payloadDTO = new CreatePostRequestDTO(
            3,
            LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
            new ProductDTO(
                    1,
                    "Pista motociclos",
                    "Tienda",
                    "Matel",
                    "Varios",
                    "Disponible por tiempo limitado"
            ),
            1,
            100.0
    );
    SellerPostDTO responseDTO = new SellerPostDTO(
            3,
            0,
            LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            new ProductDTO(
                    1,
                    "Pista motociclos",
                    "Tienda",
                    "Matel",
                    "Varios",
                    "Disponible por tiempo limitado"
            ),                1,
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

    @Test
    public void testPostNewProductReturnsInvalidRequestFormat() throws Exception {
        String payloadJson = "{}";

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.messages").isArray())
                .andExpect(jsonPath("$.messages", hasSize(4)))
                .andExpect(jsonPath("$.messages", hasItem("La fecha no puede estar vacía.")))
                .andExpect(jsonPath("$.messages", hasItem("El precio no puede estar vacío")))
                .andExpect(jsonPath("$.messages", hasItem("El  id no puede estar vacío")))
                .andExpect(jsonPath("$.messages", hasItem("La categoria no puede estar vacío")))
                .andReturn();
    }

    @Test
    public void testGetFollowedPostList() throws Exception{
        dummySetup();
        Integer userId = 1;
        SellerPost sellerPost = new SellerPost(
                3,
                1,
                LocalDate.now(),
                new Product(
                        1,
                        "Pista motociclos",
                        "Tienda",
                        "Matel",
                        "Varios",
                        "Disponible por tiempo limitado"
                ),
                1,
                100.0,
                new Seller(1,"pepe")
        );
        sellerPostRepository.create(sellerPost);
        Optional<Seller> seller = sellerRepository.get(3);
        seller.get().setPosts(Set.of(sellerPost));
        mockMvc.perform(get("/products/followed/{userId}/list",userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(userId));
    }

}
