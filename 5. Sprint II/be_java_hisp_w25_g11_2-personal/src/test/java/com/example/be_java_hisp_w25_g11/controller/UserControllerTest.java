package com.example.be_java_hisp_w25_g11.controller;

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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserControllerTest {
    IUserService userService;
    IBuyerRepository buyerRepository;
    ISellerRepository sellerRepository;
    ISellerPostRepository sellerPostRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    public void  setupValues(){
        this.buyerRepository = spy(BuyerRepositoryImp.class);
        this.sellerRepository = spy(SellerRepositoryImp.class);
        this.sellerPostRepository = spy(SellerPostRepositoryImp.class);

        LocalDate dateToUseInSellers = LocalDate.parse("2017-02-03");
        Integer sellerId = 1;
        Integer productId = 1;
        Integer postId = 1;
        Integer buyerId = 2 ;
        Product userProduct = new Product(productId,"Dado","Jugete","lego","blanco","NA");
        Seller seller = new Seller(sellerId
                ,"DanielSham"
                ,new HashSet<>(Arrays.asList())
                ,new HashSet<>(Arrays.asList())
                ,new HashSet<>(Arrays.asList()));
        SellerPost sellerPost = new SellerPost(
                sellerId,
                postId,
                dateToUseInSellers,
                userProduct,
                1,
                20.000,
                seller
        );
        Buyer buyer = new Buyer(buyerId,"Josefo");
        buyerRepository.create(buyer);
        sellerRepository.create(seller);
        sellerPostRepository.create(sellerPost);
        this.userService = new UserServiceImp(buyerRepository,sellerRepository,modelMapper);
    }
    @Test
    void follow() throws Exception {
        Integer buyerIdThaWillFollow = 2;
        Integer sellerIdThaWillBeFollowed = 1;

//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",buyerIdThaWillFollow,sellerIdThaWillBeFollowed))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
    }

    @Test
    void followersCount() {
    }

    @Test
    void followersList() {
    }

    @Test
    void followedList() {
    }

    @Test
    void unfollow() {
    }
}