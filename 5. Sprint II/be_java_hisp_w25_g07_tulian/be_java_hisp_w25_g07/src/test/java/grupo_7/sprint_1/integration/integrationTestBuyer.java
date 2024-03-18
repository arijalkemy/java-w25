package grupo_7.sprint_1.integration;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import grupo_7.sprint_1.dtos.MessageDto;
import grupo_7.sprint_1.entity.Buyer;
import grupo_7.sprint_1.utils.MockBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class integrationTestBuyer {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetValidUserAndFollowedList() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/buyers/users/{userid}/followed/list",11)
                        .param("order","name_asc"))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(11))
                .andExpect(jsonPath("$.userName").value("Buyer_1"))
                .andExpect(jsonPath("$.sellerList.length()").value(1));
    }



}
