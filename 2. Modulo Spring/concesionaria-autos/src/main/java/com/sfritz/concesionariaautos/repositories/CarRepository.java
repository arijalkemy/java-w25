package com.sfritz.concesionariaautos.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sfritz.concesionariaautos.entities.Car;
import com.sfritz.concesionariaautos.utils.DataBase;

@Repository
public class CarRepository implements ICarRepository{

    private DataBase db;

    public CarRepository(DataBase db){
        this.db = db;
    }

    @Override
    public void createVehicle(Car car) {
        db.createVehicle(car);
    }

    @Override
    public List<Car> getAllVehicles() {
        return db.getAllVehicles();
    }

    @Override
    public Car getVehicleById(Long id) {
        return db.getVehicleById(id);
    }

}
