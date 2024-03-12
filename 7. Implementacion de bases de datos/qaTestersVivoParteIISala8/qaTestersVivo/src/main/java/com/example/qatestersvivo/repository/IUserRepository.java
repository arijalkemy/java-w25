package com.example.qatestersvivo.repository;

import com.example.qatestersvivo.entity.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Tester, Long> {
}
