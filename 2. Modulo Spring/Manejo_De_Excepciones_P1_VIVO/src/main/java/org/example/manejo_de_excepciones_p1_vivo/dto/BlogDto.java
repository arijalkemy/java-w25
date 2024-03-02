package org.example.manejo_de_excepciones_p1_vivo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private int id;
    private String title;
    private String name;
    private String date;
}
