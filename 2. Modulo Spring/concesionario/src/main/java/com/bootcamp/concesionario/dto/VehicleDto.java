package com.bootcamp.concesionario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private int idVehicle;
    private String brand;
    private String model;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private double price;

}
