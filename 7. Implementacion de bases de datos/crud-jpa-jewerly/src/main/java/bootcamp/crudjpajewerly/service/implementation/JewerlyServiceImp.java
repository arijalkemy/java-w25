package bootcamp.crudjpajewerly.service.implementation;

import bootcamp.crudjpajewerly.dto.request.JewerlyRequest;
import bootcamp.crudjpajewerly.exception.JewerlyNotFoundException;
import bootcamp.crudjpajewerly.model.Jewerly;
import bootcamp.crudjpajewerly.service.IJewerlyService;
import org.springframework.stereotype.Service;
import bootcamp.crudjpajewerly.repository.JewerlyRepository;

import java.util.List;

@Service
public class JewerlyServiceImp implements IJewerlyService {

    private final JewerlyRepository jewerlyRepository;

    public JewerlyServiceImp(JewerlyRepository JewerlyRepository) {
        this.jewerlyRepository = JewerlyRepository;
    }

    @Override
    public List<Jewerly> findJewerlys() {
        return jewerlyRepository.findJewerliesByVentaONoIsTrue();
    }

    @Override
    public Jewerly findJewerlyById(long id) {
        return jewerlyRepository.findJewerlyByVentaONoIsTrueAndNroIdentificatorio(id).orElseThrow(() -> new JewerlyNotFoundException(id));
    }

    @Override
    public void saveJewerly(JewerlyRequest request) {
        Jewerly jewerly = new Jewerly();
        setJewerlyFields(request, jewerly);
        jewerlyRepository.save(jewerly);
    }

    @Override
    public void updateJewerly(Long id, JewerlyRequest request) {
        Jewerly jewerly = jewerlyRepository.findJewerlyByVentaONoIsTrueAndNroIdentificatorio(id).orElseThrow(() -> new JewerlyNotFoundException(id));
        setJewerlyFields(request, jewerly);
        jewerlyRepository.save(jewerly);
    }

    @Override
    public void deleteJewerly(long id) {
        Jewerly jewerly = jewerlyRepository.findJewerlyByVentaONoIsTrueAndNroIdentificatorio(id).orElseThrow(() -> new JewerlyNotFoundException(id));
        jewerly.setVentaONo(false);
        jewerlyRepository.save(jewerly);
    }

    private void setJewerlyFields(JewerlyRequest request, Jewerly jewerly) {
        if (request.getNombre() != null) jewerly.setNombre(request.getNombre());
        if (request.getMaterial() != null) jewerly.setMaterial(request.getMaterial());
        if (request.getPeso() != null) jewerly.setPeso(request.getPeso());
        if (request.getParticularidad() != null) jewerly.setParticularidad(request.getParticularidad());
        if (request.getPoseePiedra() != null) jewerly.setPoseePiedra(request.getPoseePiedra());
        if (request.getVentaONo() != null) jewerly.setVentaONo(request.getVentaONo());
    }

}
