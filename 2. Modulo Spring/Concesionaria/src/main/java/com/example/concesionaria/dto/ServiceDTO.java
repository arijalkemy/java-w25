package com.example.concesionaria.dto;

import com.example.concesionaria.entity.ServiceE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceDTO {
  private String date;
  private String kilometers;
  private String descriptions;

  public ServiceDTO(ServiceE s) {
    this.date = s.getDate().toString();
    this.kilometers = s.getKilometers().toString();
    this.descriptions = s.getDescriptions();
  }
}
