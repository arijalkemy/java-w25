package com.example.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
  private Integer id;
  private String brand;
  private String model;
  private LocalDate manufacturingDate;
  private Integer numberOfKilometers;
  private Integer doors;
  private Double price;
  private String currency;
  private List<ServiceE> services;
  private Integer countOfOwners;
}
