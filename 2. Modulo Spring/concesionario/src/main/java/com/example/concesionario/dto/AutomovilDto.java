package com.example.concesionario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AutomovilDto {
    private int id;
    private String brand;
    private Date manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;
}
