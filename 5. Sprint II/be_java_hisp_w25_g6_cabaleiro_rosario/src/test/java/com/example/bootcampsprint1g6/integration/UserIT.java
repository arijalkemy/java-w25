package com.example.bootcampsprint1g6.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserIT {
    @Autowired
    MockMvc mockMvc;

    // Follow user
    @Test
    @DisplayName("Follow user (IT) - Ok")
    public void followOk() throws Exception {
        this.mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", "1","2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Ok"));
    }
    @Test
    @DisplayName("Follow user (IT) - Error - Followed not a seller")
    public void followSellerError() throws Exception {
        this.mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", "1","5"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario no se puede seguir porque no es un vendedor ID: 5"));
    }

    @Test
    @DisplayName("Follow user (IT) - Error - Already Followed")
    public void followAlreadyFollowedError() throws Exception {
        this.mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", "4","1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario ya está siguiendo al vendedor con ID: 1"));
    }

    @Test
    @DisplayName("Follow user (IT) - Error - Auto-follow")
    public void followItselfError() throws Exception {
        this.mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", "1","1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario no se puede seguir así mismo ID: 1"));
    }
    // Unfollow user
    @Test
    @DisplayName("Unfollow user (IT) - Ok")
    public void unFollowOk() throws Exception {
        this.mockMvc.perform(post("/api/users/{userId}/unfollow/{userIdToFollow}", "4","1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Ok"));
    }
    @Test
    @DisplayName("Unfollow user (IT) - Error - Auto-follow")
    public void unfollowItselfError() throws Exception {
        this.mockMvc.perform(post("/api/users/{userId}/unfollow/{userIdToFollow}", "1","1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario no se puede dejar de seguir así mismo ID: 1"));
    }
    @Test
    @DisplayName("Unfollow user (IT) - Error - Not followed")
    public void unfollowNotFollowedfError() throws Exception {
        this.mockMvc.perform(post("/api/users/{userId}/unfollow/{userIdToFollow}", "5","3"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario no está siguiendo al usuario con ID: 3"));
    }

    //Get followed list
    @Test
    @DisplayName("Get followed list (IT) - Ok")
    public void getFollowedOk() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followed/list", "4"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(4))
                .andExpect(jsonPath("$.user_name").value("buyer1"))
                .andExpect(jsonPath("$.followed.length()").value(2));
    }
    @Test
    @DisplayName("Get followed list (IT) - User Error")
    public void getFollowedNoUserError() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followed/list", "12"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No existe el usuario con id: 12"));
    }
    @Test
    @DisplayName("Get followed list (IT) - Order Error")
    public void getFollowedOrderError() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followed/list?order={order}",1, "sdadsdfds"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("La variable 'order' enviada es inválida (sdadsdfds)."));
    }
    @Test
    @DisplayName("Get followed list asc order (IT) - Ok")
    public void getFollowedAscOk() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followed/list?order={order}",4, "name_asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followed[0].userName").value("seller1"))
                .andExpect(jsonPath("$.followed[1].userName").value("seller2"));
    }
    @Test
    @DisplayName("Get followed list desc order (IT) - Ok")
    public void getFollowedDescOk() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followed/list?order={order}",4, "name_desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followed[1].userName").value("seller1"))
                .andExpect(jsonPath("$.followed[0].userName").value("seller2"));
    }
    // get followers count
    @Test
    @DisplayName("Get followers count (IT) - Ok")
    public void getFollowersCountOk() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followers/count", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("seller1"))
                .andExpect(jsonPath("$.followers_count").value(2));
    }
    @Test
    @DisplayName("Get followers (IT) - Not a seller Error")
    public void getFollowersCountNoUserError() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followers/count", "4"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Los usuarios del tipo 'buyer' no tienen seguidores."));
    }
    @Test
    @DisplayName("Get followers count(IT) - Id not exists Error")
    public void getFollowersCountIdNotExistsError() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followers/count", "32"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No existe el usuario con id: 32"));
    }
    //get Followers list
    @Test
    @DisplayName("Get followers (IT) - Ok")
    public void getFollowersOk() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followers/list", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("seller1"))
                .andExpect(jsonPath("$.followers.length()").value(2));
    }
    @Test
    @DisplayName("Get followers (IT) - Not a seller Error")
    public void getFollowersNoUserError() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followers/list", "4"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El ID ingresado no corresponde a un vendedor, por favor verificarlo."));
    }
    @Test
    @DisplayName("Get followers (IT) - Id not exists Error")
    public void getFollowersIdNotExistsError() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followers/list", "32"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No existe el usuario con id: 32"));
    }
    @Test
    @DisplayName("Get followers list asc order (IT) - Ok")
    public void getFollowersAscOk() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followers/list?order={order}",1, "name_asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followers[0].userName").value("buyer1"))
                .andExpect(jsonPath("$.followers[1].userName").value("buyer2"));
    }
    @Test
    @DisplayName("Get followers list desc order (IT) - Ok")
    public void getFollowersDescOk() throws Exception {
        this.mockMvc.perform(get("/api/users/{userId}/followers/list?order={order}",1, "name_desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followers[1].userName").value("buyer1"))
                .andExpect(jsonPath("$.followers[0].userName").value("buyer2"));
    }
}
