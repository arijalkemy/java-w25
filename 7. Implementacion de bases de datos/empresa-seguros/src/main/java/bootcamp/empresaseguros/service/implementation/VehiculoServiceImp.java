package bootcamp.empresaseguros.service.implementation;

import bootcamp.empresaseguros.dto.request.VehiculoRequestDTO;
import bootcamp.empresaseguros.dto.response.PatenteDTO;
import bootcamp.empresaseguros.dto.response.PatenteMarcaDTO;
import bootcamp.empresaseguros.dto.response.VehiculoResponseDTO;
import bootcamp.empresaseguros.entity.Vehiculo;
import bootcamp.empresaseguros.exception.VehiculoNotFoundException;
import bootcamp.empresaseguros.repository.IVehiculoRepository;
import bootcamp.empresaseguros.service.IVehiculoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehiculoServiceImp implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    public VehiculoServiceImp(IVehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }
    @Override
    public List<VehiculoResponseDTO> getAllVehicles() {
        return vehiculoRepository.findAll().stream().map(VehiculoResponseDTO::new).toList();
    }

    @Override
    public void createVehicle(VehiculoRequestDTO request) {
        vehiculoRepository.save(new Vehiculo(request));
    }

    @Override
    public VehiculoResponseDTO getVehicleById(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow(() -> new VehiculoNotFoundException(id));
        return new VehiculoResponseDTO(vehiculo);
    }

    @Override
    public List<PatenteDTO> getAllVehiclesLicensePlates() {
        return vehiculoRepository.getAllVehiclesLicensePlates();
    }

    @Override
    public List<PatenteMarcaDTO> getAllVehiclesLicensePlateAndBrandOrderedByYearOfManufacturingDesc() {
        return vehiculoRepository.getAllVehiclesLicensePlatesAndBrandOrderedByYearOfManufacturingDesc();
    }

    @Override
    public List<PatenteDTO> getVehiclesLicensePlateWithMoreThan4WheelsAndYearOfManufacturingCurrentYear() {
        Integer currentYear = LocalDate.now().getYear();
        return vehiculoRepository.getVehiclesLicensePlateWithMoreThan4WheelsAndYearOfManufacturingCurrentYear(currentYear);
    }

}
