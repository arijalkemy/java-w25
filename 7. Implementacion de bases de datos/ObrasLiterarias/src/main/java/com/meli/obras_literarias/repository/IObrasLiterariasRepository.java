package com.meli.obras_literarias.repository;

import com.meli.obras_literarias.entity.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObrasLiterariasRepository extends ElasticsearchRepository<Obra,String> {
    List<Obra> findAll();
    List<Obra> findByAutor(String autor);
    List<Obra> findByNombreLike(String nombre);
    @Query("{\"sort\": [{\"cantPaginas\": {\"order\": \"desc\"}}], \"size\": 5}")
    List<Obra> findTop5PagesQuantity();
    List<Obra> findByAnioBefore(Integer anio);
    List<Obra> findByEditorial(String editorial);
}
