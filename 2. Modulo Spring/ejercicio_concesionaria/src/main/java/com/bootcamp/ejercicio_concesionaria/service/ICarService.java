package com.bootcamp.ejercicio_concesionaria.service;

import com.bootcamp.ejercicio_concesionaria.dto.request.RequestCarDTO;
import com.bootcamp.ejercicio_concesionaria.dto.response.ResponseCarDTO;

import java.time.LocalDate;
import java.util.List;

public interface ICarService {
    void addCar(RequestCarDTO carDTO);

    List<ResponseCarDTO> getUsedCars();
    List<ResponseCarDTO> getCarsBetweenDates(LocalDate since, LocalDate to);

    List<ResponseCarDTO> getCarsBetweenPrices(double since, double to);

    ResponseCarDTO getCarById(int id);
}
