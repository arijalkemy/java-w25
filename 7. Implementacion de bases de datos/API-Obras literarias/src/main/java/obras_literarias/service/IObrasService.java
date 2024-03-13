package obras_literarias.service;

import obras_literarias.dto.ObraLiterariaDto;
import obras_literarias.dto.request.NuevaObraDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.ElasticDemo01.dto.ResponseDTO;

@Service
public interface IObrasService {
    ResponseDTO saveObrasList(List<NuevaObraDTO> obras);
    List<ObraLiterariaDto> getAllByAutor(String autor);

}
