package org.example.cardeale.entity.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private String brand;
    private String model;
    private LocalDate mafufactturingDate;
    private int numberOfKilometers;
    private int doors;
    private float price;
    private String currenciy;
    private Service service;
    private int countOfOwners;
}
