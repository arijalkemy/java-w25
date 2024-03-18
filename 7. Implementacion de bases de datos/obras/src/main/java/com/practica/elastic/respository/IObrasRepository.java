package com.practica.elastic.respository;

import com.practica.elastic.domain.Obras;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface IObrasRepository extends ElasticsearchRepository<Obras, String> {

    List<Obras> findByAutor(String autor);
    List<Obras>  findByEditorial(String editorial);
    List<Obras> findByNameLike(String name);
    List<Obras> findTop5ByOrderByNumeroPaginasDesc();
    List<Obras> findByPublicacionBefore(LocalDate date);
    List<Obras> findAll();
}
