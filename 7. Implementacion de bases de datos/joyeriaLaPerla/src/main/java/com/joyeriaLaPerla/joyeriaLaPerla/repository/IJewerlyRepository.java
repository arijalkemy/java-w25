package com.joyeriaLaPerla.joyeriaLaPerla.repository;

import com.joyeriaLaPerla.joyeriaLaPerla.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewerly, Long> {
}
