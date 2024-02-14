package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.request.BlogDTORequest;
import com.bootcamp.blog.dto.response.BlogDTOResponse;
import com.bootcamp.blog.exceptions.AlreadyBlogExistException;
import com.bootcamp.blog.exceptions.NotFoundBlogException;
import com.bootcamp.blog.model.EntradaBlog;
import com.bootcamp.blog.repository.BlogRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{

    BlogRepositoryImpl blogRepo;
    public BlogServiceImpl(){
        this.blogRepo = new BlogRepositoryImpl();
    }

    @Override
    public BlogDTOResponse createBlog(BlogDTORequest blogDTORequest) {

        EntradaBlog entradaBlog = new EntradaBlog(blogDTORequest.getId(),blogDTORequest.getTitulo(),blogDTORequest.getAutor(),blogDTORequest.getFechaPublicacion());
        if(blogRepo.findById(entradaBlog.getId())!=null){
            throw new AlreadyBlogExistException("El blog ya existe, no se puede crear");
        }
        BlogDTOResponse blogDTOResponse = new BlogDTOResponse();
        blogDTOResponse.setId(blogRepo.save(entradaBlog));
        return blogDTOResponse;
    }

    @Override
    public BlogDTOResponse getBlogById(int id) {

        EntradaBlog entradaBlog = blogRepo.findById(id);

        if(entradaBlog!=null){
             return new BlogDTOResponse(entradaBlog.getId(),entradaBlog.getTitulo(), entradaBlog.getAutor(), entradaBlog.getFechaPublicacion());
        }else{
            throw new NotFoundBlogException("El blog con id: "+id+" no existe.");
        }

    }

    @Override
    public List<BlogDTOResponse> findAll(){
        return this.blogRepo.findAll().stream().map(blog ->
                new BlogDTOResponse(
                        blog.getId(),
                        blog.getTitulo(),
                        blog.getAutor(),
                        blog.getFechaPublicacion()))
                .toList();
    }


}
