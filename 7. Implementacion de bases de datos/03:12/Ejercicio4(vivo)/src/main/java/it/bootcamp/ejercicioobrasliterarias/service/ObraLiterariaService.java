package it.bootcamp.ejercicioobrasliterarias.service;

import it.bootcamp.ejercicioobrasliterarias.dto.ObraLiterariaReqDTO;
import it.bootcamp.ejercicioobrasliterarias.dto.ObraLiterariaResDTO;
import it.bootcamp.ejercicioobrasliterarias.entity.ObraLiteraria;
import it.bootcamp.ejercicioobrasliterarias.repository.IObraLiterariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ObraLiterariaService implements IObraLiterariaService {
    private ModelMapper mapper = new ModelMapper();
    private final IObraLiterariaRepository obraLiterariaRepository;

    public ObraLiterariaService(IObraLiterariaRepository obraLiterariaRepository) {
        this.obraLiterariaRepository = obraLiterariaRepository;
    }

    @Override
    public ObraLiterariaResDTO saveObra(ObraLiterariaReqDTO obraLiterariaDto) {
        ObraLiteraria obraLiteraria = mapper.map(obraLiterariaDto, ObraLiteraria.class);
        obraLiteraria = obraLiterariaRepository.save(obraLiteraria);
        return mapper.map(obraLiteraria, ObraLiterariaResDTO.class);
    }

    @Override
    public List<ObraLiterariaResDTO> getAllObras() {
        Iterable<ObraLiteraria> obraLiterariaIterable = obraLiterariaRepository.findAll();
        List<ObraLiteraria> obraLiterariasList = StreamSupport.stream(obraLiterariaIterable.spliterator(), false)
                .collect(Collectors.toList());
        List<ObraLiterariaResDTO> obraLiterariaResDTOs = new ArrayList<>();
        for (ObraLiteraria e : obraLiterariasList) {
            obraLiterariaResDTOs.add(mapper.map(e, ObraLiterariaResDTO.class));
        }
        return obraLiterariaResDTOs;
    }

    @Override
    public List<ObraLiterariaResDTO> getObrasByAutor(String autor) {
        List<ObraLiteraria> obras = obraLiterariaRepository.getObraLiterariasByAutor(autor);
        return MapObrasDtoToObras(obras);
    }

    @Override
    public List<ObraLiterariaResDTO> getObrasLikeNombre(String nombre) {
        List<ObraLiteraria> obras = obraLiterariaRepository.getObraLiterariasByNombreContaining(nombre);
        return MapObrasDtoToObras(obras);
    }

    @Override
    public List<ObraLiterariaResDTO> getObrasTop5Paginas() {
        List<ObraLiteraria> obras = obraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc();
        return MapObrasDtoToObras(obras);
    }

    @Override
    public List<ObraLiterariaResDTO> getObrasReleasedBeforeAnio(Integer anio) {
        List<ObraLiteraria> obras = obraLiterariaRepository.findAllByAnyoPrimeraPublicacionBefore(anio);
        return MapObrasDtoToObras(obras);
    }

    @Override
    public List<ObraLiterariaResDTO> getObrasByEditorial(String editorial) {
        List<ObraLiteraria> obras = obraLiterariaRepository.findAllByEditorialEqualsIgnoreCase(editorial);
        return MapObrasDtoToObras(obras);
    }

    private List<ObraLiterariaResDTO> MapObrasDtoToObras(List<ObraLiteraria> obras) {
        return obras.stream()
                .map(obra -> mapper.map(obra, ObraLiterariaResDTO.class))
                .collect(Collectors.toList());
    }
}
