package com.example.poryectoblog.repository;

import com.example.poryectoblog.entity.EntradaBlog;
import com.example.poryectoblog.exception.AlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

    private static List<EntradaBlog> entradaBlogList = List.of(new EntradaBlog(1,"Hola Mundo","Carlos","14/02/2024"));

    @Override
    public List<EntradaBlog> getAllEntradaBlog() {
        return entradaBlogList;
    }

    @Override
    public EntradaBlog getEntradaBlogById(Integer id) {
        return entradaBlogList.stream().filter(entradaBlog -> entradaBlog.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public EntradaBlog saveEntradaBlog(EntradaBlog entradaBlog) {

        if (getEntradaBlogById(entradaBlog.getId()) != null) throw new AlreadyExistsException();

        entradaBlogList.add(entradaBlog);
        return entradaBlog;

    }
}
