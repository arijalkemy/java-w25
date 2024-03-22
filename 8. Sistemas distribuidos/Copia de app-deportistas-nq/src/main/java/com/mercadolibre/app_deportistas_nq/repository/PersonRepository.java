package com.mercadolibre.app_deportistas_nq.repository;

import com.mercadolibre.app_deportistas_nq.entity.Person;
import com.mercadolibre.app_deportistas_nq.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
