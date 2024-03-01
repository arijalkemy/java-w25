package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.Integration;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void createPostIntegrationTest() throws Exception {
    PostDTO postDto = new PostDTO(21, LocalDate.parse("2024-01-03"),
        new ProductDTO(1,"Silla Gamer", "Gamer", "Razer", "Negro", "Comoda"),
        1, 1000000D);

    mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
        .contentType(MediaType.APPLICATION_JSON)
        .content(serializePost(postDto)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(21));
  }
  @Test
  void getPostPerSellerIntegrationTest() throws Exception {
    PostDTO postDto = new PostDTO(21, LocalDate.now(),
        new ProductDTO(2,"Silla Gamer", "Gamer", "Razer", "Negro", "Comoda"),
        1, 1000000D);

    mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 21));
    mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
        .contentType(MediaType.APPLICATION_JSON)
        .content(serializePost(postDto)));

    mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"));
  }
  private String serializePost(PostDTO postDto) throws JsonProcessingException {
    ObjectWriter ow = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

    return ow.writeValueAsString(postDto);
  }
}
