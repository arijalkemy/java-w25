package integration;

import ch.qos.logback.core.net.ObjectWriter;
import com.example.be_java_hisp_w25_g01.BeJavaHispW25G01Application;
import com.example.be_java_hisp_w25_g01.dto.response.FollowersDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import util.TestUtilGenerator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static util.TestUtilGenerator.getFollowersDTOasc;

@SpringBootTest(classes = BeJavaHispW25G01Application.class)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @DisplayName("Individual Integration Test")
    @Test
    public void followersCountOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 5))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(4));
    }

    @DisplayName("BONUS")
    @Test
    public void getFollowersListOk() throws Exception {
        FollowersDTO expected = getFollowersDTOasc();

        ObjectMapper writer = new ObjectMapper();

        String expectedResponse = writer.writeValueAsString(expected);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 4))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expectedResponse,result.getResponse().getContentAsString());

    }
}
