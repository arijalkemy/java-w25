package com.example.ObrasLiterarias.repository;

import co.elastic.clients.elasticsearch.ml.Page;
import com.example.ObrasLiterarias.model.ObraLiteraria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    List<ObraLiteraria> getObraLiterariaByNameContainingIgnoreCase(String keyword);

    List<ObraLiteraria> findTopByPages();
    List<ObraLiteraria> getTopByPagesOrderByPagesDesc(Integer num);

    //List<ObraLiteraria> queryObraLit

    List<ObraLiteraria> findTop5ByOrderByPagesDesc(Pageable pageable);

}
