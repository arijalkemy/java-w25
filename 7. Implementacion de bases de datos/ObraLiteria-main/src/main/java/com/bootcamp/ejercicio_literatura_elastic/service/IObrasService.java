package com.bootcamp.ejercicio_literatura_elastic.service;

import com.bootcamp.ejercicio_literatura_elastic.dto.ObraLiterariaDTO;
import com.bootcamp.ejercicio_literatura_elastic.dto.response.ResponseDTO;

import java.util.List;

public interface IObrasService {
    ResponseDTO saveObra(ObraLiterariaDTO obraLiterariaDTO);
    List<ObraLiterariaDTO> getByAutor(String autor);
    List<ObraLiterariaDTO> findTitleObra(String title);
    List<ObraLiterariaDTO> getByEditorial(String editorial);
    List<ObraLiterariaDTO> obtenerObrasConMasPaginas();
    List<ObraLiterariaDTO> getObrasAntesDelAnio(int anio);

}
