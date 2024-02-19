package com.mercadolibre.blog.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.blog.dto.BlogDto;
import com.mercadolibre.blog.entity.Blog;
import com.fasterxml.jackson.core.type.TypeReference;

public  class Mapeador {

    public static final String BASEURI= "http://localhost:8080/api/v1/blog/";
    public static Blog mapDtoToEntity(BlogDto blogDto){
        return new Blog(blogDto.getTitle(), blogDto.getAuthor(), blogDto.getPubishDate());

    }
    public static BlogDto mapEntityToDt(Integer id, Blog blog){
        return new BlogDto(id, blog.getTitle(), blog.getAuthor(), blog.getPubishDate(),BASEURI+id);

    }
}
