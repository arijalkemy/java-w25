package com.springboot.concesionariaautos.repository;

import com.springboot.concesionariaautos.entity.Car;

import java.util.List;

public interface IDealershipRepository {
    void createCar(Car car);
    List<Car> getCars();
}
