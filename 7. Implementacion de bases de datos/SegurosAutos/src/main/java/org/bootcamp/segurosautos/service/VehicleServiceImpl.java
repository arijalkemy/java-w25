package org.bootcamp.segurosautos.service;

import org.bootcamp.segurosautos.dto.AcumulativeAccidentDto;
import org.bootcamp.segurosautos.dto.PatentBrandDto;
import org.bootcamp.segurosautos.dto.PatentBrandModelDto;
import org.bootcamp.segurosautos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    private VehicleRepository repository;

    @Override
    public List<String> getPatentsFromVehicles() {
        return repository.getPatentsFromVehicles();
    }

    @Override
    public List<PatentBrandDto> getPatentsAndBrandsOrderByYear() {
        return repository.getPatentsAndBrandsBOrderByYear();
    }

    @Override
    public List<String> getPatentsWithFourWheelsAndCurrentYear() {
        return repository.getPatentsWithFourWheelsAndCurrentYear();
    }

    @Override
    public List<PatentBrandModelDto> getVehiclesWithExpensiveAccident() {
        return repository.getVehiclesWithExpensiveAccident();
    }

    @Override
    public List<AcumulativeAccidentDto> getAccumulativeAccidents() {
        return repository.getAccumulativeAccidents();
    }
}
