package com.example.concesionaria.dto.response;

import com.example.concesionaria.dto.ServiceDTO;
import com.example.concesionaria.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompleteVehicleDTO {
  private String id;
  private String brand;
  private String model;
  private String manufacturingDate;
  private String numberOfKilometers;
  private String doors;
  private String price;
  private String currency;
  private List<ServiceDTO> services;
  private String countOfOwners;

  public CompleteVehicleDTO(Vehicle v) {
    this.id = v.getId().toString();
    this.brand = v.getBrand();
    this.model = v.getModel();
    this.manufacturingDate = v.getManufacturingDate().toString();
    this.numberOfKilometers = v.getNumberOfKilometers().toString();
    this.doors = v.getDoors().toString();
    this.price = v.getPrice().toString();
    this.currency = v.getCurrency();
    this.countOfOwners = v.getCountOfOwners().toString();
    this.services = v.getServices().stream().map(ServiceDTO::new).toList();
  }
}
