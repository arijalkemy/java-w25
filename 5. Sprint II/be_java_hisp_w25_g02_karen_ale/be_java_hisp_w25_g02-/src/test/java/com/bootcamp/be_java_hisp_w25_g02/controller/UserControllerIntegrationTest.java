package com.bootcamp.be_java_hisp_w25_g02.controller;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerListDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.GenericResponseDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.ProductDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getUserTotalFollowersIntTest() throws Exception {
        // Arrange

        Integer userId = 9;
        String order = "name_asc";
        FollowerListDTO followerListDTO = new FollowerListDTO(
                9,
                "Malena",
                List.of(
                        new UserDTO(1, "Javier"),
                        new UserDTO(7, "Maria"),
                        new UserDTO(3, "Martin")
                ));

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String expectedResult = objectWriter.writeValueAsString(followerListDTO);

        // Act

        MvcResult myResult = mockMvc.perform(get("/user/{userId}/followers", userId)
                        .param("order", order)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Assert
        Assertions.assertEquals(expectedResult, myResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }
}

