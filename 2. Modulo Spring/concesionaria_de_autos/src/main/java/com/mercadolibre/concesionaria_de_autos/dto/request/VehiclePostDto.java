package com.mercadolibre.concesionaria_de_autos.dto.request;

import com.mercadolibre.concesionaria_de_autos.model.Service;
import com.mercadolibre.concesionaria_de_autos.model.Vehicle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Builder
@Getter
@Setter
public class VehiclePostDto {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;
    public Vehicle toVehicle() {
        return Vehicle.builder()
                .brand(this.getBrand())
                .model(this.getModel())
                .manufacturingDate(this.getManufacturingDate())
                .numberOfKilometers(this.getNumberOfKilometers())
                .doors(this.getDoors())
                .price(this.getPrice())
                .currency(this.getCurrency())
                .services(this.getServices())
                .countOfOwners(this.getCountOfOwners())
                .build();
    }
}
