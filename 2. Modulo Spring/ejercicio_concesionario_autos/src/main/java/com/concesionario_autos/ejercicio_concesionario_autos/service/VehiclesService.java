package com.concesionario_autos.ejercicio_concesionario_autos.service;

import com.concesionario_autos.ejercicio_concesionario_autos.dto.CarDTO;
import com.concesionario_autos.ejercicio_concesionario_autos.entity.Car;
import com.concesionario_autos.ejercicio_concesionario_autos.repository.VehiclesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiclesService implements IVehiclesService{
    @Autowired
    VehiclesRepository vehiclesRepository;

    private Long id;

    @PostConstruct
    private void postConstructor(){
        this.id=1L;
    }

    @Override
    public Car addCar(Car car) {
        Car newCar=vehiclesRepository.addItem(id, car);
        System.out.println("Carro"+newCar);
        this.id+=1;
        return newCar;
    }

    @Override
    public List<CarDTO> getAllCars() {
        return vehiclesRepository.getAll().stream().map(this::getCarDTO).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsBetweenDates(Date since, Date to) {
        return vehiclesRepository.getItemsBetweenDates(since, to);
    }

    @Override
    public List<Car> getItemsBetweenPrices(Double since, Double to) {
        return vehiclesRepository.getItemsBetweenPrices(since, to);
    }

    @Override
    public Car getCarById(Long id) {
        return vehiclesRepository.getItemById(id);
    }

    private CarDTO getCarDTO(Car car){
        CarDTO carDTO=new CarDTO();

        carDTO.setBrand(car.getBrand());
        carDTO.setCurrency(car.getCurrency());
        carDTO.setModel(car.getModel());
        carDTO.setDoors(car.getDoors());
        carDTO.setPrice(car.getPrice());
        carDTO.setCountOfOwners(car.getCountOfOwners());
        carDTO.setManufacturingDate(car.getManufacturingDate());
        carDTO.setNumberOfKilometers(car.getNumberOfKilometers());

        return carDTO;
    }
}
