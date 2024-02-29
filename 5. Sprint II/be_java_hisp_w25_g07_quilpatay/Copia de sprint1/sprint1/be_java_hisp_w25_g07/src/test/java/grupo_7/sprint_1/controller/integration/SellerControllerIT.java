package grupo_7.sprint_1.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import grupo_7.sprint_1.dtos.AddPostDto;
import grupo_7.sprint_1.utils.MockBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerControllerIT {

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
    void addPostCorrectIT() throws Exception {

        AddPostDto addPostDto = MockBuilder.mockPostDto();
        String payloadJson = writer.writeValueAsString(addPostDto);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String expectedDate = LocalDate.now().minusDays(2).format(formatter);

        mockMvc.perform(post("/sellers/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.date").value(expectedDate))
                .andExpect(jsonPath("$.product.product_id").value(addPostDto.product().productId()))
                .andExpect(jsonPath("$.category").value(1))
                .andExpect(jsonPath("$.price").value(100.0));
    }

    @Test
    void getFollowersCountCorrectIT() throws Exception {

        int userId = 1;

        mockMvc.perform(get("/sellers/users/" + userId + "/followers/count")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.userName").value("Seller_1"))
                .andExpect(jsonPath("$.followerCount").value(3));
    }

    @Test
    void getFollowersListCorrectIT() throws Exception {

        Integer userId = 1;
        String order = "name_asc";

        mockMvc.perform(get("/sellers/users/" + userId + "/followers/list?order=" + order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sellerId").value(1))
                .andExpect(jsonPath("$.sellerUserName").value("Seller_1"))
                .andExpect(jsonPath("$.buyers.length()").value(3));
    }

    @Test
    void getRecentPostsFromFollowedSellersCorrectIT() throws Exception {

        Integer userId = 11;
        String order = "date_asc";

        mockMvc.perform(get("/sellers/products/followed/" + userId + "/list?order=" + order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

}
