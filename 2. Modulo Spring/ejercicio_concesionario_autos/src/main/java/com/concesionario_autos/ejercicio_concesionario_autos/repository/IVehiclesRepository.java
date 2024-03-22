package com.concesionario_autos.ejercicio_concesionario_autos.repository;

import com.concesionario_autos.ejercicio_concesionario_autos.dto.CarDTO;
import com.concesionario_autos.ejercicio_concesionario_autos.entity.Car;

import java.util.Date;
import java.util.List;

public interface IVehiclesRepository {
    Car addItem(Long id, Car car);
    List<Car> getAll();
    List<Car> getItemsBetweenDates(Date since, Date to);
    List<Car> getItemsBetweenPrices(Double since, double to);
    Car getItemById(Long id);
}
