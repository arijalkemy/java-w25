package bootcamp.empresaseguros.service.implementation;

import bootcamp.empresaseguros.dto.response.*;
import bootcamp.empresaseguros.entity.Siniestro;
import bootcamp.empresaseguros.repository.ISiniestroRepository;
import bootcamp.empresaseguros.service.ISiniestroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class SiniestroServiceImp implements ISiniestroService {
    private final ISiniestroRepository siniestroRepository;
    ModelMapper mapper;
    public SiniestroServiceImp(ISiniestroRepository siniestroRepository,ModelMapper mapper){
        this.siniestroRepository = siniestroRepository;
    }

    @Override
    public List<SiniestroDTO> getSiniestros() {
        return null;
    }

    @Override
    public SucessDTO createSiniestro(SiniestroDTO siniestroDTO) {
        Siniestro siniestro = mapper.map(siniestroDTO, Siniestro.class);
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
    public VehiculoSiniestroDTO findByPerdida() {
    return siniestroRepository.findByPerdida();
    };

    @Override
    public List<PatenteMarcaModeloDTO> findByPerdidaAndTotalSum(){
        return siniestroRepository.findByPerdidaAndTotalSum();
    }

}
