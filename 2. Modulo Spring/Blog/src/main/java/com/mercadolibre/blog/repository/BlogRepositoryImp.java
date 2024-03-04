package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BlogRepositoryImp implements IBlogRepository {
    private List<EntradaBlog> entradas;

    public BlogRepositoryImp(List<EntradaBlog> entradas) {
        this.entradas = new ArrayList<>(
                Arrays.asList(
                        new EntradaBlog(1, "entrada1", "Juan", "01/02/2024"),
                        new EntradaBlog(2, "entrada2", "Jose", "01/02/2024")
                )
        );
    }

    @Override
    public void addEntry(EntradaBlog entry) {
        this.entradas.add(entry);
    }

    @Override
    public EntradaBlog findById(int id) {
        for (EntradaBlog entradaBlog : entradas) {
            if (entradaBlog.getId() == id) {
                return entradaBlog;
            }
        }
        return null;
    }

    @Override
    public List<EntradaBlog> getAll() {
        return entradas;
    }
}
