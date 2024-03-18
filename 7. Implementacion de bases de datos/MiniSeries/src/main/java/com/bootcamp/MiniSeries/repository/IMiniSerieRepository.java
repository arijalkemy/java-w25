package com.bootcamp.MiniSeries.repository;

import com.bootcamp.MiniSeries.MiniSeriesApplication;
import com.bootcamp.MiniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
