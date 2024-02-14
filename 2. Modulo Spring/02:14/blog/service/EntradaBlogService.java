package com.blog.ejercicio1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.ejercicio1.dto.request.EntradaBlogRequestDTO;
import com.blog.ejercicio1.dto.response.EntradaBlogIdResDTO;
import com.blog.ejercicio1.dto.response.EntradaBlogResponseDTO;
import com.blog.ejercicio1.entity.EntradaBlog;
import com.blog.ejercicio1.repository.EntradaBlogRepository;

@Service
public class EntradaBlogService implements IEntradaBlogService {

    @Autowired
    EntradaBlogRepository entradaBlogRepository;

    @Override
    public EntradaBlogIdResDTO postEntradaBlog(EntradaBlogRequestDTO entradaBlogRequestDTO) {
        EntradaBlog entradaBlog = entradaBlogRepository.postEntradaBlog(
                new EntradaBlog(entradaBlogRequestDTO.getTitulo(), entradaBlogRequestDTO.getNombreAutor()));
        return new EntradaBlogIdResDTO(entradaBlog);
    }

    @Override
    public List<EntradaBlogResponseDTO> getAllEntradaBlog() {
        List<EntradaBlogResponseDTO> auxList = new ArrayList<>();
        for (EntradaBlog entradaBlog : entradaBlogRepository.getAllEntradaBlog()) {
            auxList.add(new EntradaBlogResponseDTO(entradaBlog));
        }
        return auxList;
    }

    @Override
    public EntradaBlogResponseDTO getEntradaBlogById(Integer id) {
        EntradaBlog entradaBlog = entradaBlogRepository.getEntradaBlogById(id);
        if (entradaBlog != null) {
            return new EntradaBlogResponseDTO(entradaBlog);
        }
        return null;
    }
}
