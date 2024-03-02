package com.example.be_java_hisp_w25_g11.controller;

import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.ProductDTO;
import com.example.be_java_hisp_w25_g11.entity.Buyer;
import com.example.be_java_hisp_w25_g11.entity.Product;
import com.example.be_java_hisp_w25_g11.entity.Seller;
import com.example.be_java_hisp_w25_g11.entity.SellerPost;
import com.example.be_java_hisp_w25_g11.repository.buyer.BuyerRepositoryImp;
import com.example.be_java_hisp_w25_g11.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.ISellerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.SellerRepositoryImp;
import com.example.be_java_hisp_w25_g11.repository.seller_post.ISellerPostRepository;
import com.example.be_java_hisp_w25_g11.repository.seller_post.SellerPostRepositoryImp;
import com.example.be_java_hisp_w25_g11.service.user.IUserService;
import com.example.be_java_hisp_w25_g11.service.user.UserServiceImp;
import com.example.be_java_hisp_w25_g11.utils.MapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SellerPostControllerTest {
    @Autowired
    IUserService userService;
    @Autowired
    IBuyerRepository buyerRepository;
    @Autowired
    ISellerRepository sellerRepository;
    @Autowired
    ISellerPostRepository sellerPostRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    public void  setupValues(){
        LocalDate currentDate = LocalDate.parse("2017-02-03");
        Integer userIdOne,buyerIdOne,postId,productId = 1;
        postId = buyerIdOne = userIdOne = productId;
        Integer userIdTwo = 2;
        Integer buyerIdTwo = 2 ;

        Product userProduct = new Product(productId,"Dado","Jugete","lego","blanco","NA");

        Seller seller = new Seller(userIdOne
                ,"Daniel"
                ,new HashSet<>(Arrays.asList(buyerIdOne,buyerIdTwo))
                ,new HashSet<>(Arrays.asList())
                ,new HashSet<>(Arrays.asList()));

        Seller sellerTwo = new Seller(userIdTwo
                ,"DanielSham"
                ,new HashSet<>(Arrays.asList(buyerIdOne,buyerIdTwo))
                ,new HashSet<>(Arrays.asList())
                ,new HashSet<>(Arrays.asList()));

        SellerPost sellerPost = new SellerPost(
                userIdOne,
                postId,
                currentDate,
                userProduct,
                1,
                20.000,
                seller
        );

        Buyer buyer = new Buyer(buyerIdOne,"Jose",new HashSet<>(Arrays.asList(userIdOne,userIdTwo)));
        Buyer buyerTwo = new Buyer(buyerIdTwo,"Josefo",new HashSet<>(Arrays.asList(userIdOne,userIdTwo)));

        buyerRepository.create(buyer);
        buyerRepository.create(buyerTwo);
        sellerRepository.create(seller);
        sellerRepository.create(sellerTwo);
        sellerPostRepository.create(sellerPost);
    }
    @Test
    void postNewProduct() throws Exception {
        Integer postCategory = 1;
        Integer sellerId = 2;
        Double productPrice = 5444.4;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate currentDate = LocalDate.parse("2017-02-03");
        ProductDTO productDTO = new ProductDTO(1,"Barro","insuo","oksla","negro","NA");
        CreatePostRequestDTO payload = new CreatePostRequestDTO(
                sellerId,
                dateTimeFormatter.format(currentDate),
                productDTO,
                postCategory,
                productPrice
        );

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                        .writer()
                                .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(payload);
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

    }

    @Test
    void getFollowedPostsList() throws Exception {
        Integer userId = 1;

        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();


    }
}