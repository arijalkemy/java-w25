package com.bootcamp.ejercicio_blog.repository;

import com.bootcamp.ejercicio_blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImp implements IBlogRepository {
    private List<EntradaBlog> entradaBlogList;

    public BlogRepositoryImp() {
        this.entradaBlogList = new ArrayList<>(
                Arrays.asList(
                        new EntradaBlog(1, "Titulo-1", "Autor-1", "01/01/2001"),
                        new EntradaBlog(2, "Titulo-2", "Autor-2", "02/02/2002")
                )
        );
    }

    @Override
    public void add(EntradaBlog entradaBlog) {
        this.entradaBlogList.add(entradaBlog);
    }


    @Override
    public Optional<EntradaBlog> getById(int id) {
        return this.entradaBlogList.stream()
                .filter(entrada -> entrada.getId() == id)
                .findFirst();
    }

    @Override
    public List<EntradaBlog> getAll() {
        return this.entradaBlogList;
    }
}
