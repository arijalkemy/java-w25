package com.example.ObrasLiterarias.repository;

import com.example.ObrasLiterarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria,String> {

    List<ObraLiteraria> findAll();

    List<ObraLiteraria> findAllByAutor (String autor);

    List<ObraLiteraria> findAllByNombre (String nombre);

    List<ObraLiteraria> findTop5OrderByCantidadPaginas();

    List<ObraLiteraria> findAllByAnioPublicacionBefore (int year);

    List<ObraLiteraria> findAllByEditorial (String editorial);

}
