package com.example.bootcamp.repositories;

import com.example.bootcamp.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // se puede hacer inyeccion de dependencias en el service
// Probar si se pueden inyectar en service sin el @repository,
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {

}
