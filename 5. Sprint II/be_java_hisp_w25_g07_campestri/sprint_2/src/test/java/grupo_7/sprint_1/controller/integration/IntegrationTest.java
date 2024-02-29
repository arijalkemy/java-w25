package grupo_7.sprint_1.controller.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test de integración para seguir un vendedor, funcionamiento esperado")
    public void testFollowSellerOk() throws Exception {
        mockMvc.perform(post("/buyers/users/{buyerId}/follow/{sellerId}", 12, 2)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El vendedor se ha seguido correctamente"));
    }

    @Test
    @DisplayName("Test de integración para seguir un vendedor, cuando un comprador ya sigue al vendedor")
    public void testFollowSellerAlreadyFollowed() throws Exception {
        mockMvc.perform(post("/buyers/users/{buyerId}/follow/{sellerId}", 12, 2)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El vendedor ya está en la lista de seguidos"));
    }

    @Test
    @DisplayName("Test de integración para seguir un vendedor, cuando un comprador no existe")
    public void testFollowSellerBuyerNotExists() throws Exception {
        mockMvc.perform(post("/buyers/users/{buyerId}/follow/{sellerId}", 110, 1)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El comprador no existe"));
    }

    @Test
    @DisplayName("Test de integración para seguir un vendedor, cuando un vendedor no existe")
    public void testFollowSellerSellerNotExists() throws Exception {
        mockMvc.perform(post("/buyers/users/{buyerId}/follow/{sellerId}", 12, 102)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El vendedor no existe"));
    }
}