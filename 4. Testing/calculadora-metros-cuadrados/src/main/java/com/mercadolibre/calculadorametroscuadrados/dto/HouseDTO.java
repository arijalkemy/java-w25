package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class HouseDTO {
  private String name;
  private String address;
  private List<RoomDTO> rooms;

  public HouseDTO(String name, String address, List<RoomDTO> rooms) {
    this.name = name;
    this.address = address;
    this.rooms = rooms;
  }

  public HouseDTO() {

  }

}
