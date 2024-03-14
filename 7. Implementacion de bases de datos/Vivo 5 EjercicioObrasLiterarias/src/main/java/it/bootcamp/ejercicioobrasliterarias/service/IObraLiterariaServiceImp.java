package it.bootcamp.ejercicioobrasliterarias.service;

import it.bootcamp.ejercicioobrasliterarias.controller.ObraLiterariaController;
import it.bootcamp.ejercicioobrasliterarias.dto.ObraLiterariaDto;
import it.bootcamp.ejercicioobrasliterarias.entity.ObraLiteraria;
import it.bootcamp.ejercicioobrasliterarias.repository.ObraLiterariaRepository;
import it.bootcamp.ejercicioobrasliterarias.utils.MapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IObraLiterariaServiceImp implements  IObraLiterariaService {
    private ModelMapper mapper = new ModelMapper();
    private final ObraLiterariaRepository repository;

    public IObraLiterariaServiceImp(ObraLiterariaRepository repository){
        this.repository=repository;
    }

    public List<ObraLiterariaDto> getAllObras(){
        List<ObraLiteraria> obras = repository.findAll();
        return MapObrasDtoToObras(obras);
    }
    public List<ObraLiterariaDto> getObrasByAutor(String autor){
        List<ObraLiteraria> obras = repository.getObraLiterariasByAutor(autor);
        return MapObrasDtoToObras(obras);
    }
    public List<ObraLiterariaDto> getObrasLikeNombre(String nombre){
        List<ObraLiteraria> obras = repository.getObraLiterariasByNombreContaining(nombre);
        return MapObrasDtoToObras(obras);
    }
    public List<ObraLiterariaDto> getObrasTop5Paginas(){
        List<ObraLiteraria> obras = repository.findTop5ByOrderByCantidadPaginasDesc();
        return MapObrasDtoToObras(obras);
    }
    public List<ObraLiterariaDto> getObrasReleasedBeforeAnio(Integer anio){
        List<ObraLiteraria> obras = repository.findAllByAnyoPrimeraPublicacionBefore(anio);
        return MapObrasDtoToObras(obras);
    }
    public List<ObraLiterariaDto> getObrasByEditorial(String editorial){
        List<ObraLiteraria> obras = repository.findAllByEditorialEqualsIgnoreCase(editorial);
        return MapObrasDtoToObras(obras);
    }

    public ObraLiterariaDto saveObra(ObraLiterariaDto obraLiterariaDto){
        ObraLiteraria obraLiteraria = mapper.map(obraLiterariaDto, ObraLiteraria.class);
        obraLiteraria = repository.save(obraLiteraria);
        return mapper.map(obraLiteraria, ObraLiterariaDto.class);
    }

    private List<ObraLiterariaDto> MapObrasDtoToObras(List<ObraLiteraria> obras){
        return obras.stream()
                .map(obra -> mapper.map(obra, ObraLiterariaDto.class))
                .collect(Collectors.toList());
    }

}
