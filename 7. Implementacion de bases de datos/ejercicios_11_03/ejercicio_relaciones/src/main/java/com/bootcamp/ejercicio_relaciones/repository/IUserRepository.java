package com.bootcamp.ejercicio_relaciones.repository;

import com.bootcamp.ejercicio_relaciones.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByDni(String dni);
}
