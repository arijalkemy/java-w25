package com.example.youtuber.service;

import com.example.youtuber.dto.EntradaBlogDTO;
import com.example.youtuber.dto.GenericResponseDTO;
import com.example.youtuber.entity.EntradaBlog;
import com.example.youtuber.exception.NotCreatedException;
import com.example.youtuber.exception.NotFoundException;
import com.example.youtuber.repository.EntradaBlogRepositoryImp;
import com.example.youtuber.repository.IEntradaBlogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaEntradaBlogServiceImp implements IEntradaBlogService {

    private final IEntradaBlogRepository entradaBlogRepository;

    public EntradaEntradaBlogServiceImp (EntradaBlogRepositoryImp entradaBlogRepository){
        this.entradaBlogRepository = entradaBlogRepository;
    }

    public GenericResponseDTO savePost(EntradaBlogDTO entradaBlogDTO) {
        if(this.entradaBlogRepository.findById(entradaBlogDTO.getId()) != null)
            throw new NotCreatedException("Ya existe la entrada "+ entradaBlogDTO.getId());
       EntradaBlog entrada = new EntradaBlog (entradaBlogDTO.getId(), entradaBlogDTO.getTitle(), entradaBlogDTO.getAuthorName(), entradaBlogDTO.getPublicDate());
       return new GenericResponseDTO(HttpStatus.OK.value(), "Entrada de blog creada con éxito, id: "+ this.entradaBlogRepository.newEntrada(entrada).getIdBlog());
    }

    public EntradaBlogDTO findById(int id){
        EntradaBlog entrada = entradaBlogRepository.findById(id);
        if(entrada == null)
            throw new NotFoundException("No se encontró la entrada del blog "+id);
        return new EntradaBlogDTO(entrada.getIdBlog(), entrada.getTituloDelBlog(), entrada.getNombreDelAutor(), entrada.getFechaDePublicacion());
    }

    public List<EntradaBlogDTO> findAll() {
        List<EntradaBlog> entradas = entradaBlogRepository.findAll();
        if (entradas.size() == 0)
            throw new NotFoundException("No existen entradas de blog.");
        return new ArrayList<>(
            entradas.stream().map(entrada -> (new EntradaBlogDTO(entrada.getIdBlog(), entrada.getTituloDelBlog(), entrada.getNombreDelAutor(), entrada.getFechaDePublicacion()))).toList()
        );
    }
}
