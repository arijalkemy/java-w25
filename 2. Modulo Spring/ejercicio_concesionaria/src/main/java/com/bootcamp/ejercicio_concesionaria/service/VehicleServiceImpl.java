package com.bootcamp.ejercicio_concesionaria.service;

import com.bootcamp.ejercicio_concesionaria.dto.request.VehicleDTO;
import com.bootcamp.ejercicio_concesionaria.dto.response.VehicleWithoutServiceDTO;
import com.bootcamp.ejercicio_concesionaria.entity.Vehicle;
import com.bootcamp.ejercicio_concesionaria.repository.IVehicleRepository;
import com.bootcamp.ejercicio_concesionaria.repository.VehicleRepositoryImpl;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Service
public class VehicleServiceImpl implements IVehicleService{
    IVehicleRepository vehicleRepository;
    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public int addVehicle(VehicleDTO vehicleDto){
        if(vehicleDto.getManufacturingDate().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("La fecha de manufactura no es correcta");
        }
        Vehicle vehicle = new Vehicle(0, vehicleDto.getBrand(), vehicleDto.getModel(),vehicleDto.getManufacturingDate(), vehicleDto.getNumberOfKilometes(), vehicleDto.getDoors(), vehicleDto.getPrice(), vehicleDto.getCurrency(), vehicleDto.getServices(), vehicleDto.getCountOfOwners());
        return vehicleRepository.saveVehicle(vehicle);
    }

    @Override
    public List<VehicleWithoutServiceDTO> getVehicles() {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        return vehicles.stream().map(this::mapToDTO).toList();
    }
    private VehicleWithoutServiceDTO mapToDTO(Vehicle vehicle){
        return new VehicleWithoutServiceDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(), vehicle.getNumberOfKilometes(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getCountOfOwners());
    }
    @Override
    public VehicleWithoutServiceDTO getVehicleById(int id) {
        Vehicle vehicleFound = this.vehicleRepository.getVehicleById(id);
        if (vehicleFound != null){
        return mapToDTO(this.vehicleRepository.getVehicleById(id));
    }else {
            return null;
        }}

    @Override
    public List<VehicleWithoutServiceDTO> getVehicleByDate(LocalDate since, LocalDate to) {
        return this.vehicleRepository.getVehicleByDate(since, to).stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<VehicleWithoutServiceDTO> getVehicleByPrice(int since, int to) {
        return this.vehicleRepository.getVehicleByPrice(since, to).stream().map(this::mapToDTO).toList();
    }

}
