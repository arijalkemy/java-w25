package com.mercadolibre.concesionaria_de_autos.dto.response;

import com.mercadolibre.concesionaria_de_autos.model.Service;
import com.mercadolibre.concesionaria_de_autos.model.Vehicle;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
@Builder
@Getter
public class VehicleResponseDto {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    List<Service> services;
    private int countOfOwners;

    public static VehicleResponseDto fromVehicle(Vehicle vehicle) {
        return VehicleResponseDto.builder()
                .id(vehicle.getId())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .manufacturingDate(vehicle.getManufacturingDate())
                .numberOfKilometers(vehicle.getNumberOfKilometers())
                .doors(vehicle.getDoors())
                .price(vehicle.getPrice())
                .currency(vehicle.getCurrency())
                .services(vehicle.getServices())
                .countOfOwners(vehicle.getCountOfOwners())
                .build();
    }
}
