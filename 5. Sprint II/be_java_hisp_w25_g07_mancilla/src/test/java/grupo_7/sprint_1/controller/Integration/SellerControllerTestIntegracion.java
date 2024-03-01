package grupo_7.sprint_1.controller.Integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerControllerTestIntegracion {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test ok - getFollowersListTestOk")
    public void getFollowersListTestOk() throws Exception {
       mockMvc.perform(get("/sellers/users/{userId}/followers/list?order={order}", 1, "name_asc").contentType("application/json"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json"))
               .andExpect(jsonPath("$.buyers.length()").value(3));
    }

    @Test
    @DisplayName("Sad path - getFollowersListTestSadPath")
    public void getFollowersListTestSadPath() throws Exception {
        mockMvc.perform(get("/sellers/users/{userId}/followers/list?order={order}", 111, "name_asc").contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No se encontro el vendedor con el id: 111"));
    }

    @Test
    @DisplayName("Test ok - getFollowersCountTestOk")
    public void getFollowersCountTestOk() throws Exception {
        mockMvc.perform(get("/sellers/users/{userId}/followers/count", 1).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followerCount").value(3));
    }
}
