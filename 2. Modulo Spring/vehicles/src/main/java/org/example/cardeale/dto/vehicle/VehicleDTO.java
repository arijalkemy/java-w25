package org.example.cardeale.dto.vehicle;

import org.example.cardeale.entity.vehicle.Service;

import java.time.LocalDate;

public record VehicleDTO(String brand, String model, LocalDate manufacturingDate, int numberOfKilometers,
                         int door, float price, String currency, Service service, int countOfOwners){}
