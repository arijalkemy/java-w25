package bootcamp.crudjpajewerly.repository;

import bootcamp.crudjpajewerly.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JewerlyRepository extends JpaRepository<Jewerly, Long> {

    List<Jewerly> findJewerliesByVentaONoIsTrue();
    Optional<Jewerly> findJewerlyByVentaONoIsTrueAndNroIdentificatorio(long id);

}
