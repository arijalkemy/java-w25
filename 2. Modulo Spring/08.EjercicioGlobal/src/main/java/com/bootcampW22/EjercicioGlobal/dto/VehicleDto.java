package com.bootcampW22.EjercicioGlobal.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VehicleDto{
    Long id;
    String brand;
    String model;
    String registration;
    String color;
    Integer year;
    String max_speed;
    Integer passengers;
    String fuel_type;
    String transmission;
    Double length;
    Double width;
    Double weight;

}
