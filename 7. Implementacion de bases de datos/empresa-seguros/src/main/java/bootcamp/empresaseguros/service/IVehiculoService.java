package bootcamp.empresaseguros.service;

import bootcamp.empresaseguros.dto.request.VehiculoRequestDTO;
import bootcamp.empresaseguros.dto.response.PatenteDTO;
import bootcamp.empresaseguros.dto.response.PatenteMarcaDTO;
import bootcamp.empresaseguros.dto.response.VehiculoResponseDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehiculoService {

    List<VehiculoResponseDTO> getAllVehicles();

    void createVehicle(VehiculoRequestDTO request);

    VehiculoResponseDTO getVehicleById(Long id);

    List<PatenteDTO> getAllVehiclesLicensePlates();

    List<PatenteMarcaDTO> getAllVehiclesLicensePlateAndBrandOrderedByYearOfManufacturingDesc();

    List<PatenteDTO> getVehiclesLicensePlateWithMoreThan4WheelsAndYearOfManufacturingCurrentYear();

}
