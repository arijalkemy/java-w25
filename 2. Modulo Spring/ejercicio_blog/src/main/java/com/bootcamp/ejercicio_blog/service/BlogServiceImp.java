package com.bootcamp.ejercicio_blog.service;

import com.bootcamp.ejercicio_blog.dto.EntradaBlogDTO;
import com.bootcamp.ejercicio_blog.dto.response.ResponseEntradaBlogDTO;
import com.bootcamp.ejercicio_blog.entity.EntradaBlog;
import com.bootcamp.ejercicio_blog.exceptions.NotFoundException;
import com.bootcamp.ejercicio_blog.repository.BlogRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImp {
    @Autowired
    BlogRepositoryImp blogRepository;

    public ResponseEntradaBlogDTO addEntry(EntradaBlogDTO request){

        blogRepository.add(
                new EntradaBlog(
                        request.getId(),
                        request.getTitulo(),
                        request.getNombreAutor(),
                        request.getFecha()
                )
        );
        return new ResponseEntradaBlogDTO(request.getId(), "Se agrego correctamente");
    }
    public EntradaBlogDTO getById(int id){
        EntradaBlog entrada = blogRepository.getById(id);
        if (entrada == null)
            throw new NotFoundException("El blog con ID: " + id + " no fue encontrado");
        return new EntradaBlogDTO(
                entrada.getId(),
                entrada.getTitulo(),
                entrada.getNombreAutor(),
                entrada.getFecha()
        );
    }
    public List<EntradaBlogDTO> getAll(){
        List<EntradaBlogDTO> entradaBlogDTOList = new ArrayList<>();
        List<EntradaBlog> entradaBlogList = blogRepository.getAll();

        for(EntradaBlog entrada : entradaBlogList){
            EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO(
                    entrada.getId(),
                    entrada.getTitulo(),
                    entrada.getNombreAutor(),
                    entrada.getFecha()
            );
            entradaBlogDTOList.add(entradaBlogDTO);
        }

        return entradaBlogDTOList;
    }
}
