package com.mercadolibre.concesionariadeautos.service;

import com.mercadolibre.concesionariadeautos.dto.*;

import java.util.List;

public interface IVehicleService {
    VehicleIdDTO addVehicle(VehicleDTO vehicleDTO);
    List<VehicleWithoutServicesDTO> getAllVehicles();
    VehicleDTO getVehicleById(VehicleIdDTO vehicleIdDTO);
    List<VehicleDTO> getVehiclesBetweenDate(DateFilterDTO dateFilterDTO);
    List<VehicleDTO> getVehiclesBetweenPrice(PriceFilterDTO priceFilterDTO);
}
