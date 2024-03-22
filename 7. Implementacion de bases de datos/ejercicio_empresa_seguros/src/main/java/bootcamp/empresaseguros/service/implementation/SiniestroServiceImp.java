package bootcamp.empresaseguros.service.implementation;

import bootcamp.empresaseguros.dto.request.SiniestroRequestDTO;
import bootcamp.empresaseguros.dto.response.*;
import bootcamp.empresaseguros.entity.Siniestro;
import bootcamp.empresaseguros.entity.Vehiculo;
import bootcamp.empresaseguros.repository.ISiniestroRepository;
import bootcamp.empresaseguros.repository.IVehiculoRepository;
import bootcamp.empresaseguros.service.ISiniestroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Objects;

@Service
public class SiniestroServiceImp implements ISiniestroService {
    private final ISiniestroRepository siniestroRepository;
    private final IVehiculoRepository vehiculoRepository;
    ModelMapper mapper;
    public SiniestroServiceImp(ISiniestroRepository siniestroRepository,ModelMapper mapper, IVehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
        this.siniestroRepository = siniestroRepository;
        this.mapper = mapper;
    }

    @Override
    public List<SiniestroDTO> getSiniestros() {
        return siniestroRepository.findAll().stream()
                .map(siniestro -> mapper.map(siniestro,SiniestroDTO.class))
                .toList();
    }

    @Override
    public SucessDTO createSiniestro(SiniestroRequestDTO siniestroDTO) {
        Vehiculo vehiculo = vehiculoRepository.getReferenceById(siniestroDTO.getVehiculoId());
        Siniestro siniestro = new Siniestro(3L,siniestroDTO.getFecha(),siniestroDTO.getPerdidaEconomica(),vehiculo);
        siniestroRepository.save(siniestro);
        return new SucessDTO("Created successfully");
    }

    @Override
    public SucessDTO updateSiniestro(Long id, SiniestroDTO SiniestroDTO) {
        return null;
    }

    @Override
    public SiniestroDTO findSiniestro(Long id) {
        return null;
    }

    @Override
    public SucessDTO deleteSiniestro(Long id) {
        return null;
    }
@Override
    public List<VehiculoSiniestroDTO> findByPerdida() {
        List<Vehiculo> vehiculoBySiniestro = siniestroRepository.findByPerdida();
    return vehiculoBySiniestro.stream()
            .map(vehiculo -> mapper.map(vehiculo,VehiculoSiniestroDTO.class))
            .toList();

    };

    @Override
    public List<Object[]> findByPerdidaAndTotalSum(){
        return siniestroRepository.findByPerdidaAndTotalSum();
    }

}
