package com.example.poryectoblog.repository;

import com.example.poryectoblog.entity.EntradaBlog;
import com.example.poryectoblog.exception.AlreadyExistsException;
import com.example.poryectoblog.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

    //List<EntradaBlog> entradaBlogList = List.of(new EntradaBlog(1,"Hola Mundo","Carlos","14/02/2024"));;

    private static List<EntradaBlog> entradaBlogList;

    public EntradaBlogRepository() {
        this.entradaBlogList= new ArrayList<>();
    }

    @Override
    public List<EntradaBlog> getAllEntradaBlog() {
        return entradaBlogList;
    }

    @Override
    public EntradaBlog getEntradaBlogById(Integer id) {
         EntradaBlog existe = entradaBlogList.stream().filter(entradaBlog -> entradaBlog.getId().equals(id)).findFirst().orElse(null);

         if (existe == null) throw new NotFoundException();

        return existe;
    }

    @Override
    public EntradaBlog saveEntradaBlog(EntradaBlog entradaBlog) {

        if (getEntradaBlogById(entradaBlog.getId()) != null) throw new AlreadyExistsException("Hola");

        entradaBlogList.add(entradaBlog);
        return entradaBlog;

    }
}
