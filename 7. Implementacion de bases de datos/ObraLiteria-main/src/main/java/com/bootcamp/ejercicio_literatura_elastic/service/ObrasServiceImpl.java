package com.bootcamp.ejercicio_literatura_elastic.service;

import com.bootcamp.ejercicio_literatura_elastic.domain.ObraLiteraria;
import com.bootcamp.ejercicio_literatura_elastic.dto.ObraLiterariaDTO;
import com.bootcamp.ejercicio_literatura_elastic.dto.response.ResponseDTO;
import com.bootcamp.ejercicio_literatura_elastic.repository.IObraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ObrasServiceImpl implements IObrasService{

    private final IObraRepository obraRepository;
    private ModelMapper modelMapper;
    public ObrasServiceImpl(IObraRepository obraRepository) {
        this.obraRepository = obraRepository;
        modelMapper =  new ModelMapper();
    }


    @Override
    public ResponseDTO saveObra(ObraLiterariaDTO obraLiterariaDTO) {
        this.obraRepository.save(modelMapper.map(obraLiterariaDTO, ObraLiteraria.class));
        return new ResponseDTO("Todo OK");
    }

    @Override
    public List<ObraLiterariaDTO> getByAutor(String autor) {
        return this.obraRepository.findAllByAutor(autor).stream()
                .map(obra-> modelMapper.map(obra, ObraLiterariaDTO.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaDTO> findTitleObra(String title) {
        
        return this.obraRepository.findAllByNombreContains(title).stream()
                .map(obraLiteraria -> modelMapper.map(obraLiteraria, ObraLiterariaDTO.class)).toList();
    }


    @Override
    public List<ObraLiterariaDTO> obtenerObrasConMasPaginas(){
        return obraRepository.findAll()
                .stream()
                .map(obraLiteraria -> modelMapper.map(obraLiteraria, ObraLiterariaDTO.class))
                .sorted(Comparator.comparingInt(ObraLiterariaDTO::getCantidadPaginas).reversed())
                .limit(5)
                .toList();
    }

    @Override
    public List<ObraLiterariaDTO> getObrasAntesDelAnio(int anio){
        return this.obraRepository.findAll().stream()
                .map(obraLiteraria -> modelMapper.map(obraLiteraria, ObraLiterariaDTO.class))
                .filter(o -> o.getAnioPublicación().getYear() < anio)
                .toList();
    }

    public List<ObraLiterariaDTO> getByEditorial(String editorial){
        return this.obraRepository.findAll().stream()
                .map(obras -> modelMapper.map(obras, ObraLiterariaDTO.class))
                .filter(obraEditorial -> obraEditorial.getEditorial().equals(editorial))
                .toList();
    }
}
