package com.example.ejemplo_jpa.repository;

import com.example.ejemplo_jpa.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

}
