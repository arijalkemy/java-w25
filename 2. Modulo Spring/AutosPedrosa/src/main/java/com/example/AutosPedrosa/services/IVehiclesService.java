package com.example.AutosPedrosa.services;

import com.example.AutosPedrosa.models.Car;
import com.example.AutosPedrosa.models.CarDTO;
import java.util.Date;
import java.util.List;

public interface IVehiclesService {

    boolean addCar(Car car);
    List<CarDTO> getCars();
    List<Car> getCarsBetweenDates(Date since, Date to);
    List<Car> getCarsBetweenPrices(Double since, Double to);
    Car getCar(Long id);




}
