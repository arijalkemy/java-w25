package com.mercadolibre.elasticsearch_vivo.repository;

import com.mercadolibre.elasticsearch_vivo.entity.LiteraryWork;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ILiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {
    List<LiteraryWork> findAll();
    List<LiteraryWork> findLiteraryWorksByAuthor(String author);
    List<LiteraryWork> findLiteraryWorksByNameContaining(String name);

    List<LiteraryWork> findFirst5ByOrderByPageCountDesc();
}
