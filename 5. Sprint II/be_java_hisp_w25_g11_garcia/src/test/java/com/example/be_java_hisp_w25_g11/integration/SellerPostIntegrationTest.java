package com.example.be_java_hisp_w25_g11.integration;

import com.example.be_java_hisp_w25_g11.dto.ExceptionDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.ProductDTO;
import com.example.be_java_hisp_w25_g11.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.ISellerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller_post.ISellerPostRepository;
import com.example.be_java_hisp_w25_g11.utils.DataModeler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SellerPostIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private IBuyerRepository buyerRepository;
    @Autowired
    private ISellerRepository sellerRepository;
    @Autowired
    private ISellerPostRepository sellerPostRepository;
    @Autowired
    private DataModeler dataModeler;
    private static ObjectWriter writer;

    @BeforeAll
    static void init() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach
    void setup() {
        buyerRepository.clearData();
        sellerRepository.clearData();
        sellerPostRepository.clearData();
        dataModeler.load();
    }

    @Test
    void testPostNewProductOk() throws Exception {
        // Arrange
        Integer expectedPostId = 6;
        ProductDTO productDTO = new ProductDTO(
            2,
            "Silla Gamer",
            "Gamer",
            "Racer",
            "Red y Black",
            "Special Edition"
        );
        CreatePostRequestDTO payloadDTO = new CreatePostRequestDTO(
            7,
            "28-02-2024",
            productDTO,
            100,
            1500.50
        );
        String payloadJson = writer.writeValueAsString(payloadDTO);

        // Act
        this.mockMvc.perform(post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.post_id").value(expectedPostId));
    }

    @Test
    void testPostNewProductInvalidPayload() throws Exception {
        // Arrange
        int expectedMessagesListSize = 3;
        ProductDTO productDTO = new ProductDTO(
                2,
                "Silla Gamer",
                "Gamer",
                "Racer",
                "Red & Black",
                "Special Edition"
        );
        CreatePostRequestDTO payloadDTO = new CreatePostRequestDTO(
                7,
                "",
                productDTO,
                100,
                20000000.50
        );
        String payloadJson = writer.writeValueAsString(payloadDTO);

        // Act
        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.messages").value(hasSize(expectedMessagesListSize)));
    }

    @Test
    void testFollowedPostsListOkEmpty() throws Exception {
        // Arrange
        Integer userId = 10;

        // Act & Assert
        this.mockMvc.perform(get("/products/followed/"+userId+"/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.posts").isEmpty());
    }

    @Test
    void testFollowedPostsListInvalidOrder() throws Exception {
        // Arrange
        int userId = 10;
        String order = "empanada";
        ExceptionDTO expectedDTO = new ExceptionDTO("Argumento invalido (order debe ser DATE_ASC o DATE_DESC)");
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        // Act & Assert
        this.mockMvc.perform(get("/products/followed/"+userId+"/list?order="+order))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }
}