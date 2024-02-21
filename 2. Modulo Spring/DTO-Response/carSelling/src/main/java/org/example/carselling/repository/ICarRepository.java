package org.example.carselling.repository;

import org.example.carselling.dto.CarDTO;
import org.example.carselling.entity.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> getAllVehicles();
    void saveNewCar(Car car);
    Car getCarById(Integer id);
}
