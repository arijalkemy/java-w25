package com.bootcamp.ejercicio_concesionaria.service;

import com.bootcamp.ejercicio_concesionaria.dto.request.RequestCarDTO;
import com.bootcamp.ejercicio_concesionaria.dto.response.ResponseCarDTO;
import com.bootcamp.ejercicio_concesionaria.entity.Car;
import com.bootcamp.ejercicio_concesionaria.exception.NotFoundException;
import com.bootcamp.ejercicio_concesionaria.repository.ICarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements ICarService{
    ICarRepository carRepository;
    ObjectMapper mapper = new ObjectMapper();


    public CarServiceImp(ICarRepository carRepository) {
        this.carRepository = carRepository;
        mapper.registerModule(new JavaTimeModule());
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
        List<Car> usedCars = carRepository.getUsedCars();
        if (usedCars.isEmpty()) throw new NotFoundException("No hay autos en la lista");
        return usedCars.stream()
                .map(car -> mapper.convertValue(car, ResponseCarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseCarDTO> getCarsBetweenDates(LocalDate since, LocalDate to) {
        System.out.println(since.isAfter(LocalDate.now()));
        List<Car> carsBetweenDates = carRepository.getCarsBetweenDates(since, to);
        if (carsBetweenDates.isEmpty()) throw new NotFoundException("No hay autos entre las fechas especificadas");
        return carsBetweenDates.stream()
                .map(car -> mapper.convertValue(car, ResponseCarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseCarDTO> getCarsBetweenPrices(double since, double to) {
        List<Car> carsBetweenPrices = carRepository.getCarsBetweenPrices(since, to);
        if (carsBetweenPrices.isEmpty()) throw new NotFoundException("No hay autos entre los precios especificados");
        return carsBetweenPrices.stream()
                .map(car -> mapper.convertValue(car, ResponseCarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseCarDTO getCarById(int id) {
        Optional<Car> car =  carRepository.getCarById(id);
        if (car.isEmpty())
            throw new NotFoundException("No se encontro un auto con ese ID");
        return mapper.convertValue(car.get(), ResponseCarDTO.class);
    }
}
