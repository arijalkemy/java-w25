package org.example.ejercicio_exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogSaveRequestDTO {
    private Long id;
    private String title;
    private String authorName;
}
