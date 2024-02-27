package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoomDTO {
  private String name;
  private Integer width;
  private Integer length;

  public RoomDTO(String name, Integer width, Integer length) {
    this.name = name;
    this.width = width;
    this.length = length;
  }

  public RoomDTO() {
  }

  public Integer getSquareFeet() {
    Integer result = 0;
    if(this.width != null && this.length != null)
      result = this.width * this.length;
    return result;
  }
}
