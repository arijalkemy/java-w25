package bootcamp.miniseries.service.imp;

import bootcamp.miniseries.dto.request.MiniSerieRequestDTO;
import bootcamp.miniseries.dto.response.AwardsOfMiniserieResponseDTO;
import bootcamp.miniseries.dto.response.MiniSerieResponseDTO;
import bootcamp.miniseries.model.MiniSerie;
import bootcamp.miniseries.repository.IMiniserieRepository;
import bootcamp.miniseries.service.IMiniserieService;
import bootcamp.miniseries.util.mapper.MiniserieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiniserieServiceImp implements IMiniserieService {

    IMiniserieRepository miniserieRepository;

    public MiniserieServiceImp(IMiniserieRepository miniserieRepository) {
        this.miniserieRepository = miniserieRepository;
    }

    @Override
    public List<MiniSerieResponseDTO> findAll() {
        List<MiniSerie> listOfMiniseries = miniserieRepository.findAll();
        return listOfMiniseries.stream().map(MiniserieMapper::getResponse).toList();
    }

    @Override
    public MiniSerieResponseDTO findOne(Long id){
        Optional<MiniSerie> mini = miniserieRepository.findById(id);
        if(mini.isEmpty()) throw new RuntimeException("No se encuentra la miniserie buscada");

        return MiniserieMapper.getResponse(mini.get());
    }

    @Override
    public void save(MiniSerieRequestDTO request) {
        miniserieRepository.save(MiniserieMapper.getEntity(request));
    }

    @Override
    public AwardsOfMiniserieResponseDTO getAwardsOfMiniserie(Long id) {
        return new AwardsOfMiniserieResponseDTO(id, miniserieRepository.getAwardsOfMiniserie(id));
    }

    @Override
    public MiniSerieResponseDTO getByName(String name) {
        Optional<MiniSerie> miniSerie = miniserieRepository.findMiniSerieByName(name);
        if (miniSerie.isEmpty())
            throw new RuntimeException("");
        return MiniserieMapper.getResponse(miniSerie.get());
    }

    @Override
    public void deleteById(Long id) {
        miniserieRepository.deleteById(id);
    }


}
