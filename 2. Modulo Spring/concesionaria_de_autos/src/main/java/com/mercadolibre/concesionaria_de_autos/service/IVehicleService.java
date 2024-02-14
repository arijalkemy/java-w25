package com.mercadolibre.concesionaria_de_autos.service;

import com.mercadolibre.concesionaria_de_autos.dto.request.VehiclePostDto;
import com.mercadolibre.concesionaria_de_autos.dto.response.VehicleResponseDto;
import com.mercadolibre.concesionaria_de_autos.dto.response.VehicleResponseWithoutServicesDto;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    VehicleResponseDto createVehicle(VehiclePostDto vehicle);
    List<VehicleResponseWithoutServicesDto> getAllVehicles();
    List<VehicleResponseDto> getVehiclesByDateRange(LocalDate startDate, LocalDate endDate);
    List<VehicleResponseDto> getVehiclesByPriceRange(int startPrice, int endPrice);
    VehicleResponseDto getVehicle(Long id);
}
