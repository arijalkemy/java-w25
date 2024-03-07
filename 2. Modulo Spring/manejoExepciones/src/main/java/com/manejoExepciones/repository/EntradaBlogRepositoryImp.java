package com.manejoExepciones.repository;

import com.manejoExepciones.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class EntradaBlogRepositoryImp implements IEntradaBlogRepository{

    private List<EntradaBlog> entradaBlogs = new ArrayList<>();

    @Override
    public EntradaBlog save(EntradaBlog entradaBlog) {
        entradaBlogs.add(entradaBlog);


        return entradaBlog;
    }

    @Override
    public Optional<EntradaBlog> getById(int id) {

        return entradaBlogs.stream().filter(x -> x.getId()==id).findFirst();

    }

    @Override
    public List<EntradaBlog> getAll() {

        return entradaBlogs;
    }
}
