package com.example.ejercicio_obras.service;

import com.example.ejercicio_obras.dto.ObraLiterariaDTO;
import com.example.ejercicio_obras.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface IObraLiterariaService {
    ObraLiterariaDTO save(ObraLiterariaDTO obraLiterariaDTO);
    //Retornar las obras de un determinado autor. Por ejemplo, todas las obras de “Garcia Marquez”
    List<ObraLiterariaDTO> getBookByAutor(String name);
    //Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    List<ObraLiterariaDTO> listByKeyWords(String keyWord);
    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    List<ObraLiterariaDTO> listTopFive();
    //Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    List<ObraLiterariaDTO> listBefore(Integer anio);
    //Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    List<ObraLiteraria> listByEditorial(String editorial);
}
