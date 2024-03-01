package org.example.carselling.service;

import org.example.carselling.dto.CarDTO;

import java.util.List;

public interface ICarService {
    void createCar (CarDTO carDTO);

    List<CarDTO> getAllCars();

    CarDTO getCarById(Integer id);
}
