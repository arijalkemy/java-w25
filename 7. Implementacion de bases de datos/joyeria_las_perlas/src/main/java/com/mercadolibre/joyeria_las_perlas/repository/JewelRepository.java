package com.mercadolibre.joyeria_las_perlas.repository;

import com.mercadolibre.joyeria_las_perlas.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JewelRepository extends JpaRepository<Jewel, Long> {
    List<Jewel> findByIsOnSaleTrue();
}
