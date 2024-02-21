package com.sfritz.blog.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfritz.blog.dtos.BlogDto;
import com.sfritz.blog.entities.Blog;

public class Mapper {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Blog blogDtoToBlog(BlogDto blogDto){
        return objectMapper.convertValue(blogDto, Blog.class);
    }

    public static BlogDto blogToBlogDto(Blog blog){
        return objectMapper.convertValue(blog, BlogDto.class);
    }
}
