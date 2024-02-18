package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.request.RequestEntradaDTO;
import com.mercadolibre.blog.dto.response.ResponseEntradaDTO;
import com.mercadolibre.blog.dto.response.ResponseIdMensajeDTO;
import com.mercadolibre.blog.entity.EntradaBlog;
import com.mercadolibre.blog.exception.NotFoundException;
import com.mercadolibre.blog.exception.ResourceAlreadyExistsException;
import com.mercadolibre.blog.repository.BlogRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepositoryImp blogRepository;

    public ResponseIdMensajeDTO addEntry(RequestEntradaDTO requestEntradaDTO) {
        EntradaBlog entryFound = blogRepository.findById(requestEntradaDTO.getId());
        if (entryFound != null) {
            throw new ResourceAlreadyExistsException("ID " + requestEntradaDTO.getId() + " ya existe");
        }
        blogRepository.addEntry(new EntradaBlog(
                        requestEntradaDTO.getId(),
                        requestEntradaDTO.getTitulo(),
                        requestEntradaDTO.getAutor(),
                        requestEntradaDTO.getFecha()
                )
        );
        return new ResponseIdMensajeDTO(requestEntradaDTO.getId(), "Entada creada");
    }

    public ResponseEntradaDTO findById(int id) {
        EntradaBlog entryFound = blogRepository.findById(id);
        if (entryFound == null) {
            throw new NotFoundException("ID " + id + " no encontrado");
        }
        return new ResponseEntradaDTO(
                entryFound.getId(),
                entryFound.getTitulo(),
                entryFound.getAutor(),
                entryFound.getFecha()
        );
    }

    public List<ResponseEntradaDTO> getAll() {
        List<EntradaBlog> entradas = blogRepository.getAll();
        List<ResponseEntradaDTO> entradasDTO = new ArrayList<>();
        for (EntradaBlog entrada : entradas) {
            ResponseEntradaDTO entry = new ResponseEntradaDTO(
                    entrada.getId(),
                    entrada.getAutor(),
                    entrada.getTitulo(),
                    entrada.getFecha()
            );
            entradasDTO.add(entry);
        }
        return entradasDTO;
    }
}
