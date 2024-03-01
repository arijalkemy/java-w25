package org.socialmeli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.response.ProductDto;
import org.socialmeli.entity.Client;
import org.socialmeli.entity.Vendor;
import org.socialmeli.util.ObjectFactory;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class IntegrationTest {

        @Autowired
        private MockMvc mockMvc;

        ObjectFactory objectFactory = new ObjectFactory();

        @Test
        @DisplayName("/products/post -> Happy path")
        public void createPostOkTest() throws Exception {
                Integer postId = 1;
                ProductDto productDto = new ProductDto(1, "name 1", "type 1", "brand 1", "color 1", "notes 1");
                PostReqDto postReqDto = new PostReqDto(postId, LocalDate.now(), productDto, 1, 100.00);
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonReq;
                try {
                        jsonReq = objectMapper.writeValueAsString(postReqDto);
                } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return;
                }
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonReq))
                                .andDo(print())
                                .andExpect(status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$").value(postId));
        }

        @Test
        @DisplayName("/products/post -> Sad path: La fecha no puede estar vacía")
        public void createPostInvalidDateTest() throws Exception {
                Integer postId = 1;
                ProductDto productDto = new ProductDto(1, "name 1", "type 1", "brand 1", "color 1", "notes 1");
                PostReqDto postReqDto = new PostReqDto(postId, null, productDto, 1, 100.00);
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonReq;
                try {
                        jsonReq = objectMapper.writeValueAsString(postReqDto);
                } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return;
                }
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonReq))
                                .andDo(print())
                                .andExpect(status().isBadRequest());
        }

        @Test
        @DisplayName("/products/post -> Sad path: El precio no puede ser mayor a 10000000")
        public void createPostMaxPriceTest() throws Exception {
                Integer postId = 1;
                ProductDto productDto = new ProductDto(1, "name 1", "type 1", "brand 1", "color 1", "notes 1");
                PostReqDto postReqDto = new PostReqDto(postId, LocalDate.now(), productDto, 1, 100000000.00);
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonReq;
                try {
                        jsonReq = objectMapper.writeValueAsString(postReqDto);
                } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return;
                }
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonReq))
                                .andDo(print())
                                .andExpect(status().isBadRequest());
        }

        @Test
        @DisplayName("/users/{userId}/follow/{userIdToFollow} -> Sad path: Un vendedor no se puede seguir a un vendedor")
        public void followUserNotOkTest() throws Exception {
                Vendor vendor = objectFactory.getValidVendor();
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/users/{userId}/follow/{userIdToFollow}", vendor.getUserId(), vendor.getUserId())
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        @DisplayName("/users/{userId}/follow/{userIdToFollow} -> Happy path")
        public void followUserOkTest() throws Exception {
                Client client = objectFactory.getValidClient();
                Vendor vendor = objectFactory.getValidVendor();
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/users/{userId}/follow/{userIdToFollow}", client.getUserId(), vendor.getUserId())
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Vendedor seguido exitosamente"));
        }
}
