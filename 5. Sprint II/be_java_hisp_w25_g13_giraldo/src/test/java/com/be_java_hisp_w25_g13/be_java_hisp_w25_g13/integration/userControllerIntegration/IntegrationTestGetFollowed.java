package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.integration.userControllerIntegration;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.FollowedDTO;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestGetFollowed {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepositoryImpl userRepository;

    private static ObjectWriter writer;

    private static FollowedDTO followedDTO;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();



        followedDTO = new FollowedDTO(
                1,
                "John Doe",
                List.of(
                        new UserDTO(21, "Daniel Radcliffe"),
                        new UserDTO(22, "Emily Blunt"),
                        new UserDTO(23, "Chris Hemsworth")
                )
        );
    }

    @BeforeEach
    public void beforeEach(){
        userRepository.cleanData();
        userRepository
                .getUserById(1)
                .get().setFollowing(List.of(
                        (Seller) userRepository.getUserById(21).get(),
                        (Seller) userRepository.getUserById(22).get(),
                        (Seller) userRepository.getUserById(23).get()));
    }

    @Test
    void getFollowers() throws Exception{

        String followersJson = writer.writeValueAsString(followedDTO);
        System.out.println(followersJson);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andExpect(status().isOk())
                .andExpect(content().json(followersJson))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
