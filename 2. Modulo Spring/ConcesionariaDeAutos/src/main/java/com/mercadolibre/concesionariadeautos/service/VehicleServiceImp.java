package com.mercadolibre.concesionariadeautos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.concesionariadeautos.dto.*;
import com.mercadolibre.concesionariadeautos.entity.Vehicle;
import com.mercadolibre.concesionariadeautos.exception.NotFoundException;
import com.mercadolibre.concesionariadeautos.exception.ResourceAlreadyExistsException;
import com.mercadolibre.concesionariadeautos.repository.IVehicleRepository;
import com.mercadolibre.concesionariadeautos.repository.VehicleRepositoryImp;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImp implements IVehicleService {
    IVehicleRepository vehicleRepository;
    ObjectMapper mapper = new ObjectMapper();

    public VehicleServiceImp(VehicleRepositoryImp vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleIdDTO addVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicleFound = vehicleRepository.getVehicleById(vehicleDTO.getId());
        if (vehicleFound != null) {
            throw new ResourceAlreadyExistsException("Ya existe un vehículo con ese ID.");
        }
        vehicleRepository.addVehicle(mapper.convertValue(vehicleDTO, Vehicle.class));
        return mapper.convertValue(vehicleDTO.getId(), VehicleIdDTO.class);
    }

    @Override
    public List<VehicleWithoutServicesDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.getAllVehicles();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No hay vehículos en el sistema.");
        }
        return vehicles.stream()
                .map(v -> new VehicleWithoutServicesDTO(
                        v.getId(),
                        v.getBrand(),
                        v.getModel(),
                        v.getManufacturingDate(),
                        v.getNumberOfKilometers(),
                        v.getDoors(),
                        v.getPrice(),
                        v.getCurrency(),
                        v.getCountOfOwners()))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO getVehicleById(VehicleIdDTO vehicleIdDTO) {
        Vehicle vehicle = vehicleRepository.getVehicleById(vehicleIdDTO.getId());
        if (vehicle == null) {
            throw new NotFoundException("No existe ningún vehículo con ese ID.");
        }
        return mapper.convertValue(vehicle, VehicleDTO.class);
    }

    @Override
    public List<VehicleDTO> getVehiclesBetweenDate(DateFilterDTO dateFilterDTO) {
        List<Vehicle> vehicles = vehicleRepository.getAllVehicles();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No hay vehículos en el sistema.");
        }
        List<Vehicle> vehicleList = vehicles.stream()
                .filter(v -> v.getManufacturingDate().isAfter(dateFilterDTO.getSince()) && v.getManufacturingDate().isBefore(dateFilterDTO.getTo()))
                .toList();
        return vehicleList.stream()
                .map(v -> new VehicleDTO(
                        v.getId(),
                        v.getBrand(),
                        v.getModel(),
                        v.getManufacturingDate(),
                        v.getNumberOfKilometers(),
                        v.getDoors(),
                        v.getPrice(),
                        v.getCurrency(),
                        v.getServices(),
                        v.getCountOfOwners()))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> getVehiclesBetweenPrice(PriceFilterDTO priceFilterDTO) {
        List<Vehicle> vehicles = vehicleRepository.getAllVehicles();
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No hay vehículos en el sistema.");
        }
        List<Vehicle> vehicleList = vehicles.stream()
                .filter(v -> v.getPrice() >= (priceFilterDTO.getSince()) && v.getPrice() <= (priceFilterDTO.getTo()))
                .toList();
        return vehicleList.stream()
                .map(v -> new VehicleDTO(
                        v.getId(),
                        v.getBrand(),
                        v.getModel(),
                        v.getManufacturingDate(),
                        v.getNumberOfKilometers(),
                        v.getDoors(),
                        v.getPrice(),
                        v.getCurrency(),
                        v.getServices(),
                        v.getCountOfOwners()))
                .collect(Collectors.toList());
    }
}
