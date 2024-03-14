package bootcamp.elasticsearchgrupal.service;

import bootcamp.elasticsearchgrupal.dto.request.ObraLiterariaRequestDTO;
import bootcamp.elasticsearchgrupal.dto.response.ObraLiterariaResponseDTO;

import java.util.List;

public interface IObraLiterariaService {

    void createObraLiteraria(ObraLiterariaRequestDTO request);

    List<ObraLiterariaResponseDTO> getAllObrasliterarias();

    List<ObraLiterariaResponseDTO> getObraLiteraria(String word);

    List<ObraLiterariaResponseDTO> getObrasLiterariasOfAutor(String autor);

    List<ObraLiterariaResponseDTO> getObrasLiterariasTop5OrderedByCantidadDepaginasDesc();

    List<ObraLiterariaResponseDTO> getObrasLiterariasBeforeYear(Integer year);

    List<ObraLiterariaResponseDTO> getObrasLiterariasOfEditorial(String editorial);

}
