package com.concesionario_autos.ejercicio_concesionario_autos.repository;

import com.concesionario_autos.ejercicio_concesionario_autos.dto.CarDTO;
import com.concesionario_autos.ejercicio_concesionario_autos.entity.Car;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class VehiclesRepository implements IVehiclesRepository{
    private final Map<Long, Car> listCars=new HashMap<>();

    @Override
    public Car addItem(Long id, Car car) {
        this.listCars.put(id, car);
        return car;
    }

    @Override
    public List<Car> getAll() {
        return new ArrayList<>(listCars.values());
    }

    @Override
    public List<Car> getItemsBetweenDates(Date since, Date to) {
        return listCars.values().stream().map(car -> {
            if (car.getManufacturingDate().after(since) && car.getManufacturingDate().before(to)) {
                return car;
            }
            return null;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Car> getItemsBetweenPrices(Double since, double to) {
        return listCars.values().stream().map(car -> {
            if(car.getPrice()>=since && car.getPrice()<=to){
                return car;
            }
            return null;
        }).collect(Collectors.toList());
    }

    @Override
    public Car getItemById(Long id) {
        return listCars.get(id);
    }
}
