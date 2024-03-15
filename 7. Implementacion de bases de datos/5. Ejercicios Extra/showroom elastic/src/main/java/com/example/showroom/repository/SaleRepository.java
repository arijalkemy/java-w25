package com.example.showroom.repository;

import com.example.showroom.model.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends ElasticsearchRepository<Sale, String> {
    List<Sale> findAll();
    List<Sale> findSalesByDate(LocalDate date);

}
