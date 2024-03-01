package com.bootcamp.be_java_hisp_w25_g02.controller;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerCountDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerListDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w25_g02.entity.User;
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
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerIntegrationTest {
    private final ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    @Autowired
    MockMvc mockMvc;
    @Autowired
    @Lazy
    IUserRepository userRepository;


    @Test
    @DisplayName("IntegrationTest US-0001- Follow user -TestOK")
    @Order(1)
    void FollowUserOk() throws Exception {
        //arrange
        Integer userNoSeller = userRepository.saveUser(TestUtilGenerator.getUserWithoutFollowed());
        Integer userSeller = userRepository.saveUser(TestUtilGenerator.getUserToFollow());
        System.out.println(userSeller);
        System.out.println(userNoSeller);
        //act
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userNoSeller, userSeller))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    @DisplayName("IntegrationTest US-0002 - Get followers count - TestOK")
    @Order(2)
    void getFollowersCount() throws Exception {
        //arrange
        User userWithFollowers = TestUtilGenerator.getUserSeller();
        userWithFollowers.getFollowedBy().add(1);
        userWithFollowers.getFollowedBy().add(2);
        userWithFollowers.getFollowedBy().add(3);
        Integer userWithFollowersId = userRepository.saveUser(userWithFollowers);
        Long followersQuantity = 3L;
        FollowerCountDTO expectedResponse = new FollowerCountDTO(userWithFollowersId, userWithFollowers.getUserName(), followersQuantity);
        String expectedResponseString = writer.writeValueAsString(expectedResponse);
        //act
        MvcResult actualResponse = mockMvc.perform(get("/users/{userId}/followers/count", userWithFollowersId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        //assert
        assertEquals(expectedResponseString, actualResponse.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
    @Test
    @DisplayName("IntegrationTest US-0004- List of the users that follows a seller - TestOk")
    @Order(3)
    void getFollowersList() throws Exception {
        //arrange
        User userFollower = TestUtilGenerator.getUserWithoutFollowed();
        Integer userFollowerId = userRepository.saveUser(userFollower);
        User userFollower2 = TestUtilGenerator.getUserWithoutFollowed();
        userFollower2.setUserName("Andres");
        Integer userFollowerId2 = userRepository.saveUser(userFollower2);
        User userFollowed = TestUtilGenerator.getUserSeller();
        userFollowed.getFollowedBy().add(userFollowerId);
        userFollowed.getFollowedBy().add(userFollowerId2);
        Integer userFollowedId = userRepository.saveUser(userFollowed);
        String order = "name_asc";
        List<UserDTO> following = List.of(
                new UserDTO(userFollowerId2, userFollower2.getUserName()),
                new UserDTO(userFollowerId, userFollower.getUserName())
        );
        FollowerListDTO expectedResponse = new FollowerListDTO(userFollowedId, userFollowed.getUserName(), following);
        String expectedResponseString = writer.writeValueAsString(expectedResponse);
        //act
        MvcResult actualResponse = mockMvc.perform(
                        get("/user/{userId}/followers", userFollowedId)
                                .param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        //assert
        assertEquals(expectedResponseString, actualResponse.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
    @Test
    @DisplayName("IntegrationTest US-0007 - Unfollow a seller - TestOK")
    @Order(4)
    void unFollowUserOk() throws Exception {
        //arrange
        Integer userSellerId = userRepository.saveUser(TestUtilGenerator.getUserToFollow());
        User userNoSeller = TestUtilGenerator.getUserWithoutFollowed();
        userNoSeller.setFollowing(List.of(userSellerId));
        Integer userNoSellerId = userRepository.saveUser(TestUtilGenerator.getUserWithoutFollowed());
        System.out.println(userNoSellerId);
        System.out.println(userSellerId);
        //act
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userNoSellerId, userSellerId))
                .andDo(print())
                .andExpect(status().isOk());

    }


}
