package com.bootcamp.ejercicio_concesionaria.repository;

import com.bootcamp.ejercicio_concesionaria.entity.Car;

import java.util.List;

public interface ICarRepository {
    void saveCar(Car car);

    List<Car> getUsedCars();
}
