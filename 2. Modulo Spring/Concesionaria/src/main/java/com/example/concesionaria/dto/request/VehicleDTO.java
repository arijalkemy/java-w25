package com.example.concesionaria.dto.request;

import com.example.concesionaria.dto.ServiceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
  private String brand;
  private String model;
  private String manufacturingDate;
  private String numberOfKilometers;
  private String doors;
  private String price;
  private String currency;
  private List<ServiceDTO> services;
  private String countOfOwners;
}
