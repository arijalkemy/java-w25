package com.sfritz.blog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sfritz.blog.dtos.BlogDto;
import com.sfritz.blog.entities.Blog;
import com.sfritz.blog.exceptions.AlreadyPresentException;
import com.sfritz.blog.exceptions.NotFoundException;
import com.sfritz.blog.repositories.IBlogRepository;
import com.sfritz.blog.util.Mapper;

@Service
public class BlogService implements IBlogService{

    private IBlogRepository repository;

    public BlogService(IBlogRepository repository){
        this.repository = repository;
    }

    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        Blog blog = repository.getBlogById(blogDto.getId());
        if(blog != null){
            if(blog.getId().equals(blogDto.getId())){
                throw new AlreadyPresentException("Ya existe un blog con id: "+blogDto.getId());
            }
        }
        return Mapper.blogToBlogDto(repository.createBlog(Mapper.blogDtoToBlog(blogDto)));
    }

    @Override
    public BlogDto getBlogById(Integer id) {
        BlogDto blogDto = Mapper.blogToBlogDto(repository.getBlogById(id));
        if(blogDto == null){
            throw new NotFoundException("No se encuentra blog con id: "+id);
        }
        return blogDto;
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        return repository.getAllBlogs().stream().map(b -> Mapper.blogToBlogDto(b)).collect(Collectors.toList());
    }

}
