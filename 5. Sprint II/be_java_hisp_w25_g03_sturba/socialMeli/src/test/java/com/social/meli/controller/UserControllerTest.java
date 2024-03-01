package com.social.meli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.social.meli.dto.response.FollowedListDto;
import com.social.meli.dto.response.UserVendorDto;
import com.social.meli.dto.response.VendorFollowCountDto;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;
import java.util.stream.Stream;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@FieldDefaults(level = PRIVATE)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    final ResultMatcher jsonContentType = content().contentType("application/json");

    final ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    FollowedListDto followListDto;
    FollowedListDto descFollowListDto;

    FollowedListDto followedListDto;
    FollowedListDto descfollowedListDto;

    @BeforeEach
    void setUp() {
        UserVendorDto testUserVendorDto = new UserVendorDto(1, "Luciano Gonzalez");
        UserVendorDto testUserVendorDto2 = new UserVendorDto(2, "Sofia Fernandez");
        followListDto = new FollowedListDto(8, "Valeria Ramirez", List.of(testUserVendorDto, testUserVendorDto2));
        descFollowListDto = new FollowedListDto(8, "Valeria Ramirez", List.of(testUserVendorDto2, testUserVendorDto));
        followedListDto = new FollowedListDto(1, "Luciano Gonzalez", List.of(new UserVendorDto(8, "Valeria Ramirez"),
                new UserVendorDto(10, "Victoria Acosta")));
        descfollowedListDto = new FollowedListDto(1, "Luciano Gonzalez", List.of(new UserVendorDto(10, "Victoria Acosta"),
                new UserVendorDto(8, "Valeria Ramirez")));
    }


    static Stream<Arguments> invalidUserOrderData() {
        return Stream.of(
                Arguments.of(1, FORBIDDEN, "El usuario no es un vendedor", null),
                Arguments.of(11, NOT_FOUND, "No se encontro al usuario", null),
                Arguments.of(8, BAD_REQUEST, "Los datos de ordenamiento solicitados son incorrectos.", "asdasd")
        );
    }

    static Stream<Arguments> invalidUserFollowedOrderData() {
        return Stream.of(
                Arguments.of(11, NOT_FOUND, "No se encontro al usuario", null),
                Arguments.of(8, BAD_REQUEST, "Los datos de ordenamiento solicitados son incorrectos.", "asdasd")
        );
    }

    static Stream<Arguments> orderData() {
        return Stream.of(
                Arguments.of("name_asc"),
                Arguments.of("name_desc"),
                Arguments.of((Object) null)
        );
    }

    static Stream<Arguments> invalidVendorFollowerCountData() {
        return Stream.of(
                Arguments.of(11, NOT_FOUND, "No se encontro al usuario"),
                Arguments.of(1, FORBIDDEN, "El usuario no es un vendedor")
        );
    }

    static Stream<Arguments> invalidFollowData() {
        return Stream.of(
                Arguments.of(11, 9, NOT_FOUND, "No se encontro al usuario"),
                Arguments.of(9, 11, NOT_FOUND, "No se encontro al usuario"),
                Arguments.of(9, 1, FORBIDDEN, "El usuario no es un vendedor"),
                Arguments.of(1, 8, FORBIDDEN, "Ya sigues a este usuario")
        );
    }

    static Stream<Arguments> invalidUnfollowData() {
        return Stream.of(
                Arguments.of(11, 9, NOT_FOUND, "No se encontro al usuario"),
                Arguments.of(9, 11, NOT_FOUND, "No se encontro al usuario"),
                Arguments.of(9, 1, FORBIDDEN, "El usuario no esta en tu lista de followed")
        );
    }


    @ParameterizedTest
    @MethodSource("orderData")
    void performVendorFollowed(String order) throws Exception {
        if ("name_desc".equals(order)) followListDto = descFollowListDto;
        MvcResult mockedResponse = mockMvc.perform(get("/users/{userId}/followers/list", 8).param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonContentType)
                .andReturn();
        assertEquals(objectWriter.writeValueAsString(followListDto), mockedResponse.getResponse().getContentAsString());
    }

    @ParameterizedTest
    @MethodSource("orderData")
    void performVendorFollowers(String order) throws Exception {
        if ("name_desc".equals(order)) followListDto = descFollowListDto;
        MvcResult mockedResponse = mockMvc.perform(get("/users/{userId}/followers/list", 8).param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonContentType)
                .andReturn();
        assertEquals(objectWriter.writeValueAsString(followListDto), mockedResponse.getResponse().getContentAsString());
    }

    @ParameterizedTest
    @MethodSource(value = "invalidUserOrderData")
    void getVendorFollowersInvalidDataTests(Integer userId, HttpStatus expectedStatusCode, String errorMessage, String order) throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list", userId).param("order", order))
                .andDo(print())
                .andExpect(status().is(expectedStatusCode.value()))
                .andExpect(jsonContentType)
                .andExpect(jsonPath("$.message").value(errorMessage));
    }

    @Test
    void getVendorFollowerCountOkTest() throws Exception {
        String testCountDto = objectWriter.writeValueAsString(new VendorFollowCountDto(8, "Valeria Ramirez", 2));
        String jsonResponse = mockMvc.perform(get("/users/{userId}/followers/count", 8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonContentType)
                .andReturn().getResponse().getContentAsString();
        assertEquals(testCountDto, jsonResponse);
    }

    @ParameterizedTest
    @MethodSource("invalidVendorFollowerCountData")
    void getInvalidVendorFollowerCountInvalidUserTest(Integer userId, HttpStatus expectedStatusCode, String errorMessage) throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().is(expectedStatusCode.value()))
                .andExpect(jsonContentType)
                .andExpect(jsonPath("$.message").value(errorMessage));
    }
    @ParameterizedTest
    @ValueSource(strings = {"/users/{userId}/followers/count","/users/{userId}/followed/list","/users/{userId}/followers/list"})
    void invalidSingleIdTest(String endPoint) throws Exception {
        mockMvc.perform(get(endPoint, -1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonContentType)
                .andExpect(jsonPath("$.userId").value("El id debe ser un valor positivo"));
    }

    @ParameterizedTest
    @MethodSource("orderData")
    void getFollowedListOkTest(String order) throws Exception {
        if ("name_desc".equals(order)) followedListDto = descfollowedListDto;
        MvcResult mockedResponse = mockMvc.perform(get("/users/{userId}/followed/list", 1).param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonContentType)
                .andReturn();
        assertEquals(objectWriter.writeValueAsString(followedListDto), mockedResponse.getResponse().getContentAsString());
    }

    @ParameterizedTest
    @MethodSource("invalidUserFollowedOrderData")
    void getFollowedListInvalidDataTest(Integer userId, HttpStatus expectedStatusCode, String errorMessage, String order) throws Exception {
        mockMvc.perform(get("/users/{userId}/followed/list", userId).param("order", order))
                .andDo(print())
                .andExpect(status().is(expectedStatusCode.value()))
                .andExpect(jsonContentType)
                .andExpect(jsonPath("$.message").value(errorMessage));

    }

    @Test
    void followUserOkTest() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2, 10))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonContentType)
                .andExpect(jsonPath("$.message").value("Comenzaste a seguir al usuario Victoria Acosta"));
    }

    @ParameterizedTest
    @MethodSource("invalidFollowData")
    void followUserUserNotValidTest(Integer userId, Integer userIdToFollow, HttpStatus expectedHttpStatus, String errorMessage) throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().is(expectedHttpStatus.value()))
                .andExpect(jsonContentType)
                .andExpect(jsonPath("$.message").value(errorMessage));
    }

    @Test
    void unfollowUserOkTest() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 3, 9))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonContentType)
                .andExpect(jsonPath("$.message").value("Dejaste de seguir a Tomas Castro"));
    }

    @ParameterizedTest
    @MethodSource("invalidUnfollowData")
    void unfollowUserUserNotValidTest(Integer userId, Integer userIdToFollow, HttpStatus expectedHttpStatus, String errorMessage) throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().is(expectedHttpStatus.value()))
                .andExpect(jsonContentType)
                .andExpect(jsonPath("$.message").value(errorMessage));
    }


}