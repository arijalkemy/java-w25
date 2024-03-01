package org.example.carselling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.carselling.entity.Car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDTO {
    private String brand;
    private String model;
    private Date manufacturingDate;
    private Double numberOfKilometers;
    private int doors;
    private Double price;
    private String currency;
    private List<ServiceDTO> services;
    private int countOfOwners;

    public CarDTO(Car car) {
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        car.getServicesList().forEach(x -> serviceDTOList.add(new ServiceDTO(x.getDate(), x.getKilometers(), x.getDescriptions())));
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.manufacturingDate = car.getManufacturingDate();
        this.numberOfKilometers = car.getNumberOfKilometers();
        this.doors = car.getDoors();
        this.price = car.getPrice();
        this.currency = car.getCurrency();
        this.services = serviceDTOList;
        this.countOfOwners = car.getCountOfOwners();
    }
}
