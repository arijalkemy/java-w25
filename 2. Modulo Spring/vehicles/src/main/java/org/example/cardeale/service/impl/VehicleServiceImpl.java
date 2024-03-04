package org.example.cardeale.service.impl;

import org.example.cardeale.dto.vehicle.VehicleDTO;
import org.example.cardeale.dto.vehicle.common.DateRangeDTO;
import org.example.cardeale.dto.vehicle.common.PriceRangeDTO;
import org.example.cardeale.util.mapers.VehicleMapper;
import org.example.cardeale.repository.common.IVehicleRepository;
import org.example.cardeale.service.common.IVehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {
    private IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDTO> getAll() {
        return this.vehicleRepository.getAll().stream().map(vehicle -> VehicleMapper.toVehicleDTO(vehicle)).toList();
    }

    @Override
    public VehicleDTO create(VehicleDTO vehicleDTO) {
        return VehicleMapper.toVehicleDTO(vehicleRepository.create(VehicleMapper.toVehicle(vehicleDTO)));
    }

    @Override
    public VehicleDTO getById(int vehicleId) {
        return VehicleMapper.toVehicleDTO(this.vehicleRepository.getById(vehicleId));
    }

    @Override
    public List<VehicleDTO> getByRangePrice(PriceRangeDTO priceRangeDTO) {
        return this.vehicleRepository.getAll().stream().filter(vehicle -> vehicle.getPrice() >= priceRangeDTO.getSince()
                && vehicle.getPrice() <= priceRangeDTO.getTo())
                .map(vehicle -> VehicleMapper.toVehicleDTO(vehicle)).toList();
    }

    @Override
    public List<VehicleDTO> getByRangeDate(DateRangeDTO dateRangeDTO) {
        return this.vehicleRepository.getAll().stream().filter(vehicle ->
                (vehicle.getMafufactturingDate().isBefore(dateRangeDTO.getSince())
                        || vehicle.getMafufactturingDate().equals(dateRangeDTO.getSince()))
                                && (vehicle.getMafufactturingDate().isAfter(dateRangeDTO.getTo())
                        || vehicle.getMafufactturingDate().equals(dateRangeDTO.getTo())))
                                .map(vehicle -> VehicleMapper.toVehicleDTO(vehicle)).toList();
    }
}
