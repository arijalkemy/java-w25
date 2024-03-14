package com.example.ElasticDemo01.repository;

import com.example.ElasticDemo01.entity.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IObraRepository extends ElasticsearchRepository<Obra, String> {
    List<Obra> findAll();
    List<Obra> findByAutor(String autor);
    List<Obra> findByNombreContaining(String titulo);

    List<Obra> findAllOrderByCantidadPaginasDesc();
    List<Obra> findByAnioBefore(String anio);
    List<Obra> findByEditorial(String editorial);
}
