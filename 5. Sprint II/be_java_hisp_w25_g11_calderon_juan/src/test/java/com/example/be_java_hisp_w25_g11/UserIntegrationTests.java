package com.example.be_java_hisp_w25_g11;

import com.example.be_java_hisp_w25_g11.dto.response.SuccessDTO;
import com.example.be_java_hisp_w25_g11.entity.Buyer;
import com.example.be_java_hisp_w25_g11.entity.Seller;
import com.example.be_java_hisp_w25_g11.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.ISellerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class UserIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private IBuyerRepository buyerRepository;
    @Autowired
    private ISellerRepository sellerRepository;
    @BeforeEach
    public void repositorySetUp(){
        buyerRepository.clearData();
        sellerRepository.clearData();
    }
    private void dummySetup() {
        Buyer buyer1 = new Buyer(1, "Buyer1");
        Buyer buyer2 = new Buyer(2, "Buyer1");
        Seller seller1 = new Seller(3, "Seller1");
        buyerRepository.create(buyer1);
        buyerRepository.create(buyer2);
        sellerRepository.create(seller1);
        sellerRepository.addFollower(seller1,buyer1.getId());
        buyerRepository.addFollowed(buyer1,seller1.getId());
    }

    @Test
    public void testFollowSellerOk() throws Exception {
        Integer userId = 2;
        Integer userIdToFollow = 3;
        dummySetup();
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",userId,userIdToFollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.message").value("El usuario con id=2 ahora sigue al vendedor con id=3."));


    }

    @Test
    public void testFollowerListNotSortOk() throws Exception {
        Integer sellerId = 3;
        Integer followerId =1;
        dummySetup();

        mockMvc.perform(get("/users/{userId}/followers/list",sellerId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(sellerId))
                .andExpect(jsonPath("$.followers[0].user_id").value(followerId));



    }
    @Test
    public void followersCountTestOk() throws Exception{
        dummySetup();
        Integer userId = 3;
        this.mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").value(1));
    }

}
