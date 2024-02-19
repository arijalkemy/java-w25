package com.bootcampW22.EjercicioGlobal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public record VehicleDto(
    Long id,
    String brand,
    String model,
    String registration,
    String color,
    Integer year,
    String max_speed,
    Integer passengers,
    String fuel_type,
    String transmission,
    Double length,
    Double width,
    Double weight
    ){
}
