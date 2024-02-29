package com.bootcamp.be_java_hisp_w25_g02.controller;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerListDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegral {

    @Autowired
    MockMvc mockMvc;

    @Test
    @SneakyThrows
    public void getFollowersListTest(){
        //ARRANGE
        Integer userId = 9;
        String order = "name_asc";
        FollowerListDTO followerListDTO = new FollowerListDTO(
                9, "Malena",
                List.of(new UserDTO(1, "Javier"),
                        new UserDTO(7, "Maria"),
                        new UserDTO(3, "Martin")));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String expected = writer.writeValueAsString(followerListDTO);

        //ACT
        MvcResult current =
                 mockMvc.perform(get("/user/{userId}/followers", userId).param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        //ASSERT
        assertThat(current.getResponse().getContentAsString()).isEqualTo(expected);
    }
}
