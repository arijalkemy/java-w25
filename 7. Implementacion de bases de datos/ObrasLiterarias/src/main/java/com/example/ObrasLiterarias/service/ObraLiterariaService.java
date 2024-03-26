package com.example.ObrasLiterarias.service;

import com.example.ObrasLiterarias.dto.ObraLiterariaDTO;
import com.example.ObrasLiterarias.dto.ResponseDTO;
import com.example.ObrasLiterarias.model.ObraLiteraria;
import com.example.ObrasLiterarias.repository.IObraLiterariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService implements IObraLiterariaService{

    private IObraLiterariaRepository repository;

    public ObraLiterariaService(IObraLiterariaRepository repository){
        this.repository = repository;
    }

    @Override
    public List<ObraLiterariaDTO> getObraLiterariaByTitle(String keyword){
        return repository.getObraLiterariaByNameContainingIgnoreCase(keyword).stream()
                .map(this::obraLiterariaToObraLiterariaDto)
                .toList();
    }

    @Override
    public List<ObraLiterariaDTO> getObrasLiterariasDeAutor(String name) {
        return null;
    }

    @Override
    public List<ObraLiterariaDTO> getTopFiveMorePages() {
        List<ObraLiteraria> obras = repository.findTop5ByOrderByPagesDesc();
        return obras.stream().map(this::obraLiterariaToObraLiterariaDto).toList();
    }

    @Override
    public List<ObraLiterariaDTO> getTitlesBeforeYear(Integer year) {
        return null;
    }

    @Override
    public List<ObraLiterariaDTO> getTitlesByEditorial(String name) {
        return null;
    }

    @Override
    public ResponseDTO saveLiteraryWork(ObraLiterariaDTO obraLiterariaDTO) {
        ObraLiteraria obraLiteraria = obraLiterariaDtoToObraLiteraria(obraLiterariaDTO);
        repository.save(obraLiteraria);
        return new ResponseDTO("Ha sido creado");
    }

    private ObraLiterariaDTO obraLiterariaToObraLiterariaDto(ObraLiteraria obraLiteraria){
        return new ObraLiterariaDTO(obraLiteraria.getName(),
                obraLiteraria.getAuthor(),
                obraLiteraria.getPages(),
                obraLiteraria.getEditorial(),
                obraLiteraria.getPublishYear());
    }
    private ObraLiteraria obraLiterariaDtoToObraLiteraria(ObraLiterariaDTO obraLiteraria){
        return new ObraLiteraria(null,
                obraLiteraria.getName(),
                obraLiteraria.getAuthor(),
                obraLiteraria.getPages(),
                obraLiteraria.getEditorial(),
                obraLiteraria.getPublishYear());
    }

}
