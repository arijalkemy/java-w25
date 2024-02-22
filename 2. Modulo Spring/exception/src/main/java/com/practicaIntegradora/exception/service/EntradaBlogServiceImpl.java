package com.practicaIntegradora.exception.service;

import com.practicaIntegradora.exception.dto.EntradaBlogDTO;
import com.practicaIntegradora.exception.exceptions.NotFoundException;
import com.practicaIntegradora.exception.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaBlogServiceImpl implements IEntradaBlogService{

    @Autowired
    EntradaBlogRepository entradaBlogRepository;

    @Override
    public EntradaBlogDTO createBlog(EntradaBlogDTO entrada) {

        EntradaBlogDTO entradaBlog = new EntradaBlogDTO(entrada.getId(),entrada.getTitulo(),entrada.getAutor(),entrada.getFechaPublicacion());
        if(entradaBlogRepository.getById(entradaBlog.getId())!=null){
            throw new NotFoundException("El blog ya existe, no se puede crear");
        }
        EntradaBlogDTO blogDTOResponse = new EntradaBlogDTO();
        blogDTOResponse.setId(entradaBlogRepository.createEntrada(entradaBlog));
        return blogDTOResponse;
    }

    @Override
    public EntradaBlogDTO getById(int id) {
        EntradaBlogDTO entradaById= entradaBlogRepository.getById(id);
        if(entradaById==null){
            throw  new NotFoundException("No existe entrada");
        }
        return entradaById;
    }

    @Override
    public List<EntradaBlogDTO> getAll() {
        return entradaBlogRepository.getAll();
    }
}
