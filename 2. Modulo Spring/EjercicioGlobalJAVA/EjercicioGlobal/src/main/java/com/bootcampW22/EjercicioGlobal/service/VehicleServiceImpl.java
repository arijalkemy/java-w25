package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAverageCapacityDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleSpeedDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleAlreadyExistException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto) {

        ObjectMapper mapper = new ObjectMapper();
        if (vehicleRepository.exist(vehicleDto.id())) {
            throw new VehicleAlreadyExistException("Identificador del vehículo ya existente.");
        }

        Vehicle vehicle = vehicleRepository.save(mapper.convertValue(vehicleDto, Vehicle.class));

        return convertVehicleToDto(vehicle);
    }

    @Override
    public List<VehicleDto> searchByColoryAnio(String color, int anio) {
        List<Vehicle> vehicles = vehicleRepository.searchByColoryAnio(color, anio);
        if (vehicles.isEmpty()) throw new NotFoundException("No se encontro vehiculo");

        return vehicles.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<VehicleDto> searchByBrandYears(String brand, int startYear, int endYear) {
        List<Vehicle> vehicles = vehicleRepository.findByBrandAndYears(brand, startYear, endYear);

        if (vehicles.isEmpty()) throw new NotFoundException("No se encontro vehiculo");

        return vehicles.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleAverageSpeedDto getAverageSpeedByBrand(String brand) {
        VehicleAverageSpeedDto vehicleAverageSpeedDto = new VehicleAverageSpeedDto();
        Double averageSpeedByBrand = vehicleRepository.getAverageSpeedByBrand(brand);
        if (averageSpeedByBrand > 0.00) {

            vehicleAverageSpeedDto.setAverageSpeed(averageSpeedByBrand);
        } else {
            throw new NotFoundException("No se encontraron vehiculos con la marca seleccionada");
        }

        return vehicleAverageSpeedDto;
    }

    @Override
    public List<VehicleDto> addVehiclesBatch(List<VehicleDto> vehiclesDto) {
        ObjectMapper objectMapper = new ObjectMapper();

        for (VehicleDto vehicleDto : vehiclesDto) {
            Vehicle vehiculo = objectMapper.convertValue(vehicleDto, Vehicle.class);
            if (vehicleRepository.exist(vehiculo.getId())) {
                throw new VehicleAlreadyExistException("El vehiculo ya existe");
            } else {
                vehicleRepository.save(vehiculo);
            }

        }
        return searchAllVehicles();
    }

    @Override
    public VehicleSpeedDto updateVehicleSpeed(Long id, double speed) {
        double newSpeed = vehicleRepository.updateVehicleSpeed(id, speed);
        VehicleSpeedDto vehicleSpeedDto = new VehicleSpeedDto();
        vehicleSpeedDto.setSpeed(newSpeed);
        return vehicleSpeedDto;

    }

    @Override
    public List<VehicleDto> getVehiclesByFuelType(String fuel) {

        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByFuelType(fuel);

        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());

    }

    @Override
    public String deleteVehicle(Long id) {

        if (vehicleRepository.deleteVehicle(id)) {
            return "Vehiculo eliminado";
        } else {
            throw new NotFoundException("No se encontro el vehiculo");
        }


    }

    @Override
    public List<VehicleDto> getVehiclesByTransmissionType(String type) {
        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByTransmissionType(type);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String updateVehicleFuelType(Long id, String fuel) {

        if (vehicleRepository.updateVehicleFuelType(id, fuel)) {
            return "Vehiculo actualizado exitosamente";
        } else {
            throw new NotFoundException("Vehiculo no encontrado");
        }

    }

    @Override
    public VehicleAverageCapacityDto getAverageCapacityByBrand(String brand) {
        double averageCapacity = vehicleRepository.getAverageCapacityByBrand(brand);
        if(averageCapacity>0){
            return new VehicleAverageCapacityDto(averageCapacity);
        }else{
            throw new NotFoundException("No se encontraron vehiculos");
        }


    }

    @Override
    public List<VehicleDto> getVehiclesByDimensions(Double minLength, Double maxLength, Double minWidth, Double maxWidth) {

        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByDimensions(minLength,maxLength,minWidth,maxWidth);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<VehicleDto> getVehiclesByWeight(Double weightMin, Double weightMax) {
        List<Vehicle> vehicleList = vehicleRepository.getVehiclesByWeight(weightMin,weightMax);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }

    private VehicleDto convertVehicleToDto(Vehicle v) {
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
