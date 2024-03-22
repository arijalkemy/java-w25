package com.mercadolibre.app_deportistas_nq.repository;

import com.mercadolibre.app_deportistas_nq.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SportRepository extends JpaRepository<Sport, Long> {
    @Query("SELECT s FROM Sport s JOIN s.persons p WHERE p.id = :personId")
    List<Sport> findSportsByPersonId(@Param("personId") Long personId);
}
