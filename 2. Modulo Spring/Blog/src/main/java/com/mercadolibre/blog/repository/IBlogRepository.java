package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    public void addEntry(EntradaBlog entry);
    public EntradaBlog findById(int id);
    public List<EntradaBlog> getAll();
}
