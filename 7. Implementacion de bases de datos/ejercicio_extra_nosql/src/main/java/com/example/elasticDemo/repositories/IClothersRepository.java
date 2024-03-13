package com.example.elasticDemo.repositories;

import com.example.elasticDemo.model.Clothes;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothersRepository extends ElasticsearchRepository<Clothes, String> {
    // Prendas de un determinado talle
    List<Clothes> findAllByTalle(Double talle);

    // Prendas con una palabra clave
    List<Clothes> findAllByNombreMatchesRegex(String regex);
}
