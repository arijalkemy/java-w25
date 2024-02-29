package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.ProductDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.request.UserDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ExceptionDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowedDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowersDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.utils.FactoryUsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static com.breakingbytes.be_java_hisp_w25_g04.utils.FactoryUsers.mapper;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Actividad C - Obtener todos los personas que sigune a un determinado vendedor")
    public void getAllFollowersTestOk() throws Exception {
        // Arrange
        Integer requestId = 3;
        String requestOrder = "name_asc";
        Seller s = FactoryUsers.getSellers().get(0);
        List<UserDTO> followers = s.getFollowers().stream().map(u -> mapper.map(u, UserDTO.class)).toList();
        UserFollowersDTO userFollowersDTO = new UserFollowersDTO(s.getId(), s.getName(),followers);
        // Act
        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String expectedJson = writter.writeValueAsString(userFollowersDTO);

        // Assert
        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followers/list", requestId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Actividad C - No se puede listar todos los seguidores de un vendedor con un orden invalido")
    public void getAllFollowersTestOrdenErrorException() throws Exception {
        // Arrange
        Integer requestId = 3;
        String requestOrder = "orden_equivocado";
        ExceptionDTO expected = new ExceptionDTO("El tipo de ordenamiento alfabetico es incorrecto");
        // Act
        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
        String expectedJson = writter.writeValueAsString(expected);

        // Assert
        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.get("/users/{user_id}/followers/list", requestId)
                        .queryParam("order", requestOrder))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
    }


}
