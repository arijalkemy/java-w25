package com.bootcamp.service;

import com.bootcamp.dto.BlogDto;
import com.bootcamp.dto.CreatedBlogDto;
import com.bootcamp.entity.Blog;
import com.bootcamp.exception.DuplicatedEntryException;
import com.bootcamp.exception.NotFoundException;
import com.bootcamp.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository repo;
    @Override
    public CreatedBlogDto createBlog(BlogDto blogDto) {
        Blog blog = mapBlogDtoTOBlog(blogDto);
        if(this.repo.create(blog) != null){
            throw new DuplicatedEntryException
                    ("La entrada de blog " + blog.getId() + " ya existe");
        }


        return new CreatedBlogDto("Blog " + blog.getId() + " ha sido creado correctamente");
    }

    @Override
    public BlogDto findById(Integer id) {
        Blog blog = this.repo.findById(id);
        if(blog != null) return mapBlogTOBlogDto(blog);
        throw new NotFoundException("El blog de id " + id + " no ha sido encontrado");
    }

    @Override
    public List<BlogDto> findAll() {
        List<Blog> blogs = this.repo.findAll();
        if(blogs.isEmpty()) throw new NotFoundException("No hay entradas de blog cargadas");
        return blogs.stream().map(this::mapBlogTOBlogDto).toList();
    }

    private Blog mapBlogDtoTOBlog(BlogDto blogDto) {
        String[] arrayDate = blogDto.getPublishDate().split("-");
        //Format date YYYY-MM-DD
        LocalDate date = LocalDate.of(Integer.parseInt(arrayDate[0]), Integer.parseInt(arrayDate[1]), Integer.parseInt(arrayDate[2]));
        return new Blog(
                blogDto.getId(),
                blogDto.getTitle(),
                blogDto.getAuthor(),
                date
        );
    }

    private BlogDto mapBlogTOBlogDto(Blog blog) {
        return new BlogDto(
                blog.getId(),
                blog.getTitle(),
                blog.getAuthor(),
                blog.getPublishDate().toString()
        );
    }


}
