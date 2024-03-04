package com.example.be_java_hisp_w25_g10.controller;

import com.example.be_java_hisp_w25_g10.dtos.CountDto;
import com.example.be_java_hisp_w25_g10.dtos.FollowedFollowerDto;
import com.example.be_java_hisp_w25_g10.entities.Follower;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;


    @Test
    @DisplayName("test followers count of a user controller")
    public void testCountFollowerById() throws Exception {

        //arrage
        Integer param = 1;

        String url = "/users/{userId}/followers/count";

        RequestBuilder request = MockMvcRequestBuilders.get(url, param);

        CountDto expected = new CountDto(1,"user1",2);
        //act accert
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(
                mapper.writeValueAsString(expected)
        );
        ResultMatcher contetTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) //verifica status
                .andExpect(bodyExpected) //verifica el body
                .andExpect(contetTypeExpected); //verifica el contentType
    }

    @Test
    @DisplayName("test followers count of a user controller")
    public void testListFollowedById() throws Exception {
    //arrange
    String url = "/users/{userId}/followed/list";
    Integer param = 3;

    RequestBuilder request = MockMvcRequestBuilders.get(url, param);
    Follower expected = new Follower(3,3);

    //act
    MvcResult result = mockMvc.perform(request)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();

    //assert
    String content = result.getResponse().getContentAsString();
    FollowedFollowerDto[] followers = mapper.readValue(content, FollowedFollowerDto[].class);
    assertEquals(2, followers.length); //verifica la cantidad de followers
}







}
