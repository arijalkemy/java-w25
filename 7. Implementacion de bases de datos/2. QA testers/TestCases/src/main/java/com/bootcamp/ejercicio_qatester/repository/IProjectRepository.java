package com.bootcamp.ejercicio_qatester.repository;

import com.bootcamp.ejercicio_qatester.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long>{
}
