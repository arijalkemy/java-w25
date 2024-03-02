package org.example.manejo_de_excepciones_p1_vivo.service;

import org.example.manejo_de_excepciones_p1_vivo.dto.BlogDto;
import org.example.manejo_de_excepciones_p1_vivo.dto.BlogListDto;
import org.example.manejo_de_excepciones_p1_vivo.dto.SimpleResponseDto;
import org.example.manejo_de_excepciones_p1_vivo.entity.EntradaBlog;
import org.example.manejo_de_excepciones_p1_vivo.exception.AlreadyExistException;
import org.example.manejo_de_excepciones_p1_vivo.exception.NotFoundException;
import org.example.manejo_de_excepciones_p1_vivo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements BlogServiceInterface{

    @Autowired
    BlogRepository blogRepository = new BlogRepository();

    @Override
    public SimpleResponseDto createBlog(BlogDto blog) {
        if(blogRepository.findOneBlogById(blog.getId()).isPresent()) throw new AlreadyExistException("El blog con el Id {"+blog.getId()+"} Ya existe");
        blogRepository.insertNewBlog(blogDtoToEntity(blog));
        return new SimpleResponseDto("El blog con Id {"+blog.getId()+"} Ha sido creado correctamente");
    }

    @Override
    public BlogDto getOneBlogById(int id) throws NotFoundException {
        Optional<EntradaBlog> blog = blogRepository.findOneBlogById(id);
        if(blogRepository.findOneBlogById(id).isEmpty()) throw new NotFoundException("El Blog solicitado con Id {"+id+"} No Existe.");
        return new BlogDto(
                blog.get().getId(),
                blog.get().getTitle(),
                blog.get().getName(),
                blog.get().getDate()
        );
    }

    @Override
    public BlogListDto getAllBlogs() {
        return new BlogListDto(blogRepository.findAllBlogs().stream().map(this::blogEntityToDto).toList());
    }

    private EntradaBlog blogDtoToEntity(BlogDto blogDto) {
        return new EntradaBlog(
                blogDto.getId(),
                blogDto.getTitle(),
                blogDto.getName(),
                blogDto.getDate()
        );
    }

    private BlogDto blogEntityToDto(EntradaBlog entityBLog){
        return new BlogDto(
                entityBLog.getId(),
                entityBLog.getTitle(),
                entityBLog.getName(),
                entityBLog.getDate()
        );
    }
}
