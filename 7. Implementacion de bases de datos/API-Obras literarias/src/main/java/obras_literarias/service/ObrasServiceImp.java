package obras_literarias.service;

import obras_literarias.dto.ObraLiterariaDto;
import obras_literarias.dto.request.NuevaObraDTO;
import obras_literarias.entity.ObraLiteraria;
import obras_literarias.repository.IObrasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.ElasticDemo01.dto.ResponseDTO;

import java.util.List;

@Service
public class ObrasServiceImp implements IObrasService{
    IObrasRepository repository;

    public ObrasServiceImp(IObrasRepository repository){
        this.repository = repository;
    }

    @Override
    public ResponseDTO saveObrasList(List<NuevaObraDTO> obras) {
        ModelMapper mapper = new ModelMapper();
        List<ObraLiteraria> obrasToSave = obras.stream().map(o -> mapper.map(o, ObraLiteraria.class)).toList();
        obrasToSave.stream().map(o -> repository.save(o)).toList();
        return new ResponseDTO("Obras created");
    }

    @Override
    public List<ObraLiterariaDto> getAllByAutor(String autor){
        ModelMapper mapper = new ModelMapper();
        List<ObraLiteraria> obras = repository.findByAutor(autor);
        return obras.stream().map(o-> mapper.map(o, ObraLiterariaDto.class)).toList();
    }
}