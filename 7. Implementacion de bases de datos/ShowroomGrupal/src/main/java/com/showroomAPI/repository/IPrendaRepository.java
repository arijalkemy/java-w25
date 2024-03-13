package com.showroomAPI.repository;

import com.showroomAPI.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrendaRepository extends JpaRepository<Prenda, Long> {
}
