package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.integration.userControllerIntegration;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.FollowersDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.NumberDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.UserDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.UserRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestGetFollowers {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepositoryImpl userRepository;

    private static ObjectWriter writer;

    private static FollowersDTO followersDTO;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();



        followersDTO = new FollowersDTO(
                21,
                "Daniel Radcliffe",
                List.of(
                        new UserDTO(1, "John Doe"),
                        new UserDTO(2, "Jane Smith"),
                        new UserDTO(3, "Peter Parker")
                )
        );
    }

    @BeforeEach
    public void beforeEach(){
        userRepository.cleanData();
        Seller seller = (Seller) userRepository.getUserById(21).get();
        seller.setFollowers((List.of(
                userRepository.getUserById(1).get(),
                userRepository.getUserById(2).get(),
                userRepository.getUserById(3).get())));
    }

    @Test
    void getFollowers() throws Exception{

        String followersJson = writer.writeValueAsString(followersDTO);
        System.out.println(followersJson);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 21))
                .andExpect(status().isOk())
                .andExpect(content().json(followersJson))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getFollowersNotSeller() throws Exception{

        String followersJson = writer.writeValueAsString(followersDTO);
        System.out.println(followersJson);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El id del usuario no corresponde a un vendedor"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCountFollowers() throws Exception{
        NumberDTO expectedNumberDto = new NumberDTO(21, "Daniel Radcliffe", 3);
        String expectedNumberJson = writer.writeValueAsString(expectedNumberDto);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 21))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedNumberJson));
    }
}
