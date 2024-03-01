package com.example.bootcampsprint1g6.integration;

import com.example.bootcampsprint1g6.dto.FollowedDTO;
import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import com.example.bootcampsprint1g6.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegationTest {
    @Autowired
    MockMvc mockMvc;

    private final String URI = "/api/users";

    @Test
    public void testFollow() throws Exception {
        Integer userId = 1;
        Integer userIdToFollow = 3;

        // PostRequestDTO datos enviados por body
        GenericResponseDTO genericResponseDTO = new GenericResponseDTO(200, "Ok");

        // Convierto el request y el responseExpected a JSON
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String genericResponseDTOExpected = writer.writeValueAsString(genericResponseDTO);

        // Llamo al endpoint y verifico algunas cosas
        MvcResult mvcResult = mockMvc.perform(post(URI + "/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(genericResponseDTOExpected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }



    @Test
    public void testUnfollow() throws Exception {
        Integer userId = 1;
        Integer userIdToFollow = 3;

        // PostRequestDTO datos enviados por body
        GenericResponseDTO genericResponseDTO = new GenericResponseDTO(400, "El usuario no está siguiendo al usuario con ID: 3");

        // Convierto el request y el responseExpected a JSON
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String genericResponseDTOExpected = writer.writeValueAsString(genericResponseDTO);

        // Llamo al endpoint y verifico algunas cosas
        MvcResult mvcResult = mockMvc.perform(post(URI + "/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        Assertions.assertEquals(genericResponseDTOExpected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testUnfollowErrorUserIsNotFollowing() throws Exception{
        Integer userId = 1;
        Integer userIdToFollow = 4;

        mockMvc.perform(post(URI + "/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El usuario no está siguiendo al usuario con ID: " + userIdToFollow))
                .andReturn();
    }
    @Test
    public void testUnfollowErrorUserNotExist() throws Exception{
        Integer userId = 1;
        Integer userIdToFollow = 33;

        mockMvc.perform(post(URI + "/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No existe el usuario con id: " + userIdToFollow))
                .andReturn();
    }
    @Test
    public void testUnfollowErrorDataType() throws Exception{
        Integer userId = 1;
        String userIdToFollow = "33a";

        mockMvc.perform(post(URI + "/{userId}/unfollow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Error en el tipo de datos de los parámetros"))
                .andReturn();
    }
    @Test
    public void testUnfollowErrorIlegalArgument() throws Exception{
        Integer userId = 1;

        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            mockMvc.perform(post(URI + "/{userId}/unfollow/{userIdToFollow}", userId))
                    .andDo(print())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Not enough variable values available to expand 'userIdToFollow'"))
                    .andReturn();
        },"Not enough variable values available to expand 'userIdToFollow'");
    }

    @Test
    public void getFollowedListNameAscTestOk() throws Exception {
        Integer userId = 4;
        String NAME_ASC = "name_asc";

        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setId(1);
        userDTO1.setUserName("seller1");
        UserDTO userDTO2 = new UserDTO();
        userDTO2.setId(2);
        userDTO2.setUserName("seller2");
        userDTOList.add(userDTO1);
        userDTOList.add(userDTO2);

        FollowedDTO followedDTO = new FollowedDTO(userId, "buyer1", userDTOList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponse = writer.writeValueAsString(followedDTO);

        // Llamo al endpoint y verifico la respuesta
        MvcResult mvcResult = mockMvc.perform(get(URI + "/{userId}/followed/list", userId)
                        .param("order", NAME_ASC))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andReturn();

        Assertions.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
    @Test
    public void getFollowedListNameDescTestOk() throws Exception {
        Integer userId = 4;
        String NAME_DESC = "name_desc";

        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(new UserDTO(2, "seller2"));
        userDTOList.add(new UserDTO(1, "seller1"));
        FollowedDTO followedDTO = new FollowedDTO(userId, "buyer1", userDTOList);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponse = writer.writeValueAsString(followedDTO);

        // Llamo al endpoint y verifico la respuesta
        MvcResult mvcResult = mockMvc.perform(get(URI + "/{userId}/followed/list", userId)
                        .param("order", NAME_DESC))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andReturn();

        Assertions.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testIllegalArgumentExceptionHandler() throws Exception {
        mockMvc.perform(get(URI + "/{userId}/followed/list", 1)
                        .param("order", "invalid_order"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.message").value("La variable 'order' enviada es inválida (invalid_order)."));
    }

    @Test
    public void testNoResourceFoundExceptionHandler() throws Exception {
        mockMvc.perform(get(URI + "/unknown-endpoint"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.message").value("Endpoint inexistente"));
    }
}
