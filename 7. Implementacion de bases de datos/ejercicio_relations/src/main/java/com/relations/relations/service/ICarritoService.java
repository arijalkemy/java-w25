package com.relations.relations.service;

import com.relations.relations.dto.request.RequestCarritoDto;
import com.relations.relations.dto.response.GenericReponseDTO;
import com.relations.relations.dto.response.ResponseCarritoDto;
import com.relations.relations.model.Carrito;
import org.apache.coyote.Response;

import java.util.List;

public interface ICarritoService {
    List<ResponseCarritoDto> getAll();
    ResponseCarritoDto getById(Long id);
    GenericReponseDTO save(RequestCarritoDto carritoDto);
    GenericReponseDTO deleteById(Long id);

}
