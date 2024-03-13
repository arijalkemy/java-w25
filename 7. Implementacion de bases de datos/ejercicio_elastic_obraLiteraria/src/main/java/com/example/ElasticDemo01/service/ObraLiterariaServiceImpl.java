package com.example.ElasticDemo01.service;

import com.example.ElasticDemo01.dto.ObraLiterariaDTO;
import com.example.ElasticDemo01.dto.ObraLiterariaFiltrosDTO;
import com.example.ElasticDemo01.dto.ResponseDto;
import com.example.ElasticDemo01.entity.ObraLiteraria;
import com.example.ElasticDemo01.repository.ObraLiterariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.example.ElasticDemo01.util.MapperClass.dtoToEntity;

@Service
public class ObraLiterariaServiceImpl implements ObraLiterariaService {

    ObraLiterariaRepository repository;

    public ObraLiterariaServiceImpl(ObraLiterariaRepository repository){
        this.repository = repository;
    }
    @Override
    public ResponseDto saveBook(ObraLiterariaDTO obraLiterariaDTO) {
        ObraLiteraria obraLiteraria = dtoToEntity(obraLiterariaDTO);
        repository.save(obraLiteraria);
        return new ResponseDto("It's all fine");
    }

    @Override
    public List<ObraLiterariaDTO> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<ObraLiteraria> obrasLiterarias = repository.findAll();

        return obrasLiterarias.stream().map(e -> mapper.map(e, ObraLiterariaDTO.class)).toList();
    }

    @Override
    public List<ObraLiterariaDTO> getObraByAutor(ObraLiterariaFiltrosDTO filtros) {
        ModelMapper mapper = new ModelMapper();
        List<ObraLiteraria> obras = repository.findByAutor(filtros.getAutor());
        return obras.stream().map(e -> mapper.map(e, ObraLiterariaDTO.class)).toList();
    }

    @Override
    public List<ObraLiterariaDTO> getObraByPalabraClave(ObraLiterariaFiltrosDTO filtros) {
        ModelMapper mapper = new ModelMapper();
        List<ObraLiteraria> obras = repository.findByPalabraClave(filtros.getPalabraClave());
        return obras.stream().map(e -> mapper.map(e, ObraLiterariaDTO.class)).toList();
    }

    @Override
    public List<ObraLiterariaDTO> getTop5ByCantPag() {
        ModelMapper mapper = new ModelMapper();
        List<ObraLiteraria> obras = repository.findAllByOrderByCantidadPaginasDesc();
        return obras.stream().map(e -> mapper.map(e, ObraLiterariaDTO.class)).toList();
    }

    @Override
    public List<ObraLiterariaDTO> getBeforeDate(ObraLiterariaFiltrosDTO filtros) {
        ModelMapper mapper = new ModelMapper();
        List<ObraLiteraria> obras = repository.findAllByFechaPublicacionBefore(filtros.getFecha());
        return obras.stream().map(e -> mapper.map(e, ObraLiterariaDTO.class)).toList();
    }

    @Override
    public List<ObraLiterariaDTO> getByEditorial(ObraLiterariaFiltrosDTO filtros) {
        ModelMapper mapper = new ModelMapper();
        List<ObraLiteraria> obras = repository.findAllByEditorial(filtros.getEditorial());
        return obras.stream().map(e -> mapper.map(e, ObraLiterariaDTO.class)).toList();
    }

}
