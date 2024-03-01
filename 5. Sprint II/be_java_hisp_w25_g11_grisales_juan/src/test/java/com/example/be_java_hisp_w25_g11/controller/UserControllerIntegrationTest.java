package com.example.be_java_hisp_w25_g11.controller;

import com.example.be_java_hisp_w25_g11.dto.UserDTO;
import com.example.be_java_hisp_w25_g11.dto.response.FollowerCountDTO;
import com.example.be_java_hisp_w25_g11.dto.response.FollowerDTO;
import com.example.be_java_hisp_w25_g11.entity.Buyer;
import com.example.be_java_hisp_w25_g11.entity.Seller;
import com.example.be_java_hisp_w25_g11.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.ISellerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private IBuyerRepository buyerRepository;

    @Autowired
    private ISellerRepository sellerRepository;

    @BeforeEach
    public void repositoryReset() {
        buyerRepository.clearData();
        sellerRepository.clearData();
    }

    private void repositoryData(){
        Integer userId = 1;
        Integer userFollower1 = 2;
        Integer userFollower2 = 3;

        Seller sellerFollowed = new Seller(userId, "Federico", Set.of(userFollower1, userFollower2), Set.of(), Set.of());

        Seller sellerFollower = new Seller(userFollower1, "Estefania", Set.of(), Set.of(userId), Set.of());
        Buyer buyerFollower = new Buyer(userFollower2, "Juliana", Set.of(userId));

        sellerRepository.createAll(List.of(sellerFollowed, sellerFollower));
        buyerRepository.create(buyerFollower);
    }

    @Test
    public void followersCountTestOk() throws Exception{
        repositoryData();
        Integer userId = 1;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(2));
    }

    @Test
    public void followersListTestOk() throws Exception{
        repositoryData();

        Integer userId = 1;
        Integer followerId1 = 2;
        Integer followerId2 = 3;

        String order = "name_asc";

        Seller sellerFollowed = sellerRepository.get(userId).get();

        Seller sellerFollower1 = sellerRepository.get(followerId1).get();
        Buyer buyerFollower2 = buyerRepository.get(followerId2).get();

        FollowerDTO expectedList = new FollowerDTO(
                sellerFollowed.getId(),
                sellerFollowed.getName(),
                List.of(
                        new UserDTO(
                                sellerFollower1.getId(),
                                sellerFollower1.getName()
                        ),
                        new UserDTO(
                                buyerFollower2.getId(),
                                buyerFollower2.getName()
                        )
                )
        );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedJson = writer.writeValueAsString(expectedList);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedJson, result.getResponse().getContentAsString());
    }
}
