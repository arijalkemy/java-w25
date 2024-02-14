package com.mercadolibre.concesionaria_de_autos.service.impl;

import com.mercadolibre.concesionaria_de_autos.dto.request.VehiclePostDto;
import com.mercadolibre.concesionaria_de_autos.dto.response.VehicleResponseDto;
import com.mercadolibre.concesionaria_de_autos.dto.response.VehicleResponseWithoutServicesDto;
import com.mercadolibre.concesionaria_de_autos.exceptions.NotFoundException;
import com.mercadolibre.concesionaria_de_autos.model.Vehicle;
import com.mercadolibre.concesionaria_de_autos.repository.CrudRepository;
import com.mercadolibre.concesionaria_de_autos.service.IVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService implements IVehicleService {
    private final CrudRepository<Vehicle> vehicleRepository;

    @Override
    public VehicleResponseDto createVehicle(VehiclePostDto vehiclePostDto) {
        return VehicleResponseDto.fromVehicle(vehicleRepository.save(vehiclePostDto.toVehicle()));
    }

    @Override
    public List<VehicleResponseWithoutServicesDto> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        if(vehicles.isEmpty()) {
            throw new NotFoundException("No vehicles found");
        }
        return vehicles.stream().map(VehicleResponseWithoutServicesDto::fromVehicle).toList();
    }

    @Override
    public List<VehicleResponseDto> getVehiclesByDateRange(LocalDate startDate, LocalDate endDate) {
        List<VehicleResponseDto> vehiclesWithinRange = vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getManufacturingDate().isAfter(startDate) && vehicle.getManufacturingDate().isBefore(endDate)).map(VehicleResponseDto::fromVehicle).toList();
        if(vehiclesWithinRange.isEmpty()) {
            throw new NotFoundException("No vehicles found within date range");
        }
        return vehiclesWithinRange;
    }

    @Override
    public List<VehicleResponseDto> getVehiclesByPriceRange(int startPrice, int endPrice) {
        List<VehicleResponseDto> vehiclesWithinRange = vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getPrice() >= startPrice && vehicle.getPrice() <= endPrice).map(VehicleResponseDto::fromVehicle).toList();
        if(vehiclesWithinRange.isEmpty()) {
            throw new NotFoundException("No vehicles found within price range");
        }
        return vehiclesWithinRange;
    }

    @Override
    public VehicleResponseDto getVehicle(Long id) {
        return vehicleRepository.findById(id).map(VehicleResponseDto::fromVehicle)
                .orElseThrow(() -> new NotFoundException("Vehicle not found"));
    }
}
