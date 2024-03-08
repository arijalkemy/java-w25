package main.repository;

import main.model.MiniSerie;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public interface IMiniserieRepository extends JpaRepository <MiniSerie, Long> {
}
