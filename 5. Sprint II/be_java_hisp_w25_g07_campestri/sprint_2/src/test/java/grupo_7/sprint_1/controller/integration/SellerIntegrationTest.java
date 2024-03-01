package grupo_7.sprint_1.controller.integration;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test de integración para obtener un listado de todos los usuarios que siguen a un determinado vendedor sin especificar un orden, funcionamiento esperado")
    public void testGetFollowersOk() throws Exception {
        mockMvc.perform(get("/sellers/users/{userId}/followers/list", 1)
                        .param("order", "")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.sellerId").value(1))
                .andExpect(jsonPath("$.sellerUserName").value("Seller_1"))
                .andExpect(jsonPath("$.buyers", Matchers.not(Matchers.empty())));
    }

    @Test
    @DisplayName("Test de integración para obtener un listado ordenado alfabéticamente de todos los usuarios que siguen a un determinado vendedor, funcionamiento esperado")
    public void testGetFollowersOrderedOk() throws Exception {
        mockMvc.perform(get("/sellers/users/{userId}/followers/list", 1)
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.sellerId").value(1))
                .andExpect(jsonPath("$.sellerUserName").value("Seller_1"))
                .andExpect(jsonPath("$.buyers[0].id", Matchers.is(11)))
                .andExpect(jsonPath("$.buyers[0].userName", Matchers.is("Buyer_1")))
                .andExpect(jsonPath("$.buyers[1].id", Matchers.is(12)))
                .andExpect(jsonPath("$.buyers[1].userName", Matchers.is("Buyer_2")))
                .andExpect(jsonPath("$.buyers[2].id", Matchers.is(13)))
                .andExpect(jsonPath("$.buyers[2].userName", Matchers.is("Buyer_3")));
    }

}
