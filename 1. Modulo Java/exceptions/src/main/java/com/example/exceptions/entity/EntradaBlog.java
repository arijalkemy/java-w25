package com.example.exceptions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@AllArgsConstructor
@Data
public class EntradaBlog {
    private int id;
    private  String titulo;
    private  String autor;
    private LocalDate fechaPublicacion;
}
