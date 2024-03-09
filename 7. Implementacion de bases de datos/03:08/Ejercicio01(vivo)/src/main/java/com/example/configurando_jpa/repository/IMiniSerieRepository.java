package com.example.configurando_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.configurando_jpa.model.MiniSerie;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
