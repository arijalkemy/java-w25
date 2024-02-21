package com.sfritz.concesionariaautos.dtos.response;

import java.util.Date;
import java.util.List;

import com.sfritz.concesionariaautos.dtos.ServiceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FullResponseCarDto {

    private Long id;
    private String brand;
    private String model;
    private Date manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<ServiceDto> services;
    private Integer countOfOwners;
}
