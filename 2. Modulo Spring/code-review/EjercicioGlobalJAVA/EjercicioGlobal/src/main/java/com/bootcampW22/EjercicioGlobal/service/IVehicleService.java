package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.response.AveragePassengersDTO;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    AveragePassengersDTO getAveragePassengersByBrand(String brand);
}
