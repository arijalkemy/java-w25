package com.example.showroom.repository;

import com.example.showroom.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllBySale_Id(Long saleId);
}
