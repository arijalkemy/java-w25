package com.example.bootcamp.repositories;

import com.example.bootcamp.model.Joya;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {

}
