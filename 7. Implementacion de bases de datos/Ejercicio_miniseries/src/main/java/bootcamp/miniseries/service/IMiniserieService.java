package bootcamp.miniseries.service;

import bootcamp.miniseries.dto.request.MiniSerieRequestDTO;
import bootcamp.miniseries.dto.response.AwardsOfMiniserieResponseDTO;
import bootcamp.miniseries.dto.response.MiniSerieResponseDTO;
import bootcamp.miniseries.model.MiniSerie;

import java.util.List;

public interface IMiniserieService {

    List<MiniSerieResponseDTO> findAll();
    MiniSerieResponseDTO findOne(Long id);

    void save(MiniSerieRequestDTO request);

    AwardsOfMiniserieResponseDTO getAwardsOfMiniserie(Long id);

    MiniSerieResponseDTO getByName(String name);

    void deleteById(Long id);

}
