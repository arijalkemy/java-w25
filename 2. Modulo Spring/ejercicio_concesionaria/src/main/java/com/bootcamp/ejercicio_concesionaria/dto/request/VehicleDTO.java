package com.bootcamp.ejercicio_concesionaria.dto.request;

import com.bootcamp.ejercicio_concesionaria.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometes;
    private int doors;
    private int price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;
}
