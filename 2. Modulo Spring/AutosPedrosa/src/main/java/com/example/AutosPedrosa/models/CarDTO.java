package com.example.AutosPedrosa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {

    private Long id;
    private String brand;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufacturingDate;
    private String numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
    private List<Service> services;

}
