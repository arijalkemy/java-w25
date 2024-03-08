package com.nq.mini_series.repository;

import com.nq.mini_series.entity.MiniSerie;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mysql")
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}