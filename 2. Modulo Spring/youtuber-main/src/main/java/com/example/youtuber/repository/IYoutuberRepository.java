package com.example.youtuber.repository;

import com.example.youtuber.entities.EntradaBlog;

import java.util.List;

public interface IYoutuberRepository {

    public List<EntradaBlog> getAll();

    public EntradaBlog getEntradaBlogById(int id);

    public EntradaBlog  addEntradaBlog(EntradaBlog blog);


}
