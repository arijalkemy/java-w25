package com.bootcamp.ejercicio_concesionaria.repository;

import com.bootcamp.ejercicio_concesionaria.dto.response.ResponseCarDTO;
import com.bootcamp.ejercicio_concesionaria.entity.Car;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ICarRepository {
    void saveCar(Car car);

    List<Car> getUsedCars();
    List<Car> getCarsBetweenDates(LocalDate since, LocalDate to);

    List<Car> getCarsBetweenPrices(double since, double to);

    Optional<Car> getCarById(int id);
}
