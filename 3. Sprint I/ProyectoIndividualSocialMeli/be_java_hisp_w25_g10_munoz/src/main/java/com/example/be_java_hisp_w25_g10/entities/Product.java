package com.example.be_java_hisp_w25_g10.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private int category;
    private double price;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private double discount;
    private boolean hasPromo;

    public boolean getHasPromo() {
        return this.hasPromo;
    }

}

