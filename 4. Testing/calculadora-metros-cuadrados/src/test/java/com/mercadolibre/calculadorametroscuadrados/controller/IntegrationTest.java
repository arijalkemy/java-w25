package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.util.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectFactory objectFactory = new ObjectFactory();
    private ObjectWriter objectWriter = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();;

    @Test
    void calculateOneRoomHouse() throws Exception {
        HouseDTO house = objectFactory.getOneRoomHouse();
        String request =
                createRequestFrom(house);

        RoomDTO firstRoom = house.getRooms().get(0);
        String expectedRoomName = firstRoom.getName();
        Integer expectedSquareFeet = objectFactory.getOneRoomHouseSquareFeet();
        mockMvc
                .perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rooms[0].name").value(expectedRoomName))
                .andExpect(jsonPath("$.squareFeet").value(expectedSquareFeet))
                .andReturn();
    }

    @Test
    void calculateMultipleRoomHouse() throws Exception {
        //ARRANGE
        HouseDTO house = objectFactory.getMultipleRoomHouse();
        String request =
                createRequestFrom(house);
        HouseResponseDTO expectedResponse = getHouseResponseDTOFrom(house);

        //ACT
        MvcResult result = mockMvc
                .perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //ASSERT
        result.getResponse().setCharacterEncoding("UTF-8");
        assertThat(result.getResponse().getContentAsString())
                .isEqualTo(objectWriter.writeValueAsString(expectedResponse));
    }

    private HouseResponseDTO getHouseResponseDTOFrom(HouseDTO house) {
        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);

        int expectedPrice = objectFactory.getMultipleRoomHousePrice();
        int expectedSquareFeet = objectFactory.getMultipleRoomHouseSquareFeet();
        RoomDTO expectedBiggestRoom = objectFactory.getMultipleRoomHouseBiggestRoom();
        expectedResponse.setBiggest(expectedBiggestRoom);
        expectedResponse.setPrice(expectedPrice);
        expectedResponse.setSquareFeet(expectedSquareFeet);
        return expectedResponse;
    }

    private String createRequestFrom(HouseDTO house) {
        String request =
                "{" +
                        "\"name\":" + "\"" + house.getName() + "\"" + ", " +
                        "\"address\":" + "\"" + house.getAddress() + "\"" + ", " +
                        "\"rooms\": [" +
                        "%s" +
                        "]" +
                        "}";
        String stringRooms = getStringRooms(house);
        return String.format(request, stringRooms);
    }

    private String getStringRooms(HouseDTO house) {
        List<RoomDTO> rooms = house.getRooms();

        int i = 0;
        StringBuilder stringRooms = new StringBuilder();

        while (i < rooms.size()) {
            RoomDTO currentRoom = rooms.get(i);
            stringRooms.append(
                    getRoom(
                            currentRoom.getName(),
                            currentRoom.getWidth(),
                            currentRoom.getLength()
                    )
            );
            if (i != rooms.size() - 1) {
                stringRooms.append(", ");
            }
            i++;
        }
        return stringRooms.toString();
    }

    private String getRoom(String name, int width, int length) {
        return
                "{" +
                        "\"name\"" + ":" + "\"" + name + "\"" + ", " +
                        "\"width\"" + ":" + width + ", " +
                        "\"length\"" + ":" + length +
                        "}";
    }

}
