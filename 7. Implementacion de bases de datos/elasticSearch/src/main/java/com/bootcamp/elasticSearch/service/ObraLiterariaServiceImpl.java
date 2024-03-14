package com.bootcamp.elasticSearch.service;

import com.bootcamp.elasticSearch.dto.ObraLiterariaDto;
import com.bootcamp.elasticSearch.dto.ResponseDto;
import com.bootcamp.elasticSearch.model.ObraLiteraria;
import com.bootcamp.elasticSearch.repository.IObraLiterariaRepository;
import com.bootcamp.elasticSearch.util.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService {

    private IObraLiterariaRepository iObraLiterariaRepository;

    public ObraLiterariaServiceImpl(IObraLiterariaRepository iObraLiterariaRepository){
        this.iObraLiterariaRepository = iObraLiterariaRepository;
    }

    @Override
    public ResponseDto saveObra(ObraLiterariaDto obraLiterariaDto){
        ModelMapper mapper = new ModelMapper();
        ObraLiteraria obraLiteraria = mapper.map(obraLiterariaDto, ObraLiteraria.class);
        this.iObraLiterariaRepository.save(obraLiteraria);
        return new ResponseDto("Obra creada correctamente.");
    }


    @Override
    public List<ObraLiterariaDto> getObrasByAutor(String autor){
        ModelMapper mapper = new ModelMapper();
        return iObraLiterariaRepository.findByAutor(autor).stream().map(
                obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDto.class)
        ).toList();
    }

    @Override
    public List<ObraLiterariaDto> getObrasByTitulo(String titulo){
        return iObraLiterariaRepository.findByNombreIsLike(titulo).stream().map(
                obraLiteraria -> Mapper.getMapper().map(obraLiteraria, ObraLiterariaDto.class)
        ).toList();
    }
    @Override
    public List<ObraLiterariaDto> getObrasTop5QuantityPages(){

        return iObraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc()
                .stream().map(o-> Mapper.getMapper().map(o,ObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaDto>  getObrasBefore(int anio){

        return  iObraLiterariaRepository.findObraLiterariaByAnioPublicacionIsBefore(anio).stream()
                .map(obraLiteraria -> Mapper.getMapper().map(obraLiteraria, ObraLiterariaDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaDto> getObrasByEditorial(String editorial){
        return iObraLiterariaRepository.findObraLiterariaByEditorial(editorial).stream().map(
                obraLiteraria -> Mapper.getMapper().map(obraLiteraria, ObraLiterariaDto.class)
        ).toList();
    }
}
