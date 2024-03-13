package com.example.ejemplo_jpa.repository;

import com.example.ejemplo_jpa.model.Actor;
import com.example.ejemplo_jpa.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m where m.title = :name")
    List<Movie> findMovieByTitle(@Param("name") String name);

}
