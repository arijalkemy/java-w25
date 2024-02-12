package com.mercadolibre.concesionaria_de_autos.dto.response;

import com.mercadolibre.concesionaria_de_autos.model.Vehicle;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class VehicleResponseWithoutServicesDto {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    private int countOfOwners;
    public static VehicleResponseWithoutServicesDto fromVehicle(Vehicle vehicle) {
        return VehicleResponseWithoutServicesDto.builder()
                .id(vehicle.getId())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .manufacturingDate(vehicle.getManufacturingDate())
                .numberOfKilometers(vehicle.getNumberOfKilometers())
                .doors(vehicle.getDoors())
                .price(vehicle.getPrice())
                .currency(vehicle.getCurrency())
                .countOfOwners(vehicle.getCountOfOwners())
                .build();
    }
}
