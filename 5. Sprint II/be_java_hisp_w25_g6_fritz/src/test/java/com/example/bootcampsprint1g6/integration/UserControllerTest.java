package com.example.bootcampsprint1g6.integration;

import com.example.bootcampsprint1g6.dto.*;
import com.example.bootcampsprint1g6.entity.Buyer;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.util.UserTestGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    Seller seller1;
    Seller seller2;
    Seller seller3;
    Buyer buyer;
    @BeforeEach
    void setUp(){
        seller1 = UserTestGenerator.getSellerWithId(1);
        seller2 = UserTestGenerator.getSellerWithId(2);
        seller3 = UserTestGenerator.getSellerWithId(3);
        seller1.setUserName("seller1");
        seller2.setUserName("seller2");
        seller3.setUserName("seller3");
        buyer = UserTestGenerator.getBuyerWithId(3);
    }

    @Test
    void inexistentEndpointException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/asd"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Endpoint inexistente"));
    }

    @Test
    void httpRequestMethodNotSupportedException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), seller2.getUserId()))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Metodo no soportado"));
    }
    @Test
    void followOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), seller2.getUserId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Ok"));
    }

    @Test
    void followAgainException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), seller2.getUserId()));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), seller2.getUserId()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario ya está siguiendo al vendedor con ID: "+seller2.getUserId()));
    }

    @Test
    void followSameIdException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), seller1.getUserId()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario no se puede seguir así mismo ID: "+seller1.getUserId()));
    }

    @Test
    void followFromInexistentIdException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", 10, seller1.getUserId()))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No existe el usuario con id: "+10));
    }

    @Test
    void followToInexistentIdException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), 10))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No existe el usuario con id: "+10));
    }

    @Test
    void followWithIncorrectIdException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), "10a"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Error en el tipo de datos de los parámetros"));
    }

    @Test
    void unfollowOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), seller2.getUserId()));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/unfollow/{userIdToFollow}", seller1.getUserId(), seller2.getUserId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Ok"));
    }

    @Test
    void getFollowedListOk() throws Exception {
        FollowedDTO followedDTO = new FollowedDTO();
        followedDTO.setUserId(seller1.getUserId());
        followedDTO.setUserName(seller1.getUserName());
        followedDTO.setFollowed(Arrays.asList(new UserDTO(seller2.getUserId(), seller2.getUserName())));
        String expected = writer.writeValueAsString(followedDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), seller2.getUserId()));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{userId}/followed/list", seller1.getUserId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowedListAscOk() throws Exception {
        FollowedDTO followedDTO = new FollowedDTO();
        followedDTO.setUserId(seller1.getUserId());
        followedDTO.setUserName(seller1.getUserName());
        followedDTO.setFollowed(Arrays.asList(new UserDTO(seller2.getUserId(), seller2.getUserName()), new UserDTO(seller3.getUserId(), seller3.getUserName())));
        String expected = writer.writeValueAsString(followedDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), seller2.getUserId()));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), seller3.getUserId()));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{userId}/followed/list", seller1.getUserId()).param("order","name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowedListDescOk() throws Exception {
        FollowedDTO followedDTO = new FollowedDTO();
        followedDTO.setUserId(seller1.getUserId());
        followedDTO.setUserName(seller1.getUserName());
        followedDTO.setFollowed(Arrays.asList(new UserDTO(seller3.getUserId(), seller3.getUserName()), new UserDTO(seller2.getUserId(), seller2.getUserName())));
        String expected = writer.writeValueAsString(followedDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), seller2.getUserId()));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/{userId}/follow/{userIdToFollow}", seller1.getUserId(), seller3.getUserId()));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{userId}/followed/list", seller1.getUserId()).param("order","name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowersCountOk() throws Exception {
        FollowersCountDTO followersCountDTO = new FollowersCountDTO();
        followersCountDTO.setUserId(1);
        followersCountDTO.setUserName("seller1");
        followersCountDTO.setFollowersCount(2);
        String expected = writer.writeValueAsString(followersCountDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{userId}/followers/count", seller1.getUserId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowesListOk() throws Exception {
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setUserId(1);
        followersDTO.setUserName("seller1");
        followersDTO.setFollowers(Arrays.asList(new UserDTO(4,"buyer1"), new UserDTO(5,"buyer2")));

        String expected = writer.writeValueAsString(followersDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{userId}/followers/list", seller1.getUserId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowesListAscOk() throws Exception {
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setUserId(1);
        followersDTO.setUserName("seller1");
        followersDTO.setFollowers(Arrays.asList(new UserDTO(4,"buyer1"), new UserDTO(5,"buyer2")));

        String expected = writer.writeValueAsString(followersDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{userId}/followers/list", seller1.getUserId()).param("order","name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowesListDescOk() throws Exception {
        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setUserId(1);
        followersDTO.setUserName("seller1");
        followersDTO.setFollowers(Arrays.asList(new UserDTO(5,"buyer2"), new UserDTO(4,"buyer1")));

        String expected = writer.writeValueAsString(followersDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{userId}/followers/list", seller1.getUserId()).param("order","name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getFollowesListInvalidIdException() throws Exception {
        Integer userId = 10;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{userId}/followers/list", userId).param("order","name_desc"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No existe el usuario con id: "+userId));
    }

    @Test
    void getFollowesListInvalidOrderArgException() throws Exception {
        String param = "asd";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/{userId}/followers/list", seller1.getUserId()).param("order",param))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("La variable 'order' enviada es inválida ("+param+")."));
    }
}