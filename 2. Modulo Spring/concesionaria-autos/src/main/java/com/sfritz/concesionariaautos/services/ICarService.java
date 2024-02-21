package com.sfritz.concesionariaautos.services;

import java.util.Date;
import java.util.List;

import com.sfritz.concesionariaautos.dtos.requests.RequestCarDto;
import com.sfritz.concesionariaautos.dtos.response.FullResponseCarDto;
import com.sfritz.concesionariaautos.dtos.response.ResponseCarDto;

public interface ICarService {
    void createVehicle(RequestCarDto request);
    List<ResponseCarDto> getAllVehicles();
    List<FullResponseCarDto> getVehiclesFromManufacturingDate(Date since, Date to);
    List<FullResponseCarDto> getVehiclesFromPrices(Double since, Double to);
    FullResponseCarDto getVehicleById(Long id);
}
