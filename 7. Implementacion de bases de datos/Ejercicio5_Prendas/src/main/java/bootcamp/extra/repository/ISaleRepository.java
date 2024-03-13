package bootcamp.extra.repository;

import bootcamp.extra.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findByDate(LocalDate date);

}
