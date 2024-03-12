package com.example.poryectoblog.service;

import com.example.poryectoblog.dto.EntradaBlogDto;
import com.example.poryectoblog.dto.ErrorDto;
import com.example.poryectoblog.dto.SuccessDto;
import com.example.poryectoblog.exception.AlreadyExistsException;
import com.example.poryectoblog.exception.NotFoundException;
import com.example.poryectoblog.repository.IEntradaBlogRepository;
import com.example.poryectoblog.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaBlogService implements IEntradaBlogService{

    private IEntradaBlogRepository entradaBlogRepository;


    public EntradaBlogService(IEntradaBlogRepository entradaBlogRepository){
        this.entradaBlogRepository = entradaBlogRepository;
    }


    @Override
    public ResponseEntity<?> addNewEntradaBlog(EntradaBlogDto entradaBlog) {
        try {
            entradaBlogRepository.saveEntradaBlog(Utils.entradaBlogDtoToEntity(entradaBlog));
        }catch (Exception e){
            //return new ResponseEntity<>(new ErrorDto("El numero de id "+entradaBlog.getId()+" ya existe"), HttpStatus.BAD_REQUEST);
            throw new AlreadyExistsException("El numero de id "+entradaBlog.getId()+" ya existe");
        }

        return new ResponseEntity<>(new SuccessDto("El Blog con id: "+entradaBlog.getId()+" fue creada Exitosamente "),HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<?> getEntradaBlogById(Integer id) {

        try {
            return new ResponseEntity<>(Utils.entradaBlogEntityToDto(entradaBlogRepository.getEntradaBlogById(id)),HttpStatus.OK);
        }catch (NotFoundException e){
            //return new ResponseEntity<>(new ErrorDto("El numero de id "+entradaBlog.getId()+" ya existe"), HttpStatus.BAD_REQUEST);
            throw new NotFoundException("No existe el blog con el id: "+id);
        }


    }

    @Override
    public List<EntradaBlogDto> getAllEntradaBlog() {
        return null;
    }
}
