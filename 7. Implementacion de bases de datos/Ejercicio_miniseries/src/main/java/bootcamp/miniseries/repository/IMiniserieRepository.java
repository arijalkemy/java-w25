package bootcamp.miniseries.repository;

import bootcamp.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {

    @Query(nativeQuery = true, value =
            "SELECT amount_of_awards " +
            "FROM MINI_SERIE " +
            "WHERE id = ?"
    )
    int getAwardsOfMiniserie(Long id);
    //Para usar LIKE:  List<?> findByNameContaining
    Optional<MiniSerie> findMiniSerieByName(String name);

}
