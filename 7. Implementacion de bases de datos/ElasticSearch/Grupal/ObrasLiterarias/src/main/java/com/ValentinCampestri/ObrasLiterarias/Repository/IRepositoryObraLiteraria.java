package com.ValentinCampestri.ObrasLiterarias.Repository;

import com.ValentinCampestri.ObrasLiterarias.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

public interface IRepositoryObraLiteraria extends ElasticsearchRepository<ObraLiteraria,String> {
}
