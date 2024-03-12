package obras_literarias.service;

import obras_literarias.dto.response.ObraLiterariaDto;
import obras_literarias.dto.request.NuevaObraDto;
import obras_literarias.dto.response.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IObrasService {
    ResponseDto saveObrasList(List<NuevaObraDto> obras);
    List<ObraLiterariaDto> getAllByAutor(String autor);
    List<ObraLiterariaDto> getAllByTitulo(String titulo);
    List<ObraLiterariaDto> findTop5ByPaginas();
    List<ObraLiterariaDto> findByAnnoPublicacionBefore(String anno);
    List<ObraLiterariaDto> findByEditorial(String editorial);
}
