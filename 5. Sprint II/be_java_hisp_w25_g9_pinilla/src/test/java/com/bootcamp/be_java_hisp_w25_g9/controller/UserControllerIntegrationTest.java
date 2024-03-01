package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.UserDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowersDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter objectWriter;
    private static final String FOLLOW_URL = "/users/{userId}/follow/{userIdToFollow}";
    private static final String UNFOLLOW_URL = "/users/{userId}/unfollow/{userIdToFollow}";
    private static final String FOLLOWERS_COUNT_URL = "/users/{userId}/followers/count";
    private static final String FOLLOWERS_LIST_URL = "/users/{userId}/followers/list";
    private static final String FOLLOWED_LIST_URL = "/users/{userId}/followed/list";

    @BeforeAll
    public static void setUp(){
        objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    void followUserOk() throws Exception{
        int userId = 1;
        int userToFollow = 26;

        MessageDto dto = new MessageDto("Vendedor seguido con éxito");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(post(FOLLOW_URL, userId, userToFollow))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    void followUserHimself() throws Exception{
        int userId = 1;

        MessageDto dto = new MessageDto("El usuario no puede seguirse a sí mismo");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(post(FOLLOW_URL, userId, userId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
    }

    @Test
    void followUserNotSeller() throws Exception{
        int userId = 1;
        int userToFollow = 2;

        MessageDto dto = new MessageDto("Solo puede seguir vendedores");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(post(FOLLOW_URL, userId, userToFollow))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
    }

    @Test
    void followUserAlreadyFollowed() throws Exception{
        int userId = 1;
        int userToFollow = 29;

        MessageDto dto = new MessageDto("No se puede seguir a un vendedor que ya se esta siguiendo");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(post(FOLLOW_URL, userId, userToFollow))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
    }

    @Test
    void unfollowUserOk() throws Exception{
        int userId = 2;
        int userToFollow = 27;

        MessageDto dto = new MessageDto("El vendedor ha sido quitado de la lista de seguidos del cliente");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(post(UNFOLLOW_URL, userId, userToFollow))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    void unfollowUserNotFollowed() throws Exception{
        int userId = 1;
        int userToFollow = 26;

        MessageDto dto = new MessageDto("El vendedor no estaba en la lista de seguidos del cliente");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(post(UNFOLLOW_URL, userId, userToFollow))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
    }

    @Test
    void countFollowersOk() throws Exception{

        int userId = 29;

        FollowersCountDto dto = new FollowersCountDto(userId, "Josiah Sanchez", 1);
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(get(FOLLOWERS_COUNT_URL, userId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));

    }

    @Test
    void countFollowersNotFound() throws Exception{

        int userId = 66;

        MessageDto dto = new MessageDto("Vendedor no encontrado");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(get(FOLLOWERS_COUNT_URL, userId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().json(expected));

    }

    @Test
    void getFollowersListOk() throws Exception{

        int userId = 29;
        FollowersDto dto = new FollowersDto(userId, "Josiah Sanchez", List.of(
                new UserDto(1, "Quynn Nunez")
        ));

        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(get(FOLLOWERS_LIST_URL, userId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));

    }

    @Test
    void getFollowersListNoFollowers() throws Exception{

        int userId = 28;

        MessageDto dto = new MessageDto("El vendedor no tiene seguidores");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(get(FOLLOWERS_LIST_URL, userId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().json(expected));

    }

    @Test
    void getFollowersListNotFound() throws Exception{

        int userId = 66;

        MessageDto dto = new MessageDto("El vendedor no fue encontrado");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(get(FOLLOWERS_LIST_URL, userId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().json(expected));

    }

    @Test
    void getFollowersListNotSeller() throws Exception{

        int userId = 1;

        MessageDto dto = new MessageDto("El usuario no es un vendedor");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(get(FOLLOWERS_LIST_URL, userId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));

    }

    @Test
    void getFollowedList() throws Exception{

        int userId = 1;
        FollowedDto dto = new FollowedDto(userId, "Quynn Nunez", List.of(
                new UserDto(29, "Josiah Sanchez")
        ));

        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(get(FOLLOWED_LIST_URL, userId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));

    }

    @Test
    void getFollowedListNotFound() throws Exception{

        int userId = 66;

        MessageDto dto = new MessageDto("Usuario no encontrado");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(get(FOLLOWED_LIST_URL, userId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().json(expected));

    }

    @Test
    void getFollowedListNoFollowed() throws Exception{

        int userId = 3;

        MessageDto dto = new MessageDto("El usuario no esta siguiendo a ningún vendedor");
        String expected = objectWriter.writeValueAsString(dto);

        mockMvc.perform(get(FOLLOWED_LIST_URL, userId))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().json(expected));

    }
}