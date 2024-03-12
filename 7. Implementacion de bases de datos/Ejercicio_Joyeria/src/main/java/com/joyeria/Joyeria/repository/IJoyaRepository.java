package com.joyeria.Joyeria.repository;

import com.joyeria.Joyeria.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {

}
