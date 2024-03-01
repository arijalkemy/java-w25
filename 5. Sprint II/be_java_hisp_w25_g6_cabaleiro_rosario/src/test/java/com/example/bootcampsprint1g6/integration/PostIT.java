package com.example.bootcampsprint1g6.integration;

import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.exception.BadRequestException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

import static com.example.bootcampsprint1g6.util.DateFormatter.parseDateLocalDate;
import static com.example.bootcampsprint1g6.util.builder.Mockbuilder.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PostIT {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    // create a post
    @Test
    @DisplayName("Create post (IT) - Ok")
    void createPostOk() throws Exception {
        PostRequestDTO postDTO = buildPostRequestDTO("17-02-2024",1);
        String payloadJson = writer.writeValueAsString(postDTO);
        String expectedResponse = writer.writeValueAsString(buildPostResponseDTO());
        MvcResult response = mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();
        assertEquals(expectedResponse, response.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("Create post (IT) - No date Error")
    void createPostNoDate() throws Exception {
        PostRequestDTO postDTO = buildWrongPostRequestDTO();
        String payloadJson = writer.writeValueAsString(postDTO);
        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                        .andExpect(status().isBadRequest())
                        .andExpect(jsonPath("$.message").value("La fecha no puede estar vacía."));
    }
    //get posts from followed
    @Test
    @DisplayName("Get last posts no order (IT) - Ok")
    void getLastPostsByFollowedOk() throws Exception {
        try{
            generateSeveralPosts(4,5,8);
        }catch (Exception e){
            throw new BadRequestException("No se pudo crear el ambiente de test");
        }
        mockMvc.perform(get("/api/products/followed/{userId}/list",4)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.posts.length()").value(3))
                        .andExpect(jsonPath("$.user_id").value(4));
    }
    @Test
    @DisplayName("Get last posts (IT) - Id Error")
    void getLastPostsByFollowedIdError() throws Exception {
        mockMvc.perform(get("/api/products/followed/{userId}/list","1dsdds")
                        .contentType(MediaType.APPLICATION_JSON) )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Error en el tipo de datos de los parámetros"));
    }
    @Test
    @DisplayName("Get last posts (IT) - Order Error")
    void getLastPostsByFollowedOrderError() throws Exception {
        mockMvc.perform(get("/api/products/followed/{userId}/list?order={order}",3,"name_ascss")
                        .contentType(MediaType.APPLICATION_JSON) )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El parámetro de ordenamiento no es correcto"));
    }
    @Test
    @DisplayName("Get last posts date asc order (IT) - Ok")
    void getLastPostsByFollowedAscOk() throws Exception {
        int[] daysToSubstract = {8,4,5};
        try{
            generateSeveralPosts(daysToSubstract[0], daysToSubstract[1], daysToSubstract[2]);
        }catch (Exception e){
            throw new BadRequestException("No se pudo crear el ambiente de test");
        }
        mockMvc.perform(get("/api/products/followed/{userId}/list?order={order}",4,"date_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts.length()").value(3))
                .andExpect(jsonPath("$.posts[0].date").value(parseDateLocalDate(LocalDate.now().minusDays(daysToSubstract[0]))))
                .andExpect(jsonPath("$.posts[1].date").value(parseDateLocalDate(LocalDate.now().minusDays(daysToSubstract[2]))))
                .andExpect(jsonPath("$.posts[2].date").value(parseDateLocalDate(LocalDate.now().minusDays(daysToSubstract[1]))))
                .andExpect(jsonPath("$.user_id").value(4));
    }

    @Test
    @DisplayName("Get last posts date desc order (IT) - Ok")
    void getLastPostsByFollowedDscOk() throws Exception {
        int[] daysToSubstract = {8,4,5};
        try{
            generateSeveralPosts(daysToSubstract[0], daysToSubstract[1], daysToSubstract[2]);
        }catch (Exception e){
            throw new BadRequestException("No se pudo crear el ambiente de test");
        }
        mockMvc.perform(get("/api/products/followed/{userId}/list?order={order}",4,"date_desc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts.length()").value(3))
                .andExpect(jsonPath("$.posts[0].date").value(parseDateLocalDate(LocalDate.now().minusDays(daysToSubstract[1]))))
                .andExpect(jsonPath("$.posts[1].date").value(parseDateLocalDate(LocalDate.now().minusDays(daysToSubstract[2]))))
                .andExpect(jsonPath("$.posts[2].date").value(parseDateLocalDate(LocalDate.now().minusDays(daysToSubstract[0]))))
                .andExpect(jsonPath("$.user_id").value(4));
    }

    private void generateSeveralPosts(int daysToSubstract1, int daysToSubstract2, int daysToSubstract3) throws Exception{
        PostRequestDTO postDTO = buildPostRequestDTO(parseDateLocalDate(LocalDate.now().minusDays(daysToSubstract1)),1);
        mockMvc.perform(post("/api/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(postDTO)));
        PostRequestDTO postDTO2 = buildPostRequestDTO(parseDateLocalDate(LocalDate.now().minusDays(daysToSubstract2)),1);
        mockMvc.perform(post("/api/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(postDTO2)));
        PostRequestDTO postDTO3 = buildPostRequestDTO(parseDateLocalDate(LocalDate.now().minusDays(daysToSubstract3)),2);
        mockMvc.perform(post("/api/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(postDTO3)));
    }

}
