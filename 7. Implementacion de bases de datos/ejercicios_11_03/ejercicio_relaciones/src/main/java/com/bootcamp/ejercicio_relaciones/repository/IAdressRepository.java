package com.bootcamp.ejercicio_relaciones.repository;

import com.bootcamp.ejercicio_relaciones.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAdressRepository extends JpaRepository<Adress, Long> {
    Optional<Adress> findByStreetAndNumberAndCity (String street, String number, String city);
}
