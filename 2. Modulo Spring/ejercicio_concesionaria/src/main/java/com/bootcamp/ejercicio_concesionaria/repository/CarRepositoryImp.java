package com.bootcamp.ejercicio_concesionaria.repository;

import com.bootcamp.ejercicio_concesionaria.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepositoryImp implements ICarRepository {
    List<Car> cars = new ArrayList<>();

    @Override
    public void saveCar(Car car) {
        this.cars.add(car);
    }

    @Override
    public List<Car> getUsedCars() {
        return this.cars.stream()
                .filter(car -> car.getNumberOfKilometers() > 0)
                .collect(Collectors.toList());
    }
}
