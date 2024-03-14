package org.bootcamp.javazoo.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.bootcamp.javazoo.dto.SellerDto;
import org.bootcamp.javazoo.dto.UserDto;
import org.bootcamp.javazoo.dto.response.FollowedListDto;
import org.bootcamp.javazoo.dto.response.FollowersListDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    private static ObjectWriter mapper;
    private static DateTimeFormatter formatter;

    @BeforeAll
    public static void setUp() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void testGetFollowersList() throws Exception {
        String expected = mapper.writeValueAsString(new FollowersListDto(1, "Seller 1", List.of(new UserDto(4, "User 4"))));
        MvcResult mvcResult = this.mockMvc.perform(get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected))
                .andReturn();
        assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void testGetFollowedList() throws Exception {
        FollowersListDto followersListDto = new FollowersListDto(4,
                "User 4",
                List.of(new SellerDto(1, "Seller 1")));
        String expected = mapper.writeValueAsString(followersListDto);

        MvcResult mvcResult = this.mockMvc.perform(get("/users/{userId}/followed/list", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }

}
