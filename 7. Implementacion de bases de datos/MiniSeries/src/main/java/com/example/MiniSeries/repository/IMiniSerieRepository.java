package com.example.MiniSeries.repository;

import com.example.MiniSeries.entity.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long>{
}
