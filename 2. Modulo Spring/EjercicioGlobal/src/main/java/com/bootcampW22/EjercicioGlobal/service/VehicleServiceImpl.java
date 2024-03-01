package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;

    @Autowired
    ModelMapper modelMapper;

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
    public VehicleDto addVehicle(VehicleDto vehicle) {
        Vehicle vehicle1= modelMapper.map(vehicle,Vehicle.class);
        if(vehicleRepository.findById(vehicle.getId())!=null){
            throw new ConflictException("Identificador del vehículo ya existente.");
        }else{
           return modelMapper.      map(vehicleRepository.save(vehicle1),VehicleDto.class);
        }



    }

    @Override
    public List<VehicleDto> filterYearAndColor(Integer year, String color) {
        List<Vehicle> vehicles= vehicleRepository.findByColorAndYear(color,year);

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }else{
            return vehicles.stream().map(vehicle->modelMapper.map(vehicle,VehicleDto.class)).toList();
        }

    }

    @Override
    public List<VehicleDto> filterBrandAndBetweenYears(String brand, Integer startYear, Integer endYear) {
        List<Vehicle> vehicles= vehicleRepository.findByBrandAndBetweenYears(brand,startYear,endYear);
        if(vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }else{
            return vehicles.stream().map(vehicle->modelMapper.map(vehicle,VehicleDto.class)).toList();
        }

    }

    @Override
    public AverageSpeedDto averageSpeedToBrand(String Brand) {
        List<Vehicle> listForBrand= vehicleRepository.findByBrand(Brand);
        if(listForBrand.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }else{
            return new AverageSpeedDto(Brand,calculateAverageSpeed(listForBrand));
        }

    }

    @Override
    public ResponseDto addVehicle(List<VehicleDto> vehicles) throws IllegalAccessException {
        List<Vehicle> vehicleList= vehicles.stream().map(vehicle->modelMapper.map(vehicle,Vehicle.class)).toList();
        if(verifyList(vehicleList)){
            if(vehicleRepository.save(vehicleList)){
                return new ResponseDto(" Vehículos creados exitosamente") ;
            }
            else{
                return new ResponseDto("algo salio mal al añadir la lista");
            }

        }
        return new ResponseDto("algo salio mal al añadir la lista");
    }

    @Override
    public ResponseDto updateSpeed(Long id, String speed) throws IOException {
        //comprovamos que solo contenga numeros
        Boolean bandera= speed.replaceAll("[0-9]","").length()==0;
        if(bandera){
            Boolean actualizado = vehicleRepository.updateSpeed(id,speed);
            if(!actualizado)
                throw new NotFoundException("No se encontró el vehículo");

            return new ResponseDto("Velocidad del vehículo actualizada exitosamente");
        }else{
            throw new BadRequestException("Velocidad mal formada o fuera de rango");
        }

    }

    @Override
    public ResponseDto deletedVehicleId(Long id) {
        if(vehicleRepository.findById(id)!=null){
        vehicleRepository.deletedById(id);
        return new ResponseDto("Vehículo eliminado exitosamente");
        }else{
        throw new NotFoundException("No se encontró el vehículo");
        }

            }

    private VehicleDto convertVehicleToDto(Vehicle v) {
        return modelMapper.map(v, VehicleDto.class);
    }


    private Double calculateAverageSpeed(List<Vehicle> list){
        Double totalSpeeds=0.0;
        for (Vehicle vehicle: list) {
            totalSpeeds+=Double.parseDouble(vehicle.getMax_speed());
        }
        return totalSpeeds/list.size();
    }


    private Boolean verifyList(List<Vehicle> list) throws IllegalAccessException {
        for (Vehicle vehicle: list) {
            if(vehicleRepository.findById(vehicle.getId())!=null){
                throw new ConflictException("Algún vehículo tiene un identificador ya existente");
            }
            Field[] fields = vehicle.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(vehicle) == null) {
                    throw new BadRequestException("Datos de algún vehículo mal formados o incompletos");
                }
            }
        }

        return true;
    }
}
