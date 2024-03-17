package com.obrasliterarias.repository;

import com.obrasliterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    List<ObraLiteraria> findObraLiterariaByAutor(String autor);

    List<ObraLiteraria> findObraLiterariaByNombreContaining(String palabra);


    List<ObraLiteraria> findObraLiterariaByAnioBefore(int x);

    List<ObraLiteraria> findObraLiterariaByEditorial(String editorial);

    List<ObraLiteraria> findTop5ByOrderByPaginasDesc();
    List<ObraLiteraria> findAll();
}
