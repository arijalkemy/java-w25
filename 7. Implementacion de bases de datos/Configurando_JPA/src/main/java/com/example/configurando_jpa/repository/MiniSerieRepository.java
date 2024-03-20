package com.example.configurando_jpa.repository;

import com.example.configurando_jpa.entity.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
