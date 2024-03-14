package com.manejoExepciones.repository;

import com.manejoExepciones.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogRepository {

    public EntradaBlog save(EntradaBlog entradaBlog);

    public Optional<EntradaBlog> getById(int id);

    public List<EntradaBlog> getAll();

}
