package com.example.elasticDemo.repositories;

import com.example.elasticDemo.model.Clothes;
import com.example.elasticDemo.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {
    // Traer todas las prendas de una determinada fecha
    List<Sale> findAllByFecha(LocalDate fecha);
    // Traer la lista completa de prendas de una determinada venta.
    @Query("SELECT s.prendas FROM Sale s where s.id = :id")
    List<Clothes> findClothesBySale(@Param("id") Long id);
}
