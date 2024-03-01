package org.socialmeli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.socialmeli.dto.response.ExceptionDto;
import org.socialmeli.dto.response.FollowerCountDto;
import org.socialmeli.dto.response.MessageDto;
import org.socialmeli.entity.Client;
import org.socialmeli.entity.User;
import org.socialmeli.entity.Vendor;
import org.socialmeli.repository.implementation.ClientRepositoryImp;
import org.socialmeli.repository.implementation.PostRepositoryImp;
import org.socialmeli.repository.implementation.VendorRepositoryImp;
import org.socialmeli.util.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UsersControllerIntegration {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    VendorRepositoryImp vendorRepositoryImp;
    @Autowired
    ClientRepositoryImp clientRepositoryImp;
    @Autowired
    PostRepositoryImp postRepositoryImp;

    ObjectFactory objectFactory = new ObjectFactory();
    static ObjectWriter writer;

    private void initWriter() {
        UsersControllerIntegration.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    private void resetUserStaticId() {
        //Reseteamos para que no se rompa el repo y agregue id gigantes
        User.userIdCounter = 0;
    }

    @BeforeEach
    public void setUp() {
        initWriter();
        resetUserStaticId();
    }
    @Test
    void followersCountOkTest() throws Exception {
        Vendor mockVendor = objectFactory.getOneVendorFromDB(vendorRepositoryImp);
        FollowerCountDto expectedDto = new FollowerCountDto(
                mockVendor.getUserId(),
                mockVendor.getUserName(),
                0);

        String expected = writer.writeValueAsString(expectedDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count", mockVendor.getUserId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void followUserOkTest() throws Exception {

        Client mockClient = objectFactory.getOneClientFromDB(clientRepositoryImp);
        Vendor mockVendor = objectFactory.getOneVendorFromDB(vendorRepositoryImp);

        MessageDto expectedDto = new MessageDto("Vendedor seguido exitosamente");

        String expected = writer.writeValueAsString(expectedDto);


        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", mockClient.getUserId(), mockVendor.getUserId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void cantFollowNonExistingVendorTest() throws Exception{
        Client mockClient = objectFactory.getOneClientFromDB(clientRepositoryImp);

        ExceptionDto expectedDto = new ExceptionDto("El vendedor no existe");
        String expected = writer.writeValueAsString(expectedDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", mockClient.getUserId(), 9999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void cantFollowHimselfTest() throws Exception{
        Client mockClient = objectFactory.getOneClientFromDB(clientRepositoryImp);

        ExceptionDto expectedDto = new ExceptionDto("Un usuario no se puede seguir a si mismo");
        String expected = writer.writeValueAsString(expectedDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", mockClient.getUserId(), mockClient.getUserId()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void unfollowUserOkTest() throws Exception {
        Client mockClient = objectFactory.getOneClientFromDB(clientRepositoryImp);
        Vendor mockVendor = objectFactory.getOneVendorFromDB(vendorRepositoryImp);

        // Setup para que cliente esté siguiendo al vendedor
        clientRepositoryImp.findOne(mockClient.getUserId()).getFollowing().add(mockVendor);
        vendorRepositoryImp.findOne(mockVendor.getUserId()).getFollowers().add(mockClient);

        MessageDto expectedDto = new MessageDto("El usuario con id " + mockClient.getUserId() + " ha dejado de seguir al vendedor con id " + mockVendor.getUserId());

        String expected = writer.writeValueAsString(expectedDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", mockClient.getUserId(), mockVendor.getUserId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void cantUnfollowAnUnfollowedVendorTest() throws Exception {
        Client mockClient = objectFactory.getOneClientFromDB(clientRepositoryImp);
        Vendor mockVendor = objectFactory.getOneVendorFromDB(vendorRepositoryImp);

        ExceptionDto expectedDto = new ExceptionDto("Error: El usuario con id " + mockClient.getUserId() + " no está siguiendo al vendedor con id " + mockVendor.getUserId());
        String expected = writer.writeValueAsString(expectedDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", mockClient.getUserId(), mockVendor.getUserId()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void cantUnfollowHimselfTest() throws Exception {
        Client mockClient = objectFactory.getOneClientFromDB(clientRepositoryImp);

        ExceptionDto expectedDto = new ExceptionDto("Error: Ambos id son identicos");
        String expected = writer.writeValueAsString(expectedDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", mockClient.getUserId(), mockClient.getUserId()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}
