package bootcamp.empresaseguros.service;


import bootcamp.empresaseguros.dto.request.SiniestroRequestDTO;
import bootcamp.empresaseguros.dto.response.*;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ISiniestroService {
    List<SiniestroDTO> getSiniestros();

    SucessDTO createSiniestro(SiniestroRequestDTO SiniestroRequestDTO);


    SucessDTO updateSiniestro(Long id, SiniestroDTO SiniestroDTO);

    SiniestroDTO findSiniestro(Long id);

    SucessDTO deleteSiniestro(Long id);

    List<VehiculoSiniestroDTO> findByPerdida();
    List<Object[]> findByPerdidaAndTotalSum();


}
