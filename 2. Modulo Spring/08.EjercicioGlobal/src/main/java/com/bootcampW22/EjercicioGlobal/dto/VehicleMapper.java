package com.bootcampW22.EjercicioGlobal.dto;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VehicleMapper {
    public static VehicleDto getInstance(Vehicle vehicle) {
        VehicleDto dto = VehicleDto.builder()
                .id(vehicle.getId())
                .brand(vehicle.getBrand())
                .color(vehicle.getColor())
                .fuel_type(vehicle.getFuel_type())
                .length(vehicle.getLength())
                .max_speed(vehicle.getMax_speed())
                .model(vehicle.getModel())
                .passengers(vehicle.getPassengers())
                .registration(vehicle.getRegistration())
                .transmission(vehicle.getTransmission())
                .weight(vehicle.getWeight())
                .width(vehicle.getWidth())
                .year(vehicle.getYear())
                .build();
        return dto;
    }

    public static List<VehicleDto> getInstances(List<Vehicle> vehicles) {
        return vehicles.stream().map(VehicleMapper::getInstance).collect(Collectors.toList());
    }

    public static Vehicle getVehicle(VehicleDto vehicleDto){
        return Vehicle.builder()
                .id(vehicleDto.getId())
                .brand(vehicleDto.getBrand())
                .color(vehicleDto.getColor())
                .fuel_type(vehicleDto.getFuel_type())
                .length(vehicleDto.getLength())
                .max_speed(vehicleDto.getMax_speed())
                .model(vehicleDto.getModel())
                .passengers(vehicleDto.getPassengers())
                .registration(vehicleDto.getRegistration())
                .transmission(vehicleDto.getTransmission())
                .weight(vehicleDto.getWeight())
                .width(vehicleDto.getWidth())
                .year(vehicleDto.getYear())
                .build();
    }
}
