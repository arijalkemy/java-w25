package com.mercadolibre.empresadeseguros.repository;

import com.mercadolibre.empresadeseguros.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
