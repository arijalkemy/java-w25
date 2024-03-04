package org.example.cardeale.service.common;

import org.example.cardeale.dto.vehicle.VehicleDTO;
import org.example.cardeale.dto.vehicle.common.DateRangeDTO;
import org.example.cardeale.dto.vehicle.common.PriceRangeDTO;

import java.util.List;

public interface IVehicleService {
    List<VehicleDTO> getAll();
    VehicleDTO create(VehicleDTO vehicleDTO);
    VehicleDTO getById(int vehicleId);
    List<VehicleDTO> getByRangePrice(PriceRangeDTO priceRangeDTO);
    List<VehicleDTO> getByRangeDate(DateRangeDTO dateRangeDTO);

}
