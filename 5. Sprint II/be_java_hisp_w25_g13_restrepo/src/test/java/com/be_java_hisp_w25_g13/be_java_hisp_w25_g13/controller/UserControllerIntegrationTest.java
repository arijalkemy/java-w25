package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.controller;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.*;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IUserRepository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service.IPostService;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service.IUserService;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Constants;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Utilities;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    IUserService userService;
    @Autowired
    IPostService postService;
    @Autowired
    IUserRepository userRepository;

    @Test
    void followOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",10,29))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    void followUserNotFoundUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 50, 28))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_NOT_FOUND_ERROR_MESSAGE));
    }
    @Test
    void followUserNotFoundSeller() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 5, 280))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.SELLER_TO_FOLLOW_NOT_FOUND_ERROR_MESSAGE));
    }
    @Test
    void followUserBadRequestHimself() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 5, 5))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_FOLLOW_TO_HIMSELF_ERROR_MESSAGE));
    }
    @Test
    void followUserBadRequestUserFollowNotSeller() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 5, 8))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_IS_NOT_SELLER_ERROR_MESSAGE));
    }
    @Test
    void followUserBadRequestAlreadyFollowed() throws Exception {
        userService.followUser(5,25);
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 5, 25))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.ALREADY_FOLLOWED_SELLER_ERROR_MESSAGE));
    }
    @Test
    void unfollowOK() throws Exception {
        userService.followUser(10,27);
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",10,27))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    void unfollowUserNotFoundUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 50, 28))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_NOT_FOUND_ERROR_MESSAGE));
    }
    @Test
    void unfollowUserNotFoundSeller() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 5, 280))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.SELLER_NOT_FOUND_ERROR_MESSAGE));
    }
    @Test
    void unfollowUserNotFoundUserNotSeller() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 10, 9))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.USER_IS_NOT_SELLER_ERROR_MESSAGE));
    }
    @Test
    void unfollowUserBadRequestUserNotFollwedSeller() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 10, 28))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(Constants.NOT_FOLLOWED_SELLER_ERROR_MESSAGE));
    }

   @Test
    void getFollowersCountOK() throws Exception {
        User user1 =  Utilities.generateUser(5,"Emma Watson");
        Seller seller1 =  Utilities.generateSeller(28,"Leonardo DiCaprio", Utilities.generateListUsers());
        userService.followUser(user1.getUserId(),seller1.getUserId());

       MvcResult respose = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",28))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
               .andReturn();
       NumberDTO numberDTOExpected = new NumberDTO(seller1.getUserId(),seller1.getUserName(),1);
       Assertions.assertEquals(serializeNumberDTO(numberDTOExpected),(respose.getResponse().getContentAsString()));
    }
    private String serializeNumberDTO(NumberDTO numberDTO) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().registerModule(new JavaTimeModule()).writer();
        return ow.writeValueAsString(numberDTO);
    }
    @Test
    void getFollowersListOK() throws Exception {
        List<User> listUsers = Arrays.asList(Utilities.generateUser(7,"Clark Kent"),
                Utilities.generateUser(8,"Diana Prince"));
        List<UserDTO> listUserDTOExpected = new ArrayList<>();
        Seller seller1 =  Utilities.generateSeller(26,"Will Smith", Utilities.generateListUsers());
        for (User user: listUsers){
            userService.followUser(user.getUserId(),seller1.getUserId());
            listUserDTOExpected.add(Utilities.generateUserDTO(user.getUserId(),user.getUserName()));
        }

        MvcResult respose = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userID}/followers/list",26))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        FollowersDTO followersDTOExpected = new FollowersDTO(seller1.getUserId(),seller1.getUserName(),listUserDTOExpected);
        Assertions.assertEquals(serializeFollowersDTO(followersDTOExpected),(respose.getResponse().getContentAsString()));
    }
    private String serializeFollowersDTO(FollowersDTO followersDTO) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().registerModule(new JavaTimeModule()).writer();
        return ow.writeValueAsString(followersDTO);
    }

}
