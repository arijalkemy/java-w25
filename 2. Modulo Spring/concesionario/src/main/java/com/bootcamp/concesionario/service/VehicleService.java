package com.bootcamp.concesionario.service;

import com.bootcamp.concesionario.dto.MessageDto;
import com.bootcamp.concesionario.dto.VehicleDto;
import com.bootcamp.concesionario.model.Vehicle;
import com.bootcamp.concesionario.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Data
@Service
public class VehicleService implements IVehicleService{

    private VehicleRepository vehicleRepository;
    private ObjectMapper objectMapper;
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Override
    public MessageDto addVehicle(VehicleDto vehicleDto) {
        vehicleDto.setIdVehicle(vehicleRepository.getAllVehicles().stream().mapToInt(Vehicle::getIdVehicle).max().orElse(0)+1);
        return vehicleRepository.saveVehicle(objectMapper.convertValue(vehicleDto,Vehicle.class));
    }

    @Override
    public List<VehicleDto> getAllVehicles() {

        return vehicleRepository.getAllVehicles().stream().map(vehicle -> this.objectMapper.convertValue(vehicle,VehicleDto.class)).toList() ;
    }

    @Override
    public List<VehicleDto> getAllVehiclesByProductionDate(LocalDate sinceDate, LocalDate toDate) {
        List<Vehicle> vehicleList = vehicleRepository.getAllVehicles().stream().filter(vehicle -> vehicle.getDate().getYear()>= sinceDate.getYear() && vehicle.getDate().getYear() <= toDate.getYear()).toList();
        return  vehicleList.stream().map(vehicle -> this.objectMapper.convertValue(vehicle,VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> getAllVehiclesByPrice(double sincePrice, double toPrice) {

        List<Vehicle> vehicleList = vehicleRepository.getAllVehicles().stream().filter(vehicle -> vehicle.getPrice()>=sincePrice && vehicle.getPrice()<=toPrice).toList();
        return  vehicleList.stream().map(vehicle -> this.objectMapper.convertValue(vehicle,VehicleDto.class)).toList();
    }

    @Override
    public VehicleDto getByIdVehicle(int idVehicle) {
        return  this.objectMapper.convertValue(vehicleRepository.getByIdVehicle(idVehicle),VehicleDto.class) ;
    }
}
