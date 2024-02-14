package com.meli.manejoexcepciones.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.manejoexcepciones.dto.blog.BlogDTO;
import com.meli.manejoexcepciones.dto.common.ResponseDTO;
import com.meli.manejoexcepciones.entity.Blog;

public class BlogMapper {
    public static Blog toBlog(BlogDTO blogDTO){
        var mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return mapper.convertValue(blogDTO,Blog.class);
    }

    public static BlogDTO toBlogDTO(Blog blog){
        var mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return mapper.convertValue(blog,BlogDTO.class);
    }

    public static ResponseDTO toResponseDTO(Blog blog, String message){
        return new ResponseDTO(blog.getId(),message);
    }
}