package com.meli.obras_literarias.service;

import com.meli.obras_literarias.dto.request.ReqObraDTO;
import com.meli.obras_literarias.dto.response.MessageDto;
import com.meli.obras_literarias.dto.response.ResObraDTO;

import java.util.List;

public interface IObrasLiterariasService {
    MessageDto saveObra(ReqObraDTO reqObraDTO);

    List<ResObraDTO> getAll();

    List<ResObraDTO> getByAutor(String autor);

    List<ResObraDTO> getByTituloLike(String palabraClave);

    List<ResObraDTO> getTop5PagesQuantity();

    List<ResObraDTO> getByYearBefore(Integer year);

    List<ResObraDTO> getByEditorial(String editorial);



}
