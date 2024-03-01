package grupo_7.sprint_1.controller.Integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BuyerControllerTestIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test integracion unfollowSellerTestOk")
    public void unfollowSellerControllerTestOk() throws Exception {
        mockMvc.perform(post("/buyers/users/{userId}/unfollow/{userIdToUnfollow}", 11, 1).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Se eliminó de seguidores correctamente"));
    }

    @Test
    @DisplayName("Test ok - unfollowSellerControllerIdBuyerInvalidTestSadPath")
    public void unfollowSellerControllerIdBuyerInvalidTestSadPath() throws Exception {
        mockMvc.perform(post("/buyers/users/{userId}/unfollow/{userIdToUnfollow}", 111, 1).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No se encuentra el id del comprador"));
    }

    @Test
    @DisplayName("Sad Path - unfollowSellerControllerIdBuyerInvalidTestSadPath")
    public void unfollowSellerControllerIdFollowedInvalidTestSadPath() throws Exception {
        mockMvc.perform(post("/buyers/users/{userId}/unfollow/{userIdToUnfollow}", 11, 111).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No se encuentra el followed"));
    }

}
