package grupo_7.sprint_1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import grupo_7.sprint_1.dtos.AddPostDto;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.ProductDto;
import grupo_7.sprint_1.utils.MockBuilder;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class Integritytest {
    @Autowired
    private MockMvc mockMvc;
    static ObjectWriter writer;

    @BeforeAll
    static void setup() {
        writer = new ObjectMapper()
                .findAndRegisterModules()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }
    @Test
    public void getFollowersCountTest() throws Exception {
        int userId = 1;

        mockMvc.perform(get("/sellers/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(not(emptyOrNullString())))
                .andExpect(jsonPath("$.userId").value(1));
    }
    @Test
    public void getFollowersListTest() throws Exception {
        int userId = 1;
        String order = "asc";

        mockMvc.perform(get("/sellers/users/{userId}/followers/list?order={order}", userId, order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(not(emptyOrNullString())));
    }

    @Test
    public void followSellerTest() throws Exception {
        int buyerId = 1;
        int sellerId = 2;

        mockMvc.perform(post("/buyers/users/{buyerId}/follow/{sellerId}", buyerId, sellerId))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"message\":\"El comprador no existe\"}"));
    }


    @Test
    void addPostCorrectIT() throws Exception {
        //probar id product que no exitas en el json
        ProductDto product = new ProductDto(1233, "Product Name", "Product Type", "Product Brand", "Product Color", "Product Notes");
        AddPostDto addPostDto = new AddPostDto(1, LocalDate.now().minusDays(2), product, 1, 100.0);
        String payloadJson = writer.writeValueAsString(addPostDto);

        mockMvc.perform(post("/sellers/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
