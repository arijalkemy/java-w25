package com.springboot.concesionariaautos.service;

import com.springboot.concesionariaautos.dto.CarDTO;

import java.util.List;
import java.util.Optional;

public interface IDealershipService {
    void createCar(CarDTO car);
    List<CarDTO> getCars();
    List<CarDTO> getCarsByDates(String dateSince, String dateTo);
    List<CarDTO> getCarsByPrices(String priceSince, String priceTo);
    Optional<CarDTO> getCarById(Long id);
}
