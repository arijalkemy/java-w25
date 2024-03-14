package com.manejoExepciones.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manejoExepciones.dto.IDBlogDTO;
import com.manejoExepciones.dto.RequestBlogDTO;
import com.manejoExepciones.dto.ResponseBlogDTO;
import com.manejoExepciones.entity.EntradaBlog;
import com.manejoExepciones.exception.AlreadyExistException;
import com.manejoExepciones.exception.NotFoundException;
import com.manejoExepciones.repository.IEntradaBlogRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntradaBlogServiceImp implements IEntradaBlogService{

    private IEntradaBlogRepository entradaBlogRepository;

    @Autowired
    public EntradaBlogServiceImp(IEntradaBlogRepository entradaBlogRepository) {
        this.entradaBlogRepository = entradaBlogRepository;
    }

    @Override
    public IDBlogDTO save(RequestBlogDTO requestBlogDto) {
        Optional<EntradaBlog> dtoOptional = entradaBlogRepository.getById(requestBlogDto.getId());

        if(dtoOptional.isEmpty()){
            ModelMapper modelMapper = new ModelMapper();
            LocalDate time = LocalDate.now();
            EntradaBlog entradaBlog = new EntradaBlog();

            entradaBlog = modelMapper.map(requestBlogDto, EntradaBlog.class);
            entradaBlog.setFecha(String.valueOf(time));

            EntradaBlog entradaBlog2 = entradaBlogRepository.save(entradaBlog);
            IDBlogDTO idBlogDTO = new IDBlogDTO("Creado correctamente", entradaBlog2.getId());
            return idBlogDTO;
        }else{
            throw new AlreadyExistException();
        }

    }


    @Override
    public Optional<ResponseBlogDTO> getById(int id) {
        Optional<EntradaBlog> entradaBlog = entradaBlogRepository.getById(id);

        if(entradaBlog.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            ResponseBlogDTO responseBlogDTO = new ResponseBlogDTO();

            responseBlogDTO = modelMapper.map(entradaBlog.get(), ResponseBlogDTO.class);

            return Optional.of(responseBlogDTO);

        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public List<ResponseBlogDTO> getAll() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

      List<EntradaBlog> entradaBlogs = entradaBlogRepository.getAll();

      List<ResponseBlogDTO> responseBlogDTOS = new ArrayList<>();

        for (EntradaBlog entrada : entradaBlogs ) {
           responseBlogDTOS.add(modelMapper.map(entrada, ResponseBlogDTO.class));
        }

        return responseBlogDTOS;
    }
}
