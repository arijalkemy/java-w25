package com.bootcamp.ejercicio_concesionaria.dto.response;

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
public class VehicleWithoutServiceDTO {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometes;
    private int doors;
    private int price;
    private String currency;
    private int countOfOwners;
}
