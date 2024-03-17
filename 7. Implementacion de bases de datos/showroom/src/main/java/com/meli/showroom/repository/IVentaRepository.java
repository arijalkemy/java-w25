package com.meli.showroom.repository;

import com.meli.showroom.entity.Prenda;
import com.meli.showroom.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {

    @Query("select v.listPrendas from ventas v where v.numero =:numeroQuery")
    Set<Prenda> findPrendasFromVendaById(@Param("numeroQuery") Long id);
}
