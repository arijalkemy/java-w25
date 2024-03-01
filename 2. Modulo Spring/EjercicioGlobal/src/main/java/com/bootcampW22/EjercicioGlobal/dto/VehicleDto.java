package com.bootcampW22.EjercicioGlobal.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto
    {
        private String brand;
        private Long id;
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
