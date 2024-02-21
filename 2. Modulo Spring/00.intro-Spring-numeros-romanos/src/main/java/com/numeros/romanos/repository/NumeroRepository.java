package com.numeros.romanos.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.numeros.romanos.domain.Numero;
import org.springframework.stereotype.Repository;

@Repository
public interface NumeroRepository extends JpaRepository<Numero, Integer>{
}
