package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.AlreadyCreated;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningún auto en el sistema.");
        }
        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchByYearAndColor(String color, int year){
        List<Vehicle> vehicleList = vehicleRepository.findAll().stream().filter(
                vehicle -> vehicle.getColor().equals(color) && vehicle.getYear() == year
        ).toList();

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningún auto en el sistema");
        }

        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto addVehicle(Vehicle vehicle) {
        if (vehicle.getId() == null) throw new AlreadyCreated("El vehiculo tiene id nulo");
        List<Vehicle> vehicleList = vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getId().equals(vehicle.getId()))
                .toList();
        if (!vehicleList.isEmpty()) throw new AlreadyCreated("hay algun carro mas con ese id");

        return convertVehicleToDto(vehicle);
    }


    private VehicleDto convertVehicleToDto(Vehicle v){
        return new VehicleDto(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getRegistration(),
                v.getColor(),
                v.getYear(),
                v.getMax_speed(),
                v.getPassengers(),
                v.getFuel_type(),
                v.getTransmission(),
                v.getLength(),
                v.getWidth(),
                v.getWeight());
    }
}
