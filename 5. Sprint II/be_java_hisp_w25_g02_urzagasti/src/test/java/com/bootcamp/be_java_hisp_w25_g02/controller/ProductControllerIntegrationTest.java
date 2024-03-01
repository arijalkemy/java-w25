package com.bootcamp.be_java_hisp_w25_g02.controller;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowingPostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.GenericResponseDTO;
import com.bootcamp.be_java_hisp_w25_g02.entity.Post;
import com.bootcamp.be_java_hisp_w25_g02.entity.User;
import com.bootcamp.be_java_hisp_w25_g02.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w25_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w25_g02.util.TestUtilGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductControllerIntegrationTest {
    private final ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    @Autowired
    MockMvc mockMvc;
    @Autowired
    IPostRepository postRepository;
    @Autowired
    IUserRepository userRepository;

    @Test
    @DisplayName("IntegrationTest US-0005- Create a post - TestOK")
    @Order(1)
    void createPostOK() throws Exception {
        //arrange
        Integer userSellerId = userRepository.saveUser(TestUtilGenerator.getUserToFollow());
        PostDTO postToBeCreated = TestUtilGenerator.getPostWithUserID(userSellerId);
        //act
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postToBeCreated)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    @DisplayName("IntegrationTest US-0005- Create a post for the first time (user becomes seller) - TestOK")
    @Order(2)
    void createPostFirstTimeOK() throws Exception {
        //arrange
        Integer userSellerId = userRepository.saveUser(TestUtilGenerator.getUserWithoutFollowed());
        PostDTO postToBeCreated = TestUtilGenerator.getPostWithUserID(userSellerId, 124151);

        //act
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postToBeCreated)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());
        //assert
        assertTrue(userRepository.findById(userSellerId).get().getSeller());
    }

    @Test
    @DisplayName("IntegrationTest US-0005- Create post but the userId doesnt exist - BadRequest")
    @Order(3)
    void createPostUserDoesntExistsTest() throws Exception {
        //arrange
        Integer userNoExistentId = 120;
        while (userRepository.findById(userNoExistentId).isPresent()) {
            userNoExistentId++;
        }
        PostDTO postToBeCreated = TestUtilGenerator.getPostWithUserID(userNoExistentId);
        GenericResponseDTO expectedResponse = new GenericResponseDTO("El usuario no existe");
        String expectedResponseString = writer.writeValueAsString(expectedResponse);
        //act
        MvcResult actualResponse = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postToBeCreated)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();
        //assert
        assertEquals(expectedResponseString, actualResponse.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("IntegrationTest US-0005- Create Post with non positive userId - BadRequest")
    @Order(4)
    void createPostWithUserId0() throws Exception {
        //arrange
        Integer userId0 = 0;
        PostDTO postToBeCreated = TestUtilGenerator.getPostWithUserID(userId0);
        GenericResponseDTO expectedResponse = new GenericResponseDTO("El id de usuario debe ser mayor a 0");
        String expectedResponseString = writer.writeValueAsString(expectedResponse);
        //act
        MvcResult actualResponse = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postToBeCreated)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();
        //assert
        assertEquals(expectedResponseString, actualResponse.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("IntegrationTest US-0005- Create post without post (null)")
    @Order(5)
    void createPostWithoutAPost() throws Exception {
        //arrange
        PostDTO postToBeCreated = null;
        //act
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postToBeCreated)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();
    }


    @Test
    @DisplayName("IntegrationTest US-0006- Lists of post order date_ asc - TestOk")
    @Order(6)
    void getFollowedPostsTestOk() throws Exception {
        //arrange
        Integer userSellerId = userRepository.saveUser(TestUtilGenerator.getUserToFollow());
        User userSeller = TestUtilGenerator.getUserToFollow();
        userSeller.setUserId(userSellerId);
        User userNoSeller = TestUtilGenerator.getUserWithoutFollowed();
        userNoSeller.setFollowing(List.of(userSellerId));
        userRepository.saveUser(userNoSeller);
        List<Post> posts = TestUtilGenerator.getPostsOfUserDisordered(userSellerId);
        postRepository.savePost(posts.get(0));
        postRepository.savePost(posts.get(1));
        postRepository.savePost(posts.get(2));
        FollowingPostDTO expectedResponse = new FollowingPostDTO(
                userNoSeller.getUserId(),
                TestUtilGenerator.getPostsDTOOrderByDateAsc(userSellerId)
        );
        String expectedResponseString = writer.writeValueAsString(expectedResponse);
        //act
        MvcResult mvcResult = mockMvc
                .perform(get("/products/followed/{userId}/list", userNoSeller.getUserId())
                        .param("order", "date_asc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
        //assert
        assertEquals(expectedResponseString, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("IntegrationTest US-0006- List of post with non postive userId on path - BadRequest")
    @Order(7)
    void getFollowedPostsTestUserIdNotPositive() throws Exception {
        //arrange
        Integer idNoPositivo = 0;
        Set<GenericResponseDTO> expectedResponse = Set.of(
                new GenericResponseDTO("El Id de usuario debe ser un numero positivo")
        );
        String expectedResponseString = writer.writeValueAsString(expectedResponse);
        //act
        MvcResult actualResponse = mockMvc
                .perform(get("/products/followed/{userId}/list", idNoPositivo)
                        .param("order", "date_asc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();
        //assert
        assertEquals(expectedResponseString, actualResponse.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("IntegrationTest US-0006- List of post order date_asc")
    @Order(8)
    void getFollowedPostsDescTestOk() throws Exception {
        //arrange
        Integer userSellerId = userRepository.saveUser(TestUtilGenerator.getUserToFollow());
        User userSeller = TestUtilGenerator.getUserToFollow();
        userSeller.setUserId(userSellerId);
        User userNoSeller = TestUtilGenerator.getUserWithoutFollowed();
        userNoSeller.setFollowing(List.of(userSellerId));
        userRepository.saveUser(userNoSeller);
        List<Post> posts = TestUtilGenerator.getPostsOfUserDisordered(userSellerId);
        postRepository.savePost(posts.get(0));
        postRepository.savePost(posts.get(1));
        postRepository.savePost(posts.get(2));
        FollowingPostDTO expectedResponse = new FollowingPostDTO(
                userNoSeller.getUserId(),
                TestUtilGenerator.getPostsDTOOrderByDateDesc(userSellerId)
        );
        String expectedResponseString = writer.writeValueAsString(expectedResponse);
        //act
        MvcResult mvcResult = mockMvc
                .perform(get("/products/followed/{userId}/list", userNoSeller.getUserId())
                        .param("order", "date_desc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
        //assert
        assertEquals(expectedResponseString, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("IntegrationTest US-0006- List of posts but there are not posts of the last two weeks- NotFound")
    @Order(9)
    void getFollowedPostNoContentTest() throws Exception {
        //arrange
        Integer userSellerId = userRepository.saveUser(TestUtilGenerator.getUserToFollow());
        User userSellerWithoutPosts = TestUtilGenerator.getUserToFollow();
        userSellerWithoutPosts.setUserId(userSellerId);

        User userNoSeller = TestUtilGenerator.getUserWithoutFollowed();
        userNoSeller.setFollowing(List.of(userSellerId));
        userRepository.saveUser(userNoSeller);
        GenericResponseDTO expectedResponse = new GenericResponseDTO("No hay post de los usuarios seguidos en las ultimas 2 semanas");
        String expectedResponseString = writer.writeValueAsString(expectedResponse);
        //act
        MvcResult actualResponse = mockMvc
                .perform(get("/products/followed/{userId}/list", userNoSeller.getUserId())
                        .param("order", "date_desc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andReturn();
        //assert
        assertEquals(expectedResponseString, actualResponse.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("IntegrationTest US-0006- Lists of posts but user does'nt exists -BadRequest")
    @Order(10)
    void getFollowedPostsUserDoesntExists() throws Exception {
        //arrange
        Integer userIdNonExistent = 120;
        while (userRepository.findById(userIdNonExistent).isPresent()) {
            userIdNonExistent++;
        }
        GenericResponseDTO expectedResponse = new GenericResponseDTO("El usuario no existe");
        String expectedResponseString = writer.writeValueAsString(expectedResponse);
        //act
        MvcResult actualResponse = mockMvc
                .perform(get("/products/followed/{userId}/list", userIdNonExistent)
                        .param("order", "date_desc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andReturn();
        //assert
        assertEquals(expectedResponseString, actualResponse.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}
