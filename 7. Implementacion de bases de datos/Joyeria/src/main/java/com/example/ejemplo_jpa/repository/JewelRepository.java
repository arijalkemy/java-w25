package com.example.ejemplo_jpa.repository;

import com.example.ejemplo_jpa.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelRepository extends JpaRepository <Jewel, Long> {



}
