package com.example.showroom.repository;

import com.example.showroom.model.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  ClotheRepository extends JpaRepository<Clothe, Long> {
    //@Query("SELECT c FROM Clothe c WHERE c.nombre LIKE ?1")
    List<Clothe> findClothesByNombreContainingIgnoreCase(String nombre);

    List<Clothe> findClothesByTalleIgnoreCase(String talle);
}


