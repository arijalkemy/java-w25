package com.bootcamp.LasPerlas.repository;
import com.bootcamp.LasPerlas.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository <Jewel, Long> {
}
