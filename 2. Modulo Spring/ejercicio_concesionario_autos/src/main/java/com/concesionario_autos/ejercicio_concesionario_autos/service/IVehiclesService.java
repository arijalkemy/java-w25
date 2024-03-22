package com.concesionario_autos.ejercicio_concesionario_autos.service;

import com.concesionario_autos.ejercicio_concesionario_autos.dto.CarDTO;
import com.concesionario_autos.ejercicio_concesionario_autos.entity.Car;

import java.util.Date;
import java.util.List;

public interface IVehiclesService {
    Car addCar(Car car);
    List<CarDTO> getAllCars();
    List<Car> getCarsBetweenDates(Date since, Date to);
    List<Car> getItemsBetweenPrices(Double since, Double to);
    Car getCarById(Long id);
}
