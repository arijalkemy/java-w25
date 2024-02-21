package com.ConcesionarioAutos.demo.dto;

import java.util.Date;

public class vehiclesDTO {
    private String brand;
    private String model;
    private Date manufactureDate;
    private Integer doors;
    private Double price;
    private String currency;

    public vehiclesDTO(String brand, String model, Date manufactureDate, Integer doors, Double price, String currency) {
        this.brand = brand;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
    }

    public vehiclesDTO() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
