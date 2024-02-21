package com.example.concesionario.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Automovil {
    public int id;
    public String brand;
    public Date manufacturingDate;
    public int numberOfKilometers;
    public int doors;
    public double price;
    public String currency;
    public List<Service> services;
    public int countOfOwners;
}
