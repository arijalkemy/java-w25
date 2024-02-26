package com.bootcamp.ejercicio_concesionaria.repository;

import com.bootcamp.ejercicio_concesionaria.dto.response.ResponseCarDTO;
import com.bootcamp.ejercicio_concesionaria.entity.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CarRepositoryImp implements ICarRepository {
    List<Car> cars = new ArrayList<>();
    int counter = 1;

    @Override
    public void saveCar(Car car) {
        car.setId(counter);
        counter++;
        this.cars.add(car);
    }

    @Override
    public List<Car> getUsedCars() {
        return this.cars.stream()
                .filter(car -> car.getNumberOfKilometers() > 0)
                .collect(Collectors.toList());
    }
    @Override
    public List<Car> getCarsBetweenDates(LocalDate since, LocalDate to) {
        return this.cars.stream()
                .filter(car -> car.getManufacturingDate().isAfter(since) && car.getManufacturingDate().isBefore(to))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsBetweenPrices(double since, double to) {
        return this.cars.stream()
                .filter(car -> car.getPrice() >= since && car.getPrice() <= to)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Car> getCarById(int id) {
        return this.cars.stream().
                filter(car -> car.getId() == id)
                .findFirst();
    }
}
