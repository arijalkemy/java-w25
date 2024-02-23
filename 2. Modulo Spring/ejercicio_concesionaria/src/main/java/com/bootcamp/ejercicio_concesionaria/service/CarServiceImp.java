package com.bootcamp.ejercicio_concesionaria.service;

import com.bootcamp.ejercicio_concesionaria.dto.request.RequestCarDTO;
import com.bootcamp.ejercicio_concesionaria.dto.response.ResponseCarDTO;
import com.bootcamp.ejercicio_concesionaria.entity.Car;
import com.bootcamp.ejercicio_concesionaria.exception.NotFoundException;
import com.bootcamp.ejercicio_concesionaria.repository.ICarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements ICarService{
    ICarRepository carRepository;

    public CarServiceImp(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(RequestCarDTO carDTO) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        Car car = mapper.convertValue(carDTO, Car.class);
        carRepository.saveCar(car);
    }

    @Override
    public List<ResponseCarDTO> getUsedCars() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<Car> usedCars = carRepository.getUsedCars();
        if (usedCars.isEmpty()) throw new NotFoundException("No hay autos en la lista");
        return usedCars.stream()
                .map(car -> mapper.convertValue(car, ResponseCarDTO.class))
                .collect(Collectors.toList());
    }
}
