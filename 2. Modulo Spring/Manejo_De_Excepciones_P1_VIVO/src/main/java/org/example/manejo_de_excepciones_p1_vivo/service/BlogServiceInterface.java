package org.example.manejo_de_excepciones_p1_vivo.service;

import org.example.manejo_de_excepciones_p1_vivo.dto.BlogDto;
import org.example.manejo_de_excepciones_p1_vivo.dto.BlogListDto;
import org.example.manejo_de_excepciones_p1_vivo.dto.SimpleResponseDto;
import org.example.manejo_de_excepciones_p1_vivo.exception.NotFoundException;

public interface BlogServiceInterface {
    SimpleResponseDto createBlog(BlogDto blog);
    BlogDto getOneBlogById(int id) throws NotFoundException;
    BlogListDto getAllBlogs();
}
