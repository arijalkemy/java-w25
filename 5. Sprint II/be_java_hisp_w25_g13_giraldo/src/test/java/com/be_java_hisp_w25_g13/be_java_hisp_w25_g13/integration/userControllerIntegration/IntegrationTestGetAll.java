package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.integration.userControllerIntegration;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
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
public class IntegrationTestGetAll {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private static List<UserDTO> usersDto;


    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();



        usersDto = List.of(
                new UserDTO(1, "John Doe"),
                new UserDTO(2, "Jane Smith"),
                new UserDTO(3, "Peter Parker"),
                new UserDTO(4, "Tony Stark"),
                new UserDTO(5, "Emma Watson"),
                new UserDTO(6, "Bruce Banner"),
                new UserDTO(7, "Clark Kent"),
                new UserDTO(8, "Diana Prince"),
                new UserDTO(9, "Dave Miller"),
                new UserDTO(10, "Emma Stone"),
                new UserDTO(11, "Steve Jobs"),
                new UserDTO(12, "Elon Musk"),
                new UserDTO(13, "Bill Gates"),
                new UserDTO(14, "Tom Cruise"),
                new UserDTO(15, "Jennifer Anistan"),
                new UserDTO(16, "Julia Roberts"),
                new UserDTO(17, "Robert Downey Jr."),
                new UserDTO(18, "Natalie Portman"),
                new UserDTO(19, "Hugh Jackman"),
                new UserDTO(20, "Scarlett Johansson"),
                new UserDTO(21, "Daniel Radcliffe"),
                new UserDTO(22, "Emily Blunt"),
                new UserDTO(23, "Chris Hemsworth"),
                new UserDTO(24, "Bradley Cooper"),
                new UserDTO(25, "Mila Kunis"),
                new UserDTO(26, "Will Smith"),
                new UserDTO(27, "Margot Robbie"),
                new UserDTO(28, "Leonardo DiCaprio"),
                new UserDTO(29, "Kate Winslet"),
                new UserDTO(30, "Johnny Depp")
        );

    }

    @Test
    void getAllUsersOk() throws Exception{
        String expectedUsers = writer.writeValueAsString(usersDto);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedUsers));
    }
}
