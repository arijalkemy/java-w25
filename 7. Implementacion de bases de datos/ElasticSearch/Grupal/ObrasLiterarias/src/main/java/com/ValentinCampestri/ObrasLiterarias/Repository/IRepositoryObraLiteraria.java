package com.ValentinCampestri.ObrasLiterarias.Repository;

import com.ValentinCampestri.ObrasLiterarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryObraLiteraria extends ElasticsearchRepository<ObraLiteraria,String> {

    // Traer todas las obras (no solicitado pero util para debuguear; sólo dev nunca prod)
    // @Query("{\"query\":\"SELECT * FROM ObraLiteraria\"}")
    List<ObraLiteraria> findBy();
}
