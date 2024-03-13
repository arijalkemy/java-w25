package org.bootcamp.segurosautos.service;

import org.bootcamp.segurosautos.dto.AcumulativeAccidentDto;
import org.bootcamp.segurosautos.dto.PatentBrandDto;
import org.bootcamp.segurosautos.dto.PatentBrandModelDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IVehicleService {
    public List<String> getPatentsFromVehicles();
    public List<PatentBrandDto> getPatentsAndBrandsOrderByYear();

    public List<String> getPatentsWithFourWheelsAndCurrentYear();

    public List<PatentBrandModelDto> getVehiclesWithExpensiveAccident();

    public List<AcumulativeAccidentDto> getAccumulativeAccidents();
}
