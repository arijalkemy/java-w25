package bootcamp.extra.repository;

import bootcamp.extra.model.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IClothRepository extends JpaRepository<Cloth, String> {

    Cloth getClothByCode(String codigo);

    void deleteByCode(String codigo);

    List<Cloth> findAllBySize(String talle);

    List<Cloth> findByNameContaining(String keyWord);

    @Query("SELECT v.clothsList FROM Sale v WHERE v.id = :number")
    List<Cloth> getClothesOfSaleWithNumber(@Param("number") Long number);

}

