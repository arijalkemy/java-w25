package com.example.relations.repository;

import com.example.relations.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleDetail extends JpaRepository<Sale,Long> {
}
