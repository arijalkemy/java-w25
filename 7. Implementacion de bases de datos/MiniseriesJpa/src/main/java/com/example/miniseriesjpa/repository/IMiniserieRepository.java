package com.example.miniseriesjpa.repository;

import com.example.miniseriesjpa.model.MiniSerie;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie,Long> {

}
