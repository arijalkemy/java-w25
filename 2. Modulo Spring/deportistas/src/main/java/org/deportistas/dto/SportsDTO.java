package org.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.deportistas.model.Deporte;

import java.util.List;

@AllArgsConstructor
@Data
public class SportsDTO {
    private List<Deporte> deportes;
}
