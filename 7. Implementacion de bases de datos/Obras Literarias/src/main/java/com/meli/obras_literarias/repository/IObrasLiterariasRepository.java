package com.meli.obras_literarias.repository;

import com.meli.obras_literarias.entity.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObrasLiterariasRepository extends ElasticsearchRepository<Obra,String> {
    List<Obra> findAll();
    List<Obra> findByAutor(String autor);
    List<Obra> findByNombreLike(String nombre);
    List<Obra> findTop5ByOrderByCantPaginasDesc();
    List<Obra> findByAnioLessThan(Integer anio);
    List<Obra> findByEditorial(String editorial);
}
