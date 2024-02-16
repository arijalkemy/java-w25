package com.ejemplo.blog.service;

import com.ejemplo.blog.dto.EntradaBlogDTO;
import com.ejemplo.blog.dto.ResponseDTO;
import com.ejemplo.blog.model.EntradaBlog;

import java.util.List;

public interface IService {

    ResponseDTO create(EntradaBlogDTO entradaBlogDTO);

    ResponseDTO getBlog(int id);

    List<ResponseDTO> getBlogs();

}
