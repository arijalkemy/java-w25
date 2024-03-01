package controller;


import com.example.be_java_hisp_w25_g01.BeJavaHispW25G01Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = BeJavaHispW25G01Application.class)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;


    @DisplayName("Desarrollo Individual - Test de Integración Follow User Ok")
    @Test
    public void followUserOkTest() throws Exception {
        // Arrange
        int userId = 1;
        int userIdToFollow = 4;
        String payloadJson = "{\"message\": \"User with id: 1 is now following user with id: 4\"}";


        // Act & Assert
        this.mockMvc.perform(post("/users/" + userId + "/follow/" + userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("User with id: 1 is now following user with id: 4"));
    }

    @DisplayName("Desarrollo Individual - Test de Integración UnFollow User Ok")
    @Test
    public void unFollowUserOkTest() throws Exception {
        // Arrange
        int userId = 1;
        int userIdToUnfollow = 5;
        String payloadJson = "{\"message\": \"User with id: 1 is now unfollowing user with id: 5\"}";

        // Act & Assert

        this.mockMvc.perform(post("/users/" + userId + "/unfollow/" + userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("User with id: 1 is now unfollowing user with id: 5"));

    }



}
