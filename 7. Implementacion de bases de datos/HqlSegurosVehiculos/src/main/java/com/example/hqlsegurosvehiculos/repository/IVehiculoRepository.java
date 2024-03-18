package com.example.hqlsegurosvehiculos.repository;

import com.example.hqlsegurosvehiculos.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("select patente from Vehiculo")
    List<String> findAllPatentes();
}
