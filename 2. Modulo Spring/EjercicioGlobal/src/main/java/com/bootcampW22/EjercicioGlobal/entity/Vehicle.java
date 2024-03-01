package com.bootcampW22.EjercicioGlobal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Comparator;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
    public static Comparator<Vehicle> idComparator = Comparator.comparing(Vehicle::getId);

    public Vehicle(Long id) {
        this.id=id;
    }
}
