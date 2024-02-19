package org.bootcamp.blog.service;

import org.bootcamp.blog.dto.BlogDto;
import org.bootcamp.blog.dto.ResponseDto;
import org.bootcamp.blog.exception.DuplicateBlogException;
import org.bootcamp.blog.exception.NotFoundException;
import org.bootcamp.blog.model.EntradaBlog;
import org.bootcamp.blog.repository.IBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{

    @Autowired
    IBlogRepository blogRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseDto addBlog(BlogDto blogDtoIn){
        // EntradaBlog entradaBlog = new EntradaBlog(blogDto.getId(), blogDto.getTitle(), blogDto.getAutor(), blogDto.getDatePosting());
        EntradaBlog entradaBlog = modelMapper.map(blogDtoIn, EntradaBlog.class);
        if (existenceValidation(entradaBlog)) blogRepository.add(entradaBlog);
        return new ResponseDto("Blog creado, id: " + entradaBlog.getId());
    }
    @Override
    public List<BlogDto> getAllBlogs(){
        List<EntradaBlog> blogs = blogRepository.getAll();
        if (blogs.isEmpty()) {
            throw new NotFoundException("No se encontró ningun blog");
        }
        return blogs.stream().map(blog -> modelMapper.map(blog, BlogDto.class)).toList();
    }

    public boolean existenceValidation(EntradaBlog entradaBlog){
        // Manejo de exception para cuando un blog con id x ya exista
        if(blogRepository.getById(entradaBlog.getId()).isEmpty()){
            return true;
        } else throw new DuplicateBlogException("No se pudo crear. Blog con id: {" + entradaBlog.getId() + "} ya existe");
    }
    @Override
    public BlogDto getBlogById(int blogId){
        List<EntradaBlog> blogsInRepo = blogRepository.getById(blogId);
        if(blogsInRepo.isEmpty()){
            throw new NotFoundException("No se pudo encontrar ningun blog asociado al id: { " + blogId + " }");
        } else {
            return modelMapper.map(blogsInRepo.stream().findAny().get(), BlogDto.class);
        }
    }

}
