package com.meli.manejoexcepciones.service;

import com.meli.manejoexcepciones.dto.common.ResponseDTO;
import com.meli.manejoexcepciones.dto.blog.BlogDTO;

import java.util.List;

public interface IBlogService {
    ResponseDTO create(BlogDTO blogDTO);

    BlogDTO getById(int id);

    List<BlogDTO> getAll();
}