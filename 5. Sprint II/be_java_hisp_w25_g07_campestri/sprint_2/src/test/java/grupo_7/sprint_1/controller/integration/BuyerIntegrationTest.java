package grupo_7.sprint_1.controller.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BuyerIntegrationTest {
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

    @Test
    @DisplayName("Test de integración para dejar de seguir un vendedor, funcionamiento esperado")
    public void testUnfollowSellerOk() throws Exception {
        mockMvc.perform(post("/buyers/users/{userId}/unfollow/{userIdToUnfollow}", 11, 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Se eliminó de seguidores correctamente"));
    }

    @Test
    @DisplayName("Test de integración para dejar de seguir un vendedor, cuando el comprador no existe")
    public void testUnfollowSellerNotExists() throws Exception {
        mockMvc.perform(post("/buyers/users/{userId}/unfollow/{userIdToUnfollow}", 110, 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())

                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No se encuentra el id del comprador"));
    }

    @Test
    @DisplayName("Test de integración para dejar de seguir un vendedor, cuando el vendedor no está en la lista de seguidos")
    public void testUnfollowSellerNotFollowed() throws Exception {
        mockMvc.perform(post("/buyers/users/{userId}/unfollow/{userIdToUnfollow}", 11, 109)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())

                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No se encuentra el followed"));
    }

    @Test
    @DisplayName("Test de integración para obtener un listado ordenado alfabéticamente de todos los vendedores a los cuales sigue un determinado usuario, funcionamiento esperado")
    public void testGetFollowedListAscOk() throws Exception {
        mockMvc.perform(get("/buyers/users/{userid}/followed/list", 12)
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId").value(12))
                .andExpect(jsonPath("$.userName").value("Buyer_2"))
                .andExpect(jsonPath("$.sellerList[0].userId").value(1))
                .andExpect(jsonPath("$.sellerList[0].userName").value("Seller_1"));
    }

    @Test
    @DisplayName("Test de integración para obtener un listado ordenado invertido alfabéticamente de todos los vendedores a los cuales sigue un determinado usuario, funcionamiento esperado")
    public void testGetFollowedListDescOk() throws Exception {
        mockMvc.perform(get("/buyers/users/{userid}/followed/list", 11)
                        .param("order", "name_desc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId").value(11))
                .andExpect(jsonPath("$.userName").value("Buyer_1"))
                .andExpect(jsonPath("$.sellerList[0].userId").value(1))
                .andExpect(jsonPath("$.sellerList[0].userName").value("Seller_1"));
    }

    @Test
    @DisplayName("Test de integración para obtener un listado ordenado de todos los vendedores a los cuales sigue un determinado usuario, cuando el comprador no existe")
    public void testGetFollowedListBuyerNotExists() throws Exception {
        mockMvc.perform(get("/buyers/users/{userid}/followed/list", 110)
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())

                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El id ingresado no corresponde a ningun comprador"));
    }

    @Test
    @DisplayName("Test de integración para obtener un listado ordenado de todos los vendedores a los cuales sigue un determinado usuario, cuando el método de ordenamiento no existe")
    public void testGetFollowedListOrderNotExists() throws Exception {
        mockMvc.perform(get("/buyers/users/{userid}/followed/list", 11)
                        .param("order", "")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())

                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No se ha ingresado una opción de ordenamiento válida"));
    }
}