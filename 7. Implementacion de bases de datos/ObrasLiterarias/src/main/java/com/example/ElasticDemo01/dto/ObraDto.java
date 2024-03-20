package com.example.ElasticDemo01.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ObraDto {
    String nombre;
    String autor;
    int cantidad_paginas;
    String editorial;
    int anio;
}


/*
[
  {
    "nombre": "Cien años de soledad",
    "autor": "Gabriel García Márquez",
    "cantidad_paginas": 432,
    "editorial": "Editorial Sudamericana",
    "anio": 1967
  },
  {
    "nombre": "Don Quijote de la Mancha",
    "autor": "Miguel de Cervantes",
    "cantidad_paginas": 863,
    "editorial": "Real Academia Española",
    "anio": 1605
  },
  {
    "nombre": "Harry Potter y la piedra filosofal",
    "autor": "J.K. Rowling",
    "cantidad_paginas": 309,
    "editorial": "Bloomsbury Publishing",
    "anio": 1997
  },
  {
    "nombre": "1984",
    "autor": "George Orwell",
    "cantidad_paginas": 328,
    "editorial": "Secker & Warburg",
    "anio": 1949
  },
  {
    "nombre": "El señor de los anillos",
    "autor": "J.R.R. Tolkien",
    "cantidad_paginas": 1178,
    "editorial": "George Allen & Unwin",
    "anio": 1954
  },
  {
    "nombre": "El amor en los tiempos del cólera",
    "autor": "Gabriel García Márquez",
    "cantidad_paginas": 368,
    "editorial": "Oveja Negra",
    "anio": 1985
  },
  {
    "nombre": "La metamorfosis",
    "autor": "Franz Kafka",
    "cantidad_paginas": 55,
    "editorial": "Kurt Wolff Verlag",
    "anio": 1915
  },
  {
    "nombre": "La odisea",
    "autor": "Homero",
    "cantidad_paginas": 374,
    "editorial": "Varios",
    "anio": -800
  },
  {
    "nombre": "Orgullo y prejuicio",
    "autor": "Jane Austen",
    "cantidad_paginas": 432,
    "editorial": "T. Egerton, Whitehall",
    "anio": 1813
  },
  {
    "nombre": "El túnel",
    "autor": "Ernesto Sabato",
    "cantidad_paginas": 152,
    "editorial": "Santillana",
    "anio": 1948
  }
]


 */