package com.example.be_java_hisp_w25_g11.integration;

import com.example.be_java_hisp_w25_g11.dto.ExceptionDTO;
import com.example.be_java_hisp_w25_g11.dto.response.SuccessDTO;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserIntegrationTest {
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
    void testFollowOk() throws Exception {
        // Arrange
        int idThatFollows = 3;
        int idToFollow = 6;
        SuccessDTO expectedDTO = new SuccessDTO(
            "El usuario con id="+idThatFollows+" ahora sigue al vendedor con id="+idToFollow+"."
        );
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        // Act & Assert
        this.mockMvc.perform(post("/users/" + idThatFollows + "/follow/"+idToFollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testFollowWhenAlreadyFollowed() throws Exception {
        // Arrange
        int idThatFollows = 1;
        int idToFollow = 6;
        ExceptionDTO expectedDTO = new ExceptionDTO(
            "El comprador con id="+idThatFollows+" ya sigue al vendedor con id="+idToFollow+"."
        );
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        // Act & Assert
        this.mockMvc.perform(post("/users/"+idThatFollows+"/follow/"+idToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testFollowNotExists() throws Exception {
        // Arrange
        int idThatFollows = 1;
        int idToFollow = 0;
        ExceptionDTO expectedDTO = new ExceptionDTO("El usuario con id="+idToFollow+" no existe.");
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        // Act & Assert
        this.mockMvc.perform(post("/users/"+idThatFollows+"/follow/"+idToFollow))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testFollowSelf() throws Exception {
        // Arrange
        int idThatFollows = 1;
        int idToFollow = 1;
        ExceptionDTO expectedDTO = new ExceptionDTO("El usuario no se puede seguir a si mismo.");
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        // Act & Assert
        this.mockMvc.perform(post("/users/"+idThatFollows+"/follow/"+idToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testFollowersCountOk() throws Exception {
        // Arrange
        int userId = 6;
        int expectedCount = 2;

        // Act & Assert
        this.mockMvc.perform(get("/users/"+userId+"/followers/count"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.followers_count").value(expectedCount))
                .andExpect(jsonPath("$.user_id").value(userId));
    }

    @Test
    void testFollowersCountNotFound() throws Exception {
        ExceptionDTO expectedDTO = new ExceptionDTO("El vendedor con id=0 no existe.");
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        this.mockMvc.perform(get("/users/0/followers/count"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testFollowersCountInvalid() throws Exception {
        // Arrange
        int userId = 1;
        ExceptionDTO expectedDTO = new ExceptionDTO("Un comprador no puede tener seguidores.");
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        this.mockMvc.perform(get("/users/"+userId+"/followers/count"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testFollowersListOkEmpty() throws Exception {
        // Arrange
        int userId = 10;

        // Act & Assert
        this.mockMvc.perform(get("/users/"+userId+"/followers/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.followers").isEmpty());
    }

    @Test
    void testFollowersListInvalidOrder() throws Exception {
        // Arrange
        int userId = 10;
        String order = "empanada";
        ExceptionDTO expectedDTO = new ExceptionDTO("Argumento invalido (order debe ser NAME_ASC o NAME_DESC)");
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        // Act & Assert
        this.mockMvc.perform(get("/users/"+userId+"/followers/list?order="+order))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testFollowedListOkEmpty() throws Exception {
        // Arrange
        int userId = 10;

        // Act & Assert
        this.mockMvc.perform(get("/users/"+userId+"/followed/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.followed").isEmpty());
    }

    @Test
    void testFollowedListInvalidOrder() throws Exception {
        // Arrange
        int userId = 10;
        String order = "empanada";
        ExceptionDTO expectedDTO = new ExceptionDTO("Argumento invalido (order debe ser NAME_ASC o NAME_DESC)");
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        // Act & Assert
        this.mockMvc.perform(get("/users/"+userId+"/followed/list?order="+order))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testUnfollowOk() throws Exception {
        // Arrange
        int idThatUnfollows = 3;
        int idToUnfollow = 8;
        SuccessDTO expectedDTO = new SuccessDTO(
                "El usuario con id="+idThatUnfollows+" ha dejado de seguir al vendedor con id="+idToUnfollow+"."
        );
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        // Act & Assert
        this.mockMvc.perform(post("/users/" + idThatUnfollows + "/unfollow/"+idToUnfollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testUnfollowWhenNotFollow() throws Exception {
        // Arrange
        int idThatUnfollows = 3;
        int idToUnfollow = 6;
        ExceptionDTO expectedDTO = new ExceptionDTO(
                "El comprador con id="+idThatUnfollows+" no sigue al vendedor con id="+idToUnfollow+"."
        );
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        // Act & Assert
        this.mockMvc.perform(post("/users/"+idThatUnfollows+"/unfollow/"+idToUnfollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testUnfollowNotExists() throws Exception {
        // Arrange
        int idThatUnfollows = 1;
        int idToUnfollow = 0;
        ExceptionDTO expectedDTO = new ExceptionDTO("El usuario con id="+idToUnfollow+" no existe.");
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        // Act & Assert
        this.mockMvc.perform(post("/users/"+idThatUnfollows+"/unfollow/"+idToUnfollow))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }

    @Test
    void testUnfollowBuyer() throws Exception {
        // Arrange
        int idThatUnFollows = 1;
        int idToUnfollow = 3;
        ExceptionDTO expectedDTO = new ExceptionDTO("El usuario a dejar de seguir debe ser un vendedor.");
        String expectedResponse = writer.writeValueAsString(expectedDTO);

        // Act & Assert
        this.mockMvc.perform(post("/users/"+idThatUnFollows+"/unfollow/"+idToUnfollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expectedResponse));
    }
}