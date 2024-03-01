package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.integration.postControllerIntegration;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.ProductDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.SellerPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.PostRepositoryImpl;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.ProductRepositoryImpl;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.UserRepositoryImpl;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Utilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestPostController {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepositoryImpl userRepository;
    @Autowired
    PostRepositoryImpl postRepository;
    @Autowired
    ProductRepositoryImpl productRepository;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void setUpEach(){
        productRepository.cleanData();
        postRepository.cleanData();
        userRepository.cleanData();
        productRepository.addProduct(
                Utilities.generateProduct(1, "Arepa")
        );
        productRepository.addProduct(
                Utilities.generateProduct(2, "Papas")
        );
        productRepository.addProduct(
                Utilities.generateProduct(3, "Pan")
        );

        userRepository.getUserById(1).get().getFollowing().add(
                (Seller) userRepository.getUserById(21).get()
        );

        postRepository.addPost(
                Utilities.generatePost(21, 0, LocalDate.parse("2024-02-19"), 1, "Arepa")
        );
        postRepository.addPost(
                Utilities.generatePost(21, 1, LocalDate.parse("2024-02-26"), 2, "Papas")
        );

        postRepository.addPost(
                Utilities.generatePost(21, 2, LocalDate.parse("2024-02-01"), 3, "Pan")
        );

        postRepository.addPost(
                Utilities.generatePost(21, 3, LocalDate.parse("2024-02-28"), 4, "Azucar")
        );
    }


    @Test
    public void getProductsOk() throws Exception{
        List<ProductDTO> expectedProducs = List.of(
                Utilities.generateProductDto(1, "Arepa"),
                Utilities.generateProductDto(2, "Papas"),
                Utilities.generateProductDto(3, "Pan"));

        String expectedProducsJson = writer.writeValueAsString(expectedProducs);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedProducsJson));
    }

    @Test
    public void createPostOk() throws Exception{
        PostDTO postDTO = Utilities.generatePostDto(21, 5, LocalDate.parse("2024-02-18"), 100, "Arepa");
        String postDtoJson = writer.writeValueAsString(postDTO);
        System.out.println(postDtoJson);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(postDtoJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(postDtoJson));
        postRepository.deleteById(5);
        productRepository.deleteById(100);
    }

    @Test
    public void createPostNotSeller() throws Exception{
        PostDTO postDTO = Utilities.generatePostDto(1, 1, LocalDate.parse("2024-02-18"), 150, "Arepa");
        String postDtoJson = writer.writeValueAsString(postDTO);
        System.out.println(postDtoJson);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(postDtoJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El id del usuario no corresponde a un vendedor"));

    }

    @Test
    public void createPostProductAlreadyPresent() throws Exception{
        PostDTO postDTO = Utilities.generatePostDto(21, 1, LocalDate.parse("2024-02-18"), 1, "Arepa");
        String postDtoJson = writer.writeValueAsString(postDTO);
        System.out.println(postDtoJson);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(postDtoJson))
                .andExpect(status().isConflict())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Ya existe un post para este producto"));

    }

    @Test
    public void getPostPerFollowedOk() throws Exception{
        SellerPostDTO sellerPostDTO = Utilities.generateSellerPostDto(1);
        String postSellerPostDTO = writer.writeValueAsString(sellerPostDTO);
        System.out.println(postSellerPostDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(postSellerPostDTO));
    }

    @Test
    public void getPostPerFollowedAscOk() throws Exception{
        SellerPostDTO sellerPostDTO = Utilities.generateSellerPostDtoAsc(1);
        String postSellerPostDTO = writer.writeValueAsString(sellerPostDTO);
        System.out.println(postSellerPostDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1).queryParam("order","date_asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(postSellerPostDTO));
    }

    @Test
    public void getPostPerFollowedDescOk() throws Exception{
        SellerPostDTO sellerPostDTO = Utilities.generateSellerPostDtoDesc(1);
        String postSellerPostDTO = writer.writeValueAsString(sellerPostDTO);
        System.out.println(postSellerPostDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1).queryParam("order","date_desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(postSellerPostDTO));
    }

    @Test
    public void getPostPerFollowedInvalid() throws Exception{
        SellerPostDTO sellerPostDTO = Utilities.generateSellerPostDto(1);
        String postSellerPostDTO = writer.writeValueAsString(sellerPostDTO);
        System.out.println(postSellerPostDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1).queryParam("order","a"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El metodo de ordenamiento debe estar entre date_asc, date_desc o no tener ninguno"));

    }

}
