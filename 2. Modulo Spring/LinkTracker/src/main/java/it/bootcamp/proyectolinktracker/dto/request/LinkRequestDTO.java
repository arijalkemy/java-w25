package it.bootcamp.proyectolinktracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkRequestDTO {
    private String url;
    private String password;
}
