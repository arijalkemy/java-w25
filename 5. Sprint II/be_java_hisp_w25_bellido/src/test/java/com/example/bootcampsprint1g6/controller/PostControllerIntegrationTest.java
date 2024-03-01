package com.example.bootcampsprint1g6.controller;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.util.DateFormatter;
import com.example.bootcampsprint1g6.util.PostTestGenerator;
import com.example.bootcampsprint1g6.util.mapper.ProductMapper;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    public static void setUpWriter(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("IT Post - Create post OK")
    public void createPostTestOk() throws Exception {
        ProductDTO product = ProductMapper.getInstance(PostTestGenerator.getTestProduct());
        PostRequestDTO postRequestDTO = new PostRequestDTO(1, "10-10-2023",
                product, 123, 500.00);

        PostResponseDTO postResponseDTO = new PostResponseDTO(1, 0, "10-10-2023", product, 123, 500.00 );

        String jsonPayload = writer.writeValueAsString(postRequestDTO);
        String expectedResponse = writer.writeValueAsString(postResponseDTO);

        MvcResult mvcResult = mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("IT Post - Create post invalid date")
    public void createPostTestBadRequestExceptionInvalidDate() throws Exception {
        ProductDTO product = ProductMapper.getInstance(PostTestGenerator.getTestProduct());
        PostRequestDTO postRequestDTO = new PostRequestDTO(1, "10-10-2025",
                product, 123, 500.00);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = writer.writeValueAsString(postRequestDTO);
        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("Datos incorrectos en la solicitud"));

    }

    @Test
    @DisplayName("IT Post - Create post user doesnt exists")
    public void createPostTestNotFoundException() throws Exception {
        Integer userId = 999;
        ProductDTO product = ProductMapper.getInstance(PostTestGenerator.getTestProduct());
        PostRequestDTO postRequestDTO = new PostRequestDTO(userId, "10-10-2023",
                product, 123, 500.00);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = writer.writeValueAsString(postRequestDTO);
        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value("404"))
                .andExpect(jsonPath("$.message").value("No se puede crear el post ya que el usuario con id " + userId + " no existe."));

    }

    @Test
    @DisplayName("IT Post - Create post user is not a seller")
    public void createPostTestBadRequestExceptionUserIsABuyer() throws Exception {
        Integer userId = 4;
        ProductDTO product = ProductMapper.getInstance(PostTestGenerator.getTestProduct());
        PostRequestDTO postRequestDTO = new PostRequestDTO(userId, "10-10-2023",
                product, 123, 500.00);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = writer.writeValueAsString(postRequestDTO);
        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("El usuario no es un vendedor. No se puede concretar la operación."));

    }

    @Test
    @DisplayName("IT Post - Create post incorrect method")
    public void createPostMethodNotAllowed() throws Exception {

        mockMvc.perform(get("/api/products/post"))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("405"))
                .andExpect(jsonPath("$.message").value("Metodo no soportado"));
    }

    @Test
    @DisplayName("IT Post - Create post user id is not numeric")
    public void createPostMessageNotReadableException() throws Exception {
        String jsonPayload = "{\n" +
                "    \"user_id\": \"aaa\",\n" +
                "    \"date\": \"17-02-2024\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 23,\n" +
                "        \"product_name\": \"camisa a rayas\",\n" +
                "        \"type\": \"indumentaria\",\n" +
                "        \"brand\": \"sarkany\",\n" +
                "        \"color\": \"rojo\",\n" +
                "        \"notes\": \"unico color, puro algodon\"\n" +
                "    },\n" +
                "    \"category\": 123,\n" +
                "    \"price\": 23.4\n" +
                "}";
        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("Error en el tipo de datos enviados"));


    }

    @Test
    @DisplayName("IT Post - Create post endpoint not found")
    public void createPostEndpointNotFoundException() throws Exception {
        String jsonPayload = "{\n" +
                "    \"user_id\": \"1\",\n" +
                "    \"date\": \"17-02-2024\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 23,\n" +
                "        \"product_name\": \"camisa a rayas\",\n" +
                "        \"type\": \"indumentaria\",\n" +
                "        \"brand\": \"sarkany\",\n" +
                "        \"color\": \"rojo\",\n" +
                "        \"notes\": \"unico color, puro algodon\"\n" +
                "    },\n" +
                "    \"category\": 123,\n" +
                "    \"price\": 23.4\n" +
                "}";
        mockMvc.perform(post("/api/products/newPost")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("404"))
                .andExpect(jsonPath("$.message").value("Endpoint inexistente"));


    }

    @Test
    @DisplayName("IT Post - Create post invalid date format")
    public void createPostMethodArgumentNotValidException() throws Exception {
        String jsonPayload = "{\n" +
                "    \"user_id\": \"1\",\n" +
                "    \"date\": \"17-02-202a\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 23,\n" +
                "        \"product_name\": \"camisa a rayas\",\n" +
                "        \"type\": \"indumentaria\",\n" +
                "        \"brand\": \"sarkany\",\n" +
                "        \"color\": \"rojo\",\n" +
                "        \"notes\": \"unico color, puro algodon\"\n" +
                "    },\n" +
                "    \"category\": 123,\n" +
                "    \"price\": 23.4\n" +
                "}";
        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("Formato de fecha incorrecto"));


    }

    @Test
    @DisplayName("IT Post - Create post product is null")
    public void createPostNullPointerException() throws Exception {
        String jsonPayload = "{\n" +
                "    \"user_id\": \"1\",\n" +
                "    \"date\": \"17-02-2024\",\n" +
                "    \"product\": null,\n" +
                "    \"category\": 123,\n" +
                "    \"price\": 23.4\n" +
                "}";
        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("Atributos faltantes, por favor verifique la información enviada."));
    }


    @Test
    @DisplayName("IT Post - Get last posts Ok")
    public void getLastPostWeekTestOk() throws Exception{
        ProductDTO product = ProductMapper.getInstance(PostTestGenerator.getTestProduct());
        PostRequestDTO postOneWeekAgo = new PostRequestDTO(1,  DateFormatter.parseDateLocalDate(LocalDate.now().minusWeeks(1)),
                product, 123, 500.00);
        PostRequestDTO postTwoWeeksAgo = new PostRequestDTO(1,  DateFormatter.parseDateLocalDate(LocalDate.now().minusWeeks(2)),
                product, 123, 500.00);
        PostRequestDTO postToday = new PostRequestDTO(1,  DateFormatter.parseDateLocalDate(LocalDate.now()),
                product, 123, 500.00);

        PostListDTO expectedResponse = new PostListDTO(4, List.of(
                new PostResponseDTO(1, 0, DateFormatter.parseDateLocalDate(LocalDate.now()), product, 123, 500.00),
                new PostResponseDTO(1, 1, DateFormatter.parseDateLocalDate(LocalDate.now().minusWeeks(1)), product, 123, 500.00)
        ));

        mockMvc.perform(post("/api/products/post").contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(postToday)));
        mockMvc.perform(post("/api/products/post").contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(postOneWeekAgo)));
        mockMvc.perform(post("/api/products/post").contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(postTwoWeeksAgo)));

        MvcResult response = mockMvc.perform(get("/api/products/followed/{userId}/list", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(writer.writeValueAsString(expectedResponse), response.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("IT Post - Get last posts ascendant order Ok")
    public void getLastPostWeekTestOrderAscOk() throws Exception{
        ProductDTO product = ProductMapper.getInstance(PostTestGenerator.getTestProduct());
        PostRequestDTO postOneWeekAgo = new PostRequestDTO(1,  DateFormatter.parseDateLocalDate(LocalDate.now().minusWeeks(1)),
                product, 123, 500.00);
        PostRequestDTO postTwoWeeksAgo = new PostRequestDTO(1,  DateFormatter.parseDateLocalDate(LocalDate.now().minusWeeks(2)),
                product, 123, 500.00);
        PostRequestDTO postToday = new PostRequestDTO(1,  DateFormatter.parseDateLocalDate(LocalDate.now()),
                product, 123, 500.00);

        PostListDTO expectedResponse = new PostListDTO(4, List.of(
                new PostResponseDTO(1, 1, DateFormatter.parseDateLocalDate(LocalDate.now().minusWeeks(1)), product, 123, 500.00),
                new PostResponseDTO(1, 0, DateFormatter.parseDateLocalDate(LocalDate.now()), product, 123, 500.00)
        ));

        mockMvc.perform(post("/api/products/post").contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(postToday)));
        mockMvc.perform(post("/api/products/post").contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(postOneWeekAgo)));
        mockMvc.perform(post("/api/products/post").contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(postTwoWeeksAgo)));

        MvcResult response = mockMvc.perform(get("/api/products/followed/{userId}/list?order=date_asc", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(writer.writeValueAsString(expectedResponse), response.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("IT Post - Get last posts unsupported order")
    public void getLastPostWeekTestInvalidOrder() throws Exception{
        ProductDTO product = ProductMapper.getInstance(PostTestGenerator.getTestProduct());
        PostRequestDTO postOneWeekAgo = new PostRequestDTO(1,  DateFormatter.parseDateLocalDate(LocalDate.now().minusWeeks(1)),
                product, 123, 500.00);
        PostRequestDTO postTwoWeeksAgo = new PostRequestDTO(1,  DateFormatter.parseDateLocalDate(LocalDate.now().minusWeeks(2)),
                product, 123, 500.00);
        PostRequestDTO postToday = new PostRequestDTO(1,  DateFormatter.parseDateLocalDate(LocalDate.now()),
                product, 123, 500.00);

        mockMvc.perform(post("/api/products/post").contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(postToday)));
        mockMvc.perform(post("/api/products/post").contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(postOneWeekAgo)));
        mockMvc.perform(post("/api/products/post").contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(postTwoWeeksAgo)));

        mockMvc.perform(get("/api/products/followed/{userId}/list?order=date_random", 4))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("El parámetro de ordenamiento no es correcto"));

    }

}

