package com.bootcamp.ejercicio_literatura_elastic.repository;

import com.bootcamp.ejercicio_literatura_elastic.domain.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraRepository extends ElasticsearchRepository<ObraLiteraria,String> {
    List<ObraLiteraria> findAll();
    List<ObraLiteraria> findAllByAutor(String autor);
    List<ObraLiteraria> findAllByNombreContains(String title);

}
