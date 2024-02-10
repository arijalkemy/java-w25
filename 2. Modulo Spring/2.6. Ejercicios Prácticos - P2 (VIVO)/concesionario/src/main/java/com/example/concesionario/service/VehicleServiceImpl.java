package com.example.concesionario.service;

import com.example.concesionario.dto.VehicleServiceDTO;
import com.example.concesionario.dto.CreateVehicleDTO;
import com.example.concesionario.dto.VehicleDTO;
import com.example.concesionario.dto.VehicleNoServicesDTO;
import com.example.concesionario.entity.Vehicle;
import com.example.concesionario.entity.VehicleService;
import com.example.concesionario.repository.IVehicleRepo;
import com.example.concesionario.repository.VehicleRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService{
    private final IVehicleRepo vehicleRepo;

    @Autowired
    public VehicleServiceImpl(VehicleRepoImpl vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public void createVehicle(CreateVehicleDTO createVehicleDTO) {
        Vehicle vehicle = new Vehicle(
            createVehicleDTO.getBrand(),
            createVehicleDTO.getModel(),
            LocalDate.parse(createVehicleDTO.getManufacturingDate(), DateTimeFormatter.ISO_DATE),
            Integer.parseInt(createVehicleDTO.getNumberOfKilometers()),
            Integer.parseInt(createVehicleDTO.getDoors()),
            Integer.parseInt(createVehicleDTO.getPrice()),
            createVehicleDTO.getCurrency(),
            createVehicleDTO.getServices().stream()
                .map(service -> new VehicleService(
                    LocalDate.parse(service.getDate(), DateTimeFormatter.ISO_DATE),
                    Integer.parseInt(service.getKilometers()),
                    service.getDescriptions()
                ))
                .toList(),
            Integer.parseInt(createVehicleDTO.getCountOfOwners())
        );
        vehicleRepo.saveVehicle(vehicle);
    }

    @Override
    public List<VehicleNoServicesDTO> getVehicles() {
        List<Vehicle> vehicles = vehicleRepo.readVehicles();
        return vehicles.stream()
            .map(vehicle -> new VehicleNoServicesDTO(
                vehicle.getId().toString(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate().format(DateTimeFormatter.ISO_DATE),
                vehicle.getNumberOfKilometers().toString(),
                vehicle.getDoors().toString(),
                vehicle.getPrice().toString(),
                vehicle.getCurrency(),
                vehicle.getCountOfOwners().toString()
            ))
            .toList();
    }

    @Override
    public List<VehicleNoServicesDTO> getVehiclesByDate(String sinceDate, String toDate) {
        List<Vehicle> vehicles = vehicleRepo.readVehicles();
        return vehicles.stream()
            .filter(vehicle -> vehicle.getManufacturingDate().isAfter(LocalDate.parse(sinceDate, DateTimeFormatter.ISO_DATE))
                && vehicle.getManufacturingDate().isBefore(LocalDate.parse(toDate, DateTimeFormatter.ISO_DATE)))
            .map(vehicle -> new VehicleNoServicesDTO(
                vehicle.getId().toString(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate().format(DateTimeFormatter.ISO_DATE),
                vehicle.getNumberOfKilometers().toString(),
                vehicle.getDoors().toString(),
                vehicle.getPrice().toString(),
                vehicle.getCurrency(),
                vehicle.getCountOfOwners().toString()
            ))
            .toList();
    }

    @Override
    public List<VehicleNoServicesDTO> getVehiclesByPrice(String sincePrice, String toPrice) {
        List<Vehicle> vehicles = vehicleRepo.readVehicles();
        return vehicles.stream()
            .filter(vehicle -> vehicle.getPrice() > Integer.parseInt(sincePrice)
                && vehicle.getPrice() < Integer.parseInt(toPrice))
            .map(vehicle -> new VehicleNoServicesDTO(
                vehicle.getId().toString(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate().format(DateTimeFormatter.ISO_DATE),
                vehicle.getNumberOfKilometers().toString(),
                vehicle.getDoors().toString(),
                vehicle.getPrice().toString(),
                vehicle.getCurrency(),
                vehicle.getCountOfOwners().toString()
            ))
            .toList();
    }

    @Override
    public VehicleDTO getVehicleById(String id) {
        List<Vehicle> vehicles = vehicleRepo.readVehicles();
        return vehicles.stream()
            .filter(vehicle -> vehicle.getId().equals(Integer.parseInt(id)))
            .map(vehicle -> new VehicleDTO(
                vehicle.getId().toString(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate().format(DateTimeFormatter.ISO_DATE),
                vehicle.getNumberOfKilometers().toString(),
                vehicle.getDoors().toString(),
                vehicle.getPrice().toString(),
                vehicle.getCurrency(),
                vehicle.getServices().stream()
                    .map(service -> new VehicleServiceDTO(
                        service.getDate().format(DateTimeFormatter.ISO_DATE),
                        service.getKilometers().toString(),
                        service.getDescriptions()
                    ))
                    .toList(),
                vehicle.getCountOfOwners().toString()
            ))
            .findFirst()
            .orElse(null);
    }
}
