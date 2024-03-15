package com.example.ElasticDemo01.service;

import com.example.ElasticDemo01.dto.ObraDto;
import com.example.ElasticDemo01.dto.ResponseDto;
import com.example.ElasticDemo01.entity.Obra;
import com.example.ElasticDemo01.repository.IObraRepository;
import com.example.ElasticDemo01.util.MapperClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraServiceImpl implements IObraService {
    IObraRepository repository;

    public ObraServiceImpl(IObraRepository repository){
        this.repository=repository;
    }
    @Override
    public ResponseDto saveObra(ObraDto emp) {
        Obra obra = MapperClass.dtoToEntity(emp);
        repository.save(obra);
        return new ResponseDto("Obra guardada existosamente");
    }

    @Override
    public ResponseDto saveObras(List<ObraDto> obrasDto) {
        List<Obra> obras = obrasDto.stream().map(MapperClass::dtoToEntity).toList();
        repository.saveAll(obras);
        return new ResponseDto("Obras guardadas exitosamente");
    }

    @Override
    public List<ObraDto> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<Obra> obras = repository.findAll();
        return obras.stream().map(e->mapper.map(e, ObraDto.class)).toList();
    }

    @Override
    public List<ObraDto> getByTitulo(String titulo) {
        ModelMapper mapper = new ModelMapper();
        List<Obra> obras = repository.findByNombreContaining(titulo);
        return obras.stream().map(e->mapper.map(e, ObraDto.class)).toList();
    }

    @Override
    public List<ObraDto> getByAutor(String autor) {
        ModelMapper mapper = new ModelMapper();
        List<Obra> obras = repository.findByAutor(autor);
        return obras.stream().map(e->mapper.map(e, ObraDto.class)).toList();
    }

    @Override
    public List<ObraDto> getOrderByPageDesc() {
        ModelMapper mapper = new ModelMapper();
        List<Obra> obras = repository.findAllOrderByCantidadPaginasDesc();
        return obras.stream().map(e->mapper.map(e, ObraDto.class)).toList();
    }

    @Override
    public List<ObraDto> getBeforeYear(String anio) {
        ModelMapper mapper = new ModelMapper();
        List<Obra> obras = repository.findByAnioBefore(anio);
        return obras.stream().map(e->mapper.map(e, ObraDto.class)).toList();
    }

    @Override
    public List<ObraDto> getByEditorial(String editorial) {
        ModelMapper mapper = new ModelMapper();
        List<Obra> obras = repository.findByEditorial(editorial);
        return obras.stream().map(e->mapper.map(e, ObraDto.class)).toList();
    }
}
