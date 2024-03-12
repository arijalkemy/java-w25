package com.example.ejercicio_obras.repository;

import com.example.ejercicio_obras.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObrasRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> getAllByAutor(String autor);
    List<ObraLiteraria> findByNombreContaining(String nombre);
    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    List<ObraLiteraria> findTop5ByOrderByPaginasDesc();

    // Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    List<ObraLiteraria> findAllByAnio(Integer anio);

    // Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    List<ObraLiteraria> getAllByEditorial(String editorial);


}
