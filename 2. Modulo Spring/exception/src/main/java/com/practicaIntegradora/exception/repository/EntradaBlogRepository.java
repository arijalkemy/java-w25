package com.practicaIntegradora.exception.repository;

import com.practicaIntegradora.exception.dto.EntradaBlogDTO;
import com.practicaIntegradora.exception.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{
    List<EntradaBlogDTO> listEntradas= new ArrayList<EntradaBlogDTO>(){{
        add(new EntradaBlogDTO(1,"Prueba","Prueba","Prueba"));
    }};

    @Override
    public int createEntrada(EntradaBlogDTO entrada) {
        long i = listEntradas.stream().filter(blog -> blog.getId() == entrada.getId()).count();
        if(i > 0) return -1;
        listEntradas.add(entrada);
        return entrada.getId();
    }

    @Override
    public List<EntradaBlogDTO> getAll() {
        return listEntradas;
    }

    @Override
    public EntradaBlogDTO getById(int id) {
        for(EntradaBlogDTO entradaBlogDTO: listEntradas){
            if (entradaBlogDTO.getId()==id){
                return entradaBlogDTO;
            }
        }
        return null;
    }
}
