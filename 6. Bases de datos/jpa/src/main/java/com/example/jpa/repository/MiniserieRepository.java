package com.example.jpa.repository;

import com.example.jpa.model.Miniseries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniserieRepository extends JpaRepository<Miniseries, Long> {

}
