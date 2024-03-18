package grupo_7.sprint_1.integration;


import grupo_7.sprint_1.controller.SellerController;
import grupo_7.sprint_1.dtos.AddPostDto;
import grupo_7.sprint_1.dtos.PostDto;

import grupo_7.sprint_1.service.IBuyerService;
import grupo_7.sprint_1.service.ISellerService;
import grupo_7.sprint_1.utils.MockBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.Assert;


import static org.mockito.Mockito.when;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)

public class integrationtestseller {
    @Autowired
    MockMvc mockMvc;


    @Mock
    IBuyerService buyerService;

    @Mock
    ISellerService sellerService;

    @InjectMocks
    SellerController sellerController;
    @Test
    public void testGetValidCountOfFollowers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/sellers/users/{userId}/followers/count",1))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.userName").value("Seller_1"))
                .andExpect(jsonPath("$.followerCount").value(3));
    }
    @Test
    public void testGetValidFollowersList() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/sellers/users/{userid}/followers/list",1).param("order","name_asc"))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }
    @Test
    public void addPostTest() {
        AddPostDto newPost = MockBuilder.mockPostDto();
        PostDto expectedPost = MockBuilder.mockPostDtoResponse();

        when(sellerService.addPost(newPost.userId(), newPost)).thenReturn(expectedPost);

        ResponseEntity<?> responseEntity = sellerController.addPost(newPost);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals(expectedPost, responseEntity.getBody());
    }

    }


