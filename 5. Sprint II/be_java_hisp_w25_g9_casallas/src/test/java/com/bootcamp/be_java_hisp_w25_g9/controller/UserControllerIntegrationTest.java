package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.UserDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowersDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    static void setup(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void followUserOk() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,30)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Vendedor seguido con éxito"));
    }

    @Test
    void followUserErrorAlreadyFollowed() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,29)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("No se puede seguir a un vendedor que ya se esta siguiendo"));
    }

    @Test
    void followUserErrorYourself() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no puede seguirse a sí mismo"));
    }

    @Test
    void followUserErrorNotFoundClient() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 100,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El cliente no existe"));
    }

    @Test
    void followUserErrorNotFoundSeller() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,100)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El vendedor no existe"));
    }

    @Test
    void followUserErrorFollowOtherClient() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Solo puede seguir vendedores"));
    }

    @Test
    void unfollowUserOk() throws Exception {

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", 1,30)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("El vendedor ha sido quitado de la lista de seguidos del cliente"));
    }

    @Test
    void unfollowUserErrorAlreadyFollowed() throws Exception {

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", 1,35)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El vendedor no estaba en la lista de seguidos del cliente"));
    }

    @Test
    void unfollowUserErrorYourself() throws Exception {

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", 1,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no puede dejar de seguirse a sí mismo"));
    }

    @Test
    void unfollowUserErrorNotFoundClient() throws Exception {

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", 100,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El cliente no existe"));
    }

    @Test
    void unfollowUserErrorNotFoundSeller() throws Exception {

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", 1,100)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El vendedor no existe"));
    }

    @Test
    void countFollowers() throws Exception {
        FollowersCountDto followersCountDto = new FollowersCountDto(29, "Josiah Sanchez", 1);
        String expected = writer.writeValueAsString(followersCountDto);
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/count", 29)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void countFollowersNotFound() throws Exception {

        mockMvc.perform(get("/users/{userId}/followers/count", 31)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Vendedor no encontrado"));
    }

    @Test
    void getFollowersListOk() throws Exception {

        List<UserDto> list = List.of(new UserDto(1, "Quynn Nunez"));
        FollowersDto followersDto = new FollowersDto(29,
                "Josiah Sanchez", list);
        String expected = writer.writeValueAsString(followersDto);

        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list", 29)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowersListOrderByNameAscOk() throws Exception {

        String order = "name_asc";
        List<UserDto> list = List.of(new UserDto(1, "Quynn Nunez"));
        FollowersDto followersDto = new FollowersDto(29,
                "Josiah Sanchez", list);
        String expected = writer.writeValueAsString(followersDto);

        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list", 29)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowersListOrderByNameDesOk() throws Exception {

        String order = "name_desc";
        List<UserDto> list = List.of(new UserDto(1, "Quynn Nunez"));
        FollowersDto followersDto = new FollowersDto(29,
                "Josiah Sanchez", list);
        String expected = writer.writeValueAsString(followersDto);

        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list", 29)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowersListOrderByNameError() throws Exception {

        String order = "name";
        mockMvc.perform(get("/users/{userId}/followers/list", 2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El orden ingresado " + order + " no es válido"));
    }

    @Test
    void getFollowersListNotUserFound() throws Exception {

        mockMvc.perform(get("/users/{userId}/followers/list", 500)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El vendedor no fue encontrado"));
    }

    @Test
    void getFollowersListNotSeller() throws Exception {

        mockMvc.perform(get("/users/{userId}/followers/list", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no es un vendedor"));
    }

    @Test
    void getFollowersListEmpty() throws Exception {

        mockMvc.perform(get("/users/{userId}/followers/list", 31)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El vendedor no tiene seguidores"));
    }

    @Test
    void getFollowedListOk() throws Exception {

        List<UserDto> list = List.of(new UserDto(26, "Chase Sanchez"));
        FollowedDto followedDto = new FollowedDto(2,
                "Zena Pastor", list);
        String expected = writer.writeValueAsString(followedDto);

        MvcResult result = mockMvc.perform(get("/users/{userId}/followed/list", 2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowedListOrderByNameAscOk() throws Exception {

        String order = "name_asc";
        List<UserDto> list = List.of(new UserDto(26, "Chase Sanchez"));
        FollowedDto followedDto = new FollowedDto(2,
                "Zena Pastor", list);
        String expected = writer.writeValueAsString(followedDto);

        MvcResult result = mockMvc.perform(get("/users/{userId}/followed/list", 2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowedListOrderByNameDesOk() throws Exception {

        String order = "name_desc";
        List<UserDto> list = List.of(new UserDto(26, "Chase Sanchez"));
        FollowedDto followedDto = new FollowedDto(2,
                "Zena Pastor", list);
        String expected = writer.writeValueAsString(followedDto);

        MvcResult result = mockMvc.perform(get("/users/{userId}/followed/list", 2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowedListOrderByNameError() throws Exception {

        String order = "name";
        mockMvc.perform(get("/users/{userId}/followed/list", 2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El orden ingresado " + order + " no es válido"));
    }

    @Test
    void getFollowedListNotUserFound() throws Exception {

        mockMvc.perform(get("/users/{userId}/followed/list", 500)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Usuario no encontrado"));
    }

    @Test
    void getFollowedListEmpty() throws Exception {

        mockMvc.perform(get("/users/{userId}/followed/list", 4)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El usuario no esta siguiendo a ningún vendedor"));
    }
}