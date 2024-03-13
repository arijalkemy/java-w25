package com.clave.demo.repository;

import com.clave.demo.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ICompraRepository extends JpaRepository<Compra, Long> {

}
