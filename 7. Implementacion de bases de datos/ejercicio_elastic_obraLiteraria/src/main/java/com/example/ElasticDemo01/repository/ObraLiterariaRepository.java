package com.example.ElasticDemo01.repository;

import com.example.ElasticDemo01.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    List<ObraLiteraria> findAll();

    // Retornar las obras de un determinado autor. Por ejemplo, todas las obras de “Garcia Marquez”
    List<ObraLiteraria> findByAutor(String autor); // Utilizo Query methods

    // Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    @Query("{\"bool\": { \"filter\": [{ \"match\" : { \"nombre\" : \"?0\"} }]}}")
    List<ObraLiteraria> findByPalabraClave(String palabra);

    // Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.

    List<ObraLiteraria> findAllByOrderByCantidadPaginasDesc();

    //@Query("{\"sort\": [{ \"cantidadPaginas\": { \"order\": \"desc\" } }], \"size\": 5}")
    //List<ObraLiteraria> findAllByOrderByCantidadPaginasDescQuery();

    // Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.

    List<ObraLiteraria> findAllByFechaPublicacionBefore(LocalDate fecha);

    // Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”

    List<ObraLiteraria> findAllByEditorial(String editorial);

}
