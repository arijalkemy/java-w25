package bootcamp.empresaseguros.service.implementation;

import bootcamp.empresaseguros.dto.request.VehiculoRequestDTO;
import bootcamp.empresaseguros.dto.response.PatenteDTO;
import bootcamp.empresaseguros.dto.response.PatenteMarcaDTO;
import bootcamp.empresaseguros.dto.response.VehiculoResponseDTO;
import bootcamp.empresaseguros.entity.Vehiculo;
import bootcamp.empresaseguros.exception.VehiculoNotFoundException;
import bootcamp.empresaseguros.repository.IVehiculoRepository;
import bootcamp.empresaseguros.service.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehiculoServiceImp implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;
    ModelMapper mapper;

    public VehiculoServiceImp(IVehiculoRepository vehiculoRepository, ModelMapper mapper){

        this.vehiculoRepository = vehiculoRepository;
        this.mapper = mapper;
    }
    @Override
    public List<VehiculoResponseDTO> getAllVehicles() {
        return vehiculoRepository.findAll().stream()
                .map(VehiculoResponseDTO::new)
                .toList();
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
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream().map(vehiculo -> mapper.map(vehiculo,PatenteDTO.class)).toList();
    }

    @Override
    public List<PatenteMarcaDTO> getAllVehiclesLicensePlateAndBrandOrderedByYearOfManufacturingDesc() {
        List<Vehiculo> vehiculosOrderedByYear= vehiculoRepository.getAllVehiclesLicensePlatesAndBrandOrderedByYearOfManufacturingDesc();
        return vehiculosOrderedByYear.stream().map(vehiculo -> mapper.map(vehiculo,PatenteMarcaDTO.class)).toList();
    }

    @Override
    public List<PatenteDTO> getVehiclesLicensePlateWithMoreThan4WheelsAndYearOfManufacturingCurrentYear() {
        Integer currentYear = LocalDate.now().getYear();
        return vehiculoRepository.getVehiclesLicensePlateWithMoreThan4WheelsAndYearOfManufacturingCurrentYear(currentYear);
    }

}
