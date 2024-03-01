package org.example.carselling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Car {
    private int id;
    private String brand;
    private String model;
    private Date manufacturingDate;
    private Double numberOfKilometers;
    private int doors;
    private Double price;
    private String currency;
    private List<Services> servicesList;
    private int countOfOwners;

    public Car(String brand, String model, Date manufacturingDate, Double numberOfKilometers, int doors, Double price, String currency, List<Services> servicesList, int countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.servicesList = servicesList;
        this.countOfOwners = countOfOwners;
    }
}
