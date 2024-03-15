package com.bootcamp.elasticSearch.service;

import com.bootcamp.elasticSearch.dto.ObraLiterariaDto;
import com.bootcamp.elasticSearch.dto.ResponseDto;
import com.bootcamp.elasticSearch.model.ObraLiteraria;
import com.bootcamp.elasticSearch.repository.IObraLiterariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService {

    private IObraLiterariaRepository iObraLiterariaRepository;
    private ModelMapper mapper;

    public ObraLiterariaServiceImpl(IObraLiterariaRepository iObraLiterariaRepository, ModelMapper mapper){
        this.iObraLiterariaRepository = iObraLiterariaRepository;
        this.mapper = mapper;
    }

    @Override
    public ResponseDto saveObra(ObraLiterariaDto obraLiterariaDto){
        ObraLiteraria obraLiteraria = this.mapper.map(obraLiterariaDto, ObraLiteraria.class);
        this.iObraLiterariaRepository.save(obraLiteraria);
        return new ResponseDto("Obra creada correctamente.");
    }


    @Override
    public List<ObraLiterariaDto> getObrasByAutor(String autor){
        return iObraLiterariaRepository.findByAutor(autor).stream().map(
                obraLiteraria -> this.mapper.map(obraLiteraria, ObraLiterariaDto.class)
        ).toList(); 
    }

    @Override
    public List<ObraLiterariaDto> getObrasByTitulo(String titulo){
        return iObraLiterariaRepository.findByNombreIsLike(titulo).stream().map(
                obraLiteraria -> this.mapper.map(obraLiteraria, ObraLiterariaDto.class)
        ).toList();
    }
    @Override
    public List<ObraLiterariaDto> getObrasTop5QuantityPages(){
        return iObraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc().stream().map(
                obraLiteraria -> this.mapper.map(obraLiteraria, ObraLiterariaDto.class)
        ).toList();
    }

    @Override
    public List<ObraLiterariaDto>  getObrasBefore(int anio){
        return  iObraLiterariaRepository.findObraLiterariaByAnioPublicacionIsBefore(anio).stream()
                .map(obraLiteraria -> this.mapper.map(obraLiteraria, ObraLiterariaDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> getObrasByEditorial(String editorial){
        return iObraLiterariaRepository.findObraLiterariaByEditorial(editorial).stream().map(
                obraLiteraria -> this.mapper.map(obraLiteraria, ObraLiterariaDto.class)
        ).toList();
    }
}
