package com.example.bootcampsprint1g6.integration;

import com.example.bootcampsprint1g6.dto.FollowedDTO;
import com.example.bootcampsprint1g6.dto.FollowersCountDTO;
import com.example.bootcampsprint1g6.dto.FollowersDTO;
import com.example.bootcampsprint1g6.dto.UserDTO;
import com.example.bootcampsprint1g6.util.TestUtilGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Follow - Success")
    public void followTestOk() throws Exception {
        Integer userWhoFollows = 1;
        Integer userToBeFollowed = 2;
        mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", userWhoFollows, userToBeFollowed))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Ok"));
    }

    @Test
    @DisplayName("Follow - Following yourself")
    public void followTestFollowingYourself() throws Exception {
        Integer userWhoFollows = 1;
        Integer userToBeFollowed = 1;
        mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", userWhoFollows, userToBeFollowed))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no se puede seguir así mismo ID: " + userToBeFollowed));
    }

    @Test
    @DisplayName("Follow - Following not existing user")
    public void followTestFollowingNotExistingUser() throws Exception {
        Integer userWhoFollows = 1;
        Integer userToBeFollowed = 999;
        mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", userWhoFollows, userToBeFollowed))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No existe el usuario con id: " + userToBeFollowed));
    }

    @Test
    @DisplayName("Follow - Following buyer")
    public void followTestFollowingBuyer() throws Exception {
        Integer userWhoFollows = 1;
        Integer userToBeFollowed = 4;
        mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", userWhoFollows, userToBeFollowed))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no se puede seguir porque no es un vendedor ID: " + userToBeFollowed));
    }

    @Test
    @DisplayName("Unfollow - Success")
    public void unfollowTestOk() throws Exception {
        Integer userWhoFollows = 1;
        Integer userToBeFollowed = 2;
        follow(userWhoFollows, userToBeFollowed);
        mockMvc.perform(post("/api/users/{userId}/unfollow/{userIdToFollow}", userWhoFollows, userToBeFollowed))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Ok"));
    }

    @Test
    @DisplayName("Unfollow - Unfollowing yourself")
    public void unfollowTestUnfollowingYourself() throws Exception {
        Integer userWhoFollows = 1;
        Integer userToBeFollowed = 1;
        mockMvc.perform(post("/api/users/{userId}/unfollow/{userIdToFollow}", userWhoFollows, userToBeFollowed))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no se puede dejar de seguir así mismo ID: " + userToBeFollowed));
    }

    @Test
    @DisplayName("Unfollow - Unfollowing not followed user")
    public void unfollowTestUnfollowingNotFollowedUser() throws Exception {
        Integer userWhoFollows = 6;
        Integer userToBeFollowed = 1;
        mockMvc.perform(post("/api/users/{userId}/unfollow/{userIdToFollow}", userWhoFollows, userToBeFollowed))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no está siguiendo al usuario con ID: " + userToBeFollowed));
    }

    @Test
    @DisplayName("Followed list - Success")
    public void getFollowedListTestOk() throws Exception {
        Integer userId = 1;
        String userName = "seller1";
        FollowedDTO expectedResponse = new FollowedDTO(userId, userName, new ArrayList<>());
        String expectedPayload = TestUtilGenerator.getJsonPayload(expectedResponse);

        MvcResult result = mockMvc.perform(get("/api/users/{userId}/followed/list", userId))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayload);
    }

    @Test
    @DisplayName("Followed list - Ascending order")
    public void getFollowedListTestAscendingOrder() throws Exception {
        Integer userId = 1;
        Integer followedId1 = 2;
        Integer followedId2 = 3;
        follow(userId, followedId1);
        follow(userId, followedId2);
        String userName = "seller1";
        FollowedDTO expectedResponse = new FollowedDTO(userId, userName, List.of(
                new UserDTO(followedId1, "seller2"),
                new UserDTO(followedId2, "seller3")
        ));
        String expectedPayload = TestUtilGenerator.getJsonPayload(expectedResponse);
        String order = "name_asc";

        MvcResult result = mockMvc.perform(get("/api/users/{userId}/followed/list?order={order}", userId, order))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayload);
    }

    @Test
    @DisplayName("Followed list - Descending order")
    public void getFollowedListTestDescendingOrder() throws Exception {
        Integer userId = 1;
        Integer followedId1 = 2;
        Integer followedId2 = 3;
        follow(userId, followedId1);
        follow(userId, followedId2);
        String userName = "seller1";
        FollowedDTO expectedResponse = new FollowedDTO(userId, userName, List.of(
                new UserDTO(followedId2, "seller3"),
                new UserDTO(followedId1, "seller2")
        ));
        String expectedPayload = TestUtilGenerator.getJsonPayload(expectedResponse);
        String order = "name_desc";

        MvcResult result = mockMvc.perform(get("/api/users/{userId}/followed/list?order={order}", userId, order))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayload);
    }

    @Test
    @DisplayName("Followed list - Default order")
    public void getFollowedListTestDefaultOrder() throws Exception {
        Integer userId = 6;
        Integer followedId1 = 1;
        Integer followedId2 = 2;
        Integer followedId3 = 3;
        follow(userId, followedId2);
        follow(userId, followedId1);
        follow(userId, followedId3);
        String userName = "buyer3";
        FollowedDTO expectedResponse = new FollowedDTO(userId, userName, List.of(
                new UserDTO(followedId2, "seller2"),
                new UserDTO(followedId1, "seller1"),
                new UserDTO(followedId3, "seller3")
        ));
        String expectedPayload = TestUtilGenerator.getJsonPayload(expectedResponse);

        MvcResult result = mockMvc.perform(get("/api/users/{userId}/followed/list", userId))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayload);
    }

    @Test
    @DisplayName("Followers list - Success")
    public void getFollowersListTestOk() throws Exception {
        Integer userId = 3;
        String userName = "seller3";
        FollowersDTO expectedResponse = new FollowersDTO(userId, userName, new ArrayList<>());
        String expectedPayload = TestUtilGenerator.getJsonPayload(expectedResponse);

        MvcResult result = mockMvc.perform(get("/api/users/{userId}/followers/list", userId))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayload);
    }

    @Test
    @DisplayName("Followers list - Ascending order")
    public void getFollowersListTestAscendingOrder() throws Exception {
        Integer userId = 3;
        Integer followerId1 = 1;
        Integer followerId2 = 2;
        follow(followerId1, userId);
        follow(followerId2, userId);
        String userName = "seller3";
        FollowersDTO expectedResponse = new FollowersDTO(userId, userName, List.of(
                new UserDTO(followerId1, "seller1"),
                new UserDTO(followerId2, "seller2")
        ));
        String expectedPayload = TestUtilGenerator.getJsonPayload(expectedResponse);
        String order = "name_asc";

        MvcResult result = mockMvc.perform(get("/api/users/{userId}/followers/list?order={order}", userId, order))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayload);
    }

    @Test
    @DisplayName("Followers list - Descending order")
    public void getFollowersListTestDescendingOrder() throws Exception {
        Integer userId = 3;
        Integer followerId1 = 1;
        Integer followerId2 = 2;
        follow(followerId1, userId);
        follow(followerId2, userId);
        String userName = "seller3";
        FollowersDTO expectedResponse = new FollowersDTO(userId, userName, List.of(
                new UserDTO(followerId2, "seller2"),
                new UserDTO(followerId1, "seller1")
        ));
        String expectedPayload = TestUtilGenerator.getJsonPayload(expectedResponse);
        String order = "name_desc";

        MvcResult result = mockMvc.perform(get("/api/users/{userId}/followers/list?order={order}", userId, order))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayload);
    }

    @Test
    @DisplayName("Followers list - Default order")
    public void getFollowersListTestDefaultOrder() throws Exception {
        Integer userId = 3;
        Integer followerId1 = 1;
        Integer followerId2 = 2;
        Integer followerId3 = 4;
        follow(followerId2, userId);
        follow(followerId1, userId);
        follow(followerId3, userId);
        String userName = "seller3";
        FollowersDTO expectedResponse = new FollowersDTO(userId, userName, List.of(
                new UserDTO(followerId2, "seller2"),
                new UserDTO(followerId1, "seller1"),
                new UserDTO(followerId3, "buyer1")
        ));
        String expectedPayload = TestUtilGenerator.getJsonPayload(expectedResponse);

        MvcResult result = mockMvc.perform(get("/api/users/{userId}/followers/list", userId))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayload);
    }

    @Test
    @DisplayName("Followers list - Followers of buyer")
    public void getFollowersListTestFollowersOfBuyer() throws Exception {
        Integer userId = 4;
        mockMvc.perform(get("/api/users/{userId}/followers/list", userId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El ID ingresado no corresponde a un vendedor, por favor verificarlo."));
    }

    @Test
    @DisplayName("Followers count - No Followers")
    public void getFollowersCountTestNoFollowers() throws Exception {
        Integer userId = 3;
        String userName = "seller3";
        FollowersCountDTO expectedResponse = new FollowersCountDTO(userId, userName, 0);
        String expectedPayload = TestUtilGenerator.getJsonPayload(expectedResponse);
        MvcResult result = mockMvc.perform(get("/api/users/{userId}/followers/count", userId))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayload);
    }

    @Test
    @DisplayName("Followers count - With Followers")
    public void getFollowersCountTestWithFollowers() throws Exception {
        Integer userId = 1;
        String userName = "seller1";
        FollowersCountDTO expectedResponse = new FollowersCountDTO(userId, userName, 2);
        String expectedPayload = TestUtilGenerator.getJsonPayload(expectedResponse);
        MvcResult result = mockMvc.perform(get("/api/users/{userId}/followers/count", userId))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8)).isEqualTo(expectedPayload);
    }

    @Test
    @DisplayName("Followers count - Followers of buyer")
    public void getFollowersCountTestFollowersOfBuyer() throws Exception {
        Integer userId = 4;
        mockMvc.perform(get("/api/users/{userId}/followers/count", userId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Los usuarios del tipo 'buyer' no tienen seguidores."));
    }

    private void follow(Integer userIdWhoFollows, Integer usertIdToBeFollowed) throws Exception {
        mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", userIdWhoFollows, usertIdToBeFollowed));
    }

}
