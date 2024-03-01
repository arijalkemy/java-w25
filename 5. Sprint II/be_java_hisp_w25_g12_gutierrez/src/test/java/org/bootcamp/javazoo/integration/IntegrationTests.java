package org.bootcamp.javazoo.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.ProductDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void getFollowersListITest() throws Exception {
        int userId = 1;
        mockMvc.perform(get("/users/" + userId + "/followers/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").isString())
                .andExpect(jsonPath("$.followers").isArray());
    }

    @Test
    public void getFollowersCountITest() throws Exception {
        int userId = 1;
        mockMvc.perform(get("/users/" + userId + "/followers/count")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").isString())
                .andExpect(jsonPath("$.followers_count").isNumber());

    }

    @Test
    public void getFollowedListITest() throws Exception {
        int userId = 6;
        mockMvc.perform(get("/users/" + userId + "/followed/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").isString())
                .andExpect(jsonPath("$.followers").isArray());
    }

    @Test
    public void addFollowSellerITest() throws Exception {
        int userId = 6;
        int sellerId = 1;

        mockMvc.perform(post("/users/" + userId + "/follow/" + sellerId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Ok"));
    }

    @Test
    public void addFollowSellerITestNotOk() throws Exception {
        int userId = 1;
        int sellerId = 1;

        mockMvc.perform(post("/users/" + userId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("A user cannot follow themselves."));
    }

    @Test
    public void addFollowSellerITestNotOkAlreadyFollowing() throws Exception {
        int userId = 4;
        int sellerId = 1;

        mockMvc.perform(post("/users/" + userId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The user is already following the seller."));
    }

    @Test
    public void unfollowSellerITest() throws Exception {
        int userId = 4;
        int sellerId = 1;

        mockMvc.perform(post("/users/" + userId + "/unfollow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("You stopped following the seller"));
    }

    @Test
    public void unfollowSellerITestNotOk() throws Exception {
        int userId = 1;
        int sellerId = 4;

        mockMvc.perform(post("/users/" + userId + "/unfollow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getPostBySellerOfUserITest() throws Exception {
        int userId = 4;

        mockMvc.perform(get("/products/followed/" + userId + "/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void getPostBySellerOfUserITestNull() throws Exception {
        int userId = 7;

        mockMvc.perform(get("/products/followed/" + userId + "/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(7))
                .andExpect(jsonPath("$.posts").isArray())
                .andExpect(jsonPath("$.posts").isEmpty());
    }

    @Test
    public void getPostBySellerOfUserITestNotOk() throws Exception {
        int userId = 6;

        mockMvc.perform(get("/products/followed/" + userId + "/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("the user does not follow any seller"));
    }

    @Test
    public void addNewPostITest() throws Exception {
        ProductDto product = new ProductDto(1, "Laptop", "Electronics", "BrandX", "Silver", "Buen estado");
        PostDto postDto = new PostDto(1, "27-02-2024", product, 1, 500.0);
        String postDtoJson = objectMapper.writeValueAsString(postDto);

        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postDtoJson))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The publication was created successfully"));
    }
}
