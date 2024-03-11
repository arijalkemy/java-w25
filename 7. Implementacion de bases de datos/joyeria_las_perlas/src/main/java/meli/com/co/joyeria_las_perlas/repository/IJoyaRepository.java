package meli.com.co.joyeria_las_perlas.repository;

import meli.com.co.joyeria_las_perlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {
}
