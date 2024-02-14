package com.example.youtuber.repository;

import com.example.youtuber.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    public List<EntradaBlog> findAll();
    public EntradaBlog findById(int id);
    public EntradaBlog newEntrada(EntradaBlog entrada);

}
