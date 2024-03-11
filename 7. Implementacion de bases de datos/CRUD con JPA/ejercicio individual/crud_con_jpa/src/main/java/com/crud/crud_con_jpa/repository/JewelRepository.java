package com.crud.crud_con_jpa.repository;

import com.crud.crud_con_jpa.dto.JewelDTO;
import com.crud.crud_con_jpa.models.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JewelRepository extends JpaRepository<Jewel, Long> {

}
