package org.example.manejo_de_excepciones_p1_vivo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private int id;
    private String title;
    private String name;
    private String date;
}
