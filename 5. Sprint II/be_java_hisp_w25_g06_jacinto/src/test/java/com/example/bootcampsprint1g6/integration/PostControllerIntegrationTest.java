package com.example.bootcampsprint1g6.integration;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.util.PostTestGenerator;
import com.example.bootcampsprint1g6.util.TestUtilGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

import static com.example.bootcampsprint1g6.util.DateFormatter.parseDateLocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private int postId = 0;

    @Test
    @DisplayName("Create post - Success")
    public void createPostTestOk() throws Exception {
        PostRequestDTO requestDTO = PostTestGenerator.getPostRequestDTO();
        String payloadJson = TestUtilGenerator.getJsonPayload(requestDTO);
        PostResponseDTO expectedResponse = PostTestGenerator.getPostResponseDTO(requestDTO, 0);
        String expectedPayloadJson = TestUtilGenerator.getJsonPayload(expectedResponse);

        MvcResult result = mockMvc.perform(post("/api/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson)
        ).andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString()).isEqualTo(expectedPayloadJson);
    }

    @Test
    @DisplayName("Create post - Invalid payload (null user_id)")
    public void createPostTestNullUserIdThrowsException() throws Exception {
        PostRequestDTO requestDTO = PostRequestDTO.builder()
                .date("28-02-2024")
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Camisa a rayas")
                        .type("Indumentaria")
                        .brand("Zara")
                        .color("Rojo")
                        .build()
                )
                .category(1)
                .price(30000.0)
                .build();
        String payloadJson = TestUtilGenerator.getJsonPayload(requestDTO);

        mockMvc.perform(post("/api/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson)
        ).andDo(print()).andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("El id no puede estar vacío."));
    }

    @Test
    @DisplayName("Create post - Invalid payload (invalid date format)")
    public void createPostTestInvalidDateFormatIdThrowsException() throws Exception {
        PostRequestDTO requestDTO = PostRequestDTO.builder()
                .userId(1)
                .date("Formato de fecha incorrecto")
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Camisa a rayas")
                        .type("Indumentaria")
                        .brand("Zara")
                        .color("Rojo")
                        .build()
                )
                .category(1)
                .price(30000.0)
                .build();
        String payloadJson = TestUtilGenerator.getJsonPayload(requestDTO);

        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Formato de fecha incorrecto"));
    }

    @Test
    @DisplayName("Create post - Invalid payload (invalid date value)")
    public void createPostTestInvalidDateValueIdThrowsException() throws Exception {
        PostRequestDTO requestDTO = PostRequestDTO.builder()
                .userId(1)
                .date("20-02-3048")
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Camisa a rayas")
                        .type("Indumentaria")
                        .brand("Zara")
                        .color("Rojo")
                        .build()
                )
                .category(1)
                .price(30000.0)
                .build();
        String payloadJson = TestUtilGenerator.getJsonPayload(requestDTO);

        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Datos incorrectos en la solicitud"));
    }

    @Test
    @DisplayName("Create post - Invalid payload (null product)")
    public void createPostTestNullProductIdThrowsException() throws Exception {
        PostRequestDTO requestDTO = PostRequestDTO.builder()
                .userId(1)
                .date("20-02-2024")
                .product(null)
                .category(1)
                .price(30000.0)
                .build();
        String payloadJson = TestUtilGenerator.getJsonPayload(requestDTO);

        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Atributos faltantes, por favor verifique la información enviada."));
    }

    @Test
    @DisplayName("Create post - Not existing user")
    public void createPostTestNotExistingUser() throws Exception {
        int notExistingUserId = 999;
        PostRequestDTO requestDTO = PostRequestDTO.builder()
                .userId(notExistingUserId)
                .date("28-02-2024")
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Camisa a rayas")
                        .type("Indumentaria")
                        .brand("Zara")
                        .color("Rojo")
                        .build()
                )
                .category(1)
                .price(30000.0)
                .build();
        String payloadJson = TestUtilGenerator.getJsonPayload(requestDTO);


        mockMvc.perform(post("/api/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson)
        ).andDo(print()).andExpect(status().isNotFound())
        .andExpect(jsonPath("$.message").value("No se puede crear el post ya que el usuario con id " + notExistingUserId + " no existe."));
    }

    @Test
    @DisplayName("Create post - Buyer creates post")
    public void createPostTestBuyer() throws Exception {
        int buyerId = 4;
        PostRequestDTO requestDTO = PostRequestDTO.builder()
                .userId(buyerId)
                .date("28-02-2024")
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Camisa a rayas")
                        .type("Indumentaria")
                        .brand("Zara")
                        .color("Rojo")
                        .build()
                )
                .category(1)
                .price(30000.0)
                .build();
        String payloadJson = TestUtilGenerator.getJsonPayload(requestDTO);


        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no es un vendedor. No se puede concretar la operación."));
    }

    @Test
    @DisplayName("Create post - Invalid payload format")
    public void createPostTestInvalidPayloadFormat() throws Exception {
        String payloadJson = "invalid payload format";

        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)
                ).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Error en el tipo de datos enviados"));
    }

    @Test
    @DisplayName("Create post - Metodo no soportado")
    public void createPostTestMethodNotSupported() throws Exception {
        mockMvc.perform(get("/api/products/post")).andDo(print()).andExpect(status().isMethodNotAllowed())
                .andExpect(jsonPath("$.message").value("Metodo no soportado"));
    }

    @Test
    @DisplayName("Get last posts by followed - Success")
    public void getLastPostsByFollowedTestOk() throws Exception {
        Integer followedUserId = 1;
        PostResponseDTO postResponse1 = createPost(followedUserId, 1);
        createPost(followedUserId, 30);
        PostResponseDTO postResponse2 = createPost(followedUserId, 1);
        Integer userId = 4;
        PostListDTO expectedResponse = PostListDTO.builder()
                .userId(userId)
                .posts(List.of(postResponse1, postResponse2))
                .build();
        String expectedPayloadJson = TestUtilGenerator.getJsonPayload(expectedResponse);

        MvcResult result = mockMvc.perform(get("/api/products/followed/{userId}/list", userId))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayloadJson);
    }

    @Test
    @DisplayName("Get last posts by followed - Descending order")
    public void getLastPostsByFollowedTestDescendingOrder() throws Exception {
        Integer followedUserId = 1;
        PostResponseDTO postResponse1 = createPost(followedUserId, 2);
        PostResponseDTO postResponse2 = createPost(followedUserId, 1);
        PostResponseDTO postResponse3 = createPost(followedUserId, 3);
        Integer userId = 4;
        PostListDTO expectedResponse = PostListDTO.builder()
                .userId(userId)
                .posts(List.of(postResponse2, postResponse1, postResponse3))
                .build();
        String expectedPayloadJson = TestUtilGenerator.getJsonPayload(expectedResponse);
        String order = "date_desc";

        MvcResult result = mockMvc.perform(get("/api/products/followed/{userId}/list?order={order}", userId, order))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayloadJson);
    }

    @Test
    @DisplayName("Get last posts by followed - Ascending order")
    public void getLastPostsByFollowedTestAscendingOrder() throws Exception {
        Integer followedUserId = 1;
        PostResponseDTO postResponse1 = createPost(followedUserId, 2);
        PostResponseDTO postResponse2 = createPost(followedUserId, 1);
        PostResponseDTO postResponse3 = createPost(followedUserId, 3);
        Integer userId = 4;
        PostListDTO expectedResponse = PostListDTO.builder()
                .userId(userId)
                .posts(List.of(postResponse3, postResponse1, postResponse2))
                .build();
        String expectedPayloadJson = TestUtilGenerator.getJsonPayload(expectedResponse);
        String order = "date_asc";

        MvcResult result = mockMvc.perform(get("/api/products/followed/{userId}/list?order={order}", userId, order))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayloadJson);
    }

    @Test
    @DisplayName("Get last posts by followed - Default order")
    public void getLastPostsByFollowedTestDefaultOrder() throws Exception {
        Integer followedUserId = 1;
        PostResponseDTO postResponse1 = createPost(followedUserId, 2);
        PostResponseDTO postResponse2 = createPost(followedUserId, 1);
        PostResponseDTO postResponse3 = createPost(followedUserId, 3);
        Integer userId = 4;
        PostListDTO expectedResponse = PostListDTO.builder()
                .userId(userId)
                .posts(List.of(postResponse2, postResponse1, postResponse3))
                .build();
        String expectedPayloadJson = TestUtilGenerator.getJsonPayload(expectedResponse);

        MvcResult result = mockMvc.perform(get("/api/products/followed/{userId}/list", userId))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayloadJson);
    }

    @Test
    @DisplayName("Get last posts by followed - Orden inválida")
    public void getLastPostsByFollowedTestInvalidOrder() throws Exception {
        Integer userId = 1;
        String invalidOrder = "invalidOrder";
        mockMvc.perform(get("/api/products/followed/{userId}/list?order={invalidOrder}", userId, invalidOrder))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El parámetro de ordenamiento no es correcto"));
    }

    @Test
    @DisplayName("Get last posts by followed - Tipo de dato inválido")
    public void getLastPostsByFollowedTestInvalidUserIdType() throws Exception {
        String invalidUserIdType = "Invalid userIdType";
        mockMvc.perform(get("/api/products/followed/{userId}/list", invalidUserIdType))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Error en el tipo de datos de los parámetros"));
    }

    @Test
    @DisplayName("Create post - Endpoint inexistente")
    public void createPostTestNotExistingEndpoint() throws Exception {
        String notExistingEndpoint = "/notExistingEndpoint";
        mockMvc.perform(get(notExistingEndpoint)).andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Endpoint inexistente"));
    }

    private PostResponseDTO createPost(Integer userId, int daysBeforeToday) throws Exception {
        LocalDate date = LocalDate.now().minusDays(daysBeforeToday);
        String dateString = parseDateLocalDate(date);
        PostRequestDTO requestDTO = PostTestGenerator.getPostRequestDTO(userId, dateString);
        String payloadJson = TestUtilGenerator.getJsonPayload(requestDTO);
        mockMvc.perform(post("/api/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson)
        );

        PostResponseDTO expectedResponse = PostTestGenerator.getPostResponseDTO(requestDTO, postId);
        this.postId += 1;
        return expectedResponse;
    }

}
