package com.mercadolibre.clave_compuesta.repository;

import com.mercadolibre.clave_compuesta.model.Compra;
import com.mercadolibre.clave_compuesta.model.CompraPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository <Compra, CompraPK> {
}
