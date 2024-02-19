package com.manejoExcepciones.blogAPI.Service;

import com.manejoExcepciones.blogAPI.DTOs.BlogRequestDTO;
import com.manejoExcepciones.blogAPI.DTOs.BlogResponseDTO;

import java.util.List;

public interface IBlogService {

    boolean addBlog(BlogRequestDTO blogRequestDTO);
    BlogResponseDTO getBlog(Integer id);
    List<BlogResponseDTO> getBlogs();
}
