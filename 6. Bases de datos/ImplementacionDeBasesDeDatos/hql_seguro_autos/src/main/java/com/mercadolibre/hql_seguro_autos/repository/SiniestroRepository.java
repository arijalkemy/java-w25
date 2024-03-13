package com.mercadolibre.hql_seguro_autos.repository;

import com.mercadolibre.hql_seguro_autos.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface SiniestroRepository extends JpaRepository<Siniestro,Long> {
}
