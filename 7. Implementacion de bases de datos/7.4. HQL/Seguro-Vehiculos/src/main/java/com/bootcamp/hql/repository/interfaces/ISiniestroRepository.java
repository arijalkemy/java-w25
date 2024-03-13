package com.bootcamp.hql.repository.interfaces;

import com.bootcamp.hql.model.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
