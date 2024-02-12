package com.mercadolibre.concesionaria_de_autos.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    T save(T t);
    Optional<T> findById(Long id);
    List<T> findAll();

}
