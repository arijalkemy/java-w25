package org.bootcamp.segurosautos.repository;

import org.bootcamp.segurosautos.dto.AcumulativeAccidentDto;
import org.bootcamp.segurosautos.dto.PatentBrandDto;
import org.bootcamp.segurosautos.dto.PatentBrandModelDto;
import org.bootcamp.segurosautos.dto.PatentVehiclesDto;
import org.bootcamp.segurosautos.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v.patent FROM Vehicle v")
    public List<String> getPatentsFromVehicles();

    @Query("SELECT new org.bootcamp.segurosautos.dto.PatentBrandDto(v.patent, v.brand) FROM Vehicle v order by v.model_year")
    public List<PatentBrandDto> getPatentsAndBrandsBOrderByYear();

    @Query("SELECT v.patent FROM Vehicle v where v.wheels >= 4 AND v.model_year = year(current_date())")
    public List<String> getPatentsWithFourWheelsAndCurrentYear();

    @Query("SELECT new org.bootcamp.segurosautos.dto.PatentBrandModelDto(v.brand, v.model, v.patent) FROM Vehicle v inner join Accident a on v.id = a.vehicle.id WHERE a.cost > 10000")
    public List<PatentBrandModelDto> getVehiclesWithExpensiveAccident();

    @Query("SELECT new org.bootcamp.segurosautos.dto.AcumulativeAccidentDto(v.brand, v.model, v.patent, SUM(a.cost)) FROM Vehicle v inner join Accident a on v.id = a.vehicle.id WHERE a.cost > 10000 group by v.patent")
    public List<AcumulativeAccidentDto> getAccumulativeAccidents();

}
