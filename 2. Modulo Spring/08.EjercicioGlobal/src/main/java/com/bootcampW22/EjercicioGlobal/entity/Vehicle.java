package com.bootcampW22.EjercicioGlobal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private String registration;
    private String color;
    private Integer year;
    private String max_speed;
    private Integer passengers;
    private String fuel_type;
    private String transmission;
    private Double length;
    private Double width;
    private Double weight;
}
