package com.example.youtuber.service;

import com.example.youtuber.dto.EntradaBlogDto;
import com.example.youtuber.entities.EntradaBlog;
import com.example.youtuber.exceptions.AlreadyPresentException;
import com.example.youtuber.exceptions.NotFoundException;
import com.example.youtuber.repository.IYoutuberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YoutuberService implements IYoutuberService {

    @Autowired
    IYoutuberRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public EntradaBlogDto addBlog(EntradaBlogDto blog) {
        if (repository.getEntradaBlogById(blog.getId()) == null) {
            EntradaBlog entradaBlog = modelMapper.map(blog, EntradaBlog.class);
            return modelMapper.map(repository.addEntradaBlog(entradaBlog), EntradaBlogDto.class);

        } else {
            throw new AlreadyPresentException("Un blog con este id ya ha sido ingresado");
        }
    }

    public List<EntradaBlogDto> getAllBlogs() {
        List<EntradaBlog> lBlogs = repository.getAll();
        if (lBlogs.isEmpty()) {
            throw new NotFoundException("No se ha encontrado ningun blog");
        }
        return lBlogs.stream().map(blog -> modelMapper.map(blog, EntradaBlogDto.class)).toList();
    }


    public EntradaBlogDto getById(int id) {
        EntradaBlog blog = repository.getEntradaBlogById(id);
        if (blog == null) {
            throw new NotFoundException("No se ha encontrado ningun blog con el id " + id);
        } else {
            return modelMapper.map(blog, EntradaBlogDto.class);
        }

    }

}
