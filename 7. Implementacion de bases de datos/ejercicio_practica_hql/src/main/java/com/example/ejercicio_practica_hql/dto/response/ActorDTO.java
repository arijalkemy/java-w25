package com.example.ejercicio_practica_hql.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.security.Timestamp;

@Data
@AllArgsConstructor
public class ActorDTO {
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String firstName;
    private String lastName;
    private BigDecimal rating;
    private int favoriteMovieId;
}
