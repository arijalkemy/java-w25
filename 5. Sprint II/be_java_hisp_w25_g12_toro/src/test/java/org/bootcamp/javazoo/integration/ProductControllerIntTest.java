package org.bootcamp.javazoo.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.ProductDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.entity.Product;
import org.bootcamp.javazoo.helper.Mapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductControllerIntTest {
    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setUp() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        writer = mapper.writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("should return a list of posts of followed users")
    public void shouldReturnAListOfPostsOfFollowedUsers() throws Exception {
        // arrange
        Integer sellerId = 1;
        Integer userId = 4;
        Product product1 = new Product(1, "Laptop", "Electronics", "BrandX", "Silver", "Buen estado");
        Product product2 = new Product(2, "Smartphone", "Electronics", "BrandY", "Negro", "Usado");

        PostResponseDto post1 = Mapper.mapToPostDto(new Post(1, LocalDate.now(), product1, 1, 500.0), sellerId);
        PostResponseDto post2 = Mapper.mapToPostDto(new Post(2, LocalDate.now().minusDays(5), product2, 2, 300.0), sellerId);

        List<PostResponseDto> postsDto = new ArrayList<>(List.of(post1, post2));

        PostsFollowedUserDto expectedAnswer = Mapper.mapToPostsFollowedUserDto(postsDto, userId);

        // act and assert
        this.mockMvc.perform(get("/products/followed/{userId}/list", "4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.userId").value(expectedAnswer.getUserId()))
                .andExpect(jsonPath("$.posts.size()").value(expectedAnswer.getPosts().size()));
    }

    @Test
    @DisplayName("Should exception because user does not follow any seller")
    public void shouldReturnExceptionNotFollowAnySeller() throws Exception {
        // arrange
        Integer userId = 5;

        // act and assert
        this.mockMvc.perform(get("/products/followed/{userId}/list", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("the user does not follow any seller"));
    }

    @Test
    @DisplayName("Add new post successfully")
    public void addNewPostSuccessfully() throws Exception {
        // arrange
        Integer sellerId = 2;
        ProductDto productDto = new ProductDto(1, "Laptop", "Electronics", "BrandX", "Silver", "Buen estado");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");;
        String date = LocalDate.now().format(formatter);
        PostDto postDto = new PostDto(sellerId, date, productDto, 12, 500.0);

        // act and assert
        mockMvc.perform(post("/products/post")
                .contentType("application/json")
                .content(writer.writeValueAsString(postDto))
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("The publication was created successfully"));
    }

    @Test
    @DisplayName("Should exception because seller does not exists")
    public void shouldReturnExceptionSellerDoesNotExists() throws Exception {
        // arrange
        Integer sellerId = 9;
        ProductDto productDto = new ProductDto(1, "Laptop", "Electronics", "BrandX", "Silver", "Buen estado");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");;
        String date = LocalDate.now().format(formatter);
        PostDto postDto = new PostDto(sellerId, date, productDto, 12, 500.0);

        // act and assert
        mockMvc.perform(post("/products/post")
                .contentType("application/json")
                .content(writer.writeValueAsString(postDto))
        )
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Seller not found"));
    }

}
