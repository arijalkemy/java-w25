package com.example.elasticDemo.repositories;

import com.example.elasticDemo.model.Clothes;
import com.example.elasticDemo.model.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends ElasticsearchRepository<Sale, String> {
    // Traer todas las prendas de una determinada fecha
    List<Sale> findAllByFecha(LocalDate fecha);
    // Traer la lista completa de prendas de una determinada venta.
    // se llama a find by id
}
