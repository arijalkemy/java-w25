package grupo_7.sprint_1.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.PrintingResultHandler;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@SpringBootTest
@AutoConfigureMockMvc
public class integrationtestseller {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void testGetValidCountOfFollowers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/sellers/users/{userId}/followers/count",1))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.userName").value("Seller_1"))
                .andExpect(jsonPath("$.followerCount").value(3));
    }
    @Test
    public void testGetValidFollowersList() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/sellers/users/{userid}/followers/list",1).param("order","name_asc"))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }
}
