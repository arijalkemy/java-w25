package com.obrasliterarias.elasticsearch.repository;

import com.obrasliterarias.elasticsearch.entity.ObraLiteraria;
import org.springframework.data.domain.Limit;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findAll();

    // Retornar las obras de un determinado autor. Por ejemplo, todas las obras de “Garcia Marquez”
    List<ObraLiteraria> findAllByAutor(String autor);

    // Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    List<ObraLiteraria> findAllByNombreContainingIgnoreCase(String nombre);

    // Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    List<ObraLiteraria> findTop5PagesQuantity();

    // Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    List<ObraLiteraria> findAllByAnioPublicacionBefore(Integer anio);

    // Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    List<ObraLiteraria> findAllByEditorial(String editorial);
}
