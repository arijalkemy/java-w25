package com.example.ejemplo_jpa.repository;

import com.example.ejemplo_jpa.model.SchoolSupply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository <SchoolSupply, Long> {
}
