package com.practicas.MiniSeries.repository;

import com.practicas.MiniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {

    Optional<MiniSerie> findFirstByName(String name);



}
