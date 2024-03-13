package com.example.practicaES.repository;

import com.example.practicaES.entities.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraRepository extends ElasticsearchRepository<Obra, String> {
    List<Obra> findAll();

    List<Obra> findByAutor(String autor);

    List<Obra> findByNombreLike(String nombre);

    List<Obra> findTop5OrderByPaginas();

    List<Obra> findByAnioBefore(Integer anio);

    List<Obra> findByEditorial(String editorial);
}
