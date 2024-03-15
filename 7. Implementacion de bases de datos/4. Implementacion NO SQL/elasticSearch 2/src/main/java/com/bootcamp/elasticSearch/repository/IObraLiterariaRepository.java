package com.bootcamp.elasticSearch.repository;

import com.bootcamp.elasticSearch.model.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {


    List<ObraLiteraria> findAll();

    List<ObraLiteraria> findByAutor(String autor);

    List<ObraLiteraria> findByNombreIsLike(String title);

    List<ObraLiteraria> findObraLiterariaByAnioPublicacionIsBefore(int year);

    List<ObraLiteraria> findObraLiterariaByEditorial(String editorial);

    //tengo que traer los 5 libros con mas paginas
    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();
}
