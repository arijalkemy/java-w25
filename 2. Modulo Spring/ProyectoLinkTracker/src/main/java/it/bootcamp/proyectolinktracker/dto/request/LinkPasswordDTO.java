package it.bootcamp.proyectolinktracker.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkPasswordDTO {

    private Integer linkId;
    private String password;
}
