package com.miniseries.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniseries.main.model.MiniSerie;


@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {

}
