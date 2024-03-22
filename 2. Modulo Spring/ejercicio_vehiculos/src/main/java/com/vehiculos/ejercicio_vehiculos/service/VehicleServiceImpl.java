package com.vehiculos.ejercicio_vehiculos.service;

import com.vehiculos.ejercicio_vehiculos.dto.AverageSpeedDto;
import com.vehiculos.ejercicio_vehiculos.dto.VehicleDto;
import com.vehiculos.ejercicio_vehiculos.entity.Vehicle;
import com.vehiculos.ejercicio_vehiculos.exception.ConflictException;
import com.vehiculos.ejercicio_vehiculos.exception.NotFoundException;
import com.vehiculos.ejercicio_vehiculos.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{
    @Autowired
    IVehicleRepository vehicleRepository;

    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList=vehicleRepository.findAll();

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }

        return  vehicleList.stream().map(this::VehicleToDTO).collect(Collectors.toList());
    }

    @Override
    public String createVehicle(VehicleDto vehicleDto) {
        List<Vehicle> vehicleList=vehicleRepository.findAll();
        Vehicle vehicle=this.VehicleDTOtoVehicle(vehicleDto);

        boolean idExist=vehicleList.stream().anyMatch(v -> v.getId().equals(vehicle.getId()));

        if(idExist){
            throw new ConflictException("El vehiculo con id: "+vehicle.getId()+ " ya se encuentra registrado");
        }

        vehicleRepository.create(vehicle);

        return "Vehiculo creado exitosamente";
    }

    @Override
    public List<VehicleDto> searchVehiclesByColorAndYear(String color, Integer year) {
        List<Vehicle> vehicleList=vehicleRepository.findByColorAndYear(color, year);

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontro ningun carro con color "+color+" y "+"year "+year);
        }

        return vehicleList.stream().map(this::VehicleToDTO).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchVehiclesByBrandAndRangeYear(String brand, Integer start_year, Integer end_year) {
        List<Vehicle> vehicleList=vehicleRepository.findByBrandAndRangeYears(brand, start_year, end_year);

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontro ningun carro con la marca "+brand+" y "+"con rango "+start_year+" - "+end_year);
        }

        return vehicleList.stream().map(this::VehicleToDTO).collect(Collectors.toList());
    }

    @Override
    public AverageSpeedDto getAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicleList=vehicleRepository.findByBrand(brand);

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontro ningun carro con la marca "+brand);
        }

        int sumOfSpeeds=vehicleList.stream().mapToInt(v-> Integer.parseInt(v.getMax_speed())).sum();

        double average=vehicleList.isEmpty() ? 0 : (double) sumOfSpeeds/vehicleList.size();

        return new AverageSpeedDto(brand, average);
    }

    @Override
    public String deleteVehicle(Long id) {
        Vehicle vehicle=vehicleRepository.findById(id);
        List<Vehicle> vehicleList=vehicleRepository.findAll();

        if(vehicle==null){
            throw new NotFoundException("No se encontro ningun carro con el id"+id);
        }

        int index = -1;
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            vehicleList.remove(index);
        } else {
            throw new NotFoundException("No se encontro ningun carro con el id " + id);
        }

        return "Vehiculo eliminado exitosamente";
    }

    @Override
    public String modifySpeed(Long id, String max_speed) {
        List<Vehicle> vehicleList=vehicleRepository.findAll();
        Vehicle vehicle=vehicleRepository.findById(id);

        vehicle.setMax_speed(max_speed);

        int index=vehicleList.indexOf(vehicle);

        vehicleList.set(index, vehicle);

        return "Velocidad maxima modificada exitosamente";
    }

    private VehicleDto VehicleToDTO(Vehicle vehicle){
        return new VehicleDto(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getRegistration(),
                vehicle.getColor(),
                vehicle.getYear(),
                vehicle.getMax_speed(),
                vehicle.getPassengers(),
                vehicle.getFuel_type(),
                vehicle.getTransmission(),
                vehicle.getLength(),
                vehicle.getWidth(),
                vehicle.getWeight()
        );
    }

    private Vehicle VehicleDTOtoVehicle(VehicleDto vehicleDto){
        Vehicle vehicle=new Vehicle();

        vehicle.setId(vehicleDto.id());
        vehicle.setBrand(vehicleDto.brand());
        vehicle.setModel(vehicleDto.model());
        vehicle.setRegistration(vehicleDto.registration());
        vehicle.setColor(vehicleDto.color());
        vehicle.setYear(vehicleDto.year());
        vehicle.setMax_speed(vehicleDto.max_speed());
        vehicle.setPassengers(vehicleDto.passengers());
        vehicle.setFuel_type(vehicleDto.fuel_type());
        vehicle.setTransmission(vehicleDto.transmission());
        vehicle.setLength(vehicleDto.length());
        vehicle.setWidth(vehicleDto.width());
        vehicle.setWeight(vehicleDto.weight());

        return vehicle;
    }
}
