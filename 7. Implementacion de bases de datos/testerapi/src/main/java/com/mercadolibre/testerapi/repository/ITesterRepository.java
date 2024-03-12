package com.mercadolibre.testerapi.repository;

import com.mercadolibre.testerapi.model.Tester;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ITesterRepository extends JpaRepository<Tester, Long> {
}
