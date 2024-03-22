package com.meli.obras_literarias.service;

import com.meli.obras_literarias.dto.request.ReqObraDTO;
import com.meli.obras_literarias.dto.response.ResObraDTO;
import com.meli.obras_literarias.entity.Obra;
import com.meli.obras_literarias.repository.IObrasLiterariasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.meli.obras_literarias.dto.response.MessageDto;

import java.util.List;

@Service
public class ObrasLiterariasServiceImpl implements IObrasLiterariasService {
    private final ModelMapper mapper = new ModelMapper();
    private final IObrasLiterariasRepository repository;

    public ObrasLiterariasServiceImpl(IObrasLiterariasRepository iObrasLiterariasRepository) {
        this.repository = iObrasLiterariasRepository;
    }

    @Override
    public MessageDto saveObra(ReqObraDTO reqObraDTO) {
        repository.save(mapper.map(reqObraDTO, Obra.class));
        return new MessageDto("Obra creada.");
    }

    @Override
    public List<ResObraDTO> getAll() {
        List<Obra> obras = repository.findAll();
        return obras.stream().map(obra -> mapper.map(obra,ResObraDTO.class)).toList();
    }

    @Override
    public  List<ResObraDTO> getByAutor(String autor) {
        List<Obra> obrasByAutor = repository.findByAutor(autor);
        return obrasByAutor.stream().map(obra -> mapper.map(obrasByAutor,ResObraDTO.class)).toList();
    }

    @Override
    public List<ResObraDTO> getByTituloLike(String palabraClave) {
        List<Obra> obrasByTitulo= repository.findByNombreLike(palabraClave);
        return obrasByTitulo.stream().map(obra -> mapper.map(obrasByTitulo,ResObraDTO.class)).toList();
    }

    @Override
    public List<ResObraDTO> getTop5PagesQuantity() {
        List<Obra> topObras= repository.findTop5PagesQuantity();
        return topObras.stream().map(obra -> mapper.map(topObras,ResObraDTO.class)).toList();
    }

    @Override
    public List<ResObraDTO> getByYearBefore(Integer year) {
        List<Obra> obrasBeforeYear= repository.findByAnioBefore(year);
        return obrasBeforeYear.stream().map(obra -> mapper.map(obrasBeforeYear,ResObraDTO.class)).toList();
    }

    @Override
    public List<ResObraDTO> getByEditorial(String editorial) {
        List<Obra> obrasByEditorial = repository.findByEditorial(editorial);
        return obrasByEditorial.stream().map(obra -> mapper.map(obra, ResObraDTO.class)).toList();
    }
}
