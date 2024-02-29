package grupo_7.sprint_1.controller.integration;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BuyerControllerIT {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setup() {
        writer = new ObjectMapper()
                .findAndRegisterModules()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    void followSellerCorrectIT() throws Exception {
        Integer userId = 11;
        Integer sellerId = 4;
        mockMvc.perform(post("/buyers/users/" + userId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("El vendedor se ha seguido correctamente"));
    }

    @Test
    void getFollowedListCorrectIT() throws Exception {
        Integer userId = 11;
        String order = "name_asc";

        mockMvc.perform(get("/buyers/users/" + userId + "/followed/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(11))
                .andExpect(jsonPath("$.userName").value("Buyer_1"))
                .andExpect(jsonPath("$.sellerList.length()").value(1));
    }

    @Test
    void unfollowSellerCorrectIT() throws Exception {
        Integer userId = 11;
        Integer sellerId = 1;

        mockMvc.perform(post("/buyers/users/" + userId + "/unfollow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Se eliminó de seguidores correctamente"));
    }

}
