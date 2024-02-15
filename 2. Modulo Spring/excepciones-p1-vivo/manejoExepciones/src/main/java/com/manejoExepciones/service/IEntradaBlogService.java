package com.manejoExepciones.service;

import com.manejoExepciones.dto.IDBlogDTO;
import com.manejoExepciones.dto.RequestBlogDTO;
import com.manejoExepciones.dto.ResponseBlogDTO;
import com.manejoExepciones.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogService {

    public IDBlogDTO save(RequestBlogDTO requestBlogDto);

    public Optional<ResponseBlogDTO> getById(int id);

    public List<ResponseBlogDTO> getAll();


}
