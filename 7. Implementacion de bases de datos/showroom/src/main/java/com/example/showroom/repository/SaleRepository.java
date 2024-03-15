package com.example.showroom.repository;

import com.example.showroom.model.Clothe;
import com.example.showroom.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findSalesByDate(LocalDate date);

}
