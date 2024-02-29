package grupo_7.sprint_1.controller.integrityTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BuyerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void followSellerTest() throws Exception {
        int buyerId = 1;
        int sellerId = 2;

        mockMvc.perform(post("/buyers/users/{buyerId}/follow/{sellerId}", buyerId, sellerId))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"message\":\"El comprador no existe\"}"));
    }

}

