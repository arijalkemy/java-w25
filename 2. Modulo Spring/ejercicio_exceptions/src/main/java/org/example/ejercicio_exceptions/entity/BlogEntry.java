package org.example.ejercicio_exceptions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntry {
    private Long id;
    private String title;
    private String authorName;
    private LocalDate date;
}
