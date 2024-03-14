package bootcamp.elasticsearchgrupal.service.implementation;

import bootcamp.elasticsearchgrupal.dto.request.ObraLiterariaRequestDTO;
import bootcamp.elasticsearchgrupal.dto.response.ObraLiterariaResponseDTO;
import bootcamp.elasticsearchgrupal.model.ObraLiteraria;
import bootcamp.elasticsearchgrupal.repository.IObraLiterariaRepository;
import bootcamp.elasticsearchgrupal.service.IObraLiterariaService;
import bootcamp.elasticsearchgrupal.util.MapperClass;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService {

    private final IObraLiterariaRepository obraLiterariaRepository;

    public ObraLiterariaServiceImpl(IObraLiterariaRepository obraLiterariaRepository) {
        this.obraLiterariaRepository = obraLiterariaRepository;
    }

    @Override
    public void createObraLiteraria(ObraLiterariaRequestDTO request) {
        ObraLiteraria obraLiteraria = MapperClass.dtoToEntity(request);
        obraLiterariaRepository.save(obraLiteraria);
    }

    @Override
    public List<ObraLiterariaResponseDTO> getAllObrasliterarias() {
        return obraLiterariaRepository.findAll().stream().map(MapperClass::entityToDto).toList();
    }
    @Override
    public List<ObraLiterariaResponseDTO> getObraLiteraria(String word) {
        return obraLiterariaRepository.findObraLiterariaByNombreContains(word)
                .stream().map(MapperClass::entityToDto).toList();
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasOfAutor(String autor) {
        return obraLiterariaRepository.findObraLiterariaByAutorEqualsIgnoreCase(autor).stream().map(MapperClass::entityToDto).toList();
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasTop5OrderedByCantidadDepaginasDesc() {
        return getAllObrasliterarias().stream().sorted(Comparator.comparing(ObraLiterariaResponseDTO::getCantidadDePaginas).reversed()).limit(5).toList();
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasBeforeYear(Integer year) {
        return obraLiterariaRepository.findObraLiterariasByAnioDePrimeraPublicacionIsLessThan(year).stream().map(MapperClass::entityToDto).toList();
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasOfEditorial(String editorial) {
        return obraLiterariaRepository.findObraLiterariaByEditorialEqualsIgnoreCase(editorial).stream().map(MapperClass::entityToDto).toList();
    }


}
