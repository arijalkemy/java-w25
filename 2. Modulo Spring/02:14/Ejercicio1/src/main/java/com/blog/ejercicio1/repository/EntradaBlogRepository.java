package com.blog.ejercicio1.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.blog.ejercicio1.entity.EntradaBlog;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository {
    private List<EntradaBlog> listEntradaBlog;

    public EntradaBlogRepository() {
        EntradaBlog entradaBlog1 = new EntradaBlog("El inicio", "Autor 1");
        EntradaBlog entradaBlog2 = new EntradaBlog("El fin", "Autor 2");
        this.listEntradaBlog = new ArrayList<>(List.of(entradaBlog1, entradaBlog2));
    }

    @Override
    public EntradaBlog postEntradaBlog(EntradaBlog entradaBlog) {
        this.listEntradaBlog.add(entradaBlog);
        return entradaBlog;
    }

    @Override
    public List<EntradaBlog> getAllEntradaBlog() {
        return this.listEntradaBlog;
    }

    @Override
    public EntradaBlog getEntradaBlogById(Integer id) {
        for (EntradaBlog entradaBlog : this.listEntradaBlog) {
            if (entradaBlog.getId() == id) {
                return entradaBlog;
            }
        }
        return null;
    }

}
